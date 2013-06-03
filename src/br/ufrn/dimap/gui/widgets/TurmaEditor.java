/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.widgets;

import br.ufrn.dimap.gui.telas.*;
import br.ufrn.dimap.entidades.Disciplina;
import br.ufrn.dimap.entidades.Docente;
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
public class TurmaEditor extends Tela implements ObjectViewer{
    Turma turma;
    
    private Collection<Disciplina> disciplinasDisponiveis;
    private Collection<Docente>    docentesDisponiveis;
    private Collection<String> statusDisponiveis;
    private static final String statusDefault[] = new String[]{"Aberta", "Consolidada"};
    
    public TurmaEditor() {
        this(new Turma());
    }

    TurmaEditor(Turma turma) {
        this(turma, new ArrayList<Docente>(), new ArrayList<Disciplina>());
    }
    TurmaEditor(
            Turma turma, 
            Collection<Docente> docentesDisponiveis, 
            Collection<Disciplina> disciplinasDisponiveis) 
    {
        initComponents();
        
        this.seletorDeDocentes.setTitulo("Docentes");
        this.seletorDeDocentes.setItems(docentesDisponiveis);
        this.seletorDeDocentes.setViewer(new VinculoViewerResumo());
        
        this.setDisciplinasDisponiveis(disciplinasDisponiveis);
        
        Collection<String> status = new ArrayList<>(statusDefault.length);
        for(String s : statusDefault){
            status.add(s);
        }
        this.setStatusDisponiveis(status);
        
        this.setObject(turma);
    }

    //Status disponíveis
    public Collection<String> getStatusDisponiveis() {
        return statusDisponiveis;
    }
    public void setStatusDisponiveis(Collection<String> statusDisponiveis) {
        this.statusDisponiveis = statusDisponiveis;
        this.cmbStatus.setModel(new DefaultComboBoxModel(statusDisponiveis.toArray()));
    }
    
    //Disciplinas disponíveis
    public Collection<Disciplina> getDisciplinasDisponiveis() {
        return disciplinasDisponiveis;
    }
    public void setDisciplinasDisponiveis(Collection<Disciplina> disciplinasDisponiveis) {
        this.disciplinasDisponiveis = disciplinasDisponiveis;
        cmbDisciplinas.setModel(new DefaultComboBoxModel(disciplinasDisponiveis.toArray()));
        cmbDisciplinas.revalidate();
        cmbDisciplinas.repaint();
        
        System.out.println(this.toString() + ".setDisciplinasDisponiveis: ");
        System.out.println(cmbDisciplinas.getModel().getSize());
    }
    
    //Docentes disponíveis
    public Collection<Docente> getDocentesDisponiveis() {
        return docentesDisponiveis;
    }
    public void setDocentesDisponiveis(Collection<Docente> docentesDisponiveis) {
        this.docentesDisponiveis = docentesDisponiveis;
        this.seletorDeDocentes.setItems(docentesDisponiveis);
        
        
        System.out.println(this.toString() + ".setDocentesDisponiveis: ");
        System.out.println(seletorDeDocentes.getUnselectedItems().size());
    }

    
    public Object getObject() {
        if(turma == null){
            turma = new Turma();
        }
        turma.setDisciplina((Disciplina) cmbDisciplinas.getSelectedItem());
        turma.setCodHorarioDeAula(txtHorario.getText());
        turma.setDocentes((Collection<Docente>) this.seletorDeDocentes.getSelectedItems());
        turma.setLocalDeAula(this.txtLocalDeAula.getText());
        turma.setNumeroTurma(Integer.parseInt(txtNumTurma.getText() ));
        turma.setPeriodoLetivo(txtPeriodo.getText());
        turma.setStatus((String) this.cmbStatus.getSelectedItem());
        
        return this.turma;
    }
    public void setObject(Object obj) {
        if(obj instanceof Turma){
            this.turma = (obj != null ? (Turma)obj : new Turma());
            
            if(turma.getDisciplina() != null){
                setDisciplina(turma.getDisciplina());
            }
            else{
                this.cmbDisciplinas.setSelectedIndex(-1);
            }
            
            this.txtPeriodo.setText(turma.getPeriodoLetivo());
            this.txtNumTurma.setText(Integer.toString(turma.getNumeroTurma()));
            this.txtHorario.setText(turma.getCodHorarioDeAula());
            this.txtLocalDeAula.setText(turma.getLocalDeAula());
            this.cmbStatus.setSelectedItem(turma.getStatus());
            //set Docentes
            if(turma.getDocentes() != null){
                this.seletorDeDocentes.setSelectedItems((Collection<? extends Object>) turma.getDocentes());
            }
        }
    }
    private void setDisciplina(Disciplina disciplina) {
        int index = 0;
        int indexDisciplina = -1;
        //evitar disciplina duplicada
        while(index < cmbDisciplinas.getItemCount() && indexDisciplina < 0){
            String codDisciplina = ((Disciplina)cmbDisciplinas.getItemAt(index)).getCodigoDisciplina();

            if(codDisciplina.equals(disciplina.getCodigoDisciplina())){
                indexDisciplina = index;
            }
            ++index;
        }
        if(indexDisciplina >= 0){
            cmbDisciplinas.setSelectedItem(indexDisciplina);
        }
        else{
            //Adiciona e seleciona disciplina
            cmbDisciplinas.addItem(disciplina);
            cmbDisciplinas.setSelectedItem(disciplina);
        }
    }
    

