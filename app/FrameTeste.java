/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import br.ufrn.dimap.dataAccess.AlunoDAO;
import br.ufrn.dimap.dataAccess.DatabaseController;
import br.ufrn.dimap.dataAccess.DocenteDAO;
import br.ufrn.dimap.dataAccess.MySqlDatabaseController;
import br.ufrn.dimap.dataAccess.PublicacaoDAO;
import br.ufrn.dimap.dataAccess.TurmaDAO;
import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.entidades.Turma;
import br.ufrn.dimap.gui.Navigable;
import br.ufrn.dimap.gui.NavigationEvent;
import br.ufrn.dimap.gui.telas.TelaLogin;
import br.ufrn.dimap.gui.telas.TelaVisualizarAlunos;
import br.ufrn.dimap.gui.telas.TelaVisualizarDocentes;
import br.ufrn.dimap.gui.telas.TelaVisualizarDadosDocente;
import br.ufrn.dimap.gui.telas.TelaVisualizarTurmas;
import java.awt.Container;
import java.util.Collection;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.UIManager;

/**
 *
 * @author leobrizolara
 */
public class FrameTeste extends javax.swing.JFrame{
    DatabaseController dataManager;
    Collection<? extends Object> alunos;
    Collection<? extends Object> turmas;
    /**
     * Creates new form appJFfame
     */
    public FrameTeste() {
        
        try{
            dataManager = new MySqlDatabaseController("jdbc:mysql://localhost/dbPosGraduacao", "root","root");        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            System.exit(1);
        }
        
        AlunoDAO alunoDAO = new AlunoDAO(dataManager);
        this.alunos = alunoDAO.listAll();
        
        TurmaDAO turmaDAO = new TurmaDAO(dataManager);
        this.turmas = turmaDAO.listAll();
        
        
        DocenteDAO docentesDAO = new DocenteDAO(dataManager);
        Collection<Docente> docentes = (Collection<Docente>) docentesDAO.listAll();
        
        initComponents();
        //this.telaVisaoDocentes2.setNavigableParent(this);
             
        this.telaVisualizarAlunos1.setAlunos(alunos);
        //this.newJPanel1.setAlunos(alunos);
        
        this.telaVisualizarTurmas1.setTurmas((Collection<Turma>) turmas);
        
        this.telaVisaoDocentes2.setDocentes(docentes);
        
        this.telaVisualizarDadosTurma1.setObject(turmas.toArray()[0]);
        
        
        this.objectListView1.addElement("a");
        this.objectListView1.addElement("b");
        this.objectListView1.addElement("c");
        this.objectListView1.addElement("d");
    }
    
    public void navigate(Object source, Container tela) {
        System.out.println("navigate");
        
        if(tela instanceof TelaVisualizarDadosDocente){
            TelaVisualizarDadosDocente telaDadosDocente = (TelaVisualizarDadosDocente)tela;
        
            if(telaDadosDocente.getDocente() != null)
            {
                Docente docente = telaDadosDocente.getDocente();
                TurmaDAO turmasDAO = new TurmaDAO(dataManager);                
                telaDadosDocente.setTurmasDocente((Collection<Turma>) turmasDAO.search(docente));
 
                PublicacaoDAO publicacaoDAO = new PublicacaoDAO(dataManager);
                telaDadosDocente.setPublicacoesDocente(publicacaoDAO.search(docente.getPessoa()));
                
                this.remove(this.telaVisaoDocentes2);
                this.add(telaDadosDocente);
                
                this.pack();
            }
        }
    }

    
    TelaVisualizarDadosDocente gerarTelaDocentes(){
            TurmaDAO turmasDAO = new TurmaDAO(dataManager);
            Collection<Object> turmas = (Collection<Object>) turmasDAO.listAll();
            
            Docente createdDocente = new Docente();
            
            TelaVisualizarDadosDocente panel = new TelaVisualizarDadosDocente(createdDocente, turmas);
            
            return panel;
        
    }
//    TelaVisualizarDocentes criarTelaDocentes(){
//            DocenteDAO docentesDAO = new DocenteDAO(dataManager);
//            Collection<Docente> docente = (Collection<Docente>) docentesDAO.listAll();
//                        
//            return new TelaVisualizarDocentes(docente);
//        
//    }
    TelaVisualizarDocentes criarTelaDocentes(){                        
            return new TelaVisualizarDocentes();
        
    }
    TelaVisualizarAlunos criarTelaAlunos(){
//        AlunoDAO alunoDAO = new AlunoDAO(dataManager);
//        Collection<? extends Object> alunos = alunoDAO.listAll();
//        
//        return new TelaVisualizarAlunos(alunos);
        return new TelaVisualizarAlunos();
    }
    TelaLogin criarTelaLogin(){
        return new TelaLogin(dataManager);
    }
    
    private TelaVisualizarTurmas criarTelaVisualizarTurmas(){
        return new TelaVisualizarTurmas();
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jTabbedPane1 = new javax.swing.JTabbedPane();
        telaVisaoDocentes2 = criarTelaDocentes();
        telaVisualizarAlunos1 = criarTelaAlunos();
        telaVisualizarTurmas1 = criarTelaVisualizarTurmas();
        telaVisualizarDadosTurma1 = new br.ufrn.dimap.gui.telas.TelaVisualizarDadosTurma();
        telaLogin1 = criarTelaLogin();
        jPanel1 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        objectListView1 = new br.ufrn.dimap.gui.widgets.ObjectListView();
        jButton1 = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));

        jTabbedPane1.addTab("tab1", telaVisaoDocentes2);
        jTabbedPane1.addTab("tab2", telaVisualizarAlunos1);
        jTabbedPane1.addTab("tab4", telaVisualizarTurmas1);
        jTabbedPane1.addTab("tab5", telaVisualizarDadosTurma1);
        jTabbedPane1.addTab("tab5", telaLogin1);

        jScrollPane1.setViewportView(objectListView1);

        jButton1.setText("jButton1");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 507, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(203, 203, 203)
                        .addComponent(jButton1)))
                .addContainerGap(94, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(5, 5, 5)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 230, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(28, 28, 28)
                .addComponent(jButton1)
                .addContainerGap(38, Short.MAX_VALUE))
        );

        jTabbedPane1.addTab("tab7", jPanel1);

        getContentPane().add(jTabbedPane1);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        this.objectListView1.getSelectionModel().setSelectionInterval(0, 2);
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        try {
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FrameTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FrameTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FrameTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FrameTeste.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FrameTeste().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTabbedPane jTabbedPane1;
    private br.ufrn.dimap.gui.widgets.ObjectListView objectListView1;
    private br.ufrn.dimap.gui.telas.TelaLogin telaLogin1;
    private br.ufrn.dimap.gui.telas.TelaVisualizarDocentes telaVisaoDocentes2;
    private br.ufrn.dimap.gui.telas.TelaVisualizarAlunos telaVisualizarAlunos1;
    private br.ufrn.dimap.gui.telas.TelaVisualizarDadosTurma telaVisualizarDadosTurma1;
    private br.ufrn.dimap.gui.telas.TelaVisualizarTurmas telaVisualizarTurmas1;
    // End of variables declaration//GEN-END:variables

    @Override
    public void navigate(NavigationEvent event) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
