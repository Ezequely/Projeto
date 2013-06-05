/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import br.ufrn.dimap.entidades.Aluno;
import br.ufrn.dimap.entidades.BancaExaminadora;
import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.entidades.Examinador;
import br.ufrn.dimap.entidades.MatriculaAlunoTurma;
import br.ufrn.dimap.entidades.Publicacao;
import br.ufrn.dimap.entidades.Turma;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

    
/**
 *
 * @author leobrizolara
 */
public class BancaExaminadoraDAO extends SqlDAO{
    PublicacaoDAO publicacaoDAO;
    AlunoDAO alunoDAO;
    
    public BancaExaminadoraDAO(DatabaseController dbController){
        super(dbController);
        alunoDAO = new AlunoDAO(dataController);
        publicacaoDAO = new PublicacaoDAO(dbController);
    }
    
    @Override
    public Collection<? extends Object> listAll(String cmd, Connection conn) {//TODO: permitir transaction        
        System.out.print(this);
        System.out.println("listAll: ");
        
        //Lista todas as bancas
        Collection<? extends Object> bancasExaminadoras = super.listAll(cmd, conn);
        
        //buscar examinadores das bancas
        ExaminadorDAO examinadorDAO = new ExaminadorDAO(dataController);
        Collection<? extends Object> examinadores = examinadorDAO.listAll(conn);
        
        //Cria tabela hash com bancas para tornar sua busca mais rápida
        Map<Integer, BancaExaminadora> bancasMap = new HashMap<Integer, BancaExaminadora>();
        
        for(Object o: bancasExaminadoras){
            BancaExaminadora banca = (BancaExaminadora)o;
            bancasMap.put(banca.getCodigoBanca(), banca);
        }
        
        //Cada examinador possui o codigo para sua banca
        for(Object o : examinadores){
            Examinador exam = (Examinador)o;
            
            BancaExaminadora banca = bancasMap.get(exam.getCodigoBanca());
            banca.addExaminador(exam);
            
            System.out.print("add examinador ");
            System.out.print(exam);
            System.out.print(" to ");
            System.out.println(banca);
            
        }
        
        return bancasExaminadoras;
    }
        
        
    @Override
    /*select * from ALUNO 
		join VINCULO on MatriculaAluno = Matricula 
		natural join PESSOA 
		natural join LINHADEPESQUISA
		natural join BANCAEXAMINADORA
		join PUBLICACAO on ISSN = ISSN_Dissertacao;*/
    protected String createSelectCmd() {
        StringBuilder builder = new StringBuilder();
        builder.append(alunoDAO.createSelectCmd());
        builder.append(" natural join BANCAEXAMINADORA ");
        builder.append(" join PUBLICACAO on ISSN = ISSN_Dissertacao ");
        
        String cmd = builder.toString();
        
        return cmd;
    }

    @Override
    //(CodigoBanca, DataDeDefesa, ISSN_Dissertacao, MatriculaAluno)
    protected Object read(ResultSet rs) throws SQLException {
        BancaExaminadora bancaExaminadora = new BancaExaminadora();
        
        bancaExaminadora.setCodigoBanca(rs.getInt("CodigoBanca"));
        bancaExaminadora.setDataDeDefesa(rs.getDate("DataDeDefesa"));
        bancaExaminadora.setAluno((Aluno) alunoDAO.read(rs));
        bancaExaminadora.setDissertacao((Publicacao) publicacaoDAO.read(rs));
        
        return bancaExaminadora;    
    }

    
    @Override
    protected String getTableName() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getColumns() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getValues(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getCondicaoDeAtualizacao(Object obj) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    protected String getColumnsValues(Object object) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    
    
}
