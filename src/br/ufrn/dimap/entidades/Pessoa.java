package br.ufrn.dimap.entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;


public class Pessoa {
	    private String cpf;
	    private String nome;
	    private String endereco;
	    private String cidade;
	    private String uf;
	    private String naturalidade;
	    private String nacionalidade;
	    private Date dataNascimento;
	    private String email;
	    private String telefone;
	    private Collection<Publicacao> publicacoes;
	    private Collection<Vinculo> vinculos;

	    public Pessoa(){
	    	this.publicacoes = new ArrayList<Publicacao>();
	    	this.vinculos = new ArrayList<Vinculo>();
	    }
	    public Pessoa(String cpf) {
	    	this();
	        this.cpf = cpf;
	    }

	    //CPF
	    public String getCpf() { return cpf;}
	    public void setCpf(String cpf) { this.cpf = cpf;}
	    //Nome
	    public String getNome() { return nome;}
	    public void setNome(String nome) { this.nome = nome;}
	    //Endereco
	    public String getEndereco() { return endereco;}
	    public void setEndereco(String endereco) { this.endereco = endereco;}
	    //Cidade
	    public String getCidade() { return cidade;}
	    public void setCidade(String cidade) { this.cidade = cidade;}
	    //UF
	    public String getUf() { return uf;}
	    public void setUf(String uf) { this.uf = uf;}
	    //Naturalidade
	    public String getNaturalidade() { return naturalidade;}
	    public void setNaturalidade(String naturalidade) { this.naturalidade = naturalidade;}
	    //Nacionalidade
	    public String getNacionalidade() { return nacionalidade;}
	    public void setNacionalidade(String nacionalidade) { this.nacionalidade = nacionalidade;}
	    //Data de nascimento
	    public Date getDataNascimento() { return dataNascimento;}
	    public void setDataNascimento(Date dTNasc) { this.dataNascimento = dTNasc;}
	    //Email
	    public String getEmail() { return email;}
	    public void setEmail(String email) { this.email = email;}
	    //Telefone
	    public String getTelefone() { return telefone;}
	    public void setTelefone(String telefone) { this.telefone = telefone;}

	    //Publicacoes
	    public Iterable<Publicacao> getPublicacoes() { return publicacoes;}
	    public boolean addPublicacao(Publicacao pub){
	    	if(!this.publicacoes.contains(pub)){
	    		return this.publicacoes.add(pub);
	    	}
	    	return false;
	    }
	    public boolean removePublicacao(Publicacao pub){
	    	return publicacoes.remove(pub);
	    }

	    //Vinculos
	    public Iterable<Vinculo> getVinculos() { return vinculos;}
	    public boolean addVinculo(Vinculo vinc){
	    	if(!this.vinculos.contains(vinc)){
	    		return this.vinculos.add(vinc);
	    	}
	    	return false;
	    }
	    public boolean delVinculo(Vinculo vinc){
	    	return vinculos.remove(vinc);
	    }

	    @Override
	    public boolean equals(Object object) {
	        if ((object instanceof Pessoa)) {
		        Pessoa other = (Pessoa) object;
		        return (this.cpf != null && !this.cpf.equals(other.cpf));
	        }
	        return false;
	    }

	    @Override
	    public String toString() {
	        return this.cpf + " : " + this.nome;
	    }
}
