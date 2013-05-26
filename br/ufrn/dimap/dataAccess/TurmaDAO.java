/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import br.ufrn.dimap.entidades.Disciplina;
import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.entidades.Turma;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author leobrizolara
 */
public class TurmaDAO extends SqlDAO{
    public TurmaDAO(DatabaseController dbControl){
        super(dbControl);
    }
    
    public void update(Object obj) {
        //this.connection.
    }

    public void insert(Object obj) {
    }

    public void remove(Object obj) {
    }
    
    
    @Override
    public Collection<? extends Object> listAll(){
        return this.listAll(this.createSelectCmd());
    }
    @Override
    public Collection<? extends Object> listAll(String selectCommand){
        Collection<? extends Object> turmas = super.listAll(selectCommand);
        
        DocenteDAO docenteDAO = new DocenteDAO(this.dataController);
        for(Object o : turmas){
            Turma t = (Turma)o;
            //adicionar docentes a turma
            t.setDocentes((Collection<Docente>) docenteDAO.search(t));
        }
        
        return turmas;
    }
    
    /**
     *  @return se obj for um docente, retorna as turmas minsitradas por esse docente.
     */
    public Collection<? extends Object> search(Object obj) {
        if(obj instanceof Docente){//buscar turmas de um docente
            return this.listAll(this.createSelectTurmaDocenteCmd((Docente)obj));
        }
        
        return new ArrayList<Object>();
    }
    /* selectiona todos os professores de uma turma
     select * from 
        TURMA t 
        join DISCIPLINA d on t.CodigoDisciplina = d.CodigoDisciplina
	natural join LINHADEPESQUISA
	where CodigoTurma 
		in (select CodigoTurma from TURMA_DOCENTE where MatriculaDocente = ?)
     */
    private String createSelectTurmaDocenteCmd(Docente d) {
        StringBuilder builder = new StringBuilder();
        builder.append(this.createSelectCmd());
        builder.append(" where CodigoTurma in ");
        builder.append(" (select CodigoTurma from TURMA_DOCENTE where MatriculaDocente = '");
        builder.append(d.getMatricula());
        builder.append( "' )");
        
        return builder.toString();
    }
    
    /*select * from 
        TURMA t 
        join DISCIPLINA d on t.CodigoDisciplina = d.CodigoDisciplina
	natural join LINHADEPESQUISA*/
    protected String createSelectCmd(){
        StringBuilder builder = new StringBuilder();
        builder.append("select * from ");
        builder.append(" TURMA t");
        builder.append(" join DISCIPLINA d on t.CodigoDisciplina = d.CodigoDisciplina");
        builder.append(" natural join LINHADEPESQUISA");
        
        String cmd = builder.toString();
        System.out.println(cmd);
        
        return cmd;
    }

    @Override
    protected Object read(ResultSet rs) {
        Turma turma = new Turma();
        try {
            turma.setCodigoTurma(rs.getInt("CodigoTurma"));
            turma.setLocalDeAula(rs.getString("LocalDeAula"));
            turma.setNumeroTurma(rs.getInt("NumeroTurma"));
            turma.setPeriodoLetivo(rs.getString("PeriodoLetivo"));
            turma.setStatus(rs.getString("Status"));
            turma.setCodHorarioDeAula(rs.getString("CodHorarioDeAula"));
            turma.setDisciplina(
                    (Disciplina)(new DisciplinaDAO()).read(rs));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return turma;
    }
    
}
