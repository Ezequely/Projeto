/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import br.ufrn.dimap.entidades.Aluno;
import br.ufrn.dimap.entidades.Disciplina;
import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.entidades.Turma;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author leobrizolara
 */
public class TurmaDAO extends SqlDAO{
    public TurmaDAO(DatabaseController dbControl){
        super(dbControl);
    }
    
    ////SELECIONAR
    
    @Override
    public Collection<? extends Object> listAll(){
        return this.listAll(this.createSelectCmd());
    }
    @Override
    public Collection<? extends Object> listAll(String selectCommand, Connection conn){
        System.out.println(selectCommand);//DEBUG
        
        
        Collection<? extends Object> turmas = super.listAll(selectCommand, conn);
        
        DocenteDAO docenteDAO = new DocenteDAO(this.dataController);
        for(Object o : turmas){
            Turma t = (Turma)o;
            //adicionar docentes a turma
            t.setDocentes((Collection<Docente>) docenteDAO.search(t));
        }
        
        return turmas;
    }
    
    /**
     *  @return se obj for um docente, retorna as turmas minsitradas por esse docente.
     */
    public Collection<? extends Object> search(Object obj, Connection conn) {
        if(obj instanceof Docente){//buscar turmas de um docente
            return this.listAll(this.createSelectTurmaDocenteCmd((Docente)obj), conn);
        }
        
        return new ArrayList<Object>();
    }
    /* selectiona todos os professores de uma turma
     select * from 
        TURMA t 
        join DISCIPLINA d on t.CodigoDisciplina = d.CodigoDisciplina
	natural join LINHADEPESQUISA
	where CodigoTurma 
		in (select CodigoTurma from TURMA_DOCENTE where MatriculaDocente = ?)
     */
    private String createSelectTurmaDocenteCmd(Docente d) {
        StringBuilder builder = new StringBuilder();
        builder.append(this.createSelectCmd());
        builder.append(" where CodigoTurma in ");
        builder.append(" (select CodigoTurma from TURMA_DOCENTE where MatriculaDocente = '");
        builder.append(d.getMatricula());
        builder.append( "' )");
        
        return builder.toString();
    }
    
    
    /*select * from 
        TURMA t 
        join DISCIPLINA d on t.CodigoDisciplina = d.CodigoDisciplina
	natural join LINHADEPESQUISA*/
    protected String createSelectCmd(){
        StringBuilder builder = new StringBuilder();
        builder.append("select * from ");
        builder.append(" TURMA t ");
        builder.append(" join DISCIPLINA d on t.CodigoDisciplina = d.CodigoDisciplina");
        builder.append(" natural join LINHADEPESQUISA");
        
        String cmd = builder.toString();
        
        return cmd;
    }

    @Override
    protected Object read(ResultSet rs) {
        
        Turma turma = new Turma();
        try {
            turma.setCodigoTurma(rs.getInt("CodigoTurma"));
            turma.setLocalDeAula(rs.getString("LocalDeAula"));
            turma.setNumeroTurma(rs.getInt("NumeroTurma"));
            turma.setPeriodoLetivo(rs.getString("PeriodoLetivo"));
            turma.setStatus(rs.getString("Status"));
            turma.setCodHorarioDeAula(rs.getString("CodHorarioDeAula"));
            turma.setDisciplina(
                    (Disciplina)(new DisciplinaDAO()).read(rs));
            
        } catch (SQLException ex) {
            ex.printStackTrace();
        }

        return turma;
    }

    
    
    ///INSERIR
    @Override
    public int insert(Object obj) {
        int changedRows = -1;
        
        Connection connection = this.initTransaction();
        if(connection != null){
            changedRows = executeUpdate(createInsertCmd(obj), connection);//insere turma
            Turma turma = (Turma)obj;
            //Se turma foi inserida e há docentes, tenta inserir docentes
            if(changedRows > 0 && turma.getDocentes() != null && turma.getDocentes().size() > 0){
                //insere docentes na ultima turma criada (pois turma não possui um codigo valido)
                changedRows += executeUpdate(createInsertLastTurmaDocenteCmd(turma), connection);
            }
            this.commitTransaction(connection);
        }
        
        return changedRows;
        
    }
    
    
    

