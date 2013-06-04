/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.controladores;

import br.ufrn.dimap.dataAccess.DatabaseController;
import br.ufrn.dimap.dataAccess.DisciplinaDAO;
import br.ufrn.dimap.dataAccess.LinhaDePesquisaDAO;
import br.ufrn.dimap.entidades.Disciplina;
import br.ufrn.dimap.entidades.LinhaDePesquisa;
import br.ufrn.dimap.gui.telas.Formulario;
import br.ufrn.dimap.gui.telas.TelaGerenciar;
import br.ufrn.dimap.gui.widgets.DisciplinaEditor;
import java.util.Collection;

/**
 *
 * @author leobrizolara
 */
public class DisciplinaCRUD extends ControleCRUD{
DisciplinaDAO disciplinaDAO;
    
    public DisciplinaCRUD() {
        System.out.println("Build DisciplinaCRUD");
    }
    public DisciplinaCRUD(DatabaseController dbController){
        setDataController(dbController);
    }

    @Override
    public void setDataController(DatabaseController dbController){
        super.setDataController(dbController);
        disciplinaDAO = new DisciplinaDAO(dataController);
    }
    
    @Override
    protected TelaGerenciar createTelaGerenciar() {
        System.out.println(this.toString() + ": criar tela!");
        
        TelaGerenciar tela = new TelaGerenciar();
        tela.setCollection(this.listItems());
        //tela.setCollection(disciplinaDAO.listAll());
        
        return tela;
    }
    
    @Override
    protected Formulario createFormulario() {
        System.out.println(this.toString() + ": criar formulario!");
        
        Formulario formularioEditarDisciplinas = new Formulario(null, true);
        
        DisciplinaEditor editor = new DisciplinaEditor();
        editor.setLinhasDePesquisaDisponiveis(listLinhasDePesquisa());
        
        
        
        formularioEditarDisciplinas.setViewer(editor);
        
        return formularioEditarDisciplinas;
    }

    @Override
    protected void inserir(Object obj) {
        if(obj instanceof Disciplina){
            disciplinaDAO.insert(obj);
        }
    }

    @Override
    protected void salvar(Object obj) {
        if(obj instanceof Disciplina){
            disciplinaDAO.update(obj);
        }
    }

    @Override
    protected void excluir(Object obj) {
        if(obj instanceof Disciplina){
            disciplinaDAO.remove(obj);
        }
    }


    private Collection<LinhaDePesquisa> listLinhasDePesquisa() {
        LinhaDePesquisaDAO linhaDePesquisaDAO = new LinhaDePesquisaDAO(dataController);
        return (Collection<LinhaDePesquisa>) linhaDePesquisaDAO.listAll();
    }

    @Override
    protected Collection<? extends Object> listItems() {
        return disciplinaDAO.listAll();
    }
}
