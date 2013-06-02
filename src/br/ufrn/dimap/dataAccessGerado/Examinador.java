/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccessGerado;

import java.io.Serializable;
//import javax.persistence.Column;
//import javax.persistence.EmbeddedId;
//import javax.persistence.Entity;
//import javax.persistence.JoinColumn;
//import javax.persistence.ManyToOne;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.Table;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ezequely
 */
//@Entity
//@Table(name = "examinador")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Examinador.findAll", query = "SELECT e FROM Examinador e"),
//    @NamedQuery(name = "Examinador.findByNota", query = "SELECT e FROM Examinador e WHERE e.nota = :nota"),
//    @NamedQuery(name = "Examinador.findByCodigoBanca", query = "SELECT e FROM Examinador e WHERE e.examinadorPK.codigoBanca = :codigoBanca"),
//    @NamedQuery(name = "Examinador.findByMatriculaDocente", query = "SELECT e FROM Examinador e WHERE e.examinadorPK.matriculaDocente = :matriculaDocente")})
public class Examinador implements Serializable {
    private static final long serialVersionUID = 1L;
//    @EmbeddedId
//    protected ExaminadorPK examinadorPK;
//    @Column(name = "Nota")
//    private Integer nota;
//    @JoinColumn(name = "CodigoBanca", referencedColumnName = "CodigoBanca", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private Bancaexaminadora bancaexaminadora;
//    @JoinColumn(name = "MatriculaDocente", referencedColumnName = "MatriculaDocente", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private Docente docente;
//
//    public Examinador() {
//    }
//
//    public Examinador(ExaminadorPK examinadorPK) {
//        this.examinadorPK = examinadorPK;
//    }
//
//    public Examinador(int codigoBanca, String matriculaDocente) {
//        this.examinadorPK = new ExaminadorPK(codigoBanca, matriculaDocente);
//    }
//
//    public ExaminadorPK getExaminadorPK() {
//        return examinadorPK;
//    }
//
//    public void setExaminadorPK(ExaminadorPK examinadorPK) {
//        this.examinadorPK = examinadorPK;
//    }
//
//    public Integer getNota() {
//        return nota;
//    }
//
//    public void setNota(Integer nota) {
//        this.nota = nota;
//    }
//
//    public Bancaexaminadora getBancaexaminadora() {
//        return bancaexaminadora;
//    }
//
//    public void setBancaexaminadora(Bancaexaminadora bancaexaminadora) {
//        this.bancaexaminadora = bancaexaminadora;
//    }
//
//    public Docente getDocente() {
//        return docente;
//    }
//
//    public void setDocente(Docente docente) {
//        this.docente = docente;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (examinadorPK != null ? examinadorPK.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Examinador)) {
//            return false;
//        }
//        Examinador other = (Examinador) object;
//        if ((this.examinadorPK == null && other.examinadorPK != null) || (this.examinadorPK != null && !this.examinadorPK.equals(other.examinadorPK))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "br.ufrn.dimap.entidades.Examinador[ examinadorPK=" + examinadorPK + " ]";
//    }
    
}
