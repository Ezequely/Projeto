package br.ufrn.dimap.gui.widgets;

import br.ufrn.dimap.entidades.Agrupamento;
import java.awt.Component;
import java.util.Collection;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.TableCellRenderer;


/**
 *
 * @author leobrizolara
 */
public class TableAgrupamentoListViewer extends JTable implements AgrupamentoViewer{
    AgrupamentoTableListModel agrupamentoModel;
    ObjectViewer elementViewer;
    
    public TableAgrupamentoListViewer(){
        this(new Agrupamento(""));
    }
    public TableAgrupamentoListViewer(Agrupamento agrupamento){
        this(agrupamento, new  DefaultObjectViewer());
    }
    public TableAgrupamentoListViewer(Agrupamento agrupamento, ObjectViewer elemViewer){
        super(new AgrupamentoTableListModel(agrupamento));
        agrupamentoModel = (AgrupamentoTableListModel)this.getModel();
        this.setElementView(elemViewer);
//        this.elementViewer = elemViewer;
//        this.setDefaultRenderer(Object.class,  new TableListAgrupamentoRenderer(elementViewer));
//        this.setDefaultRenderer(Collection.class, new TableListAgrupamentoRenderer(elementViewer));
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
        //this.setDefaultRenderer(view.getObjectClass(), new TableListAgrupamentoRenderer(this));
        this.setDefaultRenderer(Object.class, new TableListAgrupamentoRenderer(view));
    }
    /*public void setElementView(ObjectViewer view, Class clss) {
        this.elementViewer = view;
        this.setDefaultRenderer(clss, new TableListAgrupamentoRenderer(view));
    }*/
}
class AgrupamentoTableListModel extends AbstractTableModel{
    private Agrupamento agrupamento;
    
    public AgrupamentoTableListModel(){
        this(new Agrupamento(""));        
    }
    public AgrupamentoTableListModel(Agrupamento agrupamento){
        super();
        setAgrupamento(agrupamento);
    }
    
    public int getRowCount() {//cada linha eh uma lista
        return 1;
    }

    public int getColumnCount() {
        return agrupamento.numCategorias();
    }

    public Object getValueAt(int row, int collum) {//retorna a categoria (colecao de objetos)
        Collection<Object> categoria;
        if(agrupamento.numCategorias() > collum){
            categoria = (Collection<Object>) agrupamento.getCategorias().toArray()[collum];
            return categoria;
//            if(categoria != null && categoria.size() > row){
//                return categoria.toArray()[row];
//            }
        }
        
        return null;
    }
//    public Object getValueAt(int row, int collum) {
//        Collection<Object> categoria;
//        if(agrupamento.numCategorias() > collum){
//            categoria = (Collection<Object>) agrupamento.getCategorias().toArray()[collum];
//            
//            if(categoria != null && categoria.size() > row){
//                return categoria.toArray()[row];
//            }
//        }
//        
//        return null;
//    }
    
    
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
        if(agrupamento.numCategorias() > col){
            String nomeCategoria = (String) agrupamento.getNomesCategoria().toArray()[col];
            if(value instanceof Collection){
                agrupamento.setCategoria(nomeCategoria, (Collection<? extends Object>) value);
            }
//            if(categoria != null && categoria.size() > row){
//                categoria.toArray()[row] = value;
//            }
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
        this.fireTableStructureChanged();
        System.out.println("AgrupamentoTableListModel.setAgrupamento() - fireTableStructureChanged()");
    }
    
}

class TableListAgrupamentoRenderer extends ObjectListView implements TableCellRenderer{
    
    public TableListAgrupamentoRenderer(ObjectViewer v){
        super(v);
    }
    
    public Component getTableCellRendererComponent(
                            JTable table, Object obj,
                            boolean isSelected, boolean hasFocus,
                            int row, int column) {
        if(obj instanceof Collection){
            this.setCollection((Collection<? extends Object>) obj);
            
            int height = (int)(this.getPreferredSize().getHeight() * 1.1);
            if(table.getRowHeight(row) < height){
                table.setRowHeight(row, height);
            }
            
            int width = (int)(this.getPreferredSize().getWidth() * 1.1);
            if(table.getColumnModel().getColumn(column).getPreferredWidth() < width){
                table.getColumnModel().getColumn(column).setPreferredWidth(width);
            }
            
            //TODO: adicionar coloração
        }
        else{
            
            this.addElement(obj);
        }
        
        return this;
    }
    
}
