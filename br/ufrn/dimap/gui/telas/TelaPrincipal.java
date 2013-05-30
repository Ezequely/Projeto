package br.ufrn.dimap.gui.telas;

import br.ufrn.dimap.gui.Navigable;
import br.ufrn.dimap.gui.NavigationEvent;
import br.ufrn.dimap.dataAccess.AlunoDAO;
import br.ufrn.dimap.dataAccess.AlunoTurmaDAO;
import br.ufrn.dimap.dataAccess.DatabaseController;
import br.ufrn.dimap.dataAccess.DocenteDAO;
import br.ufrn.dimap.dataAccess.PublicacaoDAO;
import br.ufrn.dimap.dataAccess.TurmaDAO;
import br.ufrn.dimap.entidades.Aluno;
import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.entidades.Turma;
import java.util.Collection;

public class TelaPrincipal extends Tela implements Navigable{
    private Tela telaAtual;
    private DatabaseController dbController;
    
    public TelaPrincipal() {
        initComponents();
    }
    public TelaPrincipal(DatabaseController controller) {
        initComponents();
        dbController = controller;
        
        this.navigate(new NavigationEvent(this,"TelaHome"));
    }
    
    public void navigate(NavigationEvent event) {
        String dest = event.getDestination();
        
        System.out.println("Navegar para: " + dest);
        
        
        Tela tela = null;
        if(dest.equals("TelaHome")){
            tela = navegarTelaHome(event);
        }
        else if(dest.equals("TelaVisualizarAlunos")){
            tela = navegarTelaVisualizarAlunos(event);
        }
        else if(dest.equals("TelaVisualizarDocentes")){
            tela = navegarTelaVisualizarDocentes(event);
        }
        else if(dest.equals("TelaVisualizarDadosAluno")){
            tela = navegarTelaVisualizarDadosAlunos(event);
        }
        else if(dest.equals("TelaVisualizarDadosDocente")){
            tela = navegarTelaVisualizarDadosDocente(event);
        }
        else if(dest.equals("TelaVisualizarDadosTurma")){
            tela = navegarTelaVisualizarDadosTurma(event);
        }
        else{
            System.err.println("Destino: " + event.getDestination() + " não encontrado!");
            return;
        }
        
        if(tela != null){   
            this.mudarTela(tela);
        }
    }
   
    private Tela navegarTelaHome(NavigationEvent event) {
        return new TelaHome();
    }
    private Tela navegarTelaVisualizarAlunos(NavigationEvent event) {
        if(dbController != null){
            AlunoDAO alunoDAO = new AlunoDAO(dbController);
            Collection<? extends Object> alunos = alunoDAO.listAll();
            return new TelaVisualizarAlunos(alunos);
        }
        
        return new TelaVisualizarAlunos();
    }
    
    private Tela navegarTelaVisualizarDadosAlunos(NavigationEvent event) {
        if(dbController != null && event != null && event.getArg("Aluno") != null){
            Aluno aluno = (Aluno) event.getArg("Aluno");

            AlunoTurmaDAO alunoTurmaDAO = new AlunoTurmaDAO(dbController);
            Collection<? extends Object> historicoAluno = alunoTurmaDAO.search(aluno);

            TelaVisualizarDadosAluno tela = new TelaVisualizarDadosAluno(aluno);
            tela.setHistoricoAluno(historicoAluno);

            if(aluno.getPessoa() != null){
                PublicacaoDAO publicacaoDAO = new PublicacaoDAO(dbController);
                Collection<? extends Object> publicacoes 
                        = publicacaoDAO.search(aluno.getPessoa());
                tela.setPublicacoesAluno(publicacoes);
            }
            
            return tela;
        }
        return new TelaVisualizarDadosAluno();
    }

    
    private Tela navegarTelaVisualizarDocentes(NavigationEvent event) {
        if(dbController != null){
            DocenteDAO docenteDAO = new DocenteDAO(dbController);
            Collection<? extends Object> docentes = docenteDAO.listAll();
            return new TelaVisualizarDocentes((Collection<Docente>) docentes);
        }
        
        return new TelaVisualizarDocentes();
    }
    private Tela navegarTelaVisualizarDadosDocente(NavigationEvent event) {
        
        if(dbController != null && event != null && event.getArg("Docente") != null){
            Docente docente = (Docente) event.getArg("Docente");

            TurmaDAO turmasDAO = new TurmaDAO(dbController);
            Collection<? extends Object> turmasDocente = turmasDAO.search(docente);

            TelaVisualizarDadosDocente telaDadosDocente 
                    = new TelaVisualizarDadosDocente(docente, turmasDocente);

            if(docente.getPessoa() != null){
                PublicacaoDAO publicacaoDAO = new PublicacaoDAO(dbController);
                Collection<? extends Object> publicacoesDocente 
                        = publicacaoDAO.search(docente.getPessoa());
                telaDadosDocente.setPublicacoesDocente(publicacoesDocente);
            }
            
            return telaDadosDocente;
        }
        //else
        return new TelaVisualizarDocentes();
    }
    
    private Tela navegarTelaVisualizarDadosTurma(NavigationEvent event) {
        if(event != null && event.getArg("Turma") != null){
            Turma turma = (Turma) event.getArg("Turma");

            TelaVisualizarDadosTurma telaDadosTurma = new TelaVisualizarDadosTurma(turma);
            
            return telaDadosTurma;
        }
        //else
        return new TelaVisualizarTurmas();
    }
    
    private void mudarTela(Tela tela){
        if(tela != telaAtual){
            tela.setNavigableParent(this);
            telaAtual = tela;
                        
            this.removeAll();
            this.add(telaAtual);
            this.revalidate();
            this.repaint();
        }
    }
    
    
    
    
    
    

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        setLayout(new java.awt.BorderLayout());
    }// </editor-fold>//GEN-END:initComponents
    // Variables declaration - do not modify//GEN-BEGIN:variables
    // End of variables declaration//GEN-END:variables

}