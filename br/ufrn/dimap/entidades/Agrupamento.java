/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author leobrizolara
 */
public class Agrupamento {
    Map<String, Collection<Object>> categorias;
    private String nome;
    
    public Agrupamento(String nome){
        categorias = new TreeMap<String, Collection<Object>>();
        this.nome = nome;
    }
    
    
    public Collection<String> getNomesCategoria(){
        return this.categorias.keySet();
    }
    
    public Collection<Collection<Object>> getCategorias(){
        return this.categorias.values();
    }
    
    public Collection<? extends Object> getCategoria(String key){        
        if(this.categorias.containsKey(key)){
            return categorias.get(key);
        }
        return null;//nao contem chave
    }
    public void setCategoria(String key, Collection<? extends Object> items){
        this.categorias.put(key, (Collection<Object>) items);
    }
    
    public void addItem(String key, Object item){
        if(!categorias.containsKey(key)){
            categorias.put(key, new ArrayList<Object>());
        }
        this.categorias.get(key).add(item);
    }
    public void removeItem(String key, Object item){
        this.categorias.get(key).remove(item);
    }
    
    public boolean contains(String categoria){
        return this.contains(categoria);
    }
    
    
    /** @return retorna o numero de categorias*/
    public int numCategorias(){
        return this.categorias.size();
    }
    
    /** @return retorna o numero total de elementos*/
    public int count(){
        int totalSize = 0;
        for(Collection<Object> categoria : categorias.values()){
            totalSize += categoria.size();
        }
        return totalSize;
    }
    
    /** @return retorna o numero de elemntos em uma categoria*/
    public int count(String categoria){
        if(categorias.containsKey(categoria)){
            return categoria.length();
        }
        return 0;
    }

    /**
     * @return the nome
     */
    public String getNome() {
        return nome;
    }

    /**
     * @param nome the nome to set
     */
    public void setNome(String nome) {
        this.nome = nome;
    }
}
