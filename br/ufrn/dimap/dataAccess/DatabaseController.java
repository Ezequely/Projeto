/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import java.sql.Connection;
import java.sql.Statement;

/**
 *
 * @author leobrizolara
 */
public interface DatabaseController {

    public Connection CreateConnection();    
}
