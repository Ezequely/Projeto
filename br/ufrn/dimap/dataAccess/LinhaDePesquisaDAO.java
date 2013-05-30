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
public class LinhaDePesquisaDAO extends SqlDAO{
    @Override
    protected String createSelectCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object read(ResultSet rs) throws SQLException{
        LinhaDePesquisa lp = new LinhaDePesquisa();
        
        lp.setCodigo(rs.getString("CodigoLinhaDePesquisa"));
        lp.setDescricao(rs.getString("Descricao"));
        lp.setTema(rs.getString("Tema"));
        
        return lp;
    }
    
}
