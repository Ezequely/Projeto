/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.telas;

import br.ufrn.dimap.entidades.Publicacao;

/**
 *
 * @author leobrizolara
 */
public class TelaVisualizarDadosPublicacao extends Tela {

    /**
     * Creates new form TelaVisualizarDadosPublicacao
     */
    public TelaVisualizarDadosPublicacao() {
        this(null);
    }

    TelaVisualizarDadosPublicacao(Publicacao publicacao) {
        initComponents();
        this.publicacoesViewer1.setObject(publicacao);
        
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        publicacoesViewer1 = new br.ufrn.dimap.gui.widgets.PublicacoesViewer();

        setLayout(new java.awt.BorderLayout());
        add(publicacoesViewer1, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private br.ufrn.dimap.gui.widgets.PublicacoesViewer publicacoesViewer1;
    // End of variables declaration//GEN-END:variables
}
