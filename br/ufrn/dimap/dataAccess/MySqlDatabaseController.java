/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import java.sql.Connection;
import java.sql.Statement;

import java.sql.DriverManager;
import java.sql.SQLException;
/**
 *
 * @author leobrizolara
 */
public class MySqlDatabaseController implements DatabaseController{
    private static final String MySQLDriver = "com.mysql.jdbc.Driver";  
    private String url;
    private String login;
    private String password;
    
    public MySqlDatabaseController(String Url, String Login, String Password) 
            throws ClassNotFoundException{
        url = Url;
        login = Login;
        password = Password;
        
        Class.forName(MySQLDriver);  
    }

    /**
     * @return
     * @throws SQLException
     */
    @Override
    public Connection CreateConnection(){
        try{
            return DriverManager.getConnection(url, this.login, this.password); 
        }
        catch(SQLException sqlEx){
            sqlEx.printStackTrace();
            return null;
        }
    }
    
}
