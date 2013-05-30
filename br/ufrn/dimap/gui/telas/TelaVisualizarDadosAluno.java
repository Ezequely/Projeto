/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.telas;

import br.ufrn.dimap.gui.NavigationEvent;
import br.ufrn.dimap.entidades.Aluno;
import br.ufrn.dimap.entidades.MatriculaAlunoTurma;
import br.ufrn.dimap.entidades.Publicacao;
import br.ufrn.dimap.entidades.Turma;
import br.ufrn.dimap.gui.ItemSelectionEvent;
import br.ufrn.dimap.gui.ItemSelectionListener;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author leobrizolara
 */
public class TelaVisualizarDadosAluno extends Tela implements ItemSelectionListener{    
    Aluno aluno;
    Collection<? extends Object> historicoAluno;
    Collection<? extends Object> publicacoes;
    
    //final String turmasActionCommand = "Turmas";
    final String publicacoesActionCommand = "Publicacoes";
    
    public TelaVisualizarDadosAluno() {
        this(new Aluno());
    }
    
    public TelaVisualizarDadosAluno(Aluno aluno){    
        initComponents();
        this.viewDadosPessoais.setObject(aluno);
        this.aluno = aluno;
        historicoAluno = new ArrayList<MatriculaAlunoTurma>();
        
        //this.lstTurmas.addActionListener(this);
        this.lstPublicacoes.addItemSelectionListener(this);
    }

    public void setHistoricoAluno(Collection<? extends Object> historico){
        if(historico == null){
            historicoAluno.clear();
        }
        else{
            historicoAluno = historico;
        }
        historicoAlunoViewer.setObject(historico);
    }
    public Collection<? extends Object> getHistoricoAluno(){
        return this.historicoAluno;
    }
    
    public void setPublicacoesAluno(Collection<? extends Object> publicacoes){
        if(publicacoes == null){
            this.publicacoes = new ArrayList<Turma>();
        }
        else{
            this.publicacoes = publicacoes;
        }
        this.lstPublicacoes.setCollection(this.publicacoes);
    }
    public Collection<? extends Object> getPublicacoesAluno(){
        return this.publicacoes;
    }
    
    public Aluno getAluno(){
        return this.aluno;
    }
    public void setAluno(Aluno aluno){
        this.aluno = aluno;
        this.viewDadosPessoais.setObject(aluno);
    }
    
    
    public void itemSelected(ItemSelectionEvent event) {
        NavigationEvent naviEvent = new NavigationEvent(this);
        
        if(event.getSelectedItem() instanceof Publicacao){
            naviEvent.addArg("Publicacao", event.getSelectedItem());
            naviEvent.setDestination("TelaVisualizarDadosPublicacao"); //TODO: ainda nao existe
        }
        else{
            return;//acao invalida
        }
        this.fireNavigate(naviEvent);
    }
    
//    public Turma getSelectedTurma(){
//        if(lstTurmas.isSelectionEmpty() == false){
//            return (Turma) this.lstTurmas.getSelectedValue();
//        }
//        return null;
//    }
    public Publicacao getSelectedPublicacao(){
        if(lstPublicacoes.isSelectionEmpty() == false){
            return (Publicacao) this.lstPublicacoes.getSelectedValue();
        }
        return null;
    }
    
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        scrVisualizarDados = new javax.swing.JScrollPane();
        pnlVisualizarDadosPessoais = new javax.swing.JPanel();
        viewDadosPessoais = new br.ufrn.dimap.gui.widgets.ViewDadosPessoais();
        pnlMetricas = new javax.swing.JPanel();
        lblMetricasLabel = new javax.swing.JLabel();
        pnlHistoricoAluno = new javax.swing.JPanel();
        lblHistoricoLabel = new javax.swing.JLabel();
        scrHistoricoAluno = new javax.swing.JScrollPane();
        historicoAlunoViewer = new br.ufrn.dimap.gui.widgets.HistoricoAlunoViewer();
        pnlPublicacoes = new javax.swing.JPanel();
        lblPublicacoesLabel = new javax.swing.JLabel();
        scpPublicacoes = new javax.swing.JScrollPane();
        lstPublicacoes = new br.ufrn.dimap.gui.widgets.ObjectListView();

        setLayout(new java.awt.BorderLayout());

        lblMetricasLabel.setFont(lblMetricasLabel.getFont().deriveFont(lblMetricasLabel.getFont().getStyle() | java.awt.Font.BOLD, lblMetricasLabel.getFont().getSize()+3));
        lblMetricasLabel.setText("Métricas");

