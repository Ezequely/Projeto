/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccessGerado;

import java.io.Serializable;
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
//@Table(name = "turma_docente")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "TurmaDocente.findAll", query = "SELECT t FROM TurmaDocente t"),
//    @NamedQuery(name = "TurmaDocente.findByCodigoTurma", query = "SELECT t FROM TurmaDocente t WHERE t.turmaDocentePK.codigoTurma = :codigoTurma"),
//    @NamedQuery(name = "TurmaDocente.findByMatriculaDocente", query = "SELECT t FROM TurmaDocente t WHERE t.turmaDocentePK.matriculaDocente = :matriculaDocente")})
public class TurmaDocente implements Serializable {
    private static final long serialVersionUID = 1L;
//    @EmbeddedId
//    protected TurmaDocentePK turmaDocentePK;
//    @JoinColumn(name = "MatriculaDocente", referencedColumnName = "MatriculaDocente", insertable = false, updatable = false)
//    @ManyToOne(optional = false)
//    private Docente docente;
//
//    public TurmaDocente() {
//    }
//
//    public TurmaDocente(TurmaDocentePK turmaDocentePK) {
//        this.turmaDocentePK = turmaDocentePK;
//    }
//
//    public TurmaDocente(String codigoTurma, String matriculaDocente) {
//        this.turmaDocentePK = new TurmaDocentePK(codigoTurma, matriculaDocente);
//    }
//
//    public TurmaDocentePK getTurmaDocentePK() {
//        return turmaDocentePK;
//    }
//
//    public void setTurmaDocentePK(TurmaDocentePK turmaDocentePK) {
//        this.turmaDocentePK = turmaDocentePK;
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
//        hash += (turmaDocentePK != null ? turmaDocentePK.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof TurmaDocente)) {
//            return false;
//        }
//        TurmaDocente other = (TurmaDocente) object;
//        if ((this.turmaDocentePK == null && other.turmaDocentePK != null) || (this.turmaDocentePK != null && !this.turmaDocentePK.equals(other.turmaDocentePK))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "br.ufrn.dimap.entidades.TurmaDocente[ turmaDocentePK=" + turmaDocentePK + " ]";
//    }
    
}
