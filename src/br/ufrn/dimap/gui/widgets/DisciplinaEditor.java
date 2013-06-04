/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.widgets;

import br.ufrn.dimap.entidades.Disciplina;
import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.entidades.LinhaDePesquisa;
import br.ufrn.dimap.entidades.Turma;
import br.ufrn.dimap.gui.ObjectViewer;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.DefaultComboBoxModel;

/**
 *
 * @author leobrizolara
 */
public class DisciplinaEditor extends javax.swing.JPanel implements ObjectViewer{
    Disciplina disciplina;
    
    private Collection<LinhaDePesquisa> linhasDePesquisaDisponiveis;
    private Collection<String> statusDisponiveis;
    private static final String statusDefault[] = new String[]{"Ativa", "Inativa"};
    
    public DisciplinaEditor() {
        this(new Disciplina());
    }

    DisciplinaEditor(Disciplina disciplina) {
        this(disciplina, new ArrayList<LinhaDePesquisa>());
    }
    DisciplinaEditor(
            Disciplina disciplina, 
            Collection<LinhaDePesquisa> linhasDePesquisaDisponiveis) 
    {
        initComponents();
        
        this.setLinhasDePesquisaDisponiveis(linhasDePesquisaDisponiveis);
        
        Collection<String> status = new ArrayList<>(statusDefault.length);
        for(String s : statusDefault){
            status.add(s);
        }
        this.setStatusDisponiveis(status);
        
        this.setObject(disciplina);
    }

    //Status disponíveis
    public Collection<String> getStatusDisponiveis() {
        return statusDisponiveis;
    }
    public void setStatusDisponiveis(Collection<String> statusDisponiveis) {
        this.statusDisponiveis = statusDisponiveis;
        this.cmbStatusDisciplina.setModel(new DefaultComboBoxModel(statusDisponiveis.toArray()));
    }
    
    //Disciplinas disponíveis
    public Collection<LinhaDePesquisa> getLinhasDePesquisaDisponiveis() {
        return linhasDePesquisaDisponiveis;
    }
    public void setLinhasDePesquisaDisponiveis(Collection<LinhaDePesquisa> linhasDePesquisaDisponiveis) {
        this.linhasDePesquisaDisponiveis = linhasDePesquisaDisponiveis;
        cmbLinhaDePesquisa.setModel(new DefaultComboBoxModel(linhasDePesquisaDisponiveis.toArray()));
        cmbLinhaDePesquisa.revalidate();
        cmbLinhaDePesquisa.repaint();
        
    }
        
    public Object getObject() {
        if(disciplina == null){
            disciplina = new Disciplina();
        }
        disciplina.setCodigoDisciplina(this.txtCodigoDisciplina.getText());
        disciplina.setNome(txtNomeDisciplina.getText());
        disciplina.setCargaHoraria(txtCargaHoraria.getText());
        disciplina.setLinhaDePesquisa((LinhaDePesquisa)cmbLinhaDePesquisa.getSelectedItem());
        disciplina.setStatus((String) this.cmbStatusDisciplina.getSelectedItem());
        disciplina.setEmenta(this.txtEmenta.getText());
        
        return this.disciplina;
    }
    public void setObject(Object obj) {
        if(obj instanceof Disciplina){
            this.disciplina = (obj != null ? (Disciplina)obj : new Disciplina());
            
            this.txtCodigoDisciplina.setText(disciplina.getCodigoDisciplina());
            txtNomeDisciplina.setText(disciplina.getNome());
            txtCargaHoraria.setText(disciplina.getCargaHoraria());

            //cmbLinhaDePesquisa.setSelectedItem(disciplina.getLinhaDePesquisa());
            //this.cmbStatusDisciplina.setSelectedItem(disciplina.getStatus());
            
            this.setLinhaDePesquisa(disciplina.getLinhaDePesquisa());
            this.setStatus(disciplina.getStatus());

           this.txtEmenta.setText( disciplina.getEmenta());
        }
    }
    private void setLinhaDePesquisa(LinhaDePesquisa linhaDePesquisa) {
        int index = 0;
        int indexLinhaDePesquisa = -1;
        //evitar item duplicado
        while(index < cmbLinhaDePesquisa.getItemCount() && indexLinhaDePesquisa < 0){
            String codLinhaDePesquisa = ((LinhaDePesquisa)cmbLinhaDePesquisa.getItemAt(index)).getCodigo();

            if(codLinhaDePesquisa.equals(linhaDePesquisa.getCodigo())){
                indexLinhaDePesquisa = index;
            }
            ++index;
        }
        if(indexLinhaDePesquisa >= 0){
            cmbLinhaDePesquisa.setSelectedItem(indexLinhaDePesquisa);
        }
        else{
            //Adiciona e seleciona
            cmbLinhaDePesquisa.addItem(linhaDePesquisa);
            cmbLinhaDePesquisa.setSelectedItem(linhaDePesquisa);
        }
    }
    private void setStatus(String status) {
        int index = 0;
        int indexStatus = -1;
        //evitar item duplicado
        while(index < cmbStatusDisciplina.getItemCount() && indexStatus < 0){
            if(cmbStatusDisciplina.getItemAt(index).equals(status)){
                indexStatus = index;
            }
            ++index;
        }
        if(indexStatus >= 0){
            cmbStatusDisciplina.setSelectedItem(indexStatus);
        }
        else{
            //Adiciona e seleciona
            cmbStatusDisciplina.addItem(status);
            cmbStatusDisciplina.setSelectedItem(status);
        }
    }

