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
import javax.persistence.Lob;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ezequely
 */
@Entity
@Table(name = "disciplina")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Disciplina.findAll", query = "SELECT d FROM Disciplina d"),
    @NamedQuery(name = "Disciplina.findByNome", query = "SELECT d FROM Disciplina d WHERE d.nome = :nome"),
    @NamedQuery(name = "Disciplina.findByCodigoDisciplina", query = "SELECT d FROM Disciplina d WHERE d.codigoDisciplina = :codigoDisciplina"),
    @NamedQuery(name = "Disciplina.findByCargaHor\u00e1ria", query = "SELECT d FROM Disciplina d WHERE d.cargaHor\u00e1ria = :cargaHor\u00e1ria"),
    @NamedQuery(name = "Disciplina.findByStatus", query = "SELECT d FROM Disciplina d WHERE d.status = :status")})
public class Disciplina implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "Nome")
    private String nome;
    @Id
    @Basic(optional = false)
    @Column(name = "CodigoDisciplina")
    private String codigoDisciplina;
    @Column(name = "CargaHor\u00e1ria")
    private String cargaHorária;
    @Lob
    @Column(name = "Ementa")
    private String ementa;
    @Column(name = "Status")
    private String status;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "codigoDisciplina")
    private Collection<Turma> turmaCollection;
    @JoinColumn(name = "CodLinhaDePesquisa", referencedColumnName = "CodigoLinhaDePesquisa")
    @ManyToOne
    private Linhadepesquisa codLinhaDePesquisa;

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

    public String getCargaHorária() {
        return cargaHorária;
    }

    public void setCargaHorária(String cargaHorária) {
        this.cargaHorária = cargaHorária;
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

    @XmlTransient
    public Collection<Turma> getTurmaCollection() {
        return turmaCollection;
    }

    public void setTurmaCollection(Collection<Turma> turmaCollection) {
        this.turmaCollection = turmaCollection;
    }

    public Linhadepesquisa getCodLinhaDePesquisa() {
        return codLinhaDePesquisa;
    }

    public void setCodLinhaDePesquisa(Linhadepesquisa codLinhaDePesquisa) {
        this.codLinhaDePesquisa = codLinhaDePesquisa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoDisciplina != null ? codigoDisciplina.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Disciplina)) {
            return false;
        }
        Disciplina other = (Disciplina) object;
        if ((this.codigoDisciplina == null && other.codigoDisciplina != null) || (this.codigoDisciplina != null && !this.codigoDisciplina.equals(other.codigoDisciplina))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufrn.dimap.entidades.Disciplina[ codigoDisciplina=" + codigoDisciplina + " ]";
    }
    
}
