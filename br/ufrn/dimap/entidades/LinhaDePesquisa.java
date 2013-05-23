package br.ufrn.dimap.entidades;

//TODO: definir Linha de pesquisa
public class LinhaDePesquisa {
    private String codigo;
    private String tema;
    private String descricao;

    public LinhaDePesquisa() {
    }

    public LinhaDePesquisa(String codigoLinhaDePesquisa) {
        this.codigo = codigoLinhaDePesquisa;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getTema() {
        return tema;
    }

    public void setTema(String tema) {
        this.tema = tema;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }
    
    @Override
    public boolean equals(Object object) {
        if (object instanceof LinhaDePesquisa) {
            LinhaDePesquisa other = (LinhaDePesquisa) object;
            return this.codigo != null && this.codigo.equals(other.getCodigo());
        }
        return false;
    }

    @Override
    public String toString() {
        return codigo;
    }
    
}
