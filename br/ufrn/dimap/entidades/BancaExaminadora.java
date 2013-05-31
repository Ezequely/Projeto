/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.entidades;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author leobrizolara
 */
public class BancaExaminadora {
    private int codigoBanca;
    private Date dataDeDefesa;
    private Publicacao dissertacao;
    private Aluno aluno;

    public int getCodigoBanca() {
        return codigoBanca;
    }
    public void setCodigoBanca(int codigoBanca) {
        this.codigoBanca = codigoBanca;
    }

    public Date getDataDeDefesa() {
        return dataDeDefesa;
    }
    public void setDataDeDefesa(Date dataDeDefesa) {
        this.dataDeDefesa = dataDeDefesa;
    }

    public Publicacao getDissertacao() {
        return dissertacao;
    }
    public void setDissertacao(Publicacao dissertacao) {
        this.dissertacao = dissertacao;
    }

    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }
    
    @Override
    public String toString(){
        StringBuilder str = new StringBuilder();
        if(aluno != null && aluno.getPessoa() != null ){
            str.append(aluno.getPessoa().getNome());
        }
        str.append(" - '");
        str.append((dissertacao != null ? dissertacao.getTitulo() : ""));
        str.append("' - ");
        SimpleDateFormat formatter = new SimpleDateFormat("dd 'de' MMMM 'de' yyyy");
        str.append(formatter.format(this.dataDeDefesa));
        
        return str.toString();
    }
}
