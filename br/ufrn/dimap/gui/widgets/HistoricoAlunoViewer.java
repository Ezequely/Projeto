/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.widgets;

import br.ufrn.dimap.gui.ObjectViewer;
import br.ufrn.dimap.entidades.MatriculaAlunoTurma;
import br.ufrn.dimap.entidades.Turma;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import javax.swing.JTable;
import javax.swing.table.AbstractTableModel;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 *
 * @author leobrizolara
 */
public class HistoricoAlunoViewer extends JTable implements ObjectViewer{
    Collection<? extends Object> historicoAluno;
    HistoricoAlunoTableModel model;
    public HistoricoAlunoViewer(){
        super();
        model = new HistoricoAlunoTableModel();
        historicoAluno = new ArrayList<Object>();
    }

    public void setObject(Object obj) {
        if(obj instanceof Collection){
            Collection<? extends Object> historico = (Collection<? extends Object>) obj;
            if(historico == null){
                historicoAluno.clear();
            }
            else if(historico.isEmpty() == false 
                    && historico.toArray()[0] instanceof MatriculaAlunoTurma){
                historicoAluno = historico;
            }
            updateData();
        }
    }

    public Object getObject() {
        return historicoAluno;
    }

    public Component getView() {
        return this;
    }

    public Class getObjectClass() {
        return Collection.class;
    }

    private void updateData() {
        this.model.setData(historicoAluno);
    }
}

class HistoricoAlunoTableModel extends AbstractTableModel{
    //Dados exibidos:
    //      Codigo Disciplina - Nome Disciplina - Periodo letivo - Numero turma -
    //       Nota1 - Nota2 - Nota3 - Nota4 - Media - Situação do aluno
    Collection<? extends Object> historicoAluno;
    List<Object[]>table;
    String headerNames[];
    
    public HistoricoAlunoTableModel(){
        headerNames = new String[]{"Cod. Disciplina", "Disciplina", "Período", "Turma", 
            "Nota1", "Nota2", "Nota3", "Nota Recuperação", "Média", "Situação"};
        table = new ArrayList<Object[]>();
    }
    
    public void setData(Collection<? extends Object> historico){
        this.historicoAluno = historico;
        updateTable();
        this.fireTableDataChanged();
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
        table.clear();
        for(Object o : historicoAluno){
            if(o instanceof MatriculaAlunoTurma){
                MatriculaAlunoTurma alunoTurma = (MatriculaAlunoTurma) o;
                Object values[] = new Object[this.getColumnCount()];
                if(alunoTurma.getTurma() != null){
                    Turma t = alunoTurma.getTurma();
                    if(t.getDisciplina() != null){
                        values[0] = t.getDisciplina().getCodigoDisciplina();
                        values[1] = t.getDisciplina().getNome();
                    }
                    values[2] = t.getPeriodoLetivo();
                    values[3] = t.getNumeroTurma();
                }
                //obter Notas
                for(int i =0; i < 4; ++i){
                    values[4 + i] = alunoTurma.getNota(i);
                }
                values[8] = alunoTurma.getMedia();
                values[9] = alunoTurma.getSituacao();
                
                table.add(values);
            }
        }
    }
    
    public int getRowCount() {
        return table.size();
    }

    public int getColumnCount() {
        return this.headerNames.length;
    }

    public Object getValueAt(int row, int column) {
        if(getRowCount() > row && getColumnCount() > column){
            return this.table.get(row)[column];
        }
        return null;
    }

    
}
