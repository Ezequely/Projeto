/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.widgets;

import java.awt.Component;
import javax.swing.JLabel;

/**
 *
 * @author leobrizolara
 * Uma visão generica para objetos. Utiliza o metodo toString do objeto para
 * exibi-lo na interface.
 */
public class DefaultObjectViewer extends JLabel implements ObjectViewer{
    private Object obj;
    public DefaultObjectViewer(){
        this.setOpaque(true);
    }
    public Class getObjectClass() {
        return Object.class;
    }
    public void setObject(Object obj) {
        this.obj = obj;
        this.setText(obj.toString());
    }

    public Object getObject() {
        return obj;
    }

    public Component getView() {
        return this;
    }
    
}
