/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.entidades;

/**
 *
 * @author leobrizolara
 */
public class Disciplina {
    private String nome;
    private String codigoDisciplina;
    private String cargaHoraria;
    private String ementa;
    private String status;
    private LinhaDePesquisa codLinhaDePesquisa;

    public Disciplina() {
    }

    public Disciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getNome() {
        return nome;
    }
    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCodigoDisciplina() {
        return codigoDisciplina;
    }
    public void setCodigoDisciplina(String codigoDisciplina) {
        this.codigoDisciplina = codigoDisciplina;
    }

    public String getCargaHoraria() {
        return cargaHoraria;
    }
    public void setCargaHoraria(String cargaHoraria) {
        this.cargaHoraria = cargaHoraria;
    }

    public String getEmenta() {
        return ementa;
    }
    public void setEmenta(String ementa) {
        this.ementa = ementa;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public LinhaDePesquisa getLinhaDePesquisa() {
        return codLinhaDePesquisa;
    }
    public void setLinhaDePesquisa(LinhaDePesquisa codLinhaDePesquisa) {
        this.codLinhaDePesquisa = codLinhaDePesquisa;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Disciplina) {
            Disciplina other = (Disciplina) object;
            return (this.codigoDisciplina != null && 
                    this.codigoDisciplina.equals(other.getCodigoDisciplina()));
        }
        return false;
    }
    
    @Override
    public String toString(){
        return this.codigoDisciplina + " - "+ this.nome;
    }
}
