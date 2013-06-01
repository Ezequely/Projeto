/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ezequely
 */
@Entity
@Table(name = "aluno_turma")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "AlunoTurma.findAll", query = "SELECT a FROM AlunoTurma a"),
    @NamedQuery(name = "AlunoTurma.findByCodigoTurma", query = "SELECT a FROM AlunoTurma a WHERE a.alunoTurmaPK.codigoTurma = :codigoTurma"),
    @NamedQuery(name = "AlunoTurma.findByMatriculaAluno", query = "SELECT a FROM AlunoTurma a WHERE a.alunoTurmaPK.matriculaAluno = :matriculaAluno"),
    @NamedQuery(name = "AlunoTurma.findByNota1", query = "SELECT a FROM AlunoTurma a WHERE a.nota1 = :nota1"),
    @NamedQuery(name = "AlunoTurma.findByNota2", query = "SELECT a FROM AlunoTurma a WHERE a.nota2 = :nota2"),
    @NamedQuery(name = "AlunoTurma.findByNota3", query = "SELECT a FROM AlunoTurma a WHERE a.nota3 = :nota3"),
    @NamedQuery(name = "AlunoTurma.findByNota4", query = "SELECT a FROM AlunoTurma a WHERE a.nota4 = :nota4"),
    @NamedQuery(name = "AlunoTurma.findBySituacao", query = "SELECT a FROM AlunoTurma a WHERE a.situacao = :situacao")})
public class AlunoTurma implements Serializable {
    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected AlunoTurmaPK alunoTurmaPK;
    // @Max(value=?)  @Min(value=?)//if you know range of your decimal fields consider using these annotations to enforce field validation
    @Column(name = "Nota1")
    private Double nota1;
    @Column(name = "Nota2")
    private Double nota2;
    @Column(name = "Nota3")
    private Double nota3;
    @Column(name = "Nota4")
    private Double nota4;
    @Basic(optional = false)
    @Column(name = "Situacao")
    private String situacao;

    public AlunoTurma() {
    }

    public AlunoTurma(AlunoTurmaPK alunoTurmaPK) {
        this.alunoTurmaPK = alunoTurmaPK;
    }

    public AlunoTurma(AlunoTurmaPK alunoTurmaPK, String situacao) {
        this.alunoTurmaPK = alunoTurmaPK;
        this.situacao = situacao;
    }

    public AlunoTurma(int codigoTurma, String matriculaAluno) {
        this.alunoTurmaPK = new AlunoTurmaPK(codigoTurma, matriculaAluno);
    }

    public AlunoTurmaPK getAlunoTurmaPK() {
        return alunoTurmaPK;
    }

    public void setAlunoTurmaPK(AlunoTurmaPK alunoTurmaPK) {
        this.alunoTurmaPK = alunoTurmaPK;
    }

    public Double getNota1() {
        return nota1;
    }

    public void setNota1(Double nota1) {
        this.nota1 = nota1;
    }

    public Double getNota2() {
        return nota2;
    }

    public void setNota2(Double nota2) {
        this.nota2 = nota2;
    }

    public Double getNota3() {
        return nota3;
    }

    public void setNota3(Double nota3) {
        this.nota3 = nota3;
    }

    public Double getNota4() {
        return nota4;
    }

    public void setNota4(Double nota4) {
        this.nota4 = nota4;
    }

    public String getSituacao() {
        return situacao;
    }

    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (alunoTurmaPK != null ? alunoTurmaPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof AlunoTurma)) {
            return false;
        }
        AlunoTurma other = (AlunoTurma) object;
        if ((this.alunoTurmaPK == null && other.alunoTurmaPK != null) || (this.alunoTurmaPK != null && !this.alunoTurmaPK.equals(other.alunoTurmaPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufrn.dimap.entidades.AlunoTurma[ alunoTurmaPK=" + alunoTurmaPK + " ]";
    }
    
}
