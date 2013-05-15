/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
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
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ezequely
 */
@Entity
@Table(name = "bancaexaminadora")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Bancaexaminadora.findAll", query = "SELECT b FROM Bancaexaminadora b"),
    @NamedQuery(name = "Bancaexaminadora.findByCodigoBanca", query = "SELECT b FROM Bancaexaminadora b WHERE b.codigoBanca = :codigoBanca"),
    @NamedQuery(name = "Bancaexaminadora.findByDataDeDefesa", query = "SELECT b FROM Bancaexaminadora b WHERE b.dataDeDefesa = :dataDeDefesa"),
    @NamedQuery(name = "Bancaexaminadora.findByISSNDissertacao", query = "SELECT b FROM Bancaexaminadora b WHERE b.iSSNDissertacao = :iSSNDissertacao")})
public class Bancaexaminadora implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "CodigoBanca")
    private Integer codigoBanca;
    @Column(name = "DataDeDefesa")
    @Temporal(TemporalType.DATE)
    private Date dataDeDefesa;
    @Basic(optional = false)
    @Column(name = "ISSN_Dissertacao")
    private int iSSNDissertacao;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "bancaexaminadora")
    private Collection<Examinador> examinadorCollection;
    @JoinColumn(name = "MatriculaAluno", referencedColumnName = "MatriculaAluno")
    @ManyToOne(optional = false)
    private Aluno matriculaAluno;

    public Bancaexaminadora() {
    }

    public Bancaexaminadora(Integer codigoBanca) {
        this.codigoBanca = codigoBanca;
    }

    public Bancaexaminadora(Integer codigoBanca, int iSSNDissertacao) {
        this.codigoBanca = codigoBanca;
        this.iSSNDissertacao = iSSNDissertacao;
    }

    public Integer getCodigoBanca() {
        return codigoBanca;
    }

    public void setCodigoBanca(Integer codigoBanca) {
        this.codigoBanca = codigoBanca;
    }

    public Date getDataDeDefesa() {
        return dataDeDefesa;
    }

    public void setDataDeDefesa(Date dataDeDefesa) {
        this.dataDeDefesa = dataDeDefesa;
    }

    public int getISSNDissertacao() {
        return iSSNDissertacao;
    }

    public void setISSNDissertacao(int iSSNDissertacao) {
        this.iSSNDissertacao = iSSNDissertacao;
    }

    @XmlTransient
    public Collection<Examinador> getExaminadorCollection() {
        return examinadorCollection;
    }

    public void setExaminadorCollection(Collection<Examinador> examinadorCollection) {
        this.examinadorCollection = examinadorCollection;
    }

    public Aluno getMatriculaAluno() {
        return matriculaAluno;
    }

    public void setMatriculaAluno(Aluno matriculaAluno) {
        this.matriculaAluno = matriculaAluno;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (codigoBanca != null ? codigoBanca.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Bancaexaminadora)) {
            return false;
        }
        Bancaexaminadora other = (Bancaexaminadora) object;
        if ((this.codigoBanca == null && other.codigoBanca != null) || (this.codigoBanca != null && !this.codigoBanca.equals(other.codigoBanca))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufrn.dimap.entidades.Bancaexaminadora[ codigoBanca=" + codigoBanca + " ]";
    }
    
}
