/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package br.ufrn.dimap.gui.widgets;

//import org.jdesktop.beansbinding.*;

import br.ufrn.dimap.entidades.Aluno;
import br.ufrn.dimap.entidades.Docente;
import br.ufrn.dimap.entidades.Pessoa;
import br.ufrn.dimap.entidades.Vinculo;
import java.awt.Color;
import java.awt.Component;
import java.awt.Cursor;
import javax.swing.BorderFactory;
import javax.swing.GroupLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.LayoutStyle;
import javax.swing.UIManager;
/**
 *
 * @author leobrizolara
 */
public class VinculoViewerResumo extends javax.swing.JPanel implements ObjectViewer{
    private Vinculo vinculo;
    /**
     * Creates new form pnlPessoaResumo
     */
    public VinculoViewerResumo() {
        initComponents();
    }
    public VinculoViewerResumo(Vinculo vinculo) {
        this();
        this.setVinculo(vinculo);
    }
    
    
    @Override
    public void setBackground(Color bg){
      super.setBackground(bg);
      if(this.pnlDados != null){
        this.pnlDados.setBackground(bg);
      }
    }
    @Override
    public void setForeground(Color fg){
      super.setForeground(fg);
      if(this.pnlDados != null){
          this.pnlDados.setForeground(fg);
      }
    }
    
    public Component getView() {
        return this;
    }
    
    public Object getObject() {
        return getVinculo();
    }
    public void setObject(Object obj) {
        if(obj instanceof Vinculo){
            this.setVinculo((Vinculo) obj);
        }
    }

    public Class getObjectClass() {
        return Vinculo.class;
    }
    
    public Vinculo getVinculo(){
        return vinculo;
    }
    public void setVinculo(Vinculo vinculo){
        this.vinculo = vinculo;
        
        if(vinculo != null){
            this.lblMatriculaValor.setText(vinculo.getMatricula());
           
            if(vinculo.getLinhaDePesquisa() != null){
                this.lblLinhaDePesquisaValor.setText(vinculo.getLinhaDePesquisa().getTema());
            }
            if(vinculo.getPessoa() != null){
                setPessoa(vinculo.getPessoa());
            }
            
            if(vinculo instanceof Aluno){            
                this.setAluno((Aluno)vinculo);
            }
            else if(vinculo instanceof Docente){
                this.setDocente((Docente)vinculo);
            }
        }
    }
    private void setAluno(Aluno aluno){
        this.lblTitulacaoLabel.setText("Grau");
        this.lblTitulacaoValor.setText(aluno.getGrau());
    }
    private void setDocente(Docente docente){
        this.lblTitulacaoLabel.setText("Titulação");
        this.lblTitulacaoValor.setText(docente.getTitulacao());
    }
    private void setPessoa(Pessoa pessoa){
        this.btnNomeValor.setText(pessoa.getNome());
        this.lblEmailValor.setText(pessoa.getEmail());
    }
    
    public void update(){
        this.setVinculo(this.vinculo);
    }
    
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        pnlDados = new JPanel();
        lblEmailLabel = new JLabel();
        lblEmailValor = new JLabel();
        lblMatriculaLabel = new JLabel();
        lblMatriculaValor = new JLabel();
        lblTitulacaoLabel = new JLabel();
        lblTitulacaoValor = new JLabel();
        lblLinhaDePesquisaValor = new JLabel();
        lblLinhaDePesquisaLabel = new JLabel();
        btnNomeValor = new JButton();
        imgBtnFoto = new JButton();

        setBorder(BorderFactory.createLineBorder(UIManager.getDefaults().getColor("CheckBoxMenuItem.background"), 2));

        lblEmailLabel.setText("Email:");

        lblEmailValor.setText("< Email >");

        lblMatriculaLabel.setText("Matrícula:");

        lblMatriculaValor.setText("< matricula >");

        lblTitulacaoLabel.setText("Titulação:");

        lblTitulacaoValor.setText("< titulação >");

        lblLinhaDePesquisaValor.setText("< linha de pesquisa >");

        lblLinhaDePesquisaLabel.setText("Linha de Pesquisa:");

        btnNomeValor.setFont(btnNomeValor.getFont().deriveFont(btnNomeValor.getFont().getSize()+4f));
        btnNomeValor.setText("<Nome>");
        btnNomeValor.setBorderPainted(false);
        btnNomeValor.setContentAreaFilled(false);
        btnNomeValor.setCursor(new Cursor(Cursor.HAND_CURSOR));

        GroupLayout pnlDadosLayout = new GroupLayout(pnlDados);
        pnlDados.setLayout(pnlDadosLayout);
        pnlDadosLayout.setHorizontalGroup(
            pnlDadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addGroup(pnlDadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(btnNomeValor)
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addComponent(lblEmailLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblEmailValor))
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addComponent(lblMatriculaLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblMatriculaValor))
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addComponent(lblLinhaDePesquisaLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblLinhaDePesquisaValor))
                    .addGroup(pnlDadosLayout.createSequentialGroup()
                        .addComponent(lblTitulacaoLabel)
                        .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(lblTitulacaoValor)))
                .addGap(0, 6, Short.MAX_VALUE))
        );
        pnlDadosLayout.setVerticalGroup(
            pnlDadosLayout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(pnlDadosLayout.createSequentialGroup()
                .addComponent(btnNomeValor)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblEmailLabel)
                    .addComponent(lblEmailValor))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblMatriculaValor)
                    .addComponent(lblMatriculaLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblTitulacaoValor)
                    .addComponent(lblTitulacaoLabel))
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(pnlDadosLayout.createParallelGroup(GroupLayout.Alignment.BASELINE)
                    .addComponent(lblLinhaDePesquisaValor)
                    .addComponent(lblLinhaDePesquisaLabel)))
        );

        imgBtnFoto.setText("foto");
        imgBtnFoto.setBorderPainted(false);
        imgBtnFoto.setContentAreaFilled(false);
        imgBtnFoto.setCursor(new Cursor(Cursor.HAND_CURSOR));

        GroupLayout layout = new GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(imgBtnFoto, GroupLayout.PREFERRED_SIZE, 128, GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(pnlDados, GroupLayout.DEFAULT_SIZE, GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(GroupLayout.Alignment.LEADING)
                    .addComponent(imgBtnFoto, GroupLayout.PREFERRED_SIZE, 131, GroupLayout.PREFERRED_SIZE)
                    .addComponent(pnlDados, GroupLayout.PREFERRED_SIZE, GroupLayout.DEFAULT_SIZE, GroupLayout.PREFERRED_SIZE))
                .addContainerGap(GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private JButton btnNomeValor;
    private JButton imgBtnFoto;
    private JLabel lblEmailLabel;
    private JLabel lblEmailValor;
    private JLabel lblLinhaDePesquisaLabel;
    private JLabel lblLinhaDePesquisaValor;
    private JLabel lblMatriculaLabel;
    private JLabel lblMatriculaValor;
    private JLabel lblTitulacaoLabel;
    private JLabel lblTitulacaoValor;
    private JPanel pnlDados;
    // End of variables declaration//GEN-END:variables


}