    public Component getView() {
        return this;
    }

    public Class getObjectClass() {
        return Turma.class;
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
        pnlGlobal = new javax.swing.JPanel();
        pnlDadosTurma = new javax.swing.JPanel();
        lblDisciplinaValor = new javax.swing.JLabel();
        lblPeriodoValor = new javax.swing.JLabel();
        lblTurmaNumLabel = new javax.swing.JLabel();
        lblHorarioLabel = new javax.swing.JLabel();
        lblLocalDeAulaLabel = new javax.swing.JLabel();
        lblStatusLabel = new javax.swing.JLabel();
        cmbDisciplinas = new javax.swing.JComboBox();
        txtPeriodo = new javax.swing.JTextField();
        txtNumTurma = new javax.swing.JTextField();
        txtHorario = new javax.swing.JTextField();
        txtLocalDeAula = new javax.swing.JTextField();
        cmbStatus = new javax.swing.JComboBox();
        seletorDeDocentes = new br.ufrn.dimap.gui.widgets.SeletorDeItemsEditor();

        setLayout(new java.awt.BorderLayout());

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        lblDisciplinaValor.setFont(lblDisciplinaValor.getFont().deriveFont(lblDisciplinaValor.getFont().getSize()+4f));
        lblDisciplinaValor.setText("Disciplina:");

        lblPeriodoValor.setFont(lblPeriodoValor.getFont().deriveFont(lblPeriodoValor.getFont().getSize()+2f));
        lblPeriodoValor.setText("Período");

        lblTurmaNumLabel.setText("Número da Turma:");

        lblHorarioLabel.setText("Horário de aula:");

        lblLocalDeAulaLabel.setText("Local de aula:");

        lblStatusLabel.setText("Status:");

        javax.swing.GroupLayout pnlDadosTurmaLayout = new javax.swing.GroupLayout(pnlDadosTurma);
        pnlDadosTurma.setLayout(pnlDadosTurmaLayout);
        pnlDadosTurmaLayout.setHorizontalGroup(
            pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosTurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosTurmaLayout.createSequentialGroup()
                        .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(lblTurmaNumLabel)
                            .addComponent(lblPeriodoValor)
                            .addComponent(lblHorarioLabel)
                            .addComponent(lblLocalDeAulaLabel)
                            .addComponent(lblStatusLabel))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(txtNumTurma)
                            .addComponent(txtPeriodo)
                            .addComponent(txtHorario)
                            .addComponent(txtLocalDeAula)
                            .addComponent(cmbStatus, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addGroup(pnlDadosTurmaLayout.createSequentialGroup()
                        .addComponent(lblDisciplinaValor)
                        .addGap(55, 55, 55)
                        .addComponent(cmbDisciplinas, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap())
        );
        pnlDadosTurmaLayout.setVerticalGroup(
            pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosTurmaLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDisciplinaValor)
                    .addComponent(cmbDisciplinas, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblPeriodoValor)
                    .addComponent(txtPeriodo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTurmaNumLabel)
                    .addComponent(txtNumTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblHorarioLabel)
                    .addComponent(txtHorario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLocalDeAulaLabel)
                    .addComponent(txtLocalDeAula, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosTurmaLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblStatusLabel)
                    .addComponent(cmbStatus, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(19, 19, 19))
        );

        javax.swing.GroupLayout pnlGlobalLayout = new javax.swing.GroupLayout(pnlGlobal);
        pnlGlobal.setLayout(pnlGlobalLayout);
        pnlGlobalLayout.setHorizontalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDadosTurma, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(seletorDeDocentes, javax.swing.GroupLayout.DEFAULT_SIZE, 449, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGlobalLayout.setVerticalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addComponent(pnlDadosTurma, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(seletorDeDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(pnlGlobal);

        add(jScrollPane1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JComboBox cmbDisciplinas;
    private javax.swing.JComboBox cmbStatus;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblDisciplinaValor;
    private javax.swing.JLabel lblHorarioLabel;
    private javax.swing.JLabel lblLocalDeAulaLabel;
    private javax.swing.JLabel lblPeriodoValor;
    private javax.swing.JLabel lblStatusLabel;
    private javax.swing.JLabel lblTurmaNumLabel;
    private javax.swing.JPanel pnlDadosTurma;
    private javax.swing.JPanel pnlGlobal;
    private br.ufrn.dimap.gui.widgets.SeletorDeItemsEditor seletorDeDocentes;
    private javax.swing.JTextField txtHorario;
    private javax.swing.JTextField txtLocalDeAula;
    private javax.swing.JTextField txtNumTurma;
    private javax.swing.JTextField txtPeriodo;
    // End of variables declaration//GEN-END:variables

}
