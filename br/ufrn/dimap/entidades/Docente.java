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
@Table(name = "docente")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Docente.findAll", query = "SELECT d FROM Docente d"),
    @NamedQuery(name = "Docente.findByTitulacao", query = "SELECT d FROM Docente d WHERE d.titulacao = :titulacao"),
    @NamedQuery(name = "Docente.findByCargo", query = "SELECT d FROM Docente d WHERE d.cargo = :cargo"),
    @NamedQuery(name = "Docente.findByMatriculaDocente", query = "SELECT d FROM Docente d WHERE d.matriculaDocente = :matriculaDocente")})
public class Docente implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "Titulacao")
    private String titulacao;
    @Column(name = "Cargo")
    private String cargo;
    @Id
    @Basic(optional = false)
    @Column(name = "MatriculaDocente")
    private String matriculaDocente;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docente")
    private Collection<Examinador> examinadorCollection;
    @OneToMany(mappedBy = "matriculaOrientador")
    private Collection<Aluno> alunoCollection;
    @JoinColumn(name = "MatriculaDocente", referencedColumnName = "Matricula", insertable = false, updatable = false)
    @OneToOne(optional = false)
    private Vinculo vinculo;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "docente")
    private Collection<TurmaDocente> turmaDocenteCollection;

    public Docente() {
    }

    public Docente(String matriculaDocente) {
        this.matriculaDocente = matriculaDocente;
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

    public String getMatriculaDocente() {
        return matriculaDocente;
    }

    public void setMatriculaDocente(String matriculaDocente) {
        this.matriculaDocente = matriculaDocente;
    }

    @XmlTransient
    public Collection<Examinador> getExaminadorCollection() {
        return examinadorCollection;
    }

    public void setExaminadorCollection(Collection<Examinador> examinadorCollection) {
        this.examinadorCollection = examinadorCollection;
    }

    @XmlTransient
    public Collection<Aluno> getAlunoCollection() {
        return alunoCollection;
    }

    public void setAlunoCollection(Collection<Aluno> alunoCollection) {
        this.alunoCollection = alunoCollection;
    }

    public Vinculo getVinculo() {
        return vinculo;
    }

    public void setVinculo(Vinculo vinculo) {
        this.vinculo = vinculo;
    }

    @XmlTransient
    public Collection<TurmaDocente> getTurmaDocenteCollection() {
        return turmaDocenteCollection;
    }

    public void setTurmaDocenteCollection(Collection<TurmaDocente> turmaDocenteCollection) {
        this.turmaDocenteCollection = turmaDocenteCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matriculaDocente != null ? matriculaDocente.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Docente)) {
            return false;
        }
        Docente other = (Docente) object;
        if ((this.matriculaDocente == null && other.matriculaDocente != null) || (this.matriculaDocente != null && !this.matriculaDocente.equals(other.matriculaDocente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufrn.dimap.entidades.Docente[ matriculaDocente=" + matriculaDocente + " ]";
    }
    
}
