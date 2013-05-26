/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package app;

import br.ufrn.dimap.dataAccess.DatabaseController;
import br.ufrn.dimap.dataAccess.DocenteDAO;
import br.ufrn.dimap.dataAccess.MySqlDatabaseController;
import br.ufrn.dimap.dataAccess.PublicacaoDAO;
import br.ufrn.dimap.dataAccess.TurmaDAO;
import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.entidades.Turma;
import br.ufrn.dimap.gui.telas.Navigable;
import br.ufrn.dimap.gui.telas.TelaVisualizarDocentes;
import br.ufrn.dimap.gui.telas.TelaVisualizarDadosDocente;
import java.awt.Color;
import java.awt.Container;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;
import java.util.Map.Entry;
import java.util.Set;
import javax.swing.UIManager;

/**
 *
 * @author leobrizolara
 */
public class FrameTeste extends javax.swing.JFrame implements Navigable {
    DatabaseController dataManager;
    
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
        
        initComponents();
        this.telaVisaoDocentes2.setNavigableParent(this);
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
    TelaVisualizarDocentes criarTelaDocentes(){
            DocenteDAO docentesDAO = new DocenteDAO(dataManager);
            Collection<Docente> docente = (Collection<Docente>) docentesDAO.listAll();
                        
            return new TelaVisualizarDocentes(docente);
        
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        telaVisaoDocentes2 = criarTelaDocentes();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new java.awt.GridLayout(1, 0));
        getContentPane().add(telaVisaoDocentes2);

        pack();
    }// </editor-fold>//GEN-END:initComponents

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
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
    private br.ufrn.dimap.gui.telas.TelaVisualizarDocentes telaVisaoDocentes2;
    // End of variables declaration//GEN-END:variables


}
