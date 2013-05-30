/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.telas;

import br.ufrn.dimap.entidades.Turma;
import br.ufrn.dimap.gui.ObjectViewer;
import br.ufrn.dimap.gui.widgets.VinculoViewerResumo;
import java.awt.Component;
import java.util.Collection;

/**
 *
 * @author leobrizolara
 */
public class TelaVisualizarDadosTurma extends Tela implements ObjectViewer {
    Turma turma;
    /**
     * Creates new form TelaVisualizarDadosTurma
     */
    public TelaVisualizarDadosTurma() {
        this(new Turma());
    }

    TelaVisualizarDadosTurma(Turma turma) {
        initComponents();
        
        this.lstDocentes.setViewer(new VinculoViewerResumo());
        
        this.setObject(turma);
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblDisciplinaValor = new javax.swing.JLabel();
        lblPeriodoValor = new javax.swing.JLabel();
        lblTurmaNumLabel = new javax.swing.JLabel();
        lblTurmaNumValor = new javax.swing.JLabel();
        lblHorarioLabel = new javax.swing.JLabel();
        lblHorarioValor = new javax.swing.JLabel();
        lblLocalDeAulaLabel = new javax.swing.JLabel();
        lblLocalDeAulaValor = new javax.swing.JLabel();
        lblStatusLabel = new javax.swing.JLabel();
        lblStatusValor = new javax.swing.JLabel();
        lblDocentesLabel = new javax.swing.JLabel();
        scpDocentes = new javax.swing.JScrollPane();
        lstDocentes = new br.ufrn.dimap.gui.widgets.ObjectListView();

        lblDisciplinaValor.setFont(lblDisciplinaValor.getFont().deriveFont(lblDisciplinaValor.getFont().getSize()+4f));
        lblDisciplinaValor.setText("<Disciplina>");

        lblPeriodoValor.setFont(lblPeriodoValor.getFont().deriveFont(lblPeriodoValor.getFont().getSize()+2f));
        lblPeriodoValor.setText("<período>");

        lblTurmaNumLabel.setText("Turma:");

        lblTurmaNumValor.setText("<nº turma>");

        lblHorarioLabel.setText("Horário de aula:");

        lblHorarioValor.setText("<horario>");

        lblLocalDeAulaLabel.setText("Local de aula:");

        lblLocalDeAulaValor.setText("<local de aula>");

        lblStatusLabel.setText("Status:");

        lblStatusValor.setText("<status>");

        lblDocentesLabel.setText("Docentes:");

        scpDocentes.setViewportView(lstDocentes);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpDocentes)
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblDisciplinaValor)
                                .addGap(18, 18, 18)
                                .addComponent(lblPeriodoValor))
                            .addComponent(lblDocentesLabel)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblHorarioLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblHorarioValor)
                                .addGap(18, 18, 18)
                                .addComponent(lblLocalDeAulaLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblLocalDeAulaValor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblStatusLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblStatusValor))
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(lblTurmaNumLabel)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(lblTurmaNumValor)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDisciplinaValor)
                    .addComponent(lblPeriodoValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTurmaNumLabel)
                    .addComponent(lblTurmaNumValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHorarioLabel)
                    .addComponent(lblHorarioValor)
                    .addComponent(lblLocalDeAulaLabel)
                    .addComponent(lblLocalDeAulaValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatusLabel)
                    .addComponent(lblStatusValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblDocentesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblDisciplinaValor;
    private javax.swing.JLabel lblDocentesLabel;
    private javax.swing.JLabel lblHorarioLabel;
    private javax.swing.JLabel lblHorarioValor;
    private javax.swing.JLabel lblLocalDeAulaLabel;
    private javax.swing.JLabel lblLocalDeAulaValor;
    private javax.swing.JLabel lblPeriodoValor;
    private javax.swing.JLabel lblStatusLabel;
    private javax.swing.JLabel lblStatusValor;
    private javax.swing.JLabel lblTurmaNumLabel;
    private javax.swing.JLabel lblTurmaNumValor;
    private br.ufrn.dimap.gui.widgets.ObjectListView lstDocentes;
    private javax.swing.JScrollPane scpDocentes;
    // End of variables declaration//GEN-END:variables

    public void setObject(Object obj) {
        if(obj instanceof Turma){
            this.turma = (Turma)obj;
            if(turma.getDisciplina() != null){
                this.lblDisciplinaValor.setText(turma.getDisciplina().getNome());
            }
            
            this.lblPeriodoValor.setText(turma.getPeriodoLetivo());
            this.lblTurmaNumValor.setText(Integer.toString(turma.getNumeroTurma()));
            
            this.lblHorarioValor.setText(turma.getCodHorarioDeAula());
            this.lblLocalDeAulaValor.setText(turma.getLocalDeAula());
            
            this.lblStatusValor.setText(turma.getStatus());
            if(this.turma.getDocentes() != null){
                this.lstDocentes.setCollection((Collection<? extends Object>) turma.getDocentes());
            }
        }
    }

    public Object getObject() {
        return this.turma;
    }

    public Component getView() {
        return this;
    }

    public Class getObjectClass() {
        return Turma.class;
    }
}
