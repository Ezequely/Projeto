/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.telas;

import br.ufrn.dimap.dataAccess.DatabaseController;
import br.ufrn.dimap.dataAccess.MySqlDatabaseController;
import br.ufrn.dimap.gui.Navigable;
import br.ufrn.dimap.gui.NavigationEvent;
import javax.swing.UIManager;

/**
 *
 * @author leobrizolara
 */
public class AppRoot extends javax.swing.JFrame implements Navigable{
    Tela telaAtual;
    DatabaseController dataManager;
    public AppRoot() {
        //Inicializar controlador do banco de dados
        try{
            dataManager = new MySqlDatabaseController("jdbc:mysql://localhost/dbPosGraduacao", "root","root");        }
        catch(ClassNotFoundException e){
            e.printStackTrace();
            System.exit(1);
        }
        
        initComponents();
        //this.navigate(new NavigationEvent(this, "TelaLogin"));
        this.navigate(new NavigationEvent(this, "TelaPrincipal"));
    }

    public void navigate(NavigationEvent event) {
        System.out.println("Navegar para: " + event.getDestination());
        
        
        String dest = event.getDestination();
        Tela tela = null;
        if(dest.equals("TelaLogin")){
            tela = navegarTelaLogin();
        }
        else if(dest.equals("TelaPrincipal")){
            tela = navegarTelaPrincipal();
        }
        else{
            System.err.println("Destino: " + event.getDestination() + " não encontrado!");
            return;
        }
        
        if(tela != null && tela != telaAtual){   
            tela.setNavigableParent(this);
            telaAtual = tela;
            telaAtual.setPreferredSize(this.getPreferredSize());
            
            this.getContentPane().removeAll();
            this.getContentPane().add(telaAtual);
            
            this.pack();
        }
    }
    
    
    private Tela navegarTelaLogin() {
        return new TelaLogin(this.dataManager);
    }
    private Tela navegarTelaPrincipal() {
        return new TelaPrincipal(this.dataManager);
    }
    
    
    
   //Codigos criados pelo Netbeans
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(640, 480));

        pack();
    }// </editor-fold>//GEN-END:initComponents

    
    public static void main(String args[]) {
        try {
            //Look and Feel do sistema
            UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(AppRoot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(AppRoot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(AppRoot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(AppRoot.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new AppRoot().setVisible(true);
            }
        });
    }
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables


}
