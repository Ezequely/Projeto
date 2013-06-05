/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.entidades;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;
import java.util.Map;
import java.util.TreeMap;

/**
 *
 * @author leobrizolara
 */
public class BancaExaminadora {
    private int codigoBanca;
    private Date dataDeDefesa;
    private Publicacao dissertacao;
    private Aluno aluno;

//    private Map<String, Double> notasExaminadores;
    private Collection<Examinador> examinadores;
    
    public BancaExaminadora(){
        examinadores = new ArrayList<Examinador>();
//        notasExaminadores = new TreeMap<String, Double>();
    }
    
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
    
    public void addExaminador(Examinador examinador){
        this.examinadores.add(examinador);
    }
    public void removeExaminador(Examinador examinador){
        this.examinadores.remove(examinador);
        //notasExaminadores.remove(examinador.getMatricula());
    }
//    public void setNota(Examinador examinador, Double nota){
//        
//        //this.notasExaminadores.put(examinador.getMatricula(), nota);
//    }
//    public Double getNota(Examinador examinador){
//        if(notasExaminadores.containsKey(examinador.getMatricula())){
//            return this.notasExaminadores.get(examinador.getMatricula());
//        }
//        return null;
//    }
    
    public Collection<Examinador> getExaminadores() {
        return examinadores;
    }

    public void setExaminadores(Collection<Examinador> examinadores) {
        this.examinadores = examinadores;
    }
}
