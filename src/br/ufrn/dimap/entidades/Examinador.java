/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.entidades;

/**
 *
 * @author leobrizolara
 */
public class Examinador {
    private double nota;
    private Docente docente;
    private int codigoBanca;

    public double getNota() {
        return nota;
    }
    public void setNota(double nota) {
        this.nota = nota;
    }

    public Docente getDocente() {
        return docente;
    }
    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    public int getCodigoBanca() {
        return codigoBanca;
    }

    public void setCodigoBanca(int codigoBanca) {
        this.codigoBanca = codigoBanca;
    }
    
    @Override
    public String toString(){
        return (docente != null ? docente.toString() : "") + " - " + Double.toString(nota);
    }
}
