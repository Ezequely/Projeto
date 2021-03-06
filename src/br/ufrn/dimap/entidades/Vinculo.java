package br.ufrn.dimap.entidades;

import java.util.Date;

public class Vinculo {
    	private Pessoa pessoa;
	    private String matricula;
	    private boolean ativo;
	    private Date dataDeMatricula;
	    private LinhaDePesquisa linhaDePesquisa;

	    public Vinculo(){
	    }
	    public Vinculo(Pessoa pessoa, String matricula) {
	    	this.pessoa = pessoa;
	    	this.matricula = matricula;
	    }

	    //Matricula
	    public String getMatricula() {return matricula;}
	    public void setMatricula(String matricula) {this.matricula = matricula;}

	    //"ativo"
	    public boolean getAtivo() {return ativo;}
	    public void setAtivo(Boolean ativo) {this.ativo = ativo;}

	    //Data de matricula
	    public Date getDataDeMatricula() {return dataDeMatricula;}
	    public void setDataDeMatricula(Date dataDeMatricula) {this.dataDeMatricula = dataDeMatricula;}

	    //linha de pesquisa
	    public LinhaDePesquisa 	getLinhaDePesquisa() {return linhaDePesquisa;}
	    public void 			setLinhaDePesquisa(LinhaDePesquisa linhaDePesquisa) {this.linhaDePesquisa = linhaDePesquisa;}

	    //Pessoa
	    public Pessoa getPessoa() {return pessoa;}
	    public void setPessoa(Pessoa pessoa) {this.pessoa = pessoa;}

	    @Override
	    public boolean equals(Object object) {
	        if (!(object instanceof Vinculo)) {
	            return false;
	        }
	        Vinculo other = (Vinculo) object;
	        return (this.matricula != null && !this.matricula.equals(other.matricula) 
	        			&& this.pessoa!=null && this.pessoa.equals(other.getPessoa()));
	    }
	    
	    @Override
	    public String toString(){
                String str = "";
                if(this.pessoa != null){
                    str += pessoa.getNome();
                }
                str += " [" + this.getMatricula() + "] ";
                return str;
	    }
}
