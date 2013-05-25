/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.dataAccess;

import br.ufrn.dimap.entidades.Disciplina;
import br.ufrn.dimap.entidades.Turma;
import java.sql.ResultSet;
import java.sql.SQLException;

/**
 *
 * @author leobrizolara
 */
public class TurmaDAO extends SqlDAO{
    public TurmaDAO(DatabaseController dbControl){
        super(dbControl);
    }
    
    public void update(Object obj) {
        //this.connection.
    }

    public void insert(Object obj) {
    }

    public Object search(Object obj) {
        return null;
    }

    public void remove(Object obj) {
    }
    
    /*select * from 
        TURMA t 
        join DISCIPLINA d on t.CodigoDisciplina = d.CodigoDisciplina
	natural join LINHADEPESQUISA;*/
    protected String createSelectCmd(){
        StringBuilder builder = new StringBuilder();
        builder.append("select * from ");
        builder.append(" TURMA t");
        builder.append(" join DISCIPLINA d on t.CodigoDisciplina = d.CodigoDisciplina");
        builder.append(" natural join LINHADEPESQUISA;");
        
        String cmd = builder.toString();
        System.out.println(cmd);
        
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
    
}
