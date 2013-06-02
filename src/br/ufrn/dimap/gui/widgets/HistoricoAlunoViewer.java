/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.widgets;

import br.ufrn.dimap.gui.ObjectViewer;
import br.ufrn.dimap.entidades.MatriculaAlunoTurma;
import java.awt.Component;
import java.util.ArrayList;
import java.util.Collection;
import javax.swing.JTable;

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
        this.setModel(model);
        historicoAluno = new ArrayList<Object>();
    }

    public void setObject(Object obj) {
        if(obj instanceof Collection){
            System.out.println("HistoricoAlunoViewer.setObject: "+obj.toString());
            for(Object o : (Collection)obj ){
                System.out.println(o.toString());
            }
            
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


