package br.com.provacBeta.vacinacao.guiVacinacao;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.provacBeta.interfaces.TelasGerais;

public class PainelOpcoesVacinacao extends JPanel{
	private String operacoes[] = {"Escolha uma operação","Cadastrar","Alterar","Procurar","Remover "};
	private JComboBox listaOpcoes;
	
	private JTextField aviso = new JTextField("Clique em um dos botões acima");
	private Color corFormulario = Color.decode("#6F9890");
	private Color corDiferente = Color.decode("#336666");
	private Color corFonte = Color.decode("#FFFFFF");
    private Color corDestaque = Color.decode("#5C8B7C");
	private Color corAtencao = Color.ORANGE;
	
	
    public PainelOpcoesVacinacao(JPanel painelCentral){
		
		aviso.setBackground(corAtencao);
		setBackground(corDiferente);
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		listaOpcoes = new JComboBox(operacoes);        
        listaOpcoes.setBackground(corFormulario);
        listaOpcoes.setForeground(corFonte);
//        add(aviso);
        listaOpcoes.addActionListener(//Classe interna anonima
          		 new ActionListener(){   
          			 //metodo ActionPerformed da classe tratadora anônima
                      public void actionPerformed(ActionEvent e) {
                      JComboBox JCBOperacoes = (JComboBox)e.getSource();
                      String cmbOperacao = (String)JCBOperacoes.getSelectedItem();
                      
                      if(cmbOperacao == operacoes[1]){//
                   	    TelaGeralVacinacao tg = new TelaGeralVacinacao(null);
                        PainelCadastrarVacinacao pcv = new PainelCadastrarVacinacao(null);
                        tg.add(pcv, BorderLayout.CENTER);
                        pcv.setVisible(true);
                        tg.setVisible(true);
                        tg.repaint();
                      }else if(cmbOperacao == operacoes[2]){
                   	    TelaGeralVacinacao tg = new TelaGeralVacinacao(null);
                   	    PainelAtualizarVacinacao pav = new PainelAtualizarVacinacao(null);
                   	    tg.add(pav, BorderLayout.CENTER);
                   	    pav.setVisible(true);
                   	    tg.setVisible(true);
                   	    tg.repaint();
                      }else if(cmbOperacao == operacoes[3]){
                   	    TelaGeralVacinacao tg = new TelaGeralVacinacao(null);
                   	    PainelProcurarVacinacao ppv = new PainelProcurarVacinacao(null);
                   	    tg.add(ppv, BorderLayout.CENTER);
                   	    ppv.setVisible(true);
                   	    tg.setVisible(true);
                   	    tg.repaint();
                      }else if(cmbOperacao == operacoes[4]){
                   	    TelaGeralVacinacao tg = new TelaGeralVacinacao(null);
                   	    PainelRemoverVacinacao prv = new PainelRemoverVacinacao(null);
                   	    tg.add(prv, BorderLayout.CENTER);
                   	    prv.setVisible(true);
                   	    tg.setVisible(true);
                   	    tg.repaint();
                      }
               
           }
       });
        add(listaOpcoes);
	}
}
