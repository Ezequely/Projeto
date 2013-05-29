/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.widgets;

import br.ufrn.dimap.entidades.Agrupamento;
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
 *
 * @author leobrizolara
 */
public class ListAgrupamentoViewer extends ObjectListView implements AgrupamentoViewer{
    Agrupamento agrupamento;
    ObjectViewer elementViewer;
  
    DefaultListModel listModel;
    ListAction listAction;
    
    
    public ListAgrupamentoViewer(){
        this(new Agrupamento(""), new DefaultObjectViewer());
    }
    public ListAgrupamentoViewer(Agrupamento agrupamento){
        this(agrupamento, new DefaultObjectViewer());
    }
    public ListAgrupamentoViewer(Agrupamento agrupamento, ObjectViewer elementViewer){
        super();
        listModel = new DefaultListModel();
        this.setModel(listModel);
        
        listAction = new ListAction(this);
        
        this.setAgrupamento(agrupamento);
        elementViewer = elementViewer;
        this.setCellRenderer(new ListCellAgrupamentoRenderer(elementViewer));
    }
    
    public void setAgrupamento(Agrupamento agrupamento) {
        this.agrupamento = agrupamento;
        
        for(Collection<? extends Object> collection : agrupamento.getCategorias()){
            this.listModel.addElement(collection);
        }
    }

    public Agrupamento getAgrupamento() {
        return agrupamento;
    }

    public Component getView() {
        return this;
    }

    public ObjectViewer getElementView() {
        return this.elementViewer;
    }

    public void setElementView(ObjectViewer view) {
        this.elementViewer = view;
    }

    public void setObject(Object obj) {
        if(obj instanceof Agrupamento){
            this.setAgrupamento((Agrupamento)obj);
        }
    }

    public Object getObject() {
        return this.agrupamento;
    }

    public Class getObjectClass() {
        return Agrupamento.class;
    }
    
    
    
    public void addActionListener(ActionListener listener){
        this.listAction.addActionListener(listener);
    }
    public void removeActionListener(ActionListener listener){
        this.listAction.removeActionListener(listener);
    }    
}


class ListCellAgrupamentoRenderer implements ListCellRenderer{
    ObjectListView listView;
    JLabel defaultView;
    ListCellAgrupamentoRenderer(ObjectViewer objView){
        listView = new ObjectListView(objView);
        defaultView = new JLabel();
        
        listView.setLayoutOrientation(JList.HORIZONTAL_WRAP);
        defaultView.setOpaque(true);
    }
    
    public Component getListCellRendererComponent(
            JList jlist, 
            Object e, 
            int index, 
            boolean isSelected, 
            boolean cellHasFocus)  
    {        
        //this.viewer.setObject(e);
        
         Color background;
         Color foreground;

         // check if this cell represents the current DnD drop location
         JList.DropLocation dropLocation = jlist.getDropLocation();
         if (dropLocation != null
                 && !dropLocation.isInsert()
                 && dropLocation.getIndex() == index) {

             //background = Color.BLUE;
             background = new Color(182, 171, 160);
             foreground = Color.WHITE;
             //background = UIManager.getColor("List.dropLineColor");
             //foreground = UIManager.getColor("List.background");

         // check if this cell is selected
         } else if (isSelected) {
             //background = Color.RED;
             background = new Color(240, 119, 70);
             foreground = Color.BLACK;

         // unselected, and not the DnD drop location
         } else {
             //nao selecionado
             background = Color.WHITE;
             foreground = Color.BLACK;
             //dependente do Look and Feel
//             background = UIManager.getColor("List.background"); 
//             foreground = UIManager.getColor("List.textForeground");
         };

         Component comp;
         if(e instanceof Collection){
            this.listView.setCollection((Collection<? extends Object>) e);
            this.listView.setBackground(background);
            this.listView.setForeground(foreground);
            comp = listView;
         }
         else{
            this.defaultView.setText(e.toString());
            this.defaultView.setBackground(background);
            this.defaultView.setForeground(foreground);
            comp = defaultView;
         }

         return comp;
    }
    
}