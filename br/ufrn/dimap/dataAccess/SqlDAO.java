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

    public void remove(Object obj) {
    }

    public Collection<? extends Object> listAll() {
        return this.listAll(this.createSelectCmd());
    }
    
    /**Permite as classes na hierarquia executar comandos de busca especificos*/
    protected Collection<? extends Object> listAll(String selectCmd){
        System.out.println(selectCmd);//DEBUG
        
        try {
            Connection connection = this.dataController.CreateConnection();

            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(selectCmd);
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

    /**
     *  @return por padrao retorna uma colecao vazia.
     */
    public Collection<? extends Object> search(Object obj) {
        return new ArrayList<Object>();
    }
    
}
