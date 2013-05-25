/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author leobrizolara
 */
public abstract class SqlDAO implements DatabaseAccessObject{
    
    protected DatabaseController dataController;
    
    public SqlDAO(){
    }
    public SqlDAO(DatabaseController dbControl){
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
            Collection<Object> objects = new ArrayList<Object>();
            
            while (rs.next()){
                objects.add(read(rs));
            }
            connection.close();
            return objects;
        } catch(SQLException e){
            e.printStackTrace();
        } 
        return null;
    }
    
    protected abstract String createSelectCmd();

    protected abstract Object read(ResultSet rs) throws SQLException;
    
}
