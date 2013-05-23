package br.ufrn.dimap.entidades;

import java.util.ArrayList;
import java.util.Collection;

public class Docente extends Vinculo{
    private String titulacao;
    private String cargo;
    private Collection<Turma> turmasAtivas; //cada instancia de um docente só armazenará as turmas ativas de um professor (para reduzir o espaço consumido)

    public Docente() {
    	super();
    	turmasAtivas = new ArrayList<Turma>();
    }
    public Docente(Pessoa pessoa, String matricula) {
    	super(pessoa,matricula);
    	turmasAtivas = new ArrayList<Turma>();
    }

    public String getTitulacao() {
        return titulacao;
    }
    public void setTitulacao(String titulacao) {
        this.titulacao = titulacao;
    }

    public String getCargo() {
        return cargo;
    }
    public void setCargo(String cargo) {
        this.cargo = cargo;
    }


    public Iterable<Turma> getTurmasAtivas() {
        return turmasAtivas;
    }
    public boolean addTurma(Turma turma){
    	if(!this.turmasAtivas.contains(turma)){
    		return this.turmasAtivas.add(turma);
    	}
    	return false;
    }
    public boolean delTurma(Turma turma){
    	return turmasAtivas.remove(turma);
    }

    @Override
    public boolean equals(Object object) {
    	return object instanceof Docente && super.equals(object);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
