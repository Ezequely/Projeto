/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.widgets;

import br.ufrn.dimap.gui.ObjectViewer;
import br.ufrn.dimap.gui.AgrupamentoViewer;
import br.ufrn.dimap.entidades.Agrupamento;
import br.ufrn.dimap.gui.ItemSelectionEvent;
import br.ufrn.dimap.gui.ItemSelectionListener;
import br.ufrn.dimap.gui.TableAction;
import java.awt.Color;
import java.awt.Component;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.TableCellRenderer;


/**
 *
 * @author leobrizolara
 */
public class TableAgrupamentoViewer extends JTable implements AgrupamentoViewer, ActionListener{
    AgrupamentoTableModel agrupamentoModel;
    ObjectViewer elementViewer;
    TableAction tableAction;
    Collection<ItemSelectionListener> itemSelectionListeners;
    
    
    public TableAgrupamentoViewer(){
        this(new Agrupamento(""));
    }
    public TableAgrupamentoViewer(Agrupamento agrupamento){
        this(agrupamento, new  DefaultObjectViewer());
    }
    public TableAgrupamentoViewer(Agrupamento agrupamento, ObjectViewer elemViewer){
        super(new AgrupamentoTableModel(agrupamento));
        agrupamentoModel = (AgrupamentoTableModel)this.getModel();
        this.setElementView(elemViewer);
        this.setCellSelectionEnabled(true);
        
        this.setShowHorizontalLines(false);
        
        tableAction = new TableAction(this);
        tableAction.addActionListener(this);
        itemSelectionListeners = new ArrayList<ItemSelectionListener>();
    }
    
    public void setAgrupamento(Agrupamento agrupamento){
        this.agrupamentoModel.setAgrupamento(agrupamento);
    }
    public Agrupamento getAgrupamento(){
        return this.agrupamentoModel.getAgrupamento();
    }

    public void setObject(Object obj) {
        if(obj instanceof Agrupamento){
            this.setAgrupamento((Agrupamento) obj);
        }
    }
    public Object getObject() {
        return this.getAgrupamento();
    }

    public Class getObjectClass() {
        return Agrupamento.class;
    }

    public Component getView() {
        return this;
    }

    public ObjectViewer getElementView() {
        return this.elementViewer;
    }

    public void setElementView(ObjectViewer view) {
        this.elementViewer = view;
        this.setDefaultRenderer(Object.class, new TableAgrupamentoRenderer(view));
    }
    
    //Tratamento de eventos
    public void actionPerformed(ActionEvent ae) {
        System.out.println("actionPerformed" + this.getClass());
        if(ae.getSource() == this){
            fireItemSelectedEvent();
        }
    }
    public void addItemSelectionListener(ItemSelectionListener listener){
        this.itemSelectionListeners.add(listener);
    }
    public void removeItemSelectionListener(ItemSelectionListener listener){
        this.itemSelectionListeners.remove(listener);
    }
    protected void fireItemSelectedEvent() {
        ItemSelectionEvent event = new ItemSelectionEvent(this);
        
        int selectedRow = this.getSelectionModel().getLeadSelectionIndex();
        int selectedCol = this.getColumnModel().getSelectionModel().getLeadSelectionIndex();
        Object selected =  this.getModel().getValueAt(selectedRow, selectedCol);
        
        event.setSelectedItem(selected);
        
        for(ItemSelectionListener listener : this.itemSelectionListeners ){
            listener.itemSelected(event);
        }
    }
}
class AgrupamentoTableModel extends AbstractTableModel{
    private Agrupamento agrupamento;
    int rowCount;
    int colCount;
    
    public AgrupamentoTableModel(){
        this(new Agrupamento(""));        
    }
    public AgrupamentoTableModel(Agrupamento agrupamento){
        super();
        setAgrupamento(agrupamento);
    }
    
    public int getRowCount() {
        return rowCount;
    }

    public int getColumnCount() {
        return colCount;
    }

