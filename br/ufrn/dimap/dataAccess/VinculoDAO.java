/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import br.ufrn.dimap.entidades.LinhaDePesquisa;
import br.ufrn.dimap.entidades.Pessoa;
import br.ufrn.dimap.entidades.Vinculo;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leobrizolara
 */
public class VinculoDAO extends SqlDAO{
    @Override
    protected String createSelectCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object read(ResultSet rs) throws SQLException {
        Vinculo vinculo = new Vinculo();
        
        Pessoa p = (Pessoa)new PessoaDAO().read(rs);
        vinculo.setPessoa(p);
        
        LinhaDePesquisa lp = (LinhaDePesquisa) (new LinhaDePesquisaDAO()).read(rs);
        vinculo.setLinhaDePesquisa(lp);
        
        vinculo.setMatricula(rs.getString("Matricula"));
        vinculo.setDataDeMatricula(rs.getDate("DataDeMatricula"));
        vinculo.setAtivo(rs.getBoolean("Ativo"));
        
        return vinculo;
    }
    
}
