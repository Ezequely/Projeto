/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.controladores;

import br.ufrn.dimap.dataAccess.DatabaseController;
import br.ufrn.dimap.dataAccess.DisciplinaDAO;
import br.ufrn.dimap.dataAccess.DocenteDAO;
import br.ufrn.dimap.dataAccess.TurmaDAO;
import br.ufrn.dimap.entidades.Disciplina;
import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.entidades.Turma;
import br.ufrn.dimap.gui.telas.Formulario;
import br.ufrn.dimap.gui.telas.TelaGerenciar;
import br.ufrn.dimap.gui.widgets.TurmaEditor;
import br.ufrn.dimap.gui.widgets.TurmaViewer;
import br.ufrn.dimap.dataAccess.Parameter;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author leobrizolara
 */
public class TurmaCRUD extends ControleCRUD{
    TurmaDAO turmaDAO;
    
    public TurmaCRUD() {
        System.out.println("Build TurmaCRUD");
    }
    TurmaCRUD(DatabaseController dbController){
        setDataController(dbController);
    }

    @Override
    public void setDataController(DatabaseController dbController){
        super.setDataController(dbController);
        turmaDAO = new TurmaDAO(dataController);
    }
    
    @Override
    protected TelaGerenciar createTelaGerenciar() {
        System.out.println(this.toString() + ": criar tela!");
        
        TelaGerenciar tela = new TelaGerenciar();
        tela.setElementViewer(new TurmaViewer());
        tela.setCollection(listItems());
        //tela.setCollection(turmaDAO.listAll());
        
        return tela;
    }
    
    @Override
    protected Formulario createFormulario() {
        System.out.println(this.toString() + ": criar formulario!");
        
        Formulario formularioEditarTurmas = new Formulario(null, true);
        
        TurmaEditor editor = new TurmaEditor();
        editor.setDisciplinasDisponiveis(listDisciplinasDisponiveis());                
        editor.setDocentesDisponiveis(listDocentesDisponiveis());
        
        
        System.out.print("Disciplinas disponiveis: ");
        System.out.println(editor.getDisciplinasDisponiveis());
        System.out.print("Docentes disponiveis: ");
        System.out.println(editor.getDocentesDisponiveis());
        
        
        formularioEditarTurmas.setViewer(editor);
        
        return formularioEditarTurmas;
    }

    @Override
    protected void inserir(Object obj) {
        if(obj instanceof Turma){
            turmaDAO.insert(obj);
        }
    }

    @Override
    protected void salvar(Object obj) {
        if(obj instanceof Turma){
            turmaDAO.update(obj);
        }
    }

    @Override
    protected void excluir(Object obj) {
        if(obj instanceof Turma){
            turmaDAO.remove(obj);
        }
    }

    private Collection<Docente> listDocentesDisponiveis() {
        DocenteDAO docenteDAO = new DocenteDAO(dataController);
        return (Collection<Docente>) docenteDAO.search(new Parameter("Ativo", 1));
        
    }

    private Collection<Disciplina> listDisciplinasDisponiveis() {
        DisciplinaDAO disciplinaDAO = new DisciplinaDAO(dataController);
        return (Collection<Disciplina>) disciplinaDAO.search(new Parameter("Status", "Ativa"));
    }

    @Override
    protected Collection<? extends Object> listItems() {
        return turmaDAO.listAll();
    }
    
}
