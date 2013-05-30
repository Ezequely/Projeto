/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import br.ufrn.dimap.entidades.Aluno;
import br.ufrn.dimap.entidades.MatriculaAlunoTurma;
import br.ufrn.dimap.entidades.Turma;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author leobrizolara
 */
public class AlunoTurmaDAO extends SqlDAO{

    public AlunoTurmaDAO(DatabaseController dbController) {
        super(dbController);
    }
    
    
    public Collection<? extends Object> listAll(String cmd) {//TODO: permitir transaction
        Collection<? extends Object> matriculasAlunoTurma = super.listAll(cmd);
        AlunoDAO alunoDAO = new AlunoDAO(dataController);
        String selectAlunoCmd = createSelectAlunoCmd(alunoDAO.createSelectCmd());
        
        Collection<? extends Object> alunos = alunoDAO.listAll(selectAlunoCmd);
        
        //para cada turma 'MatriculaAlunoTurma' busca o aluno
        for(Object o : matriculasAlunoTurma){
            MatriculaAlunoTurma alunoTurma = (MatriculaAlunoTurma) o;
            //buscar aluno
            for(Object a : alunos){
                Aluno aluno = (Aluno)a;
                if(alunoTurma.getAluno().getMatricula().equals(aluno.getMatricula())){
                    alunoTurma.setAluno(aluno);
                }
            }
        }
        
        return matriculasAlunoTurma;
    }
    
    public Collection<? extends Object> search(Object obj) {
        if(obj instanceof Aluno){
            return this.listAll(this.createSelectAlunoHistoricoCmd((Aluno)obj));
        }
        
        return new ArrayList<Object>();
    }
    
    @Override
    protected String createSelectCmd() {
        StringBuilder builder = new StringBuilder();
        builder.append("select * from ");
        builder.append(" ALUNO_TURMA");
        builder.append(" natural join TURMA t");
        builder.append(" join DISCIPLINA d on t.CodigoDisciplina = d.CodigoDisciplina");
        builder.append(" natural join LINHADEPESQUISA");
        
        return builder.toString();
    }

    @Override
    protected Object read(ResultSet rs) throws SQLException {
        MatriculaAlunoTurma alunoTurma = new MatriculaAlunoTurma();
        
        alunoTurma.setNota(0, (Double) rs.getObject("Nota1"));
        alunoTurma.setNota(1, (Double) rs.getObject("Nota2"));
        alunoTurma.setNota(2, (Double) rs.getObject("Nota3"));
        alunoTurma.setNota(3, (Double) rs.getObject("Nota4"));
        
        alunoTurma.setSituacao(rs.getString("Situacao"));
        alunoTurma.setTurma((Turma) new TurmaDAO(dataController).read(rs));
        
        Aluno aluno = new Aluno();
        aluno.setMatricula(rs.getString("MatriculaAluno"));
        alunoTurma.setAluno(aluno);
        
        return alunoTurma;
    }

    /*
      select * from 
        TURMA t 
        join DISCIPLINA d on t.CodigoDisciplina = d.CodigoDisciplina
	natural join LINHADEPESQUISA
	natural join ALUNO_TURMA where MatriculaAluno = ?; */
    private String createSelectAlunoHistoricoCmd(Aluno aluno) {
        StringBuilder builder = new StringBuilder();
        builder.append(this.createSelectCmd());
        builder.append(" where MatriculaAluno = ");
        builder.append(aluno.getMatricula());
        
        return builder.toString();
    }

    
    /*select * from 
	PESSOA 
        natural join VINCULO 
        join ALUNO on Matricula = MatriculaAluno 
        natural left join LINHADEPESQUISA
		where Matricula in (select MatriculaAluno from ALUNO_TURMA)*/
    private String createSelectAlunoCmd(String createSelectCmd) {
        StringBuilder builder = new StringBuilder(createSelectCmd);
        builder.append(" where MatriculaAluno in ");
        builder.append("(select MatriculaAluno from ALUNO_TURMA)");
        
        return builder.toString();
    
    }
    
}