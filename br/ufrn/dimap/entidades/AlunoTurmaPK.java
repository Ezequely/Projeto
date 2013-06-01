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
public class AlunoTurmaPK implements Serializable {
    @Basic(optional = false)
    @Column(name = "CodigoTurma")
    private int codigoTurma;
    @Basic(optional = false)
    @Column(name = "MatriculaAluno")
    private String matriculaAluno;

    public AlunoTurmaPK() {
    }

    public AlunoTurmaPK(int codigoTurma, String matriculaAluno) {
        this.codigoTurma = codigoTurma;
        this.matriculaAluno = matriculaAluno;
    }

    public int getCodigoTurma() {
        return codigoTurma;
    }

    public void setCodigoTurma(int codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) codigoTurma;
        hash += (matriculaAluno != null ? matriculaAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoTurmaPK)) {
            return false;
        }
        AlunoTurmaPK other = (AlunoTurmaPK) object;
        if (this.codigoTurma != other.codigoTurma) {
            return false;
        }
        if ((this.matriculaAluno == null && other.matriculaAluno != null) || (this.matriculaAluno != null && !this.matriculaAluno.equals(other.matriculaAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufrn.dimap.entidades.AlunoTurmaPK[ codigoTurma=" + codigoTurma + ", matriculaAluno=" + matriculaAluno + " ]";
    }
    
}
