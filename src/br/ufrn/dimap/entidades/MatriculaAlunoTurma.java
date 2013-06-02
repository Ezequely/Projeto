/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.entidades;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/**Uma 'MatriculaAlunoTurma' representa a relação que um aluno tem com uma turma*/
public class MatriculaAlunoTurma {    
    private Aluno aluno;
    private Turma turma;
    private List<Double> notas;
    private String situacao;

    public final Double pesos[] = {4.0,5.0,6.0, 15.0};
    
    public MatriculaAlunoTurma(){
        this(new Aluno(), new Turma());
    }
    public MatriculaAlunoTurma(Aluno aluno, Turma turma){
        this.aluno = aluno;
        this.turma = turma;
        notas = new ArrayList<Double>(4);
    }
    
    public Aluno getAluno() {
        return aluno;
    }
    public void setAluno(Aluno aluno) {
        this.aluno = aluno;
    }

    public Turma getTurma() {
        return turma;
    }
    public void setTurma(Turma turma) {
        this.turma = turma;
    }

    public Double getMedia(){
        if(!notas.isEmpty()){
            Double somaNotasPonderadas = 0.0;
            Double somaPesos = 0.0;
            
            for(int i=0; i < 3; ++i){
                if(this.notas.get(i) != null){
                    somaNotasPonderadas += notas.get(i) * pesos[i];
                }
                somaPesos += pesos[i];
            }
            if(this.notas.get(3) != null){
                somaNotasPonderadas += notas.get(3) * pesos[3];
                somaPesos += pesos[3];
            }

            return somaNotasPonderadas / somaPesos;
        }
        return 0.0;
    }
    public Double getNota(int i){
        return notas.get(i);
    }
    public void setNota(int i, Double nota){
        notas.add(i, nota);
    }
    public Collection<Double> getNotas() {
        return notas;
    }
    public void setNotas(Collection<Double> notas) {
        this.notas = (List<Double>) notas;
    }

    public String getSituacao() {
        return situacao;
    }
    public void setSituacao(String situacao) {
        this.situacao = situacao;
    }
    
    public String toString(){
        String str = (aluno != null ? aluno.toString() : "");
        str += (getMedia() != null ? " " + getMedia().toString() : "");
        str += (getSituacao() != null ? " " + getSituacao() : "");
        return str;
    }
}
