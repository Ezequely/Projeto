package br.ufrn.dimap.gui.widgets;

import java.awt.event.*;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.*;

/*Adaptado de : http://tips4java.wordpress.com/2008/10/14/list-action/*/
/*
 *	Add an Action to a JList that can be invoked either by using
 *  the keyboard or a mouse.
 *
 *  By default the Enter will will be used to invoke the Action
 *  from the keyboard although you can specify and KeyStroke you wish.
 *
 *  A double click with the mouse will invoke the same Action.
 *
 *  The Action can be reset at any time.
 */
public class ListAction  extends AbstractAction implements MouseListener
{
    private static final KeyStroke ENTER = KeyStroke.getKeyStroke(KeyEvent.VK_ENTER, 0);

    private JList list;
    private KeyStroke keyStroke;
    private Collection<ActionListener> actionListeners;

    /*
     *	Add an Action to the JList bound by the default KeyStroke
     */
    public ListAction(JList list)
    {
            this(list, ENTER);
    }

    /*
     *	Add an Action to the JList bound by the specified KeyStroke
     */
    public ListAction(JList list, KeyStroke keyStroke)
    {
        this.actionListeners = new ArrayList<ActionListener>();
        
            this.list = list;
            this.keyStroke = keyStroke;

            //  Add the KeyStroke to the InputMap

            InputMap im = list.getInputMap();
            im.put(keyStroke, keyStroke);

            //  Add the Action to the ActionMap

            list.getActionMap().put(keyStroke, this);

            //  Handle mouse double click

            list.addMouseListener( this );
    }

    //  Implement MouseListener interface

    public void mouseClicked(MouseEvent e)
    {
        if (e.getClickCount() == 2)
        {
            Action action = list.getActionMap().get(keyStroke);

            if (action != null)
            {
                ActionEvent event = new ActionEvent(
                        list,
                        ActionEvent.ACTION_PERFORMED,
                        "");
                action.actionPerformed(event);
            }
        }
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
        System.out.println("fired!");
        
        //define a source como o objeto que foi selecionado
        ae.setSource(this.list.getModel().getElementAt(this.list.getSelectedIndex()));
        
        for(ActionListener listener : actionListeners){
            System.out.println("fired listener!");
            listener.actionPerformed(ae);
        }
    }
}
