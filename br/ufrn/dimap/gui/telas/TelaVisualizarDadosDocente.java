/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.telas;

import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.entidades.Publicacao;
import br.ufrn.dimap.entidades.Turma;
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
public class TelaVisualizarDadosDocente extends Tela implements ActionListener{    
    Docente docente;
    Collection<? extends Object> historicoDeTurmas;
    Collection<? extends Object> publicacoesDocente;
    
    final String turmasActionCommand = "Turmas";
    final String publicacoesActionCommand = "Publicacoes";
    
    public TelaVisualizarDadosDocente() {
        this(new Docente(), null); //TODO: retirar isso
    }
    
    public TelaVisualizarDadosDocente(Docente docente, Collection<? extends Object> turmasMinistradas){    
        initComponents();
        this.viewDadosPessoais.setObject(docente);
        this.docente = docente;
        this.setTurmasDocente(turmasMinistradas);
        
        this.lstTurmasMinistradas.addActionListener(this);
        this.lstPublicacoes.addActionListener(this);
        
        lstTurmasMinistradas.setActionCommand(turmasActionCommand);
        lstPublicacoes.setActionCommand(publicacoesActionCommand);
    }

    public void setTurmasDocente(Collection<? extends Object> TurmasDocente){
        if(TurmasDocente == null){
            historicoDeTurmas = new ArrayList<Turma>();
        }
        else{
            historicoDeTurmas = TurmasDocente;
        }
        this.lstTurmasMinistradas.setCollection(historicoDeTurmas);
    }
    public Collection<? extends Object> getTurmasDocente(){
        return this.historicoDeTurmas;
    }
    
    public void setPublicacoesDocente(Collection<? extends Object> publicacoes){
        if(publicacoes == null){
            this.publicacoesDocente = new ArrayList<Turma>();
        }
        else{
            this.publicacoesDocente = publicacoes;
        }
        this.lstPublicacoes.setCollection(publicacoesDocente);
    }
    public Collection<? extends Object> getPublicacoesDocente(){
        return this.publicacoesDocente;
    }
    
    public Docente getDocente(){
        return this.docente;
    }
    public void setDocente(Docente docente){
        this.docente = docente;
        this.viewDadosPessoais.setObject(docente);
    }

    private ObjectListView criarTurmaList() {
        return new ObjectListView(new TurmaViewer());
    }
    private ObjectListView criarListaDePublicacoes(){
        return new ObjectListView();
    }
    
    
    public void actionPerformed(ActionEvent ae) {
        NavigationEvent naviEvent = new NavigationEvent(this);
        if(ae.getActionCommand().equals(turmasActionCommand)){
            naviEvent.addArg("Turma", this.getSelectedTurma());
            naviEvent.setDestination("TelaVisualizarDadosTurma");
        }
        else if(ae.getActionCommand().equals(publicacoesActionCommand)){
            naviEvent.addArg("Publicacao", this.getSelectedPublicacao());
            naviEvent.setDestination("TelaVisualizarDadosPublicacao"); //TODO: ainda nao existe
        }
        else{
            return;//acao invalida
        }
        this.fireNavigate(naviEvent);
    }
    
    public Turma getSelectedTurma(){
        if(lstTurmasMinistradas.isSelectionEmpty() == false){
            return (Turma) this.lstTurmasMinistradas.getSelectedValue();
        }
        return null;
    }
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
        pnlVisualizarDadosDocente = new javax.swing.JPanel();
        viewDadosPessoais = new br.ufrn.dimap.gui.widgets.ViewDadosPessoais();
        pnlPublicacoes = new javax.swing.JPanel();
        lblPublicacoesLabel = new javax.swing.JLabel();
        scpPublicacoes = new javax.swing.JScrollPane();
        lstPublicacoes = criarListaDePublicacoes();
        pnlMetricas = new javax.swing.JPanel();
        lblMetricasLabel = new javax.swing.JLabel();
        pnlTurmasMinistradas = new javax.swing.JPanel();
        lblTurmaMinistradasLabel = new javax.swing.JLabel();
        scrTurmasMinistradas = new javax.swing.JScrollPane();
        lstTurmasMinistradas = criarTurmaList();

        setLayout(new java.awt.BorderLayout());

        lblPublicacoesLabel.setFont(lblPublicacoesLabel.getFont().deriveFont(lblPublicacoesLabel.getFont().getStyle() | java.awt.Font.BOLD, lblPublicacoesLabel.getFont().getSize()+3));
        lblPublicacoesLabel.setText("Publicações");

