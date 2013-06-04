package br.ufrn.dimap.gui.telas;

import br.ufrn.dimap.gui.Navigable;
import br.ufrn.dimap.gui.NavigationEvent;
import br.ufrn.dimap.dataAccess.AlunoDAO;
import br.ufrn.dimap.dataAccess.AlunoTurmaDAO;
import br.ufrn.dimap.dataAccess.BancaExaminadoraDAO;
import br.ufrn.dimap.dataAccess.DatabaseController;
import br.ufrn.dimap.dataAccess.DocenteDAO;
import br.ufrn.dimap.dataAccess.PublicacaoDAO;
import br.ufrn.dimap.dataAccess.TurmaDAO;
import br.ufrn.dimap.entidades.Aluno;
import br.ufrn.dimap.entidades.BancaExaminadora;
import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.entidades.MatriculaAlunoTurma;
import br.ufrn.dimap.entidades.Turma;
import br.ufrn.dimap.gui.controladores.ControleCRUD;
import java.util.Collection;
import java.util.Stack;

public class TelaPrincipal extends Tela implements Navigable{
    private Tela telaAtual;
    private DatabaseController dbController;
    private Stack<NavigationEvent> stackDesfazer;
    private Stack<NavigationEvent> stackRefazer;
    
    public TelaPrincipal() {
        this(null);
    }
    public TelaPrincipal(DatabaseController controller) {
        initComponents();
        stackDesfazer = new Stack<NavigationEvent>();
        stackRefazer = new Stack<NavigationEvent>();
        dbController = controller;
        
        this.btnUndo.setEnabled(false);
        this.navigate(new NavigationEvent(this,"TelaHome"));
    }
    
    public void navigate(NavigationEvent event) {
        if(this.naviTo(event)){            
            this.stackDesfazer.add(event);
            if(stackDesfazer.size() > 1){
                this.btnUndo.setEnabled(true);
            }
        }
        System.out.println("Navegou para: " + event.getDestination());
    }
    
    protected boolean naviTo(NavigationEvent event){
        System.out.println("Navegar para: " + event.getDestination());
        String dest = event.getDestination();
        
        Tela tela = null;
        if(dest.equals("TelaGerenciar")){
            this.mudarTela((ControleCRUD)event.getArg("Controle"));
            return true;
        }
        else if(dest.equals("TelaHome")){
            tela = navegarTelaHome(event);
        }
        else if(dest.equals("TelaVisualizarAlunos")){
            tela = navegarTelaVisualizarAlunos(event);
        }
        else if(dest.equals("TelaVisualizarDocentes")){
            tela = navegarTelaVisualizarDocentes(event);
        }
        else if(dest.equals("TelaVisualizarTurmas")){
            tela = navegarTelaVisualizarTurmas(event);
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
        else if(dest.equals("TelaVisualizarBancasExaminadoras")){
            tela = navegarTelaVisualizarBancasExaminadoras(event);
        }
        else if(dest.equals("TelaVisualizarDadosBancaExaminadora")){
            tela = navegarTelaVisualizarDadosBancaExaminadora(event);
        }
        else{
            System.err.println("Destino: " + event.getDestination() + " não encontrado!");
            return false;
        }
        
        if(tela != null){               
            this.mudarTela(tela);
            return true;
        }        
        return false;
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

            System.out.println("Historico aluno: " + historicoAluno.size());
            for(Object o : historicoAluno){
                MatriculaAlunoTurma alunoTurma = (MatriculaAlunoTurma)o;
                System.out.println("\t" + alunoTurma.toString());
            }
            
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
        else{
            return new TelaVisualizarDadosAluno();
        }
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
    
    
    private Tela navegarTelaVisualizarTurmas(NavigationEvent event) {
        if(dbController != null){
            TurmaDAO turmaDAO = new TurmaDAO(dbController);
            Collection<? extends Object> turmas = turmaDAO.listAll();
            return new TelaVisualizarTurmas((Collection<Turma>) turmas);
        }
        
        return new TelaVisualizarTurmas();
    }
    private Tela navegarTelaVisualizarDadosTurma(NavigationEvent event) {
        if(event != null && event.getArg("Turma") != null){
            Turma turma = (Turma) event.getArg("Turma");

            TelaVisualizarDadosTurma telaDadosTurma = new TelaVisualizarDadosTurma(turma);
            
            AlunoTurmaDAO alunoTurmaDAO = new AlunoTurmaDAO(dbController);
            telaDadosTurma.setAlunosTurma(
                    (Collection<MatriculaAlunoTurma>) alunoTurmaDAO.search(turma));
            
            return telaDadosTurma;
        }
        //else
        return new TelaVisualizarTurmas();
    }
    
    private Tela navegarTelaVisualizarBancasExaminadoras(NavigationEvent event) {
        if(dbController != null){
            BancaExaminadoraDAO bancaDAO = new BancaExaminadoraDAO(dbController);
            Collection<? extends Object> bancas = bancaDAO.listAll();
            return new TelaVisualizarBancasExaminadoras((Collection<BancaExaminadora>) bancas);
        }        
        
        return new TelaVisualizarBancasExaminadoras();
    }
    private Tela navegarTelaVisualizarDadosBancaExaminadora(NavigationEvent event) {
        if(event != null && event.getArg("BancaExaminadora") != null){
            BancaExaminadora bancaExaminadora = (BancaExaminadora) event.getArg("BancaExaminadora");

            TelaVisualizarDadosBancaExaminadora telaDadosBancaExaminadora = 
                    new TelaVisualizarDadosBancaExaminadora(bancaExaminadora);
            
            return telaDadosBancaExaminadora;
        }
        //else
        return new TelaVisualizarBancasExaminadoras();
    }
    
    private void mudarTela(Tela tela){
        if(tela != telaAtual){
            tela.setNavigableParent(this);
            telaAtual = tela;
                        
            this.pnlTela.removeAll();
            this.pnlTela.add(telaAtual);
            this.revalidate();
            this.repaint();
        }
    }
    
    /**Retorna para a tela na ultima navegação*/
    private void undo() {
        if(this.stackDesfazer.size() > 1){
            stackRefazer.add(stackDesfazer.pop());
            this.naviTo(stackDesfazer.peek());
            if(this.stackDesfazer.size() == 1){//so tem o atual
                this.btnUndo.setEnabled(false);
            }
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

        jToolBar1 = new javax.swing.JToolBar();
        btnUndo = new javax.swing.JButton();
        pnlTela = new javax.swing.JPanel();

        setLayout(new java.awt.BorderLayout());

        jToolBar1.setRollover(true);

        btnUndo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/img/undoIcon32x32.png"))); // NOI18N
        btnUndo.setFocusable(false);
        btnUndo.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        btnUndo.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        btnUndo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnUndoActionPerformed(evt);
            }
        });
        jToolBar1.add(btnUndo);

        add(jToolBar1, java.awt.BorderLayout.NORTH);

        pnlTela.setLayout(new java.awt.BorderLayout());
        add(pnlTela, java.awt.BorderLayout.CENTER);
    }// </editor-fold>//GEN-END:initComponents

    private void btnUndoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnUndoActionPerformed
        this.undo();
    }//GEN-LAST:event_btnUndoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnUndo;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JPanel pnlTela;
    // End of variables declaration//GEN-END:variables

    private void mudarTela(ControleCRUD controlador) {            
        controlador.setDataController(this.dbController);
        controlador.show(this.pnlTela);
    }

}
