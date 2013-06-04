/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import br.ufrn.dimap.entidades.LinhaDePesquisa;
import br.ufrn.dimap.entidades.Disciplina;
import br.ufrn.dimap.entidades.Turma;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leobrizolara
 */
public class DisciplinaDAO extends SqlDAO{
    public DisciplinaDAO(){}
    public DisciplinaDAO(DatabaseController dbController){
        super(dbController);
    }
    
    /*select * from 
	DISCIPLINA
	natural join LINHADEPESQUISA;*/
    @Override
    protected String createSelectCmd() {
        StringBuilder builder = new StringBuilder();
        builder.append("select * from ");
        builder.append(" DISCIPLINA d ");
        builder.append(" natural join LINHADEPESQUISA ");
        
        String cmd = builder.toString();
        
        return cmd;
    }

    @Override
    protected Object read(ResultSet rs) throws SQLException{
        Disciplina disciplina = new Disciplina();
        
        disciplina.setNome(rs.getString("Nome"));
        disciplina.setCodigoDisciplina(rs.getString("CodigoDisciplina"));
        disciplina.setCargaHoraria(rs.getString("CargaHoraria"));
        disciplina.setEmenta(rs.getString("Ementa"));
        disciplina.setStatus(rs.getString("Status"));
        //le objeto linha de pesquisa
        disciplina.setLinhaDePesquisa((LinhaDePesquisa) (new LinhaDePesquisaDAO().read(rs)));
        
        return disciplina;
    }

    
    @Override
    protected String getTableName() {
        return "DISCIPLINA";
    }

    @Override
    protected String getCondicaoDeAtualizacao(Object obj) {
            return " DISCIPLINA.CodigoDisciplina = "
                    + getStringValue(((Disciplina)obj).getCodigoDisciplina());
    }

    /**
        NumeroTurma = ?, 
        PeriodoLetivo = ?, 
        CodigoDisciplina = ?, 
        Status = 'Consolidada',
        CodHorarioDeAula = ?,
        LocalDeAula = ? */
    protected String getColumnsValues(Object object) {
        Disciplina disciplina = (Disciplina)object;
        StringBuilder columnsValues = new StringBuilder();
        
        
        columnsValues.append(" Nome = ");
        columnsValues.append(getStringValue(disciplina.getNome()));
        columnsValues.append(", CodigoDisciplina = ");
        columnsValues.append(getStringValue(disciplina.getCodigoDisciplina()));
        columnsValues.append(", CargaHoraria = ");
        columnsValues.append(getStringValue(disciplina.getCargaHoraria()));
        columnsValues.append(", Ementa = ");
        columnsValues.append(getStringValue(disciplina.getEmenta()));
        columnsValues.append(", Status = ");
        columnsValues.append(getStringValue(disciplina.getStatus()));
        
        columnsValues.append(", CodigoLinhaDePesquisa = ");
        if(disciplina.getLinhaDePesquisa()!= null){
            columnsValues.append(getStringValue(disciplina.getLinhaDePesquisa().getCodigo()));
        }
        else{
            columnsValues.append(getNullValue());
        }
        
        return columnsValues.toString();
    }
    public String getColumns(){
        StringBuilder columns = new StringBuilder();
        
        columns.append(" (");
        columns.append(" Nome");
        columns.append(", CodigoDisciplina");
        columns.append(", CargaHoraria");
        columns.append(", Ementa");
        columns.append(", Status");
        columns.append(", CodigoLinhaDePesquisa");
        columns.append(") ");
        
        return columns.toString();
    }
    @Override
    protected String getValues(Object object){        
        Disciplina disciplina = (Disciplina)object;
        StringBuilder values = new StringBuilder();
        
        
        values.append("(");
        values.append(getStringValue(disciplina.getNome()));
        values.append(", ");
        values.append(getStringValue(disciplina.getCodigoDisciplina()));
        values.append(", ");
        values.append(getStringValue(disciplina.getCargaHoraria()));
        values.append(", ");
        values.append(getStringValue(disciplina.getEmenta()));
        values.append(", ");
        values.append(getStringValue(disciplina.getStatus()));
        values.append(", ");
        
        if(disciplina.getLinhaDePesquisa()!= null){
            values.append(getStringValue(disciplina.getLinhaDePesquisa().getCodigo()));
        }
        else{
            values.append(getNullValue());
        }
        
        values.append(")");
        
        return values.toString();
    }
    
    
}
