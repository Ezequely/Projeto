/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.widgets;

import br.ufrn.dimap.gui.ItemSelectionEvent;
import br.ufrn.dimap.gui.ItemSelectionListener;
import br.ufrn.dimap.gui.ObjectViewer;
import br.ufrn.dimap.gui.ListAction;
import br.ufrn.dimap.gui.ListCellObjectRenderer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.DefaultListModel;
import javax.swing.JList;

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
public class ObjectListView extends JList<Object> implements ActionListener{
    DefaultListModel listModel;
    Collection<Object> collection;
    ObjectViewer viewer;
    
    ListAction listAction;
    final String itemSelectActionCommand = "Selected";
    Collection<ItemSelectionListener> itemSelectionListeners;
    
    public ObjectListView(){
        this(new DefaultObjectViewer(), new ArrayList<Object>());
    }
    public ObjectListView(ObjectViewer objViewer){
        this(objViewer, new ArrayList<Object>());
    }
    public ObjectListView(ObjectViewer viewer, Collection<? extends Object> objects){
        super();
        listModel = new DefaultListModel();
        this.setModel(listModel);
        
        listAction = new ListAction(this);
        listAction.setActionCommand(itemSelectActionCommand);
        listAction.addActionListener(this);
        itemSelectionListeners = new ArrayList<ItemSelectionListener>();
        
        this.setViewer(viewer);
        
        this.setCollection(objects);
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
    public Collection<? extends Object> getCollection(){
        return collection;
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

    
//    public String getActionCommand() {
//        return listAction.getActionCommand();
//    }
//    public void setActionCommand(String actionCommand) {
//        this.listAction.setActionCommand(actionCommand);
//    }
//    public void addActionListener(ActionListener listener){
//        this.listAction.addActionListener(listener);
//    }
//    public void removeActionListener(ActionListener listener){
//        this.listAction.removeActionListener(listener);
//    }
    
    //Tratamento de eventos
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == this && ae.getActionCommand() == this.itemSelectActionCommand){
            fireItemSelectedEvent();
        }
    }
    public void addItemSelectionListener(ItemSelectionListener listener){
        this.itemSelectionListeners.add(listener);
    }
    public void removeItemSelectionListener(ItemSelectionListener listener){
        this.itemSelectionListeners.remove(listener);
    }
    protected void fireItemSelectedEvent() {
        ItemSelectionEvent event = new ItemSelectionEvent(this);
        event.setSelectedItem(this.getSelectedValue());
        
        for(ItemSelectionListener listener : this.itemSelectionListeners ){
            listener.itemSelected(event);
        }
    }
}