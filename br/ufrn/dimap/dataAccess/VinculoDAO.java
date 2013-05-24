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

    static void read(Vinculo vinculo, ResultSet rs) throws SQLException {
        Pessoa p = new Pessoa();
        PessoaDAO.read(p, rs);
        vinculo.setPessoa(p);
        
        LinhaDePesquisa lp = new LinhaDePesquisa();
        LinhaDePesquisaDAO.read(lp, rs);
        vinculo.setlinhaDePesquisa(lp);
        
        vinculo.setMatricula(rs.getString("Matricula"));
        vinculo.setDataDeMatricula(rs.getDate("DataDeMatricula"));
        vinculo.setAtivo(rs.getBoolean("Ativo"));
    }
    
}
