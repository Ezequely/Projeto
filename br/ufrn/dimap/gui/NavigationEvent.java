/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui;

import java.util.Collection;
import java.util.EventObject;
import java.util.HashMap;
import java.util.Map;

/**
 *
 * @author leobrizolara
 */
public class NavigationEvent extends EventObject{
    /**Algum tipo de argumento que uma tela precisa passar para a 'tela pai' efetuar a navegação*/
    private Map<String, Object> args;
    
    private String destination;
    public NavigationEvent(Object source){
        this(source, "");
    }
    public NavigationEvent(Object source, String dest){
        super(source);
        destination = dest;
        args = new HashMap<String, Object>();
    }
    public String getDestination(){
        return destination;
    }
    public void setDestination(String destination) {
        this.destination = destination;
    }

    public void addArg(String key, Object value){
        this.args.put(key, value);
    }
    public void removeArg(String key){
        this.args.remove(key);
    }
    public Object getArg(String key){
        if(args.containsKey(key)){
            return args.get(key);
        }
        return null;
    }
    public void setArgs(Map<String, Object> args) {
        this.args = args;
    }
    public Map<String, ? extends Object> getArgs() {
        return args;
    }
}
