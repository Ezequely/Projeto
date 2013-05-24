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
public class DocenteDAO implements DatabaseAccessObject{   
    DatabaseController dataController;
    public DocenteDAO(DatabaseController dbControl){
        dataController = dbControl;
    }
    
    public void update(Object obj) {
        //this.connection.
    }

    public void insert(Object obj) {
    }

    public Object search(Object obj) {
        return null;
    }

    public void remove(Object obj) {
    }

    public Collection<Object> listAll() {
        try {
            Connection connection = this.dataController.CreateConnection();

            String sql = this.createSelectCmd();
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(sql);
            Collection<Object> docentes = new ArrayList<Object>();
            while (rs.next()){
                Docente docente = new Docente();
                this.readDocente(docente, rs);

                docentes.add(docente);
            }
            connection.close();
            return docentes;
        } catch(SQLException e){
            e.printStackTrace();
        } 
        return null;
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

    private void readDocente(Docente docente, ResultSet rs) throws SQLException {
        VinculoDAO.read((Vinculo)docente, rs);
        
        docente.setCargo(rs.getString("Cargo"));
        docente.setTitulacao(rs.getString("Titulacao"));
    }
    
}
