/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.telas;

import br.ufrn.dimap.entidades.Agrupamento;
import br.ufrn.dimap.entidades.Aluno;
import br.ufrn.dimap.gui.widgets.VinculoViewerResumo;
import java.text.SimpleDateFormat;
import java.util.Collection;
import javax.swing.JComboBox;




enum TipoAgrupamento{
    TODOS, ANO, ATIVO, GRAU, LINHADEPESQUISA
}

/**
 *
 * @author leobrizolara
 */
public class TelaVisualizarAlunos extends javax.swing.JPanel {
    Collection<? extends Object> alunos;
    TipoAgrupamento agrupamentoAtual;
    /**
     * Creates new form TelaVisualizarAlunos
     */
    public TelaVisualizarAlunos() {
        initComponents();
        agrupamentoAtual = TipoAgrupamento.TODOS;
        this.cmbTiposAgrupamento.addItem(TipoAgrupamento.TODOS);
        this.cmbTiposAgrupamento.addItem(TipoAgrupamento.ANO);
        this.cmbTiposAgrupamento.addItem(TipoAgrupamento.ATIVO);
        this.cmbTiposAgrupamento.addItem(TipoAgrupamento.GRAU);
        this.cmbTiposAgrupamento.addItem(TipoAgrupamento.LINHADEPESQUISA);
        
        System.out.println("End Constr");
        //this.lstAlunos.setViewer(new VinculoViewerResumo());
        //this.tableAgrupamentoListViewer1.setElementView(new VinculoViewerResumo());
    }
    public TelaVisualizarAlunos(Collection<? extends Object> alunos) {
        this();//chama construtor sem parametros
        this.setAlunos(alunos);
        
        System.out.println("End Constr alunos");
    }

    public void setAlunos(Collection<? extends Object> alunos){
        this.alunos = alunos;
        this.agrupamentoAtual = TipoAgrupamento.TODOS;
        this.agrupar();
        
        //this.setTipoAgrupamento(TipoAgrupamento.TODOS);
        //this.tableAgrupamentoListViewer1.setAgrupamento(criarAgrupamentoTodos());
        //this.lstAlunos.setCollection(alunos);
    }
    public Collection<? extends Object> getAlunos(){
        return this.alunos;
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
        System.out.print("Agrupar!");
        
        Agrupamento agrupamento;
        switch(agrupamentoAtual){
            case TODOS:
                agrupamento = criarAgrupamentoTodos();
                break;
            case ANO:
                agrupamento = criarAgrupamentoPorAno();
                break;
            case ATIVO:
                agrupamento = criarAgrupamentoPorAtividade();
                break;
            case GRAU:
                agrupamento = criarAgrupamentoPorGrau();
                break;
            case LINHADEPESQUISA:
                agrupamento = criarAgrupamentoPorLinhaDePesquisa();
                break;
            default:
                throw new AssertionError(agrupamentoAtual.name());
        }
        this.tableAgrupamentoListViewer1.setAgrupamento(agrupamento);
    }
    private Agrupamento criarAgrupamentoTodos() {
        Agrupamento agrupamento = new Agrupamento("Alunos");
        agrupamento.setCategoria("Alunos", alunos);
        
        return agrupamento;
    }
    private Agrupamento criarAgrupamentoPorAno() {
        Agrupamento agrupamento = new Agrupamento("Alunos por ano de entrada");
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy");
        
        for(Object o : alunos){
            if(o instanceof Aluno){
                Aluno aluno = (Aluno)o;
                agrupamento.addItem(formatter.format(aluno.getDataDeMatricula()), o);
            }
        }
        
        return agrupamento;    
    }
    private Agrupamento criarAgrupamentoPorAtividade() {
        Agrupamento agrupamento = new Agrupamento("Alunos por estado do vínculo");
        
        for(Object o : alunos){
            if(o instanceof Aluno){
                Aluno aluno = (Aluno)o;
                agrupamento.addItem((aluno.getAtivo() ? "Ativo" : "Inativo"), o);
            }
        }
        
        return agrupamento;    
    }
    private Agrupamento criarAgrupamentoPorGrau() {
        Agrupamento agrupamento = new Agrupamento("Alunos por grau");
        
        for(Object o : alunos){
            if(o instanceof Aluno){
                Aluno aluno = (Aluno)o;
                agrupamento.addItem(aluno.getGrau(), o);
            }
        }
        
        return agrupamento;       
    }
    private Agrupamento criarAgrupamentoPorLinhaDePesquisa() {
        Agrupamento agrupamento = new Agrupamento("Alunos por linha de pesquisa");
        
        for(Object o : alunos){
            if(o instanceof Aluno){
                Aluno aluno = (Aluno)o;
                if(aluno.getLinhaDePesquisa() != null && aluno.getLinhaDePesquisa().getTema() != null){
                    agrupamento.addItem(aluno.getLinhaDePesquisa().getTema(), o);
                }
                else{
                    agrupamento.addItem("none", o);
                }
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
        btnTodos = new javax.swing.JButton();
        btnAgruparPorAno = new javax.swing.JButton();
        btnAgruparPorAtividade = new javax.swing.JButton();
        btnAgruparPorGrau = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        jScrollPane2 = new javax.swing.JScrollPane();
        tableAgrupamentoListViewer1 = new br.ufrn.dimap.gui.widgets.TableAgrupamentoListViewer();

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

        btnTodos.setText("Todos");
        btnTodos.setToolTipText("Exibir os alunos sem agrupamento");
        btnTodos.setFocusable(false);
        btnTodos.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnTodos.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnTodos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnTodosActionPerformed(evt);
            }
        });
        jToolBar1.add(btnTodos);

