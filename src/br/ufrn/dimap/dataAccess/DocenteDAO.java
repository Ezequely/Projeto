/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.entidades.Turma;
import br.ufrn.dimap.entidades.Vinculo;
import java.sql.*;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author leobrizolara
 */
public class DocenteDAO extends SqlDAO{  
    public DocenteDAO(DatabaseController dbControl){
        super(dbControl);
    }

    DocenteDAO() {}
    
    public Collection<? extends Object> search(Object obj, Connection conn){
        if(obj instanceof Turma){//buscar docentes de uma turma
            String cmdSelectDocentesDaTurma = this.createSelectTurmaDocenteCmd((Turma)obj);
            return this.listAll(cmdSelectDocentesDaTurma, conn);
        }
        
        //else: retorna lista vazia
        return new ArrayList<Docente>();
    }
    
    /* selectiona todos os professores de uma turma
     select * from 
	PESSOA natural join
	VINCULO natural join
	(Select Titulacao, MatriculaDocente as Matricula, Cargo from DOCENTE) as D 
		natural left join
	LINHADEPESQUISA
	where Matricula 
                in (select MatriculaDocente from TURMA_DOCENTE where CodigoTurma = ?)
     */
    private String createSelectTurmaDocenteCmd(Turma t) {
        StringBuilder builder = new StringBuilder();
        builder.append(this.createSelectCmd());
        builder.append(" where Matricula in ");
        builder.append(" (select MatriculaDocente from TURMA_DOCENTE where CodigoTurma = ");
        builder.append(Integer.toString(t.getCodigoTurma()));
        builder.append( " )");
        
        return builder.toString();
    }
    
    /*select * from 
	PESSOA natural join
	VINCULO natural join
	(Select Titulacao, MatriculaDocente as Matricula, Cargo from DOCENTE) as D 
		natural left join
	LINHADEPESQUISA;*/
    protected String createSelectCmd(){
        StringBuilder builder = new StringBuilder();
        builder.append("select * from ");
        builder.append("PESSOA ");
        builder.append("natural join VINCULO ");
        builder.append("join DOCENTE on MatriculaDocente = Matricula ");
        builder.append("natural left join LINHADEPESQUISA");
        
        String cmd = builder.toString();
        
        return cmd;
    }

    @Override
    protected Object read(ResultSet rs) throws SQLException {
        Docente docente = new Docente((Vinculo)(new VinculoDAO()).read(rs));
        
        docente.setCargo(rs.getString("Cargo"));
        docente.setTitulacao(rs.getString("Titulacao"));
        
        return docente;
    }    

    
    @Override
    protected String getTableName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getValues(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getCondicaoDeAtualizacao(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getColumnsValues(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
