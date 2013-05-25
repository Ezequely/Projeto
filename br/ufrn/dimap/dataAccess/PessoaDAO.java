/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import br.ufrn.dimap.entidades.Pessoa;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leobrizolara
 */
public class PessoaDAO extends SqlDAO{

    @Override
    protected String createSelectCmd() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected Object read(ResultSet rs) throws SQLException {
        Pessoa p = new Pessoa();
        p.setCpf(rs.getString("CPF"));
        p.setNome(rs.getString("Nome"));
        p.setCidade(rs.getString("Cidade"));
        p.setDataNascimento(rs.getDate("DTNasc"));
        p.setEmail(rs.getString("E_mail"));
        p.setEndereco(rs.getString("Endereco"));
        p.setNacionalidade(rs.getString("Nacionalidade"));
        p.setNaturalidade(rs.getString("Naturalidade"));
        p.setTelefone(rs.getString("Telefone"));
        p.setUf(rs.getString("uf"));
        
        return p;
    }
}
