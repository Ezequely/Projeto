/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import br.ufrn.dimap.entidades.Turma;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;

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
    
    

    //MÉTODOS abstratos
    
    /** @return um comando sql para realizar uma seleção*/
    protected abstract String createSelectCmd();

    /** Lê uma linha de um ResultSet e retorna um objeto com a representação dos dados lidos.
     *  Encapsula os dados de um registro do banco em um objeto.
     */
    protected abstract Object read(ResultSet rs) throws SQLException;
    
    
    
    protected abstract String getTableName();

    protected abstract String getColumns();

    protected abstract String getValues(Object obj);

    protected abstract String getCondicaoDeAtualizacao(Object obj);

    protected abstract String getColumnsValues(Object object);
    
    ///ATUALIZAR
    public void update(Object obj) {
        executeUpdate(createUpdateCmd(obj));
    }

    ///INSERIR
    public void insert(Object obj) {
        executeUpdate(createInsertCmd(obj));
    }
    ///REMOVER
    public void remove(Object obj) {
        executeUpdate(createDeleteCmd(obj));
    }
    
    /**insert into <table>  (<columns>) values  (<values>);
     */
    protected String createInsertCmd(Object obj) {
        StringBuilder cmd = new StringBuilder();
        if(obj instanceof Turma){
            cmd.append("insert into ");
            cmd.append(getTableName());
            cmd.append(" ");
            cmd.append(getColumns());
            cmd.append(" values ");
            cmd.append(getValues(obj));
        }
        return cmd.toString();
    }

    /**delete from <table> where <condicao de exclusao>;*/
    protected String createDeleteCmd(Object obj) {
        StringBuilder cmd = new StringBuilder();
        cmd.append("delete from ");
        cmd.append(getTableName());
        cmd.append(" where ");
        cmd.append(getCondicaoDeAtualizacao(obj));
        
        return cmd.toString();
    }

    /** update <table> set <columnsValues> where <condicaoDeAtualizacao>; */
    protected String createUpdateCmd(Object obj) {
        StringBuilder cmd = new StringBuilder();
        cmd.append("update ");
        cmd.append(getTableName());
        cmd.append(" set ");
        cmd.append(getColumnsValues(obj));
        cmd.append(" where ");
        cmd.append(getCondicaoDeAtualizacao(obj));
        
        return cmd.toString();
    }
    
    protected void executeUpdate(String updateCmd){  
        //Cria conexão
        Connection connection = this.dataController.createConnection();
        
        try {
            //Inicializa transação
            dataController.beginTransaction(connection);
            
            //Realiza inserção
            this.executeUpdate(updateCmd, connection);
            
            //Commit
            dataController.commit(connection);
            //Se conexão ainda estiver aberta, fecha
            if(connection.isClosed() == false){
                connection.close();
            }
        } catch (SQLException ex) {
            Logger.getLogger(SqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    protected void executeUpdate(String cmd, Connection connection){
        System.out.println(cmd);//DEBUG
        
        try {
            Statement sqlStatement = connection.createStatement();
            
            sqlStatement.executeUpdate(cmd);
            
        } catch(SQLException e){
            e.printStackTrace();
        } 
        
    }
    
    
    public Collection<? extends Object> listAll() {
        return this.listAll(this.createSelectCmd());
    }
    
    /**Permite as classes na hierarquia executar comandos de busca especificos
     *  -- utiliza transações por padrão, pois garante que consultas encadeadas 
     *      (a varios objetos DAO serão executadas de forma consistente).
     */
    protected final Collection<? extends Object> listAll(String selectCmd){  
        //Cria conexão
        Connection connection = this.dataController.createConnection();
        
        try {
            //Inicializa transação
            dataController.beginTransaction(connection);
            //Realiza busca
            Collection<Object> objects = (Collection<Object>) this.listAll(selectCmd, connection);
            //Commit
            dataController.commit(connection);
            //Se conexão ainda estiver aberta, fecha
            if(connection.isClosed() == false){
                connection.close();
            }
            return objects;
            
        } catch (SQLException ex) {
            Logger.getLogger(SqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        } catch (Exception ex) {
            Logger.getLogger(SqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        
        return null;
    }
    
    /**Permite as classes na hierarquia utilizar transações
     *  -- Se um objeto DAO está em uma transação e deseja realizar uma consulta através de
     *      outro objeto, deve utilizar este método, passando sua conexão.
     *  -- Caso necessário, esse método deve ser sobrescrito ao invés dos anteriores
     */
    protected Collection<? extends Object> listAll(String selectCmd, Connection connection){
        System.out.println(selectCmd);//DEBUG
        
        try {
            Statement sqlStatement = connection.createStatement();
            ResultSet rs = sqlStatement.executeQuery(selectCmd);
            Collection<Object> objects = new ArrayList<Object>();
            
            while (rs.next()){
                objects.add(read(rs));
            }
            
            return objects;
        } catch(SQLException e){
            e.printStackTrace();
        } 
        return null;
        
    }

    /**Para Override utilize search(Object obj, Connection conn) e não este*/
    public final Collection<? extends Object> search(Object obj) {
        Connection conn = dataController.createConnection();
        try {
            dataController.beginTransaction(conn);
        
            Collection<? extends Object> objs = this.search(obj, conn);

            dataController.commit(conn);
            if(conn.isClosed() == false){
                conn.close();
            }
            return objs;
        
        } catch (Exception ex) {
            ex.printStackTrace();
            Logger.getLogger(SqlDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
    }
    /**
     *  @return por padrao retorna uma colecao vazia.
     */
    public Collection<? extends Object> search(Object obj, Connection conn) {
        return new ArrayList<Object>();
    }
    
    
    public Collection<? extends Object> search(Parameter param) {
        return this.listAll(createFilteredSearch(param));
    }
    public Collection<? extends Object> search(Parameter param, Connection conn) {
        return this.listAll(createFilteredSearch(param), conn);
    }
    
    /*  select ...
        where param.key = param.value*/
    private String createFilteredSearch(Parameter param) {
        StringBuilder builder = new StringBuilder(this.createSelectCmd());
        builder.append(" where ");
        builder.append(param.getKey());
        builder.append(" = ");
        if(!(param.getValue() instanceof String) && ! (param.getValue() instanceof Date)){
            builder.append(param.getValue().toString());
        }
        else{
            builder.append(" '");
            builder.append(param.getValue().toString());
            builder.append("' ");
        }
        return builder.toString();
    }
    
    ///AUXILIARES
    protected String getStringValue(String value){
        if(value != null){
            return "'" + value + "'";
        }
        else{
            return getNullValue();
        }
    }
    protected String getIntegerValue(Integer value){
        if(value != null){
            return Integer.toString(value);
        }
        else{
            return getNullValue();
        }
    }
    protected String getNullValue(){
        return "NULL";
    }

    
}
