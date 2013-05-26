package br.ufrn.dimap.entidades;

import java.util.Collection;

public class Turma {
    private int codigoTurma;
    private int numeroTurma;
    private String periodoLetivo;
    private String status;
    private String codHorarioDeAula;
    private String localDeAula;
    private Disciplina disciplina;
    private Collection<Docente> docentes;//docentes que ministraram a turma

    public Turma(){
    }
    public Turma(int codigoTurma, int numeroTurma, Disciplina disc) {
        this.codigoTurma = codigoTurma;
        this.numeroTurma = numeroTurma;
        this.disciplina = disc;
    }

    public Iterable<Docente> getDocentes() {
        return docentes;
    }
    public void setDocentes(Collection<Docente> docentes) {
        this.docentes = docentes;
    }
    
    public int getCodigoTurma() {
        return codigoTurma;
    }
    public void setCodigoTurma(int codigoTurma) {
        this.codigoTurma = codigoTurma;
    }

    public int getNumeroTurma() {
        return numeroTurma;
    }
    public void setNumeroTurma(int numeroTurma) {
        this.numeroTurma = numeroTurma;
    }

    public String getPeriodoLetivo() {
        return periodoLetivo;
    }
    public void setPeriodoLetivo(String periodoLetivo) {
        this.periodoLetivo = periodoLetivo;
    }

    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }

    public String getCodHorarioDeAula() {
        return codHorarioDeAula;
    }
    public void setCodHorarioDeAula(String codHorarioDeAula) {
        this.codHorarioDeAula = codHorarioDeAula;
    }

    public String getLocalDeAula() {
        return localDeAula;
    }
    public void setLocalDeAula(String localDeAula) {
        this.localDeAula = localDeAula;
    }

    public Disciplina getDisciplina() {
        return disciplina;
    }
    public void setDisciplina(Disciplina disc) {
        this.disciplina = disc;
    }

    @Override
    public boolean equals(Object object) {
        if (object instanceof Turma) {
            Turma other = (Turma) object;
            return this.getCodigoTurma()  > 0 && this.getCodigoTurma() == other.getCodigoTurma();
        }
        return false;
    }
}
