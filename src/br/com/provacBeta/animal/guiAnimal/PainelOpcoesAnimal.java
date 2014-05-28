package br.com.provacBeta.animal.guiAnimal;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import javax.swing.ImageIcon;
import javax.swing.JComboBox;
import javax.swing.JComponent;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.provacBeta.usuario.Usuario;
import br.com.provacBeta.vacinacao.guiVacinacao.PainelAtualizarVacinacao;

public class PainelOpcoesAnimal extends JPanel {	
	
	private JFrame telaOriginal;
	
	private JComboBox listaOpcoes;
	
	private TelaGeralAnimais telaGeralAnimais;
	
	private PainelCadastrarAnimal cadastroAniaml;
		
	private String operacoes[] =  {
			                      "Escolha uma operação",
			                      "Cadastrar",
			                      "Alterar",
			                      "Procurar",
			                      "Remover"
			                      };	
	
	private Container paineis[] = {			
			                    new PainelAtualizarAnimal(this),
			                    new PainelCadastrarAnimal(this),
			                    new PainelProcurarAnimal(this),
			                    new PainelAtualizarVacinacao(this)
		                   	   };
	
	
	private JTextField aviso = new JTextField("Clique em um dos botões acima");
	private Color corFormulario = Color.decode("#6F9890");
	private Color corDiferente = Color.decode("#336666");
	private Color corFonte = Color.decode("#FFFFFF");
    private Color corDestaque = Color.decode("#5C8B7C");
	private Color corAtencao = Color.ORANGE;	
   
	
    public PainelOpcoesAnimal(JFrame tela, Usuario u){
    	telaOriginal = tela;    	
		aviso.setBackground(corAtencao);
		setBackground(corDiferente);
		
		setLayout(new FlowLayout(FlowLayout.RIGHT));
		listaOpcoes = new JComboBox(operacoes);        
        listaOpcoes.setBackground(corFormulario);
        listaOpcoes.setForeground(corFonte);        
        listaOpcoes.addActionListener(
        		//Classe interna anonima
           		 new ActionListener(){   
           			 //metodo ActionPerformed da classe tratadora anônima
                       public void actionPerformed(ActionEvent e) {
                       JComboBox JCBOperacoes = (JComboBox)e.getSource();
                       String cmbOperacao = (String)JCBOperacoes.getSelectedItem();                       
                       
                       if(cmbOperacao == operacoes[1]){//   
                    	       
                    	   	   PainelCadastrarAnimal pca = new PainelCadastrarAnimal(null);
                    	   	   TelaGeralAnimais tg = new TelaGeralAnimais(null,pca);
                    	   	   tg.add(pca, BorderLayout.CENTER);
                    	       pca.setVisible(true);
                    	       tg.setVisible(true);                    	  
                    	       tg.repaint();
                       }else if(cmbOperacao == operacoes[2]){                    	       
                    	       
                    	       PainelAtualizarAnimal paa = new PainelAtualizarAnimal(null);
                    	       TelaGeralAnimais tg = new TelaGeralAnimais(null,paa);
                    	       tg.add(paa, BorderLayout.CENTER);
                	           paa.setVisible(true);
                	           tg.setVisible(true);
                	           tg.repaint(); 
                       }else if(cmbOperacao == operacoes[3]){
                    	       
                    	       PainelProcurarAnimal ppa = new PainelProcurarAnimal(null);
                    	       TelaGeralAnimais tg = new TelaGeralAnimais(null, ppa);
                    	       tg.add(ppa, BorderLayout.CENTER);
                	           ppa.setVisible(true);
                	           tg.setVisible(true);
                	           tg.repaint();
                       }else if(cmbOperacao == operacoes[4]){
                    	       
                    	       PainelRemoverAnimal pra = new PainelRemoverAnimal(null);
                    	       TelaGeralAnimais tg = new TelaGeralAnimais(null, pra);
                    	       tg.add(pra, BorderLayout.CENTER);
                	           pra.setVisible(true);
                	           tg.setVisible(true);
                	           tg.repaint();
                       }
                
            }
        });
        add(listaOpcoes);
    }
}