    public Object getValueAt(int row, int collum) {
        Collection<Object> categoria;
        if(agrupamento.numCategorias() > collum){
            categoria = (Collection<Object>) agrupamento.getCategorias().toArray()[collum];
            
            if(categoria != null && categoria.size() > row){
                return categoria.toArray()[row];
            }
        }
        
        return null;
    }
    
    
    @Override
    public Class getColumnClass(int c) {
        return getValueAt(0, c).getClass();
    }
    
    @Override
    public String getColumnName(int col) {
        if(agrupamento.numCategorias() > col){
            return agrupamento.getNomesCategoria().toArray()[col].toString();
        }
        return "";
    }
    @Override
    public boolean isCellEditable(int row, int col)
        { return false; }
    @Override
    public void setValueAt(Object value, int row, int col) {
        Collection<Object> categoria;
        if(agrupamento.numCategorias() > col){
            categoria = (Collection<Object>) agrupamento.getCategorias().toArray()[col];
            
            if(categoria != null && categoria.size() > row){
                categoria.toArray()[row] = value;
            }
        }
        
        fireTableCellUpdated(row, col);
    }

    /**
     * @return the agrupamento
     */
    public Agrupamento getAgrupamento() {
        return agrupamento;
    }
    /**
     * @param agrupamento the agrupamento to set
     */
    public void setAgrupamento(Agrupamento agrupamento) {
        this.agrupamento = agrupamento;
        rowCount = calcRowCount();
        colCount = agrupamento.getNomesCategoria().size();
        this.fireTableStructureChanged();
    }
    
    int calcRowCount(){
        int maxNumItems = 0;
        for(String nomeCategoria : agrupamento.getNomesCategoria()){
//            int size = agrupamento.count(nomeCategoria);
            int size = agrupamento.getCategoria(nomeCategoria).size();
            maxNumItems = (size > maxNumItems ? size : maxNumItems);
        }
        
        return maxNumItems;
    }
    
}

class TableAgrupamentoRenderer implements TableCellRenderer{
    private ObjectViewer viewer;
    private Color unselectedBackground;
    private Color unselectedForeground;
    private Color selectedBackground;
    private Color selectedForeground;
    public TableAgrupamentoRenderer(ObjectViewer v){
        this.viewer = v;
        JTable tmp = new JTable();
        selectedBackground = tmp.getSelectionBackground();
        selectedForeground = tmp.getSelectionForeground();
        unselectedBackground = tmp.getBackground();
        unselectedForeground = tmp.getForeground();
        
    }
    
    public Component getTableCellRendererComponent(
                            JTable table, Object obj,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
        //ObjectViewer elementViewer = viewer.getElementView();
        
        getViewer().setObject(obj);
        
        int height = (int)(getViewer().getView().getPreferredSize().getHeight() * 1.1);
        if(table.getRowHeight(row) < height){
            table.setRowHeight(row, height);
        }

        int width = (int)(getViewer().getView().getPreferredSize().getWidth() * 1.1);
        if(table.getColumnModel().getColumn(column).getPreferredWidth() < width){
            table.getColumnModel().getColumn(column).setPreferredWidth(width);
        }
        
        if(isSelected){
            getViewer().getView().setForeground(selectedForeground);
            getViewer().getView().setBackground(selectedBackground);
        }
        else{
            getViewer().getView().setForeground(unselectedForeground);
            getViewer().getView().setBackground(unselectedBackground);
        }
        
        
        return getViewer().getView();
    }

    public ObjectViewer getViewer() {
        return viewer;
    }
    public void setViewer(ObjectViewer viewer) {
        this.viewer = viewer;
    }

    public Color getUnselectedBackground() {
        return unselectedBackground;
    }
    public void setUnselectedBackground(Color unselectedBackground) {
        this.unselectedBackground = unselectedBackground;
    }

    public Color getUnselectedForeground() {
        return unselectedForeground;
    }
    public void setUnselectedForeground(Color unselectedForeground) {
        this.unselectedForeground = unselectedForeground;
    }

    public Color getSelectedBackground() {
        return selectedBackground;
    }
    public void setSelectedBackground(Color selectedBackground) {
        this.selectedBackground = selectedBackground;
    }

    public Color getSelectedForeground() {
        return selectedForeground;
    }
    public void setSelectedForeground(Color selectedForeground) {
        this.selectedForeground = selectedForeground;
    }
    
}
