/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccessGerado;

import java.io.Serializable;
import java.util.Collection;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.Lob;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ezequely
 */
//@Entity
//@Table(name = "linhadepesquisa")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Linhadepesquisa.findAll", query = "SELECT l FROM Linhadepesquisa l"),
//    @NamedQuery(name = "Linhadepesquisa.findByCodigoLinhaDePesquisa", query = "SELECT l FROM Linhadepesquisa l WHERE l.codigoLinhaDePesquisa = :codigoLinhaDePesquisa"),
//    @NamedQuery(name = "Linhadepesquisa.findByTema", query = "SELECT l FROM Linhadepesquisa l WHERE l.tema = :tema")})
public class Linhadepesquisa implements Serializable {
    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @Column(name = "CodigoLinhaDePesquisa")
//    private String codigoLinhaDePesquisa;
//    @Column(name = "Tema")
//    private String tema;
//    @Lob
//    @Column(name = "Descricao")
//    private String descricao;
//    @OneToMany(mappedBy = "codLinhaDePesquisa")
//    private Collection<Disciplina> disciplinaCollection;
//    @OneToMany(mappedBy = "codigoLinhaDePesquisa")
//    private Collection<Vinculo> vinculoCollection;
//
//    public Linhadepesquisa() {
//    }
//
//    public Linhadepesquisa(String codigoLinhaDePesquisa) {
//        this.codigoLinhaDePesquisa = codigoLinhaDePesquisa;
//    }
//
//    public String getCodigoLinhaDePesquisa() {
//        return codigoLinhaDePesquisa;
//    }
//
//    public void setCodigoLinhaDePesquisa(String codigoLinhaDePesquisa) {
//        this.codigoLinhaDePesquisa = codigoLinhaDePesquisa;
//    }
//
//    public String getTema() {
//        return tema;
//    }
//
//    public void setTema(String tema) {
//        this.tema = tema;
//    }
//
//    public String getDescricao() {
//        return descricao;
//    }
//
//    public void setDescricao(String descricao) {
//        this.descricao = descricao;
//    }
//
//    @XmlTransient
//    public Collection<Disciplina> getDisciplinaCollection() {
//        return disciplinaCollection;
//    }
//
//    public void setDisciplinaCollection(Collection<Disciplina> disciplinaCollection) {
//        this.disciplinaCollection = disciplinaCollection;
//    }
//
//    @XmlTransient
//    public Collection<Vinculo> getVinculoCollection() {
//        return vinculoCollection;
//    }
//
//    public void setVinculoCollection(Collection<Vinculo> vinculoCollection) {
//        this.vinculoCollection = vinculoCollection;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (codigoLinhaDePesquisa != null ? codigoLinhaDePesquisa.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Linhadepesquisa)) {
//            return false;
//        }
//        Linhadepesquisa other = (Linhadepesquisa) object;
//        if ((this.codigoLinhaDePesquisa == null && other.codigoLinhaDePesquisa != null) || (this.codigoLinhaDePesquisa != null && !this.codigoLinhaDePesquisa.equals(other.codigoLinhaDePesquisa))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "br.ufrn.dimap.entidades.Linhadepesquisa[ codigoLinhaDePesquisa=" + codigoLinhaDePesquisa + " ]";
//    }
//    
}
