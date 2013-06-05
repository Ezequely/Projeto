/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.telas;

import br.ufrn.dimap.entidades.BancaExaminadora;
import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.gui.ItemSelectionEvent;
import br.ufrn.dimap.gui.ItemSelectionListener;
import br.ufrn.dimap.gui.ObjectViewer;
import java.awt.Component;
import java.text.SimpleDateFormat;

/**
 *
 * @author leobrizolara
 */
public class TelaVisualizarDadosBancaExaminadora extends Tela implements ObjectViewer, ItemSelectionListener {
    BancaExaminadora banca;
    
    public TelaVisualizarDadosBancaExaminadora() {
        this(new BancaExaminadora());
    }

    TelaVisualizarDadosBancaExaminadora(BancaExaminadora banca) {
        initComponents();
        
        //this.lstExaminadores.setViewer(new VinculoViewerResumo());
        //this.lstExaminadores.setViewer(new ExaminadorViewer());
        
        this.setObject(banca);
    }

    
    public void setObject(Object obj) {
        if(obj != null && obj instanceof BancaExaminadora){
            this.banca = (BancaExaminadora)obj;
            
            this.lblTituloValor.setText(
               (banca.getDissertacao() != null ? banca.getDissertacao().getTitulo() : ""));
            
            if(banca.getAluno() != null){
                this.lblGrauValor.setText(banca.getAluno().getGrau());
                if(banca.getAluno().getPessoa() != null){
                    this.lblAutorValor.setText(banca.getAluno().getPessoa().getNome());
                    Docente orientador = banca.getAluno().getOrientador();
                    this.lblOrientadorValor.setText(
                     (orientador!=null && orientador.getPessoa()!= null ? orientador.getPessoa().getNome() : ""));
                            
                }
                else{
                    lblAutorValor.setText("");
                    lblOrientadorValor.setText("");
                }
            }
            else{
                lblAutorValor.setText("");
                lblOrientadorValor.setText("");
                this.lblGrauValor.setText("");
            }
            SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
            this.lblDataValor.setText(formatter.format(banca.getDataDeDefesa()));
            
            if(banca.getExaminadores() != null){
                this.lstExaminadores.setCollection(banca.getExaminadores());
            }
            
            this.updateGui();
        }
    }

    public Object getObject() {
        return this.banca;
    }

    public Component getView() {
        return this;
    }

    public Class getObjectClass() {
        return BancaExaminadora.class;
    }

//    private void agrupar() {//TODO: adicionar novas formas de agrupamento?
//        if(alunosTurma != null){
//            agrupamentoAlunos = new Agrupamento("Alunos");
//            for(Object obj : alunosTurma){
//                if(obj instanceof MatriculaAlunoTurma){
//                    this.agrupamentoAlunos.addItem("Alunos", obj);
//                }
//            }
//            this.tableAgrupamentoAlunos.setAgrupamento(agrupamentoAlunos);
//        }
//    }
    
    public void itemSelected(ItemSelectionEvent event) {
//        if(event.getSelectedItem() instanceof MatriculaAlunoTurma){
//            NavigationEvent eventNavi = new NavigationEvent(this, "TelaVisualizarDadosAluno");
//            eventNavi.addArg("Aluno", ((MatriculaAlunoTurma)event.getSelectedItem()).getAluno());
//            this.fireNavigate(eventNavi);
//        }
    }
    
