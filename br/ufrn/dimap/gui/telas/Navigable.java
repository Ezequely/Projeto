/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.telas;

import java.util.EventListener;

/**
 *
 * @author leobrizolara
 */
public interface Navigable extends EventListener{
    void navigate(NavigationEvent event);
}
