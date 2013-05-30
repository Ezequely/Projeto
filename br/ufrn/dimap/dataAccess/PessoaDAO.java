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

    
    public Pessoa Insert(String cpf, String nome, String endereco, String cidade, String uf, String nacionalidade, String naturalidade, String DTNasc, String telefone, String email){
        StringBuilder sqlCmd = new StringBuilder();
        sqlCmd.append(createSelectCmd());
        sqlCmd.append("'(' '");
        sqlCmd.append(cpf);
        sqlCmd.append(",'");
        sqlCmd.append(nome);
        sqlCmd.append(",'");
        sqlCmd.append(endereco);
        sqlCmd.append(",'");
        sqlCmd.append(cidade);
        sqlCmd.append(",'");
        sqlCmd.append(uf);
        sqlCmd.append(",'");
        sqlCmd.append(naturalidade);
        sqlCmd.append(",'");
        sqlCmd.append(nacionalidade);
        sqlCmd.append(",'");
        sqlCmd.append(DTNasc);
        sqlCmd.append(",'");
        sqlCmd.append(email);
        sqlCmd.append(",'");
        sqlCmd.append(telefone);
        sqlCmd.append(")");
        
        return null;
    }
    

    /*select Login, CPF, Nome, Endereco, Cidade, UF, Naturalidade, Nacionalidade, DTNasc, E_mail, Telefone from
	USUARIO natural join PESSOA where Login = ? and PasswordHash = ?;*/
    protected String createInsertCmd() {
        StringBuilder sqlCmd = new StringBuilder();
        sqlCmd.append("INSERT INTO PESSOA ("); 
        sqlCmd.append("Login, CPF, Nome, Endereco, Cidade, UF, Naturalidade, Nacionalidade, DTNasc, E_mail, Telefone) ");
        sqlCmd.append("VALUE ");
    
        return sqlCmd.toString();
    }
    
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
