/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.telas;

import br.ufrn.dimap.entidades.Agrupamento;
import br.ufrn.dimap.entidades.Aluno;
import br.ufrn.dimap.gui.ItemSelectionEvent;
import br.ufrn.dimap.gui.ItemSelectionListener;
import br.ufrn.dimap.gui.NavigationEvent;
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
public class TelaVisualizarAlunos extends Tela implements ItemSelectionListener{
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
        
        this.tblAgrupamentoAlunosViewer.addItemSelectionListener(this);
    }
    public TelaVisualizarAlunos(Collection<? extends Object> alunos) {
        this();//chama construtor sem parametros
        this.setAlunos(alunos);
    }

    
    public void itemSelected(ItemSelectionEvent event) {
        
        if(event.getSelectedItem() instanceof Aluno){
            NavigationEvent naviEvent = new NavigationEvent(this, "TelaVisualizarDadosAluno");
            naviEvent.addArg("Aluno", event.getSelectedItem());
            
            this.fireNavigate(naviEvent);
        }
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
        this.tblAgrupamentoAlunosViewer.setAgrupamento(agrupamento);
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
        jScrollPane1 = new javax.swing.JScrollPane();
        tblAgrupamentoAlunosViewer = new br.ufrn.dimap.gui.widgets.TableAgrupamentoViewer();

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

        jScrollPane1.setViewportView(tblAgrupamentoAlunosViewer);

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
    private br.ufrn.dimap.gui.widgets.TableAgrupamentoViewer tblAgrupamentoAlunosViewer;
    // End of variables declaration//GEN-END:variables

}
