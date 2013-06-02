/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccessGerado;

import java.io.Serializable;
//import javax.persistence.Basic;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
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
//@Table(name = "turma")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Turma.findAll", query = "SELECT t FROM Turma t"),
//    @NamedQuery(name = "Turma.findByCodigoTurma", query = "SELECT t FROM Turma t WHERE t.codigoTurma = :codigoTurma"),
//    @NamedQuery(name = "Turma.findByNumeroTurma", query = "SELECT t FROM Turma t WHERE t.numeroTurma = :numeroTurma"),
//    @NamedQuery(name = "Turma.findByPeriodoLetivo", query = "SELECT t FROM Turma t WHERE t.periodoLetivo = :periodoLetivo"),
//    @NamedQuery(name = "Turma.findByStatus", query = "SELECT t FROM Turma t WHERE t.status = :status"),
//    @NamedQuery(name = "Turma.findByCodHorarioDeAula", query = "SELECT t FROM Turma t WHERE t.codHorarioDeAula = :codHorarioDeAula"),
//    @NamedQuery(name = "Turma.findByLocalDeAula", query = "SELECT t FROM Turma t WHERE t.localDeAula = :localDeAula")})
public class Turma implements Serializable {
    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @Column(name = "CodigoTurma")
//    private Integer codigoTurma;
//    @Basic(optional = false)
//    @Column(name = "NumeroTurma")
//    private int numeroTurma;
//    @Column(name = "PeriodoLetivo")
//    private String periodoLetivo;
//    @Column(name = "Status")
//    private String status;
//    @Column(name = "CodHorarioDeAula")
//    private String codHorarioDeAula;
//    @Column(name = "LocalDeAula")
//    private String localDeAula;
//    @JoinColumn(name = "CodigoDisciplina", referencedColumnName = "CodigoDisciplina")
//    @ManyToOne(optional = false)
//    private Disciplina codigoDisciplina;
//
//    public Turma() {
//    }
//
//    public Turma(Integer codigoTurma) {
//        this.codigoTurma = codigoTurma;
//    }
//
//    public Turma(Integer codigoTurma, int numeroTurma) {
//        this.codigoTurma = codigoTurma;
//        this.numeroTurma = numeroTurma;
//    }
//
//    public Integer getCodigoTurma() {
//        return codigoTurma;
//    }
//
//    public void setCodigoTurma(Integer codigoTurma) {
//        this.codigoTurma = codigoTurma;
//    }
//
//    public int getNumeroTurma() {
//        return numeroTurma;
//    }
//
//    public void setNumeroTurma(int numeroTurma) {
//        this.numeroTurma = numeroTurma;
//    }
//
//    public String getPeriodoLetivo() {
//        return periodoLetivo;
//    }
//
//    public void setPeriodoLetivo(String periodoLetivo) {
//        this.periodoLetivo = periodoLetivo;
//    }
//
//    public String getStatus() {
//        return status;
//    }
//
//    public void setStatus(String status) {
//        this.status = status;
//    }
//
//    public String getCodHorarioDeAula() {
//        return codHorarioDeAula;
//    }
//
//    public void setCodHorarioDeAula(String codHorarioDeAula) {
//        this.codHorarioDeAula = codHorarioDeAula;
//    }
//
//    public String getLocalDeAula() {
//        return localDeAula;
//    }
//
//    public void setLocalDeAula(String localDeAula) {
//        this.localDeAula = localDeAula;
//    }
//
//    public Disciplina getCodigoDisciplina() {
//        return codigoDisciplina;
//    }
//
//    public void setCodigoDisciplina(Disciplina codigoDisciplina) {
//        this.codigoDisciplina = codigoDisciplina;
//    }
//
//    @Override
//    public int hashCode() {
//        int hash = 0;
//        hash += (codigoTurma != null ? codigoTurma.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Turma)) {
//            return false;
//        }
//        Turma other = (Turma) object;
//        if ((this.codigoTurma == null && other.codigoTurma != null) || (this.codigoTurma != null && !this.codigoTurma.equals(other.codigoTurma))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "br.ufrn.dimap.entidades.Turma[ codigoTurma=" + codigoTurma + " ]";
//    }
    
}
