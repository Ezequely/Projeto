/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui;

import java.util.EventObject;

/**
 *
 * @author leobrizolara
 */
public class ItemSelectionEvent extends EventObject {
    private Object selectedItem;
    
    public ItemSelectionEvent(Object source) {
        this(source, null);
    }
    public ItemSelectionEvent(Object source, Object itemSelected) {
        super(source);
        selectedItem = itemSelected;
    }

    public Object getSelectedItem() {
        return selectedItem;
    }
    public void setSelectedItem(Object selectedItem) {
        this.selectedItem = selectedItem;
    }
    
    
}
