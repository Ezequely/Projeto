/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.entidades;

/**
 *
 * @author leobrizolara
 */
public class Usuario {
    private String login;
    private Pessoa pessoa;

    public Usuario(){
        login = "";
    }
    public Usuario(String login, Pessoa pessoa){
        this.login = login;
        this.pessoa = pessoa;
    }
    
    /**
     * @return the login
     */
    public String getLogin() {
        return login;
    }
    /**
     * @param login the login to set
     */
    public void setLogin(String login) {
        this.login = login;
    }

    /**
     * @return the pessoa
     */
    public Pessoa getPessoa() {
        return pessoa;
    }
    /**
     * @param pessoa the pessoa to set
     */
    public void setPessoa(Pessoa pessoa) {
        this.pessoa = pessoa;
    }
    
}
