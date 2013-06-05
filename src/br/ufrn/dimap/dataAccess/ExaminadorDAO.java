/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.entidades.Examinador;
import br.ufrn.dimap.entidades.Vinculo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leobrizolara
 */
public class ExaminadorDAO extends SqlDAO{

    public ExaminadorDAO() {
    }
    public ExaminadorDAO(DatabaseController dataController) {
        super(dataController);
    }

    
    
    @Override
    /* select * from 
            PESSOA natural join
            VINCULO 
        join DOCENTE on MatriculaDocente = Matricula
            natural left join LINHADEPESQUISA
            natural join EXAMINADOR;*/
    protected String createSelectCmd() {
        StringBuilder builder = new StringBuilder();
        builder.append("select * from ");
        builder.append("PESSOA ");
        builder.append("natural join VINCULO ");
        builder.append("join DOCENTE on MatriculaDocente = Matricula ");
        builder.append(" natural left join LINHADEPESQUISA ");
        builder.append(" natural join EXAMINADOR ");
        
        String cmd = builder.toString();
        
        return cmd;
    }

    @Override
    protected Object read(ResultSet rs) throws SQLException {
        Examinador examinador = new Examinador();
        
        Docente docente = (Docente) (new DocenteDAO()).read(rs);
        examinador.setDocente(docente);
        examinador.setNota(rs.getDouble("Nota"));
        examinador.setCodigoBanca(rs.getInt("CodigoBanca"));
        
        return examinador;
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
