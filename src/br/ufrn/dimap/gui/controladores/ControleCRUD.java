/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.controladores;

import br.ufrn.dimap.dataAccess.DatabaseController;
import br.ufrn.dimap.gui.Navigable;
import br.ufrn.dimap.gui.NavigationEvent;
import br.ufrn.dimap.gui.telas.Formulario;
import br.ufrn.dimap.gui.telas.TelaGerenciar;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Collection;

/**
 *
 * @author leobrizolara
 */
public abstract class ControleCRUD implements Navigable, ActionListener{

    DatabaseController dataController;
    
    public void setDataController(DatabaseController dbController) {
        dataController = dbController;
    }
    public DatabaseController getDataController(DatabaseController dbController) {
        return dataController;
    }
    
    enum FormState{
        NONE, CREATING, UPDATING
    }
    private FormState formState;
    protected TelaGerenciar tela;
    
    public ControleCRUD(){
        formState = FormState.NONE;
    }
    
    public void show(Container container){
        System.out.print(this.toString());
        System.out.println(".show");
        
        tela = createTelaGerenciar();
        tela.setNavigableParent(this);
        
        container.removeAll();
        container.add(tela);
    }
    
    @Override
    public void navigate(NavigationEvent event) {
        String command = event.getDestination();
        
        if(command == "Novo"){
            formState = FormState.CREATING;
            abrirFormulario(null);
        }
        else if(command == "Editar"){
            formState = FormState.UPDATING;
            abrirFormulario(event.getArg("Item"));
        }
        else if (command == "Excluir"){
            excluir(event.getArg("Item"));
            
        }
        else{//error!
            System.err.println("Comando " + command + " não identificado!");
        }
    }
    
    private void abrirFormulario(Object item){
        Formulario form = createFormulario();
        if(item != null){
            form.setObject(item);
        }
        form.addActionListener(this);
        form.pack();
        form.setVisible(true);
    } 
    
    @Override
    public void actionPerformed(ActionEvent ae) {
        System.out.print(this);
        System.out.println(".actionPerformed");
        
        if(ae.getSource() instanceof Formulario){
            Formulario form = (Formulario)ae.getSource();
            if(form.isResult()){
                if(formState == FormState.CREATING){
                    Object novo = form.getObject();
                    inserir(novo);
                    tela.addItem(novo);
                }
                else if(formState == FormState.UPDATING){
                    salvar(form.getObject());
                }
            }
            formState = FormState.NONE;
        }
    }
    
    

    protected abstract TelaGerenciar createTelaGerenciar();
    protected abstract Formulario createFormulario();
    protected abstract void inserir(Object obj);
    protected abstract void salvar(Object obj);
    protected abstract void excluir(Object obj);
    
}
