/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.widgets;

import br.ufrn.dimap.entidades.Agrupamento;
import java.awt.Component;

/**
 *
 * @author leobrizolara
 */
public interface AgrupamentoViewer extends ObjectViewer{
    
    public void setAgrupamento(Agrupamento agrupamento);
    public Agrupamento getAgrupamento();
    public Component getView();
    public ObjectViewer getElementView();
    public void setElementView(ObjectViewer view);
}