    private void updateGui() {
        this.revalidate();
        this.repaint();
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
        pnlDadosBancaExaminadora = new javax.swing.JPanel();
        lblAutorLabel = new javax.swing.JLabel();
        lblAutorValor = new javax.swing.JLabel();
        lblGrauLabel = new javax.swing.JLabel();
        lblGrauValor = new javax.swing.JLabel();
        lbTituloLabel = new javax.swing.JLabel();
        lblTituloValor = new javax.swing.JLabel();
        lblDataDaDefesaLabel = new javax.swing.JLabel();
        lblDataValor = new javax.swing.JLabel();
        lblOrientadorLabel = new javax.swing.JLabel();
        lblOrientadorValor = new javax.swing.JLabel();
        pnlDocentes = new javax.swing.JPanel();
        lblDocentesLabel = new javax.swing.JLabel();
        scpDocentes = new javax.swing.JScrollPane();
        lstExaminadores = new br.ufrn.dimap.gui.widgets.ObjectListView();

        jScrollPane1.setVerticalScrollBarPolicy(javax.swing.ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        lblAutorLabel.setText("Autor:");

        lblAutorValor.setText("<autor>");

        lblGrauLabel.setText("Grau:");

        lblGrauValor.setText("<grau>");

        lbTituloLabel.setText("Título:");

        lblTituloValor.setText("<título>");

        lblDataDaDefesaLabel.setText("Data da defesa:");

        lblDataValor.setText("<data>");

        lblOrientadorLabel.setText("Orientador:");

        lblOrientadorValor.setText("<orientador>");

        javax.swing.GroupLayout pnlDadosBancaExaminadoraLayout = new javax.swing.GroupLayout(pnlDadosBancaExaminadora);
        pnlDadosBancaExaminadora.setLayout(pnlDadosBancaExaminadoraLayout);
        pnlDadosBancaExaminadoraLayout.setHorizontalGroup(
            pnlDadosBancaExaminadoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosBancaExaminadoraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosBancaExaminadoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(pnlDadosBancaExaminadoraLayout.createSequentialGroup()
                        .addComponent(lbTituloLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblTituloValor))
                    .addGroup(pnlDadosBancaExaminadoraLayout.createSequentialGroup()
                        .addComponent(lblOrientadorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblOrientadorValor))
                    .addGroup(pnlDadosBancaExaminadoraLayout.createSequentialGroup()
                        .addComponent(lblDataDaDefesaLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblDataValor))
                    .addGroup(pnlDadosBancaExaminadoraLayout.createSequentialGroup()
                        .addComponent(lblAutorLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblAutorValor))
                    .addGroup(pnlDadosBancaExaminadoraLayout.createSequentialGroup()
                        .addComponent(lblGrauLabel)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(lblGrauValor)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        pnlDadosBancaExaminadoraLayout.setVerticalGroup(
            pnlDadosBancaExaminadoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosBancaExaminadoraLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlDadosBancaExaminadoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblAutorLabel)
                    .addComponent(lblAutorValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosBancaExaminadoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblGrauLabel)
                    .addComponent(lblGrauValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosBancaExaminadoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lbTituloLabel)
                    .addComponent(lblTituloValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosBancaExaminadoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblDataDaDefesaLabel)
                    .addComponent(lblDataValor))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosBancaExaminadoraLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblOrientadorLabel)
                    .addComponent(lblOrientadorValor))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pnlDocentes.setLayout(new java.awt.BorderLayout());

        lblDocentesLabel.setText("Banca Examinadora:");
        pnlDocentes.add(lblDocentesLabel, java.awt.BorderLayout.NORTH);

        scpDocentes.setViewportView(lstExaminadores);

        pnlDocentes.add(scpDocentes, java.awt.BorderLayout.CENTER);

        javax.swing.GroupLayout pnlGlobalLayout = new javax.swing.GroupLayout(pnlGlobal);
        pnlGlobal.setLayout(pnlGlobalLayout);
        pnlGlobalLayout.setHorizontalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addGroup(pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(pnlDadosBancaExaminadora, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(pnlDocentes, javax.swing.GroupLayout.DEFAULT_SIZE, 463, Short.MAX_VALUE))
                .addContainerGap())
        );
        pnlGlobalLayout.setVerticalGroup(
            pnlGlobalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(pnlGlobalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(pnlDadosBancaExaminadora, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(pnlDocentes, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(362, Short.MAX_VALUE))
        );

        jScrollPane1.setViewportView(pnlGlobal);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 326, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lbTituloLabel;
    private javax.swing.JLabel lblAutorLabel;
    private javax.swing.JLabel lblAutorValor;
    private javax.swing.JLabel lblDataDaDefesaLabel;
    private javax.swing.JLabel lblDataValor;
    private javax.swing.JLabel lblDocentesLabel;
    private javax.swing.JLabel lblGrauLabel;
    private javax.swing.JLabel lblGrauValor;
    private javax.swing.JLabel lblOrientadorLabel;
    private javax.swing.JLabel lblOrientadorValor;
    private javax.swing.JLabel lblTituloValor;
    private br.ufrn.dimap.gui.widgets.ObjectListView lstExaminadores;
    private javax.swing.JPanel pnlDadosBancaExaminadora;
    private javax.swing.JPanel pnlDocentes;
    private javax.swing.JPanel pnlGlobal;
    private javax.swing.JScrollPane scpDocentes;
    // End of variables declaration//GEN-END:variables


}
