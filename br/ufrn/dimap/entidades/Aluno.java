/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.entidades;

import java.io.Serializable;
import java.util.Collection;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ezequely
 */
@Entity
@Table(name = "aluno")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Aluno.findAll", query = "SELECT a FROM Aluno a"),
    @NamedQuery(name = "Aluno.findByGrau", query = "SELECT a FROM Aluno a WHERE a.grau = :grau"),
    @NamedQuery(name = "Aluno.findByMatriculaAluno", query = "SELECT a FROM Aluno a WHERE a.matriculaAluno = :matriculaAluno")})
public class Aluno implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "Grau")
    private String grau;
    @Id
    @Basic(optional = false)
    @Column(name = "MatriculaAluno")
    private String matriculaAluno;
    @JoinColumn(name = "MatriculaAluno", referencedColumnName = "Matricula", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Vinculo vinculo;
    @JoinColumn(name = "MatriculaOrientador", referencedColumnName = "MatriculaDocente")
    @ManyToOne
    private Docente matriculaOrientador;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "matriculaAluno")
    private Collection<Bancaexaminadora> bancaexaminadoraCollection;

    public Aluno() {
    }

    public Aluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public String getGrau() {
        return grau;
    }

    public void setGrau(String grau) {
        this.grau = grau;
    }

    public String getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(String matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    public Vinculo getVinculo() {
        return vinculo;
    }

    public void setVinculo(Vinculo vinculo) {
        this.vinculo = vinculo;
    }

    public Docente getMatriculaOrientador() {
        return matriculaOrientador;
    }

    public void setMatriculaOrientador(Docente matriculaOrientador) {
        this.matriculaOrientador = matriculaOrientador;
    }

    @XmlTransient
    public Collection<Bancaexaminadora> getBancaexaminadoraCollection() {
        return bancaexaminadoraCollection;
    }

    public void setBancaexaminadoraCollection(Collection<Bancaexaminadora> bancaexaminadoraCollection) {
        this.bancaexaminadoraCollection = bancaexaminadoraCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculaAluno != null ? matriculaAluno.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Aluno)) {
            return false;
        }
        Aluno other = (Aluno) object;
        if ((this.matriculaAluno == null && other.matriculaAluno != null) || (this.matriculaAluno != null && !this.matriculaAluno.equals(other.matriculaAluno))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufrn.dimap.entidades.Aluno[ matriculaAluno=" + matriculaAluno + " ]";
    }
    
}
