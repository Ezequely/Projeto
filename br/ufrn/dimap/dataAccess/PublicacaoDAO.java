/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import br.ufrn.dimap.entidades.Pessoa;
import br.ufrn.dimap.entidades.Publicacao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;

/**
 *
 * @author leobrizolara
 */
public class PublicacaoDAO extends SqlDAO{
    //Campos publicacao: (Titulo, Tema, Periodico, Data, Tipo, ISSN, Resumo, URL)
    
    public PublicacaoDAO(DatabaseController dbController){
        super(dbController);
    }
    
    @Override
    public Collection<? extends Object> search(Object obj) {
        if(obj instanceof Pessoa){//buscar publicacoes de alguem
            return this.listAll(this.createSelectPublicacoesPessoaCmd((Pessoa)obj));
        }
        
        return new ArrayList<Object>();
    }
    /*
     * select * from PUBLICACAO;
     */
    @Override
    protected String createSelectCmd() {
        StringBuilder builder = new StringBuilder();
        builder.append("select * from ");
        builder.append(" PUBLICACAO");
        
        String cmd = builder.toString();
        
        return cmd;
    }
    /*
     * select * from PUBLICACAO 
     * natural join PESSOA_PUBLICACAO where CPF = ?;
     */
    private String createSelectPublicacoesPessoaCmd(Pessoa pessoa) {
        StringBuilder builder = new StringBuilder();
        builder.append(createSelectCmd());
        builder.append(" natural join PESSOA_PUBLICACAO where CPF = ");
        builder.append(pessoa.getCpf());
        
        String cmd = builder.toString();
        
        return cmd;
    }

    @Override
    protected Object read(ResultSet rs) throws SQLException {
        Publicacao publicacao = new Publicacao();
        publicacao.setData(rs.getDate("Data"));
        publicacao.setTitulo(rs.getString("Titulo"));
        publicacao.setTema(rs.getString("Tema"));
        publicacao.setPeriodico(rs.getString("Periodico"));
        publicacao.setTipo(rs.getString("Tipo"));
        publicacao.setIssn(rs.getString("ISSN"));
        publicacao.setResumo(rs.getString("Resumo"));
        publicacao.setUrl(rs.getString("URL"));
        
        return publicacao;
    }

    
}
