package br.com.provacBeta.usuario.guiUsuario;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.provacBeta.guiProvacina.TelaFuncionario;
import br.com.provacBeta.usuario.Usuario;

public class PainelOpcoesUsuario extends JPanel {
	private String operacoes[] = {"Escolha uma operação","Cadastrar","Alterar","Procurar","Remover"};
	private JComboBox listaOpcoes;
	private static Usuario usuario;
	
	private JTextField aviso = new JTextField("Clique em um dos botões acima");
	private Color corFormulario = Color.decode("#6F9890");
	private Color corDiferente = Color.decode("#336666");
	private Color corFonte = Color.decode("#FFFFFF");
    private Color corDestaque = Color.decode("#5C8B7C");
	private Color corAtencao = Color.ORANGE;
	
	
	
    public PainelOpcoesUsuario(JPanel painelCentral){
		
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
                   	   
                       PainelCadastrarUsuario pcu = new PainelCadastrarUsuario(null);
                      
                       TelaGeralUsuario tg = new TelaGeralUsuario(null, pcu);
//                       tg.add(pcu, BorderLayout.CENTER);
//                       pcu.setVisible(true);
                       tg.setVisible(true);
                       tg.repaint();
                      }else if(cmbOperacao == operacoes[2]){
                       
                       PainelAtualizarUsuario pa = new PainelAtualizarUsuario(null);
                       TelaGeralUsuario tg = new TelaGeralUsuario(null,pa);
//                       tg.add(pa, BorderLayout.CENTER);
//                       pa.setVisible(true);
                       tg.setVisible(true);                       
                       tg.repaint();
                      }else if(cmbOperacao == operacoes[3]){
                   	  
                       PainelProcurarUsuario ppu = new PainelProcurarUsuario(null);
                       TelaGeralUsuario tg = new TelaGeralUsuario(null,ppu);
//                       tg.add(ppu, BorderLayout.CENTER);
//                       ppu.setVisible(true);
                       tg.setVisible(true);                       
                       tg.repaint();
                      }else if(cmbOperacao == operacoes[4]){
                   	   
                   	   PainelRemoverUsuario pru = new PainelRemoverUsuario(null);
                   	   TelaGeralUsuario tg = new TelaGeralUsuario(null,pru);
//                   	   tg.add(pru, BorderLayout.CENTER);
//                   	   pru.setVisible(true);
                   	   tg.setVisible(true);                   	   
                   	   tg.repaint();
                      }
               
           }
       });
//        add(aviso);
        add(listaOpcoes);
	}
}
