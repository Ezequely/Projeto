/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.widgets;

import br.ufrn.dimap.entidades.Turma;
import java.awt.Color;
import java.awt.Component;
import javax.swing.JList;

/**
 *
 * @author leobrizolara
 */
public class TurmaViewer extends javax.swing.JPanel implements ObjectViewer{
    Turma turma;
    /**
     * Creates new form ViewTurma
     */
    public TurmaViewer() {
        initComponents();
    }
    

    public void setObject(Object obj) {
        if(obj instanceof Turma){
            this.setTurma((Turma)obj);
        }
    }

    public Object getObject() {
        return getTurma();
    }

    public Class getObjectClass() {
        return Turma.class;
    }
    
    public Component getView() {
        return this;
    }
    public void setTurma(Turma t){
        this.turma = t;
        update();
    }
    public Turma getTurma(){
        return turma;
    }
    public void update(){
        if(turma != null){
            this.lblDisciplina.setText(this.turma.getDisciplina().getNome());
            this.lblHorarioDeAula.setText(turma.getCodHorarioDeAula());
            this.lblLocalDeAula.setText(turma.getLocalDeAula());
            this.lblNumTurma.setText(Integer.toString(turma.getNumeroTurma()));
            this.lblSituacaoTurma.setText(turma.getStatus());
            this.lblPeriodo.setText(turma.getPeriodoLetivo());
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDisciplina = new javax.swing.JLabel();
        lblPeriodo = new javax.swing.JLabel();
        lblNumTurma = new javax.swing.JLabel();
        lblSituacaoTurma = new javax.swing.JLabel();
        lblHorarioDeAula = new javax.swing.JLabel();
        lblLocalDeAula = new javax.swing.JLabel();

        setLayout(new java.awt.FlowLayout(java.awt.FlowLayout.LEFT, 15, 5));

        lblDisciplina.setText("Disciplina Valor");
        add(lblDisciplina);

        lblPeriodo.setText("Periodo Valor");
        add(lblPeriodo);

        lblNumTurma.setText("Num Turma Valor");
        add(lblNumTurma);

        lblSituacaoTurma.setText("Situação turma Valor");
        add(lblSituacaoTurma);

        lblHorarioDeAula.setText("Horario de aula valor");
        add(lblHorarioDeAula);

        lblLocalDeAula.setText("Local de aula valor");
        add(lblLocalDeAula);
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDisciplina;
    private javax.swing.JLabel lblHorarioDeAula;
    private javax.swing.JLabel lblLocalDeAula;
    private javax.swing.JLabel lblNumTurma;
    private javax.swing.JLabel lblPeriodo;
    private javax.swing.JLabel lblSituacaoTurma;
    // End of variables declaration//GEN-END:variables

    public Component getListCellRendererComponent(
            JList<? extends Turma> jlist, 
            Turma e, 
            int index, 
            boolean isSelected, 
            boolean bln1) 
    {
        this.setTurma(e);
        
        
         Color background;
         Color foreground;

         // check if this cell represents the current DnD drop location
         JList.DropLocation dropLocation = jlist.getDropLocation();
         if (dropLocation != null
                 && !dropLocation.isInsert()
                 && dropLocation.getIndex() == index) {

             background = Color.BLUE;
             foreground = Color.WHITE;

         // check if this cell is selected
         } else if (isSelected) {
             background = Color.RED;
             foreground = Color.WHITE;

         // unselected, and not the DnD drop location
         } else {
             background = Color.WHITE;
             foreground = Color.BLACK;
         };

         setBackground(background);
         setForeground(foreground);

         return this;
    }

}