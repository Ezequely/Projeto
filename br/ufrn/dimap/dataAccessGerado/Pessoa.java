/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccessGerado;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
//import javax.persistence.Basic;
//import javax.persistence.CascadeType;
//import javax.persistence.Column;
//import javax.persistence.Entity;
//import javax.persistence.Id;
//import javax.persistence.ManyToMany;
//import javax.persistence.NamedQueries;
//import javax.persistence.NamedQuery;
//import javax.persistence.OneToMany;
//import javax.persistence.Table;
//import javax.persistence.Temporal;
//import javax.persistence.TemporalType;
import javax.xml.bind.annotation.XmlRootElement;
import javax.xml.bind.annotation.XmlTransient;

/**
 *
 * @author Ezequely
 */
//@Entity
//@Table(name = "pessoa")
//@XmlRootElement
//@NamedQueries({
//    @NamedQuery(name = "Pessoa.findAll", query = "SELECT p FROM Pessoa p"),
//    @NamedQuery(name = "Pessoa.findByCpf", query = "SELECT p FROM Pessoa p WHERE p.cpf = :cpf"),
//    @NamedQuery(name = "Pessoa.findByNome", query = "SELECT p FROM Pessoa p WHERE p.nome = :nome"),
//    @NamedQuery(name = "Pessoa.findByEndereco", query = "SELECT p FROM Pessoa p WHERE p.endereco = :endereco"),
//    @NamedQuery(name = "Pessoa.findByCidade", query = "SELECT p FROM Pessoa p WHERE p.cidade = :cidade"),
//    @NamedQuery(name = "Pessoa.findByUf", query = "SELECT p FROM Pessoa p WHERE p.uf = :uf"),
//    @NamedQuery(name = "Pessoa.findByNaturalidade", query = "SELECT p FROM Pessoa p WHERE p.naturalidade = :naturalidade"),
//    @NamedQuery(name = "Pessoa.findByNacionalidade", query = "SELECT p FROM Pessoa p WHERE p.nacionalidade = :nacionalidade"),
//    @NamedQuery(name = "Pessoa.findByDTNasc", query = "SELECT p FROM Pessoa p WHERE p.dTNasc = :dTNasc"),
//    @NamedQuery(name = "Pessoa.findByEmail", query = "SELECT p FROM Pessoa p WHERE p.email = :email"),
//    @NamedQuery(name = "Pessoa.findByTelefone", query = "SELECT p FROM Pessoa p WHERE p.telefone = :telefone")})
public class Pessoa implements Serializable {
    private static final long serialVersionUID = 1L;
//    @Id
//    @Basic(optional = false)
//    @Column(name = "CPF")
//    private String cpf;
//    @Column(name = "Nome")
//    private String nome;
//    @Column(name = "Endereco")
//    private String endereco;
//    @Column(name = "Cidade")
//    private String cidade;
//    @Column(name = "UF")
//    private String uf;
//    @Column(name = "Naturalidade")
//    private String naturalidade;
//    @Column(name = "Nacionalidade")
//    private String nacionalidade;
//    @Column(name = "DTNasc")
//    @Temporal(TemporalType.DATE)
//    private Date dTNasc;
//    @Column(name = "E_mail")
//    private String email;
//    @Column(name = "Telefone")
//    private String telefone;
//    @ManyToMany(mappedBy = "pessoaCollection")
//    private Collection<Publicacao> publicacaoCollection;
//    @OneToMany(cascade = CascadeType.ALL, mappedBy = "cpf")
//    private Collection<Vinculo> vinculoCollection;
//
//    public Pessoa() {
//    }
//
//    public Pessoa(String cpf) {
//        this.cpf = cpf;
//    }
//
//    public String getCpf() {
//        return cpf;
//    }
//
//    public void setCpf(String cpf) {
//        this.cpf = cpf;
//    }
//
//    public String getNome() {
//        return nome;
//    }
//
//    public void setNome(String nome) {
//        this.nome = nome;
//    }
//
//    public String getEndereco() {
//        return endereco;
//    }
//
//    public void setEndereco(String endereco) {
//        this.endereco = endereco;
//    }
//
//    public String getCidade() {
//        return cidade;
//    }
//
//    public void setCidade(String cidade) {
//        this.cidade = cidade;
//    }
//
//    public String getUf() {
//        return uf;
//    }
//
//    public void setUf(String uf) {
//        this.uf = uf;
//    }
//
//    public String getNaturalidade() {
//        return naturalidade;
//    }
//
//    public void setNaturalidade(String naturalidade) {
//        this.naturalidade = naturalidade;
//    }
//
//    public String getNacionalidade() {
//        return nacionalidade;
//    }
//
//    public void setNacionalidade(String nacionalidade) {
//        this.nacionalidade = nacionalidade;
//    }
//
//    public Date getDTNasc() {
//        return dTNasc;
//    }
//
//    public void setDTNasc(Date dTNasc) {
//        this.dTNasc = dTNasc;
//    }
//
//    public String getEmail() {
//        return email;
//    }
//
//    public void setEmail(String email) {
//        this.email = email;
//    }
//
//    public String getTelefone() {
//        return telefone;
//    }
//
//    public void setTelefone(String telefone) {
//        this.telefone = telefone;
//    }
//
//    @XmlTransient
//    public Collection<Publicacao> getPublicacaoCollection() {
//        return publicacaoCollection;
//    }
//
//    public void setPublicacaoCollection(Collection<Publicacao> publicacaoCollection) {
//        this.publicacaoCollection = publicacaoCollection;
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
//        hash += (cpf != null ? cpf.hashCode() : 0);
//        return hash;
//    }
//
//    @Override
//    public boolean equals(Object object) {
//        // TODO: Warning - this method won't work in the case the id fields are not set
//        if (!(object instanceof Pessoa)) {
//            return false;
//        }
//        Pessoa other = (Pessoa) object;
//        if ((this.cpf == null && other.cpf != null) || (this.cpf != null && !this.cpf.equals(other.cpf))) {
//            return false;
//        }
//        return true;
//    }
//
//    @Override
//    public String toString() {
//        return "br.ufrn.dimap.entidades.Pessoa[ cpf=" + cpf + " ]";
//    }
    
}