        javax.swing.GroupLayout pnlMetricasLayout = new javax.swing.GroupLayout(pnlMetricas);
        pnlMetricas.setLayout(pnlMetricasLayout);
        pnlMetricasLayout.setHorizontalGroup(
            pnlMetricasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMetricasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblMetricasLabel)
                .addContainerGap(522, Short.MAX_VALUE))
        );
        pnlMetricasLayout.setVerticalGroup(
            pnlMetricasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlMetricasLayout.createSequentialGroup()
                .addComponent(lblMetricasLabel)
                .addContainerGap(29, Short.MAX_VALUE))
        );

        pnlHistoricoAluno.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));
        pnlHistoricoAluno.setLayout(new java.awt.BorderLayout());

        lblHistoricoLabel.setFont(lblHistoricoLabel.getFont().deriveFont(lblHistoricoLabel.getFont().getStyle() | java.awt.Font.BOLD, lblHistoricoLabel.getFont().getSize()+3));
        lblHistoricoLabel.setText("Histórico");
        pnlHistoricoAluno.add(lblHistoricoLabel, java.awt.BorderLayout.NORTH);

        scrHistoricoAluno.setBorder(javax.swing.BorderFactory.createEmptyBorder(5, 5, 5, 5));

        historicoAlunoViewer.setCellSelectionEnabled(true);
        scrHistoricoAluno.setViewportView(historicoAlunoViewer);

        pnlHistoricoAluno.add(scrHistoricoAluno, java.awt.BorderLayout.CENTER);

        pnlPublicacoes.setLayout(new java.awt.BorderLayout());

        lblPublicacoesLabel.setFont(lblPublicacoesLabel.getFont().deriveFont(lblPublicacoesLabel.getFont().getStyle() | java.awt.Font.BOLD, lblPublicacoesLabel.getFont().getSize()+3));
        lblPublicacoesLabel.setText("Publicações");
        pnlPublicacoes.add(lblPublicacoesLabel, java.awt.BorderLayout.NORTH);

        scpPublicacoes.setViewportView(lstPublicacoes);

        pnlPublicacoes.add(scpPublicacoes, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlVisualizarDadosPessoaisLayout = new javax.swing.GroupLayout(pnlVisualizarDadosPessoais);
        pnlVisualizarDadosPessoais.setLayout(pnlVisualizarDadosPessoaisLayout);
        pnlVisualizarDadosPessoaisLayout.setHorizontalGroup(
            pnlVisualizarDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVisualizarDadosPessoaisLayout.createSequentialGroup()
                .addGroup(pnlVisualizarDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlHistoricoAluno, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(pnlVisualizarDadosPessoaisLayout.createSequentialGroup()
                        .addGroup(pnlVisualizarDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(viewDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(pnlMetricas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(pnlVisualizarDadosPessoaisLayout.createSequentialGroup()
                                .addContainerGap()
                                .addComponent(pnlPublicacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 600, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 10, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlVisualizarDadosPessoaisLayout.setVerticalGroup(
            pnlVisualizarDadosPessoaisLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVisualizarDadosPessoaisLayout.createSequentialGroup()
                .addComponent(viewDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMetricas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlHistoricoAluno, javax.swing.GroupLayout.PREFERRED_SIZE, 278, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPublicacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 265, Short.MAX_VALUE)
                .addContainerGap())
        );

        scrVisualizarDados.setViewportView(pnlVisualizarDadosPessoais);

        add(scrVisualizarDados, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.ufrn.dimap.gui.widgets.HistoricoAlunoViewer historicoAlunoViewer;
    private javax.swing.JLabel lblHistoricoLabel;
    private javax.swing.JLabel lblMetricasLabel;
    private javax.swing.JLabel lblPublicacoesLabel;
    private br.ufrn.dimap.gui.widgets.ObjectListView lstPublicacoes;
    private javax.swing.JPanel pnlHistoricoAluno;
    private javax.swing.JPanel pnlMetricas;
    private javax.swing.JPanel pnlPublicacoes;
    private javax.swing.JPanel pnlVisualizarDadosPessoais;
    private javax.swing.JScrollPane scpPublicacoes;
    private javax.swing.JScrollPane scrHistoricoAluno;
    private javax.swing.JScrollPane scrVisualizarDados;
    private br.ufrn.dimap.gui.widgets.ViewDadosPessoais viewDadosPessoais;
    // End of variables declaration//GEN-END:variables

}