package br.com.provacBeta.propriedade.guiPropriedade;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelOpcoesPropriedade extends JPanel{
	private String operacoes[] = {"Escolha uma operação","Cadastrar","Alterar","Procurar","Remover"};
	private JComboBox listaOpcoes;
	
	private JTextField aviso = new JTextField("Clique em um dos botões acima");
	private Color corFormulario = Color.decode("#6F9890");
	private Color corDiferente = Color.decode("#336666");
	private Color corFonte = Color.decode("#FFFFFF");
    private Color corDestaque = Color.decode("#5C8B7C");
	private Color corAtencao = Color.ORANGE;
	
	
    public PainelOpcoesPropriedade(JPanel painelCentral){
		
		aviso.setBackground(corAtencao);
		setBackground(corDiferente);
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		listaOpcoes = new JComboBox(operacoes);        
        listaOpcoes.setBackground(corFormulario);
        listaOpcoes.setForeground(corFonte);
        listaOpcoes.addActionListener(//Classe interna anonima
           		 new ActionListener(){   
           			 //metodo ActionPerformed da classe tratadora anônima
                       public void actionPerformed(ActionEvent e) {
                       JComboBox JCBOperacoes = (JComboBox)e.getSource();
                       String cmbOperacao = (String)JCBOperacoes.getSelectedItem();
                         
                       if(cmbOperacao == operacoes[1]){// 
                    	   TelaGeralPropriedade tg = new TelaGeralPropriedade(null);
                	   	   PainelCadastrarPropriedade pcp = new PainelCadastrarPropriedade(null);
                	       tg.add(pcp, BorderLayout.CENTER);
                	       pcp.setVisible(true);
                	       tg.setVisible(true);
                	       tg.repaint();
                       }else if(cmbOperacao == operacoes[2]){                     	
                    	   TelaGeralPropriedade tg = new TelaGeralPropriedade(null);
                	   	   PainelAtualizarPropriedade pap = new PainelAtualizarPropriedade(null);
                	       tg.add(pap, BorderLayout.CENTER);
                	       pap.setVisible(true);
                	       tg.setVisible(true);
                	       tg.repaint();
                       }else if(cmbOperacao == operacoes[3]){                    	
                    	   TelaGeralPropriedade tg = new TelaGeralPropriedade(null);
                	   	   PainelProcurarPropriedade ppp = new PainelProcurarPropriedade(null);
                	       tg.add(ppp, BorderLayout.CENTER);
                	       ppp.setVisible(true);
                	       tg.setVisible(true);
                	       tg.repaint();
                       }else if(cmbOperacao == operacoes[4]){                    	
                    	   TelaGeralPropriedade tg = new TelaGeralPropriedade(null);
                	   	   PainelRemoverPropriedade prp = new PainelRemoverPropriedade(null);
                	       tg.add(prp, BorderLayout.CENTER);
                	       prp.setVisible(true);
                	       tg.setVisible(true);
                	       tg.repaint();
                       }
                
            }
        });
//        add(aviso);
        add(listaOpcoes);
	}

}
