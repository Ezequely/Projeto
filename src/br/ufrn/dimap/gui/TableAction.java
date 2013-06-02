/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.InputMap;
import javax.swing.JTable;
import javax.swing.KeyStroke;

public class TableAction  extends AbstractAction implements MouseListener
{
    private static final KeyStroke ENTER = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

    private JTable table;
    private KeyStroke keyStroke;
    private Collection<ActionListener> actionListeners;

    private String actionCommand;
    /*
     *	Add an Action to the JTable bound by the default KeyStroke
     */
    public TableAction(JTable table)
    {
            this(table, ENTER);
    }

    /*
     *	Add an Action to the JTable bound by the specified KeyStroke
     */
    public TableAction(JTable table, KeyStroke keyStroke)
    {
        this.actionCommand = "";
        this.actionListeners = new ArrayList<ActionListener>();
        
        this.table = table;
        this.keyStroke = keyStroke;

        //  Add the KeyStroke to the InputMap
        InputMap im = table.getInputMap();
        im.put(keyStroke, keyStroke);

        //  Add the Action to the ActionMap
        table.getActionMap().put(keyStroke, this);

        //  Handle mouse double click
        table.addMouseListener( this );
    }

    //  Implement MouseListener interface

    public void mouseClicked(MouseEvent e)
    {
        if (e.getClickCount() == 2)
        {
            Action action = table.getActionMap().get(keyStroke);

            if (action != null)
            {
                ActionEvent event = new ActionEvent(
                        table,
                        ActionEvent.ACTION_PERFORMED,
                        actionCommand);
                action.actionPerformed(event);
            }
        }
        //define a source como o objeto que foi selecionado
        //ae.setSource(this.list.getModel().getElementAt(this.list.getSelectedIndex()));
        
    }

    public void mouseEntered(MouseEvent e) {}

    public void mouseExited(MouseEvent e) {}

    public void mousePressed(MouseEvent e) {}

    public void mouseReleased(MouseEvent e) {}

        
    public void addActionListener(ActionListener listener){
        this.actionListeners.add(listener);
    }
    public void removeActionListener(ActionListener listener){
        this.actionListeners.remove(listener);
    }
        
    public void actionPerformed(ActionEvent ae) {
        for(ActionListener listener : actionListeners){
            listener.actionPerformed(ae);
        }
    }
    
    public String getActionCommand() {
        return actionCommand;
    }
    public void setActionCommand(String actionCommand) {
        this.actionCommand = actionCommand;
    }
}
