/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import br.ufrn.dimap.entidades.LinhaDePesquisa;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leobrizolara
 */
public class LinhaDePesquisaDAO {

    static void read(LinhaDePesquisa lp, ResultSet rs) throws SQLException {
        lp.setCodigo(rs.getString("CodigoLinhaDePesquisa"));
        lp.setDescricao(rs.getString("Descricao"));
        lp.setTema(rs.getString("Tema"));
    }
    
}
