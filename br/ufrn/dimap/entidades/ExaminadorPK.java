/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Ezequely
 */
@Embeddable
public class ExaminadorPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CodigoBanca")
    private int codigoBanca;
    @Basic(optional = false)
    @Column(name = "MatriculaDocente")
    private String matriculaDocente;

    public ExaminadorPK() {
    }

    public ExaminadorPK(int codigoBanca, String matriculaDocente) {
        this.codigoBanca = codigoBanca;
        this.matriculaDocente = matriculaDocente;
    }

    public int getCodigoBanca() {
        return codigoBanca;
    }

    public void setCodigoBanca(int codigoBanca) {
        this.codigoBanca = codigoBanca;
    }

    public String getMatriculaDocente() {
        return matriculaDocente;
    }

    public void setMatriculaDocente(String matriculaDocente) {
        this.matriculaDocente = matriculaDocente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoBanca;
        hash += (matriculaDocente != null ? matriculaDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ExaminadorPK)) {
            return false;
        }
        ExaminadorPK other = (ExaminadorPK) object;
        if (this.codigoBanca != other.codigoBanca) {
            return false;
        }
        if ((this.matriculaDocente == null && other.matriculaDocente != null) || (this.matriculaDocente != null && !this.matriculaDocente.equals(other.matriculaDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufrn.dimap.entidades.ExaminadorPK[ codigoBanca=" + codigoBanca + ", matriculaDocente=" + matriculaDocente + " ]";
    }
    
}
