/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.entidades.Vinculo;
import java.sql.Connection;
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
    
    @Override
    public void update(Object obj) {
        //this.connection.
    }

    @Override
    public void insert(Object obj) {
    }

    @Override
    public Object search(Object obj) {
        return null;
    }

    @Override
    public void remove(Object obj) {
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
        System.out.println(cmd);
        
        
        return cmd;
    }

    @Override
    protected Object read(ResultSet rs) throws SQLException {
        Docente docente = new Docente((Vinculo)(new VinculoDAO()).read(rs));
        
        docente.setCargo(rs.getString("Cargo"));
        docente.setTitulacao(rs.getString("Titulacao"));
        
        return docente;
    }
    
}
