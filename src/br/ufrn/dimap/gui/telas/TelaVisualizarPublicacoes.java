/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.telas;

import br.ufrn.dimap.entidades.Agrupamento;
import br.ufrn.dimap.entidades.Aluno;
import br.ufrn.dimap.entidades.Publicacao;
import br.ufrn.dimap.gui.ItemSelectionEvent;
import br.ufrn.dimap.gui.ItemSelectionListener;
import br.ufrn.dimap.gui.NavigationEvent;
import java.text.SimpleDateFormat;
import java.util.Collection;
import javax.swing.JComboBox;






/**
 *
 * @author leobrizolara
 */
public class TelaVisualizarPublicacoes extends Tela implements ItemSelectionListener{

    
    enum TipoAgrupamento{
    TODOS, ANO, PERIODICO, TEMA, TIPO
    }
    
    Collection<? extends Object> publicacoes;
    TipoAgrupamento agrupamentoAtual;
    /**
     * Creates new form TelaVisualizarPublicacoes
     */
    public TelaVisualizarPublicacoes() {
        initComponents();
        agrupamentoAtual = TipoAgrupamento.TODOS;
        this.cmbTiposAgrupamento.addItem(TipoAgrupamento.TODOS);
        this.cmbTiposAgrupamento.addItem(TipoAgrupamento.ANO);
        this.cmbTiposAgrupamento.addItem(TipoAgrupamento.PERIODICO);
        this.cmbTiposAgrupamento.addItem(TipoAgrupamento.TEMA);
        this.cmbTiposAgrupamento.addItem(TipoAgrupamento.TIPO);
        
        this.tblAgrupamentoPublicacoesViewer.addItemSelectionListener(this);
    }
    public TelaVisualizarPublicacoes(Collection<? extends Object> publicacoes) {
        this();//chama construtor sem parametros
        this.setPublicacoes(publicacoes);
    }

    
    public void itemSelected(ItemSelectionEvent event) {
        
        if(event.getSelectedItem() instanceof Publicacao){
            NavigationEvent naviEvent = new NavigationEvent(this, "TelaVisualizarDadosPublicacao");
            naviEvent.addArg("Publicacao", event.getSelectedItem());
            
            this.fireNavigate(naviEvent);
        }
    }
    
    public void setPublicacoes(Collection<? extends Object> publicacoes){
        this.publicacoes = publicacoes;
        this.agrupamentoAtual = TipoAgrupamento.TODOS;
        this.agrupar();
        
        //this.setTipoAgrupamento(TipoAgrupamento.TODOS);
        //this.tableAgrupamentoListViewer1.setAgrupamento(criarAgrupamentoTodos());
        //this.lstPublicacoes.setCollection(publicacoes);
    }
    public Collection<? extends Object> getPublicacoes(){
        return this.publicacoes;
    }
    
    
    public void setTipoAgrupamento(TipoAgrupamento tipoAgrupamento) {
        if(this.agrupamentoAtual != tipoAgrupamento){
            this.agrupamentoAtual = tipoAgrupamento;
            this.agrupar();
        }
    }
    public TipoAgrupamento getTipoAgrupamento(){
        return this.agrupamentoAtual;
    }
    private void agrupar() {
        Agrupamento agrupamento;
        switch(agrupamentoAtual){
            case TODOS:
                agrupamento = criarAgrupamentoTodos();
                break;
            case ANO:
                agrupamento = criarAgrupamentoPorAno();
                break;
            case PERIODICO:
                agrupamento = criarAgrupamentoPorPeriodico();
                break;
            case TEMA:
                agrupamento = criarAgrupamentoPorTema();
                break;
            case TIPO:
                agrupamento = criarAgrupamentoPorTipo();
                break;
            default:
                throw new AssertionError(agrupamentoAtual.name());
        }
        this.tblAgrupamentoPublicacoesViewer.setAgrupamento(agrupamento);
    }
    private Agrupamento criarAgrupamentoTodos() {
        Agrupamento agrupamento = new Agrupamento("Publicações");
        agrupamento.setCategoria("Publicações", publicacoes);
        
        return agrupamento;
    }
    private Agrupamento criarAgrupamentoPorAno() {
        Agrupamento agrupamento = new Agrupamento("Publicações por ano de publicação");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        
        for(Object o : publicacoes){
            if(o instanceof Publicacao){
                Publicacao publicacao = (Publicacao)o;
                agrupamento.addItem(formatter.format(publicacao.getData()), o);
            }
        }
        
        return agrupamento;    
    }
    private Agrupamento criarAgrupamentoPorPeriodico() {
        Agrupamento agrupamento = new Agrupamento("Publicações por periódico");
        
        for(Object o : publicacoes){
            if(o instanceof Publicacao ){
                Publicacao publicacao = (Publicacao)o;
                if(publicacao.getPeriodico() != null){
                    agrupamento.addItem(publicacao.getPeriodico(), o);
                }
                else{
                    
                    agrupamento.addItem("none", o);
                }
            }
        }
        
        return agrupamento;       
    }
    private Agrupamento criarAgrupamentoPorTema() {
        Agrupamento agrupamento = new Agrupamento("Publicações por tema");
        
        for(Object o : publicacoes){
            if(o instanceof Publicacao){
                Publicacao publicacao = (Publicacao)o;
                agrupamento.addItem(publicacao.getTema(), o);
            }
        }
        
        return agrupamento;       
    }
    
    private Agrupamento criarAgrupamentoPorTipo() {
        Agrupamento agrupamento = new Agrupamento("Publicações por tipo");
        
        for(Object o : publicacoes){
            if(o instanceof Publicacao){
                Publicacao publicacao = (Publicacao)o;
                agrupamento.addItem(publicacao.getTipo(), o);
            }
        }
        
        return agrupamento;   
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        lblTipoAgrupamento = new javax.swing.JLabel();
        cmbTiposAgrupamento = new javax.swing.JComboBox();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgrupamentoPublicacoesViewer = new br.ufrn.dimap.gui.widgets.TableAgrupamentoViewer();

        setLayout(new java.awt.BorderLayout());

        jToolBar1.setRollover(true);

        lblTipoAgrupamento.setText("Agrupamento:");
        jToolBar1.add(lblTipoAgrupamento);

        cmbTiposAgrupamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmbTiposAgrupamentoActionPerformed(evt);
            }
        });
        jToolBar1.add(cmbTiposAgrupamento);

        add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jScrollPane1.setViewportView(tblAgrupamentoPublicacoesViewer);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void cmbTiposAgrupamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTiposAgrupamentoActionPerformed
        JComboBox comboBox = (JComboBox) evt.getSource();
        if(comboBox.getSelectedItem() instanceof TipoAgrupamento){
            this.setTipoAgrupamento((TipoAgrupamento) comboBox.getSelectedItem());
        }
    }//GEN-LAST:event_cmbTiposAgrupamentoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbTiposAgrupamento;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblTipoAgrupamento;
    private br.ufrn.dimap.gui.widgets.TableAgrupamentoViewer tblAgrupamentoPublicacoesViewer;
    // End of variables declaration//GEN-END:variables

}