    public Component getView() {
        return this;
    }

    public Class getObjectClass() {
        return Disciplina.class;
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
        pnlDadosTurma = new javax.swing.JPanel();
        lblTitulo = new javax.swing.JLabel();
        lblCodigoDisciplina = new javax.swing.JLabel();
        txtCodigoDisciplina = new javax.swing.JTextField();
        lblNomeDisciplina = new javax.swing.JLabel();
        txtNomeDisciplina = new javax.swing.JTextField();
        lblCargaHoraria = new javax.swing.JLabel();
        txtCargaHoraria = new javax.swing.JTextField();
        lblLinhaDePesquisa = new javax.swing.JLabel();
        cmbLinhaDePesquisa = new javax.swing.JComboBox();
        lblStatusDisciplina = new javax.swing.JLabel();
        cmbStatusDisciplina = new javax.swing.JComboBox();
        lblEmenta = new javax.swing.JLabel();
        scpEmenta = new javax.swing.JScrollPane();
        txtEmenta = new javax.swing.JTextArea();

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        lblTitulo.setFont(lblTitulo.getFont().deriveFont(lblTitulo.getFont().getSize()+4f));
        lblTitulo.setText("Disciplina:");

        lblCodigoDisciplina.setFont(lblCodigoDisciplina.getFont().deriveFont(lblCodigoDisciplina.getFont().getSize()+2f));
        lblCodigoDisciplina.setText("Código:");

        lblNomeDisciplina.setText("Nome:");

        lblCargaHoraria.setText("Carga Horária:");

        lblLinhaDePesquisa.setText("Linha de Pesquisa:");

        lblStatusDisciplina.setText("Status:");

        lblEmenta.setText("Ementa:");

        txtEmenta.setColumns(20);
        txtEmenta.setRows(5);
        scpEmenta.setViewportView(txtEmenta);

        javax.swing.GroupLayout pnlDadosTurmaLayout = new javax.swing.GroupLayout(pnlDadosTurma);
        pnlDadosTurma.setLayout(pnlDadosTurmaLayout);
        pnlDadosTurmaLayout.setHorizontalGroup(
            pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosTurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(scpEmenta, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 470, Short.MAX_VALUE)
                    .addGroup(pnlDadosTurmaLayout.createSequentialGroup()
                        .addComponent(lblLinhaDePesquisa)
                        .addGap(18, 18, 18)
                        .addComponent(cmbLinhaDePesquisa, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(pnlDadosTurmaLayout.createSequentialGroup()
                        .addComponent(lblCargaHoraria)
                        .addGap(45, 45, 45)
                        .addComponent(txtCargaHoraria))
                    .addGroup(pnlDadosTurmaLayout.createSequentialGroup()
                        .addComponent(lblNomeDisciplina)
                        .addGap(98, 98, 98)
                        .addComponent(txtNomeDisciplina))
                    .addGroup(pnlDadosTurmaLayout.createSequentialGroup()
                        .addComponent(lblCodigoDisciplina)
                        .addGap(85, 85, 85)
                        .addComponent(txtCodigoDisciplina))
                    .addGroup(pnlDadosTurmaLayout.createSequentialGroup()
                        .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTitulo)
                            .addComponent(lblEmenta))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(pnlDadosTurmaLayout.createSequentialGroup()
                        .addComponent(lblStatusDisciplina)
                        .addGap(96, 96, 96)
                        .addComponent(cmbStatusDisciplina, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDadosTurmaLayout.setVerticalGroup(
            pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosTurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(lblTitulo)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodigoDisciplina)
                    .addComponent(txtCodigoDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblNomeDisciplina)
                    .addComponent(txtNomeDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCargaHoraria)
                    .addComponent(txtCargaHoraria, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLinhaDePesquisa)
                    .addComponent(cmbLinhaDePesquisa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatusDisciplina)
                    .addComponent(cmbStatusDisciplina, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(lblEmenta)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(scpEmenta, javax.swing.GroupLayout.DEFAULT_SIZE, 124, Short.MAX_VALUE)
                .addContainerGap())
        );

        jScrollPane1.setViewportView(pnlDadosTurma);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbLinhaDePesquisa;
    private javax.swing.JComboBox cmbStatusDisciplina;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCargaHoraria;
    private javax.swing.JLabel lblCodigoDisciplina;
    private javax.swing.JLabel lblEmenta;
    private javax.swing.JLabel lblLinhaDePesquisa;
    private javax.swing.JLabel lblNomeDisciplina;
    private javax.swing.JLabel lblStatusDisciplina;
    private javax.swing.JLabel lblTitulo;
    private javax.swing.JPanel pnlDadosTurma;
    private javax.swing.JScrollPane scpEmenta;
    private javax.swing.JTextField txtCargaHoraria;
    private javax.swing.JTextField txtCodigoDisciplina;
    private javax.swing.JTextArea txtEmenta;
    private javax.swing.JTextField txtNomeDisciplina;
    // End of variables declaration//GEN-END:variables

}
