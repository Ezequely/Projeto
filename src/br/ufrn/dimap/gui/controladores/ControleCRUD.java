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
import javax.swing.JOptionPane;

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
            executarCommand(Operation.EXCLUIR, event.getArg("Item"));
            
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
                    executarCommand(Operation.INSERIR, form.getObject());
                }
                else if(formState == FormState.UPDATING){
                    executarCommand(Operation.ATUALIZAR, form.getObject());
                }
            }
            formState = FormState.NONE;
        }
    }
    
    enum Operation{
        INSERIR, ATUALIZAR, EXCLUIR
    }
    private boolean executarCommand(Operation op, Object object){
        int updatedRows = -1;
        switch(op){
            case INSERIR:
                updatedRows = inserir(object);
                break;
            case ATUALIZAR:
                updatedRows = salvar(object);
                break;
            case EXCLUIR:
                updatedRows = excluir(object);
                break;
            default:
                throw new AssertionError(op.name());            
        }
        
        if(updatedRows > 0){
            //Atualizar items da tela
            tela.setCollection(listItems());
        }
        else if(updatedRows <= 0){
            JOptionPane.showMessageDialog(null, "Um erro inesperado ocorreu!", "", JOptionPane.ERROR_MESSAGE);
        }
        
        return (updatedRows > 0);
    }
    
    

    protected abstract TelaGerenciar createTelaGerenciar();
    protected abstract Formulario createFormulario();
    protected abstract int inserir(Object obj);
    protected abstract int salvar(Object obj);
    protected abstract int excluir(Object obj);
    protected abstract Collection<? extends Object> listItems();
    
}
