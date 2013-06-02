/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.widgets;

import br.ufrn.dimap.entidades.MatriculaAlunoTurma;
import br.ufrn.dimap.entidades.Turma;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.table.AbstractTableModel;

/**
 *
 * @author leobrizolara
 */
public class HistoricoAlunoTableModel extends AbstractTableModel{
    //Dados exibidos:
    //      Codigo Disciplina - Nome Disciplina - Periodo letivo - Numero turma -
    //       Nota1 - Nota2 - Nota3 - Nota4 - Media - Situação do aluno
    Collection<? extends Object> historicoAluno;
    List<Object[]>dataTable;
    String headerNames[];
    boolean editable[];
    
    public HistoricoAlunoTableModel(){
        headerNames = new String[]{"Cod. Disciplina", "Disciplina", "Período", "Turma", 
            "Nota1", "Nota2", "Nota3", "Nota Recuperação", "Média", "Situação"};
        dataTable = new ArrayList<Object[]>();
        
        editable = new boolean[headerNames.length];
        for(int i=0; i < editable.length; ++i){
            editable[i] = false;
        }
    }
    
    @Override
    public boolean isCellEditable(int row, int col){
        return isEditable(col);
    }
    public void setEditable(int col, boolean canEdit){
        editable[col] = canEdit;
    }
    public boolean isEditable(int col){
        return editable[col];
    }
    
    public void setData(Collection<? extends Object> historico){
        this.historicoAluno = historico;
        updateTable();
        //this.fireTableDataChanged();
        this.fireTableStructureChanged();
    }
    public Collection<? extends Object> getData(){
        return historicoAluno;
    }
    
    @Override
    public String getColumnName(int column){
        if(column < getColumnCount()){
            return headerNames[column];
        }
        return null;
    }
    
    
    protected void updateTable() {
        dataTable.clear();
        for(Object o : historicoAluno){
            if(o instanceof MatriculaAlunoTurma){
                MatriculaAlunoTurma alunoTurma = (MatriculaAlunoTurma) o;
                Object tableRow[] = new Object[this.getColumnCount()];
                if(alunoTurma.getTurma() != null){
                    Turma t = alunoTurma.getTurma();
                    if(t.getDisciplina() != null){
                        tableRow[0] = t.getDisciplina().getCodigoDisciplina();
                        tableRow[1] = t.getDisciplina().getNome();
                    }
                    tableRow[2] = t.getPeriodoLetivo();
                    tableRow[3] = t.getNumeroTurma();
                }
                //obter Notas
                for(int i =0; i < 4; ++i){
                    tableRow[4 + i] = alunoTurma.getNota(i);
                }
                tableRow[8] = alunoTurma.getMedia();
                tableRow[9] = alunoTurma.getSituacao();
                
                dataTable.add(tableRow);
            }
        }
    }
    
    public int getRowCount() {
        return dataTable.size();
    }

    public int getColumnCount() {
        return this.headerNames.length;
    }

    public Object getValueAt(int row, int column) {
        if(getRowCount() > row && getColumnCount() > column){
            return this.dataTable.get(row)[column];
        }
        return null;
    }

    
}