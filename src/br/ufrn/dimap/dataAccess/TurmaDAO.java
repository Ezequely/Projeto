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
        else if(obj instanceof Aluno){
            return this.listAll(this.createSelectTurmaAlunoCmd((Aluno)obj), conn);
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
    private String createSelectTurmaAlunoCmd(Aluno aluno) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
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

    

    
    

//    @Override
//    /**insert into TURMA 
//     * (NumeroTurma, PeriodoLetivo, CodigoDisciplina, Status, CodHorarioDeAula,LocalDeAula) 
//     * values 
//     *   (...);
//     */
//    protected String createInsertCmd(Object obj) {
//        StringBuilder cmd = new StringBuilder();
//        if(obj instanceof Turma){
//            cmd.append("insert into TURMA ");
//            cmd.append(getColumns());
//            cmd.append(" values ");
//            cmd.append(getValues((Turma)obj));
//        }
//        return cmd.toString();
//    }
//
//    @Override
//    /**delete from TURMA where CodigoTurma = ?;*/
//    protected String createDeleteCmd(Object obj) {
//        StringBuilder cmd = new StringBuilder();
//        if(obj instanceof Turma){
//            Turma t = (Turma)obj;
//            cmd.append("delete from TURMA where CodigoTurma = ");
//            cmd.append(getIntegerValue(t.getCodigoTurma()));
//        }
//        return cmd.toString();
//    }
//
//    @Override
//    /** update TURMA set 
//		NumeroTurma = ?, 
//		PeriodoLetivo = ?, 
//		CodigoDisciplina = ?, 
//		Status = 'Consolidada',
//		CodHorarioDeAula = ?,
//		LocalDeAula = ?
//        where TURMA.CodigoTurma=?; */
//    protected String createUpdateCmd(Object obj) {
//        StringBuilder cmd = new StringBuilder();
//        if(obj instanceof Turma){
//            cmd.append("update TURMA set ");
//            cmd.append(getColumnsValues((Turma)obj));
//            cmd.append(" where TURMA.CodigoTurma = ");
//            cmd.append(getIntegerValue(((Turma)obj).getCodigoTurma()));
//        }
//        return cmd.toString();
//    }

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
