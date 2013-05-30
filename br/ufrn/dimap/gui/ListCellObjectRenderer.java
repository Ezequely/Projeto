/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui;

import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;
import javax.swing.ListCellRenderer;

/**
 *
 * @author leobrizolara
 */
public class ListCellObjectRenderer implements ListCellRenderer{
    ObjectViewer viewer;
    
    public ListCellObjectRenderer(ObjectViewer objView){
        super();
        this.viewer = objView;
    }
    
    public Component getListCellRendererComponent(
            JList jlist, 
            Object e, 
            int index, 
            boolean isSelected, 
            boolean cellHasFocus)  
    {        
        this.viewer.setObject(e);
        
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
         }

         viewer.getView().setBackground(background);
         viewer.getView().setForeground(foreground);

         return viewer.getView();
    }
    
}