        btnAgruparPorAno.setText("Por Ano");
        btnAgruparPorAno.setToolTipText("Agrupar alunos por ano de entrada");
        btnAgruparPorAno.setFocusable(false);
        btnAgruparPorAno.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgruparPorAno.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgruparPorAno.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgruparPorAnoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgruparPorAno);

        btnAgruparPorAtividade.setText("Ativos/Inativos");
        btnAgruparPorAtividade.setToolTipText("Exibir alunos agrupados por estado do vinculo");
        btnAgruparPorAtividade.setFocusable(false);
        btnAgruparPorAtividade.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgruparPorAtividade.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgruparPorAtividade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgruparPorAtividadeActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgruparPorAtividade);

        btnAgruparPorGrau.setText("Grau");
        btnAgruparPorGrau.setToolTipText("Exibir alunos agrupados por grau.");
        btnAgruparPorGrau.setFocusable(false);
        btnAgruparPorGrau.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAgruparPorGrau.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAgruparPorGrau.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAgruparPorGrauActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAgruparPorGrau);

        jButton1.setText("Linha De Pesquisa");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jToolBar1.add(jButton1);

        add(jToolBar1, java.awt.BorderLayout.PAGE_END);

        jScrollPane2.setViewportView(tableAgrupamentoListViewer1);

        add(jScrollPane2, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAgruparPorAnoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgruparPorAnoActionPerformed
        this.setTipoAgrupamento(TipoAgrupamento.ANO);
    }//GEN-LAST:event_btnAgruparPorAnoActionPerformed

    private void btnTodosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnTodosActionPerformed
        this.setTipoAgrupamento(TipoAgrupamento.TODOS);
    }//GEN-LAST:event_btnTodosActionPerformed

    private void btnAgruparPorAtividadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgruparPorAtividadeActionPerformed
        this.setTipoAgrupamento(TipoAgrupamento.ATIVO);
    }//GEN-LAST:event_btnAgruparPorAtividadeActionPerformed

    private void btnAgruparPorGrauActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAgruparPorGrauActionPerformed
        this.setTipoAgrupamento(TipoAgrupamento.GRAU);
    }//GEN-LAST:event_btnAgruparPorGrauActionPerformed

    private void cmbTiposAgrupamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmbTiposAgrupamentoActionPerformed
        JComboBox comboBox = (JComboBox) evt.getSource();
        if(comboBox.getSelectedItem() instanceof TipoAgrupamento){
            System.out.println("Select: " + comboBox.getSelectedItem());
            this.setTipoAgrupamento((TipoAgrupamento) comboBox.getSelectedItem());
        }
    }//GEN-LAST:event_cmbTiposAgrupamentoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAgruparPorAno;
    private javax.swing.JButton btnAgruparPorAtividade;
    private javax.swing.JButton btnAgruparPorGrau;
    private javax.swing.JButton btnTodos;
    private javax.swing.JComboBox cmbTiposAgrupamento;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblTipoAgrupamento;
    private br.ufrn.dimap.gui.widgets.TableAgrupamentoListViewer tableAgrupamentoListViewer1;
    // End of variables declaration//GEN-END:variables


}