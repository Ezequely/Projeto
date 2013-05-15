/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.entidades;

import java.io.Serializable;
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
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author Ezequely
 */
@Entity
@Table(name = "vinculo")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Vinculo.findAll", query = "SELECT v FROM Vinculo v"),
    @NamedQuery(name = "Vinculo.findByMatricula", query = "SELECT v FROM Vinculo v WHERE v.matricula = :matricula"),
    @NamedQuery(name = "Vinculo.findByAtivo", query = "SELECT v FROM Vinculo v WHERE v.ativo = :ativo"),
    @NamedQuery(name = "Vinculo.findByDataDeMatricula", query = "SELECT v FROM Vinculo v WHERE v.dataDeMatricula = :dataDeMatricula")})
public class Vinculo implements Serializable {
    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "Matricula")
    private String matricula;
    @Column(name = "Ativo")
    private Boolean ativo;
    @Column(name = "DataDeMatricula")
    @Temporal(TemporalType.DATE)
    private Date dataDeMatricula;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vinculo")
    private Aluno aluno;
    @JoinColumn(name = "CodigoLinhaDePesquisa", referencedColumnName = "CodigoLinhaDePesquisa")
    @ManyToOne
    private Linhadepesquisa codigoLinhaDePesquisa;
    @JoinColumn(name = "CPF", referencedColumnName = "CPF")
    @ManyToOne(optional = false)
    private Pessoa cpf;
    @OneToOne(cascade = CascadeType.ALL, mappedBy = "vinculo")
    private Docente docente;

    public Vinculo() {
    }

    public Vinculo(String matricula) {
        this.matricula = matricula;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public Boolean getAtivo() {
        return ativo;
    }

    public void setAtivo(Boolean ativo) {
        this.ativo = ativo;
    }

    public Date getDataDeMatricula() {
        return dataDeMatricula;
    }

    public void setDataDeMatricula(Date dataDeMatricula) {
        this.dataDeMatricula = dataDeMatricula;
    }

    public Aluno getAluno() {
        return aluno;
    }

    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Linhadepesquisa getCodigoLinhaDePesquisa() {
        return codigoLinhaDePesquisa;
    }

    public void setCodigoLinhaDePesquisa(Linhadepesquisa codigoLinhaDePesquisa) {
        this.codigoLinhaDePesquisa = codigoLinhaDePesquisa;
    }

    public Pessoa getCpf() {
        return cpf;
    }

    public void setCpf(Pessoa cpf) {
        this.cpf = cpf;
    }

    public Docente getDocente() {
        return docente;
    }

    public void setDocente(Docente docente) {
        this.docente = docente;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (matricula != null ? matricula.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Vinculo)) {
            return false;
        }
        Vinculo other = (Vinculo) object;
        if ((this.matricula == null && other.matricula != null) || (this.matricula != null && !this.matricula.equals(other.matricula))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "br.ufrn.dimap.entidades.Vinculo[ matricula=" + matricula + " ]";
    }
    
}