    /* Inserir docentes na ultima turma criada
     * insert into TURMA_DOCENTE values ((select MAX(CodigoTurma) from TURMA), ?);*/
    private String createInsertLastTurmaDocenteCmd(Turma t) {
        StringBuilder builder = new StringBuilder();
        builder.append("insert into TURMA_DOCENTE values ");
        boolean first = true;
        for(Docente d : t.getDocentes()){
            builder.append((first? " (" : " ,("));
            //builder.append(this.getIntegerValue(t.getCodigoTurma()));
            builder.append(" (select MAX(CodigoTurma) from TURMA) ");
            builder.append(" , ");
            builder.append(this.getStringValue(d.getMatricula()));
            builder.append(") ");
            first = false;
        }
        
        return builder.toString();
    }
    
    
    private String createInsertTurmaDocenteCmd(Turma t) {
        StringBuilder builder = new StringBuilder();
        builder.append("insert into TURMA_DOCENTE values ");
        boolean first = true;
        for(Docente d : t.getDocentes()){
            builder.append((first? " (" : " ,("));
            builder.append(this.getIntegerValue(t.getCodigoTurma()));
            builder.append(" , ");
            builder.append(this.getStringValue(d.getMatricula()));
            builder.append(") ");
            first = false;
        }
        
        return builder.toString();
    }
    ///ATUALIZAR
    @Override
    public int update(Object obj) {
        int changedRows = -1;
        
        Connection connection = this.initTransaction();
        if(connection != null){
            changedRows = executeUpdate(createUpdateCmd(obj), connection);//insere turma
            Turma turma = (Turma)obj;
            //Se turma foi atualizada e há docentes, tenta atualizar referencia a docentes
            if(changedRows > 0 && turma.getDocentes() != null && turma.getDocentes().size() > 0){
                //deleta referencias anteriores
                executeUpdate(createDeleteTurmaDocenteCmd(turma), connection);
                //insere novas
                return changedRows + executeUpdate(createInsertTurmaDocenteCmd(turma), connection);
            }
            this.commitTransaction(connection);
        }
        
        return changedRows;
    }
    
    private String createDeleteTurmaDocenteCmd(Turma t) {
        StringBuilder builder = new StringBuilder();
        builder.append("delete from TURMA_DOCENTE where CodigoTurma = ");
        builder.append(getIntegerValue(t.getCodigoTurma()));
        
        return builder.toString();
    }

    @Override
    protected String getTableName() {
        return "TURMA";
    }

    @Override
    protected String getCondicaoDeAtualizacao(Object obj) {
            return " TURMA.CodigoTurma = "
                    + getIntegerValue(((Turma)obj).getCodigoTurma());
    }

    /**
        NumeroTurma = ?, 
        PeriodoLetivo = ?, 
        CodigoDisciplina = ?, 
        Status = 'Consolidada',
        CodHorarioDeAula = ?,
        LocalDeAula = ? */
    protected String getColumnsValues(Object object) {
        Turma turma = (Turma)object;
        StringBuilder columnsValues = new StringBuilder();
        
        columnsValues.append(" NumeroTurma = ");
        columnsValues.append(getIntegerValue(turma.getNumeroTurma()));
        columnsValues.append(", PeriodoLetivo = ");
        columnsValues.append(getStringValue(turma.getPeriodoLetivo()));
        
        columnsValues.append(", CodigoDisciplina = ");
        if(turma.getDisciplina() != null){
            columnsValues.append(getStringValue(turma.getDisciplina().getCodigoDisciplina()));
        }
        else{//TODO: disciplina permite valor NULL? gerar exceção?
            columnsValues.append(getNullValue());            
        }
        
        columnsValues.append(", Status = ");
        columnsValues.append(getStringValue(turma.getStatus()));
        columnsValues.append(", CodHorarioDeAula = ");
        columnsValues.append(getStringValue(turma.getCodHorarioDeAula()));
        columnsValues.append(", LocalDeAula = ");
        columnsValues.append(getStringValue(turma.getLocalDeAula()));
        
        return columnsValues.toString();
    }
    public String getColumns(){
        StringBuilder columns = new StringBuilder();
        
        columns.append(" (");
        //columns.append("CodigoTurma");
        columns.append("NumeroTurma");
        columns.append(", PeriodoLetivo");
        columns.append(", CodigoDisciplina");
        columns.append(", Status");
        columns.append(", CodHorarioDeAula");
        columns.append(", LocalDeAula");
        columns.append(") ");
        
        return columns.toString();
    }
    @Override
    protected String getValues(Object object){
        Turma turma = (Turma)object;
        
        StringBuilder values = new StringBuilder();
        values.append("(");
        //values.append(getIntegerValue(t.getCodigoTurma())); -- codigo turma é gerado automaticamente
        values.append(getIntegerValue(turma.getNumeroTurma()));
        values.append(", ");
        
        values.append(getStringValue(turma.getPeriodoLetivo()));
        values.append(", ");
        if(turma.getDisciplina() != null){
            values.append(getStringValue(turma.getDisciplina().getCodigoDisciplina()));
        }
        else{//TODO: disciplina permite valor NULL? gerar exceção?
            values.append(getNullValue());            
        }
        values.append(", ");
        values.append(getStringValue(turma.getStatus()));
        values.append(", ");
        values.append(getStringValue(turma.getCodHorarioDeAula()));
        values.append(", ");
        values.append(getStringValue(turma.getLocalDeAula()));
        values.append(")");
        
        return values.toString();
    }

}
