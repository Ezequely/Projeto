/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.entidades;

/**
 *
 * @author leobrizolara
 */
public class Aluno  extends Vinculo{
    private String grau;
    private Docente orientador;

    public Aluno() {
    	super();
    }
    public Aluno(Pessoa pessoa, String matricula) {
    	super(pessoa,matricula);
    }
    public Aluno(Vinculo vinculo){//copia dados do vinculo para aluno
        this.setAtivo(vinculo.getAtivo());
        this.setDataDeMatricula(vinculo.getDataDeMatricula());
        this.setMatricula(vinculo.getMatricula());
        this.setPessoa(vinculo.getPessoa());
        this.setLinhaDePesquisa(vinculo.getLinhaDePesquisa());        
    }

    public String getGrau() {
        return grau;
    }
    public void setGrau(String grau) {
        this.grau = grau;
    }

    public Docente getOrientador() {
        return orientador;
    }
    public void setOrientador(Docente orientador) {
        this.orientador = orientador;
    }

    @Override
    public boolean equals(Object object) {
    	return object instanceof Aluno && super.equals(object);
    }

    @Override
    public String toString() {
        return super.toString();
    }
}
