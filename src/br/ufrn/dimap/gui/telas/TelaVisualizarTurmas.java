/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.telas;

import br.ufrn.dimap.gui.Navigable;
import br.ufrn.dimap.entidades.Turma;
import br.ufrn.dimap.gui.ItemSelectionEvent;
import br.ufrn.dimap.gui.ItemSelectionListener;
import br.ufrn.dimap.gui.NavigationEvent;
import br.ufrn.dimap.gui.widgets.ObjectListView;
import br.ufrn.dimap.gui.widgets.TurmaViewer;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author leobrizolara
 */
public class TelaVisualizarTurmas extends Tela implements ItemSelectionListener {
Collection<? extends Object> turmas;
    /**
     * Creates new form TelaVisaoTurmas
     */
    public TelaVisualizarTurmas(){
        this(new ArrayList<Turma>());
    }
    public TelaVisualizarTurmas(Collection<Turma> turmas) {
        this.turmas = turmas; 
        initComponents();
        
        this.lstTurmas.addItemSelectionListener(this);
    }
    
    public void itemSelected(ItemSelectionEvent event) {
        if(event.getSource() == this.lstTurmas && event.getSelectedItem() instanceof Turma){
            NavigationEvent naviEvent = new NavigationEvent(this, "TelaVisualizarDadosTurma");
            naviEvent.addArg("Turma", (Turma)event.getSelectedItem());
            
            this.fireNavigate(naviEvent);
        }
    }
    
    private ObjectListView  criarListaDeTurmas(){
        if(turmas == null){
            return new ObjectListView(new TurmaViewer());
        }
        else{
            return new ObjectListView(new TurmaViewer(),turmas);
        }
    }
    
    public void setTurmas(Collection<Turma> turmas){
        this.turmas = turmas;
        this.lstTurmas.setCollection(turmas);
    }
    public Collection<Turma> getTurmas(){
        return (Collection<Turma>) this.turmas;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        lstTurmas = criarListaDeTurmas();

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setViewportView(lstTurmas);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private br.ufrn.dimap.gui.widgets.ObjectListView lstTurmas;
    // End of variables declaration//GEN-END:variables

}