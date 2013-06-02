/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.telas;

import br.ufrn.dimap.gui.Navigable;
import br.ufrn.dimap.gui.NavigationEvent;
import br.ufrn.dimap.gui.Navigator;
import javax.swing.JPanel;

/**
 *
 * @author leobrizolara
 */
public class Tela extends JPanel implements Navigator {
    protected Navigable navigateParent;

    public void setNavigableParent(Navigable parent) {
        this.navigateParent = parent;
    }

    public Navigable getNavigableParent() {
        return this.navigateParent;
    }
    
    public void fireNavigate(String destination){
        if(this.navigateParent != null){
            navigateParent.navigate(new NavigationEvent(this, destination));
        }
    }
    public void fireNavigate(NavigationEvent event){
        if(this.navigateParent != null){
            navigateParent.navigate(event);
        }
    }
    
}
