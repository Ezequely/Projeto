/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.widgets;

import br.ufrn.dimap.gui.ObjectViewer;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JOptionPane;

/**
 *
 * @author leobrizolara
 */
public class SeletorDeItemsEditor extends javax.swing.JPanel {
    Collection<Object> itemsDesselecionados;
    private int limiteSelecionados;
    
    //CONSTRUTORES
    
    public SeletorDeItemsEditor() {
        this("");
    }
    public SeletorDeItemsEditor(String title) {
        initComponents();
        this.setTitulo(title);
        limiteSelecionados = -1;
    }

    //MÉTODOS
    
    public void setItems(Collection<? extends Object> items){
        System.out.print(this.toString() + ".setItems : ");
        System.out.println(items);
        
        itemsDesselecionados = new ArrayList<Object>(items);//copia
        this.lstSelecionados.setCollection(new ArrayList<Object>());//esvazia selecionados
    }
    public void setSelectedItems(Collection<? extends Object> items){
        Collection<Object> toDeselect = new ArrayList<>();
        for(Object o : getSelectedItems()){
            if(!items.contains(o)){
                toDeselect.add(o);
            }
        }
        this.itemsDesselecionados.addAll(toDeselect);
        this.lstSelecionados.setCollection(items);
    }
    public Collection<? extends Object> getSelectedItems(){
        return (Collection<? extends Object>) lstSelecionados.getCollection();
    }
    public Collection<? extends Object> getUnselectedItems(){
        return itemsDesselecionados;
    }
    //selecionar
    public boolean selectItem(int index){
        if(index >=0 && index < this.itemsDesselecionados.size()){
            return selectItem(itemsDesselecionados.toArray()[index]);
        }
        return false;
    }
    public boolean selectItem(Object item){
        if(this.itemsDesselecionados.contains(item)){
            return lstSelecionados.addElement(item) && itemsDesselecionados.remove(item);
        }
        return false;
    }
    //desselecionar
    public boolean deselectItem(int index){
        Collection selecionados = (Collection)this.lstSelecionados.getCollection();
        
        if(index >=0 && index < selecionados.size()){
            return deselectItem(selecionados.toArray()[index]);
        }
        return false;
    }
    public boolean deselectItem(Object item){
        
        if(((Collection)this.lstSelecionados.getCollection()).contains(item)){
            return lstSelecionados.removeElement(item) 
                    && ((Collection)itemsDesselecionados).add(item);
        }
        return false;
    }
    
    //PROPRIEDADES
    
    public String getTitulo(){
        return this.lblTituloLabel.getText();
    }
    public void setTitulo(String titulo){
        this.lblTituloLabel.setText(titulo);
    }
    
    public int getLimiteSelecionados() {
        return limiteSelecionados;
    }
    public void setLimiteSelecionados(int limiteSelecionados) {
        this.limiteSelecionados = limiteSelecionados;
    }
    
    public void setViewer(ObjectViewer viewer){
        this.lstSelecionados.setViewer(viewer);
    }
    public ObjectViewer getViewer(){
        return this.lstSelecionados.getViewer();
    }
    
    
    //MÉTODOS AUXILIARES
    
    private void removerItem() {
        if(lstSelecionados.isSelectionEmpty() == false){
            Object selected = lstSelecionados.getSelectedValue();
            ((Collection<Object>)itemsDesselecionados).add(selected);
            lstSelecionados.removeElement(selected);
        }
    }

    private void adicionarItem() {
        if(limiteSelecionados < 0 ||
                ((Collection)this.lstSelecionados.getCollection()).size() < limiteSelecionados)
        {
            System.out.print("Desselecionados: ");
            System.out.println(itemsDesselecionados.size());
            
            Object items[] = itemsDesselecionados.toArray();
            String names[] = new String[items.length];
            for(int i = 0; i < items.length; ++i){
                names[i] = items[i].toString();
            }
            //TODO: GAMBIARRA! Problema com seleção na combobox
            
            Object selectedName = JOptionPane.showInputDialog(
                    this, 
                    "Escolha um item: ", 
                    "", 
                    JOptionPane.PLAIN_MESSAGE, 
                    null, 
                    names, 
                    (names.length > 0 ? names[0] : null));
            
            Object selected = null;
            for(int i = 0; i < items.length; ++i){
                if(items[i].toString().equals(selectedName)){
                    selected = items[i];
                    break;
                }
            }
            
//            Object selected = JOptionPane.showInputDialog(
//                    this, 
//                    "Escolha um item: ", 
//                    "", 
//                    JOptionPane.PLAIN_MESSAGE, 
//                    null, 
//                    items, 
//                    (items.length > 0 ? items[0] : null));

            if(selected != null){
                lstSelecionados.addElement(selected);
                itemsDesselecionados.remove(selected);
            }
        }
        else{
            JOptionPane.showMessageDialog(this,"Desselecione um item.","Limite máximo de items!", JOptionPane.WARNING_MESSAGE);
        }
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblTituloLabel = new javax.swing.JLabel();
        scpItems = new javax.swing.JScrollPane();
        lstSelecionados = new br.ufrn.dimap.gui.widgets.ObjectListView();
        jToolBar1 = new javax.swing.JToolBar();
        btnAdd = new javax.swing.JButton();
        btnRemover = new javax.swing.JButton();

        setLayout(new java.awt.BorderLayout());

        lblTituloLabel.setText("<titulo>:");
        add(lblTituloLabel, java.awt.BorderLayout.NORTH);

        scpItems.setViewportView(lstSelecionados);

        add(scpItems, java.awt.BorderLayout.CENTER);

        jToolBar1.setRollover(true);

        btnAdd.setText("Add");
        btnAdd.setFocusable(false);
        btnAdd.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnAdd.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnAdd.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnAddActionPerformed(evt);
            }
        });
        jToolBar1.add(btnAdd);

        btnRemover.setText("Remover");
        btnRemover.setFocusable(false);
        btnRemover.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnRemover.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnRemover.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnRemoverActionPerformed(evt);
            }
        });
        jToolBar1.add(btnRemover);

        add(jToolBar1, java.awt.BorderLayout.SOUTH);
    }// </editor-fold>//GEN-END:initComponents

    private void btnAddActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnAddActionPerformed
        adicionarItem();
    }//GEN-LAST:event_btnAddActionPerformed

    private void btnRemoverActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnRemoverActionPerformed
        removerItem();
    }//GEN-LAST:event_btnRemoverActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnAdd;
    private javax.swing.JButton btnRemover;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JLabel lblTituloLabel;
    private br.ufrn.dimap.gui.widgets.ObjectListView lstSelecionados;
    private javax.swing.JScrollPane scpItems;
    // End of variables declaration//GEN-END:variables

}
