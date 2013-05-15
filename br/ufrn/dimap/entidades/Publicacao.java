/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.entidades;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Lob;
import javax.persistence.ManyToMany;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
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
@Table(name = "publicacao")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Publicacao.findAll", query = "SELECT p FROM Publicacao p"),
    @NamedQuery(name = "Publicacao.findByTitulo", query = "SELECT p FROM Publicacao p WHERE p.titulo = :titulo"),
    @NamedQuery(name = "Publicacao.findByTema", query = "SELECT p FROM Publicacao p WHERE p.tema = :tema"),
    @NamedQuery(name = "Publicacao.findByPeriodico", query = "SELECT p FROM Publicacao p WHERE p.periodico = :periodico"),
    @NamedQuery(name = "Publicacao.findByData", query = "SELECT p FROM Publicacao p WHERE p.data = :data"),
    @NamedQuery(name = "Publicacao.findByTipo", query = "SELECT p FROM Publicacao p WHERE p.tipo = :tipo"),
    @NamedQuery(name = "Publicacao.findByIssn", query = "SELECT p FROM Publicacao p WHERE p.issn = :issn"),
    @NamedQuery(name = "Publicacao.findByUrl", query = "SELECT p FROM Publicacao p WHERE p.url = :url")})
public class Publicacao implements Serializable {
    private static final long serialVersionUID = 1L;
    @Column(name = "Titulo")
    private String titulo;
    @Column(name = "Tema")
    private String tema;
    @Column(name = "Periodico")
    private String periodico;
    @Column(name = "Data")
    @Temporal(TemporalType.DATE)
    private Date data;
    @Column(name = "Tipo")
    private String tipo;
    @Id
    @Basic(optional = false)
    @Column(name = "ISSN")
    private String issn;
    @Lob
    @Column(name = "Resumo")
    private String resumo;
    @Column(name = "URL")
    private String url;
    @JoinTable(name = "pessoa_publicacao", joinColumns = {
        @JoinColumn(name = "ISSN", referencedColumnName = "ISSN")}, inverseJoinColumns = {
        @JoinColumn(name = "CPF", referencedColumnName = "CPF")})
    @ManyToMany
    private Collection<Pessoa> pessoaCollection;

    public Publicacao() {
    }

    public Publicacao(String issn) {
        this.issn = issn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getPeriodico() {
        return periodico;
    }

    public void setPeriodico(String periodico) {
        this.periodico = periodico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    @XmlTransient
    public Collection<Pessoa> getPessoaCollection() {
        return pessoaCollection;
    }

    public void setPessoaCollection(Collection<Pessoa> pessoaCollection) {
        this.pessoaCollection = pessoaCollection;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (issn != null ? issn.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Publicacao)) {
            return false;
        }
        Publicacao other = (Publicacao) object;
        if ((this.issn == null && other.issn != null) || (this.issn != null && !this.issn.equals(other.issn))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufrn.dimap.entidades.Publicacao[ issn=" + issn + " ]";
    }
    
}
