/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.widgets;

import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 * @author leobrizolara
 * 
 * ObjectListView define uma interface para uma lista de objetos.
 * a interface a ser exibida para cada um dos elementos da lista é definida pela
 * instância de ObjectViewer passada a classe.
 * 
 * Provê funcionalidades de acessar e definir a lista de objetos referenciada pela 
 * ObjectListViewe permite a um cliente detectar e receber qual elemento foi 
 * selecionado pelo usuario (utilizando um ActionListener).
 */
public class ObjectListView extends JList<Object>{
    DefaultListModel listModel;
    Collection<Object> collection;
    ObjectViewer viewer;
    
    ListAction listAction;
    
    public ObjectListView(){
        this(new DefaultObjectViewer());
    }
    public ObjectListView(ObjectViewer objViewer){
        super();
        listModel = new DefaultListModel();
        this.setModel(listModel);
        
        listAction = new ListAction(this);
        
        this.setViewer(objViewer);
    }
    public ObjectListView(ObjectViewer viewer, Collection<? extends Object> objects){
        this(viewer);
        this.setCollection(objects);
    }
    
    
    public void addActionListener(ActionListener listener){
        this.listAction.addActionListener(listener);
    }
    public void removeActionListener(ActionListener listener){
        this.listAction.removeActionListener(listener);
    }
        
    
    public void setViewer(ObjectViewer objViewer){
        this.viewer = objViewer;
        this.setCellRenderer(new ListCellObjectRenderer(objViewer));
    }
    public ObjectViewer getViewer(){
        return viewer;        
    }
    

    public void setCollection(Collection<? extends Object> objects) {
        this.collection = (Collection<Object>) objects;
        this.listModel.removeAllElements();
        
        for(Object o : objects){
            listModel.addElement(o);
        }
    }
    public Iterator<Object> getCollection(){
        return (Iterator<Object>) collection;
    }
    public boolean addElement(Object obj){
        if(this.collection.contains(obj) == false){
            this.listModel.addElement(obj);
            return this.collection.add(obj);
        }
        return false;
    }
    public boolean removeElement(Object obj){
        if(this.collection.contains(obj)){
            this.listModel.removeElement(obj);
            return this.collection.remove(obj);
        }
        return false;
    }
}