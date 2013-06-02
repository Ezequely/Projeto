/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import br.ufrn.dimap.entidades.Aluno;
import br.ufrn.dimap.entidades.BancaExaminadora;
import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.entidades.MatriculaAlunoTurma;
import br.ufrn.dimap.entidades.Publicacao;
import br.ufrn.dimap.entidades.Turma;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Collection;

    
/**
 *
 * @author leobrizolara
 */
public class BancaExaminadoraDAO extends SqlDAO{
    PublicacaoDAO publicacaoDAO;
    AlunoDAO alunoDAO;
    
    public BancaExaminadoraDAO(DatabaseController dbController){
        super(dbController);
        alunoDAO = new AlunoDAO(dataController);
        publicacaoDAO = new PublicacaoDAO(dbController);
    }
    
    @Override
    public Collection<? extends Object> listAll(String cmd, Connection conn) {//TODO: permitir transaction        
        //Lista todas as bancas
        Collection<? extends Object> bancasExaminadoras = super.listAll(cmd, conn);
        
        //buscar examinadores das bancas
        DocenteDAO docenteDAO = new DocenteDAO(dataController);
        
        //para cada banca examinadora obtem examinadores
        for(Object o : bancasExaminadoras){
            BancaExaminadora banca = (BancaExaminadora) o;
            //buscar examinador
            String selectExaminadorCmd 
                    = createSelectExaminadoresCmd(docenteDAO.createSelectCmd(), banca);
            Collection<? extends Object> examinadores 
                    = docenteDAO.listAll(selectExaminadorCmd, conn);
            
            banca.setExaminadores((Collection<Docente>) examinadores);
        }
        
        return bancasExaminadoras;
    }
        

    private String createSelectExaminadoresCmd(String createSelectCmd, BancaExaminadora banca) {    
        StringBuilder builder = new StringBuilder();
        builder.append(createSelectCmd);
        builder.append(" natural join BANCAEXAMINADORA ");
        builder.append(" join PUBLICACAO on ISSN = ISSN_Dissertacao ");
        
        String cmd = builder.toString();
        
        return cmd;
    }
        
    @Override
    /*select * from ALUNO 
		join VINCULO on MatriculaAluno = Matricula 
		natural join PESSOA 
		natural join LINHADEPESQUISA
		natural join BANCAEXAMINADORA
		join PUBLICACAO on ISSN = ISSN_Dissertacao;*/
    protected String createSelectCmd() {
        StringBuilder builder = new StringBuilder();
        builder.append(alunoDAO.createSelectCmd());
        builder.append(" natural join BANCAEXAMINADORA ");
        builder.append(" join PUBLICACAO on ISSN = ISSN_Dissertacao ");
        
        String cmd = builder.toString();
        
        return cmd;
    }

    @Override
    //(CodigoBanca, DataDeDefesa, ISSN_Dissertacao, MatriculaAluno)
    protected Object read(ResultSet rs) throws SQLException {
        BancaExaminadora bancaExaminadora = new BancaExaminadora();
        
        bancaExaminadora.setCodigoBanca(rs.getInt("CodigoBanca"));
        bancaExaminadora.setDataDeDefesa(rs.getDate("DataDeDefesa"));
        bancaExaminadora.setAluno((Aluno) alunoDAO.read(rs));
        bancaExaminadora.setDissertacao((Publicacao) publicacaoDAO.read(rs));
        
        
        
        return bancaExaminadora;    
    }
}