        scpPublicacoes.setViewportView(lstPublicacoes);

        javax.swing.GroupLayout pnlPublicacoesLayout = new javax.swing.GroupLayout(pnlPublicacoes);
        pnlPublicacoes.setLayout(pnlPublicacoesLayout);
        pnlPublicacoesLayout.setHorizontalGroup(
            pnlPublicacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPublicacoesLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblPublicacoesLabel)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(pnlPublicacoesLayout.createSequentialGroup()
                .addComponent(scpPublicacoes, javax.swing.GroupLayout.PREFERRED_SIZE, 580, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 30, Short.MAX_VALUE))
        );
        pnlPublicacoesLayout.setVerticalGroup(
            pnlPublicacoesLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlPublicacoesLayout.createSequentialGroup()
                .addComponent(lblPublicacoesLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpPublicacoes, javax.swing.GroupLayout.DEFAULT_SIZE, 226, Short.MAX_VALUE)
                .addContainerGap())
        );

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

        lblTurmaMinistradasLabel.setFont(lblTurmaMinistradasLabel.getFont().deriveFont(lblTurmaMinistradasLabel.getFont().getStyle() | java.awt.Font.BOLD, lblTurmaMinistradasLabel.getFont().getSize()+3));
        lblTurmaMinistradasLabel.setText("Turmas Ministradas");

        scrTurmasMinistradas.setViewportView(lstTurmasMinistradas);

        javax.swing.GroupLayout pnlTurmasMinistradasLayout = new javax.swing.GroupLayout(pnlTurmasMinistradas);
        pnlTurmasMinistradas.setLayout(pnlTurmasMinistradasLayout);
        pnlTurmasMinistradasLayout.setHorizontalGroup(
            pnlTurmasMinistradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurmasMinistradasLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlTurmasMinistradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlTurmasMinistradasLayout.createSequentialGroup()
                        .addComponent(lblTurmaMinistradasLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(scrTurmasMinistradas, javax.swing.GroupLayout.DEFAULT_SIZE, 579, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlTurmasMinistradasLayout.setVerticalGroup(
            pnlTurmasMinistradasLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlTurmasMinistradasLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTurmaMinistradasLabel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scrTurmasMinistradas, javax.swing.GroupLayout.DEFAULT_SIZE, 184, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout pnlVisualizarDadosDocenteLayout = new javax.swing.GroupLayout(pnlVisualizarDadosDocente);
        pnlVisualizarDadosDocente.setLayout(pnlVisualizarDadosDocenteLayout);
        pnlVisualizarDadosDocenteLayout.setHorizontalGroup(
            pnlVisualizarDadosDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVisualizarDadosDocenteLayout.createSequentialGroup()
                .addGroup(pnlVisualizarDadosDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(viewDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlMetricas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlTurmasMinistradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(pnlVisualizarDadosDocenteLayout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(pnlPublicacoes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
        pnlVisualizarDadosDocenteLayout.setVerticalGroup(
            pnlVisualizarDadosDocenteLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlVisualizarDadosDocenteLayout.createSequentialGroup()
                .addComponent(viewDadosPessoais, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlMetricas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlTurmasMinistradas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlPublicacoes, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        scrVisualizarDados.setViewportView(pnlVisualizarDadosDocente);

        add(scrVisualizarDados, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel lblMetricasLabel;
    private javax.swing.JLabel lblPublicacoesLabel;
    private javax.swing.JLabel lblTurmaMinistradasLabel;
    private br.ufrn.dimap.gui.widgets.ObjectListView lstPublicacoes;
    private br.ufrn.dimap.gui.widgets.ObjectListView lstTurmasMinistradas;
    private javax.swing.JPanel pnlMetricas;
    private javax.swing.JPanel pnlPublicacoes;
    private javax.swing.JPanel pnlTurmasMinistradas;
    private javax.swing.JPanel pnlVisualizarDadosDocente;
    private javax.swing.JScrollPane scpPublicacoes;
    private javax.swing.JScrollPane scrTurmasMinistradas;
    private javax.swing.JScrollPane scrVisualizarDados;
    private br.ufrn.dimap.gui.widgets.ViewDadosPessoais viewDadosPessoais;
    // End of variables declaration//GEN-END:variables



}
