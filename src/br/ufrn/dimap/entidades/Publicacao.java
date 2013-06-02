package br.ufrn.dimap.entidades;

import java.util.Collection;
import java.util.Date;

public class Publicacao {
    private String titulo;
    private String tema;
    private String periodico;
    private Date data;
    private String tipo;
    private String issn;
    private String resumo;
    private String url;
    private Collection<Pessoa> autores;

    public Publicacao() {
    }

    public Publicacao(String issn) {
        this.issn = issn;
    }

    public String getTitulo() {
        return titulo;
    }

    public void setTitulo(String titulo) {
        this.titulo = titulo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getPeriodico() {
        return periodico;
    }

    public void setPeriodico(String periodico) {
        this.periodico = periodico;
    }

    public Date getData() {
        return data;
    }

    public void setData(Date data) {
        this.data = data;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getIssn() {
        return issn;
    }

    public void setIssn(String issn) {
        this.issn = issn;
    }

    public String getResumo() {
        return resumo;
    }

    public void setResumo(String resumo) {
        this.resumo = resumo;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public Collection<Pessoa> getAutores() {
        return autores;
    }

    public void setAutores(Collection<Pessoa> autores) {
        this.autores = autores;
    }
    
    @Override
    public boolean equals(Object object) {
        if ((object instanceof Publicacao)) {
            Publicacao other = (Publicacao) object;
            return (this.issn != null && this.issn.equals(other.getIssn()));
        }
        return false;
    }

    @Override
    public String toString() {
        return this.titulo;
    }
}
