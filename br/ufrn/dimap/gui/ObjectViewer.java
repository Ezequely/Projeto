package br.ufrn.dimap.gui;

import java.awt.Component;

/**
 * @author leobrizolara
 * 
 * Essa interface permite definir objetos que provêem uma visao para um
 * determinado tipo de objeto.
 */
public interface ObjectViewer{
    public void setObject(Object obj);
    public Object getObject();
    public Component getView();
    public Class getObjectClass();
}
