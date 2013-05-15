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
    @Column(name = "CodTurma")
    private String codTurma;
    @Basic(optional = false)
    @Column(name = "MatriculaAluno")
    private String matriculaAluno;

    public AlunoTurmaPK() {
    }

    public AlunoTurmaPK(String codTurma, String matriculaAluno) {
        this.codTurma = codTurma;
        this.matriculaAluno = matriculaAluno;
    }

    public String getCodTurma() {
        return codTurma;
    }

    public void setCodTurma(String codTurma) {
        this.codTurma = codTurma;
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
        hash += (codTurma != null ? codTurma.hashCode() : 0);
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
        if ((this.codTurma == null && other.codTurma != null) || (this.codTurma != null && !this.codTurma.equals(other.codTurma))) {
            return false;
        }
        if ((this.matriculaAluno == null && other.matriculaAluno != null) || (this.matriculaAluno != null && !this.matriculaAluno.equals(other.matriculaAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufrn.dimap.entidades.AlunoTurmaPK[ codTurma=" + codTurma + ", matriculaAluno=" + matriculaAluno + " ]";
    }
    
}
