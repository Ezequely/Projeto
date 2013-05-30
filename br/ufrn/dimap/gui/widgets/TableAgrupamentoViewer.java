/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.widgets;

import br.ufrn.dimap.entidades.Agrupamento;
import java.awt.Component;
import java.util.Collection;
import java.util.Iterator;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


/**
 *
 * @author leobrizolara
 */
public class TableAgrupamentoViewer extends JTable implements AgrupamentoViewer{
    AgrupamentoTableModel agrupamentoModel;
    ObjectViewer elementViewer;
    
    public TableAgrupamentoViewer(){
        super(new AgrupamentoTableModel());
        agrupamentoModel = (AgrupamentoTableModel)this.getModel();
    }
    public TableAgrupamentoViewer(Agrupamento agrupamento){
        super(new AgrupamentoTableModel(agrupamento));
        agrupamentoModel = (AgrupamentoTableModel)this.getModel();
    }
    public TableAgrupamentoViewer(Agrupamento agrupamento, ObjectViewer elemViewer){
        this(agrupamento);
        this.elementViewer = elemViewer;
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
        this.setDefaultRenderer(view.getObjectClass(), new TableAgrupamentoRenderer(this));
    }
    public void setElementView(ObjectViewer view, Class clss) {
        this.elementViewer = view;
        this.setDefaultRenderer(clss, new TableAgrupamentoRenderer(this));
    }
}
class AgrupamentoTableModel extends AbstractTableModel{
    private Agrupamento agrupamento;
    
    public AgrupamentoTableModel(){
        this(new Agrupamento(""));        
    }
    public AgrupamentoTableModel(Agrupamento agrupamento){
        super();
        setAgrupamento(agrupamento);
    }
    
    public int getRowCount() {
        int maxNumItems = 0;
        for(String nomeCategoria : agrupamento.getNomesCategoria()){
            int size = agrupamento.count(nomeCategoria);
            maxNumItems = (size > maxNumItems ? size : maxNumItems);
        }
        
        return maxNumItems;
    }

    public int getColumnCount() {
        return agrupamento.numCategorias();
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
    }
    
}

class TableAgrupamentoRenderer extends DefaultTableCellRenderer{
    AgrupamentoViewer viewer;
    
    public TableAgrupamentoRenderer(AgrupamentoViewer v){
        this.viewer = v;
    }
    
    public Component getTableCellRendererComponent(
                            JTable table, Object obj,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
        ObjectViewer elementViewer = viewer.getElementView();
        
        elementViewer.setObject(obj);
        
        //TODO: adicionar coloração
        
        
        
        return elementViewer.getView();
    }
    
}
