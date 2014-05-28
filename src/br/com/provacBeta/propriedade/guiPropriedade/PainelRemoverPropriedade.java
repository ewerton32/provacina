package br.com.provacBeta.propriedade.guiPropriedade;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelRemoverPropriedade extends JPanel{
	JLabel nomePainel = new JLabel("RemoverPropriedade");	
	JLabel informe = new JLabel("Digite o numero da propriedade");	
    JTextField campoNumUsuario = new JTextField(20);
    
    
    JPanel painelId = new JPanel();
    JPanel painelinforme = new JPanel();
    JPanel painelNumUsuario = new JPanel();    
    Color corFormulario = Color.decode("#6F9890");
	Color corDiferente = Color.decode("#336666");
	Color corFonte = Color.decode("#FFFFFF");
	Color corDestaque = Color.decode("#5C8B7C");
	
	
	public PainelRemoverPropriedade(JPanel painelCentro){
      
      setBackground(corDiferente );
      setLayout(new GridLayout(6,1));
      
      nomePainel.setForeground(corFonte);
      informe.setForeground(corFonte);
      painelinforme.add(informe);
      painelinforme.setBackground(corDiferente);
      painelId.add(nomePainel);
      painelId.setBackground(corDiferente);
      JLabel espaco = new JLabel("   ");
      
      add(painelId);
      add(espaco);
      add(painelinforme);
      painelNumUsuario.add(campoNumUsuario);
      painelNumUsuario.setBackground(corDiferente);;
      add(painelNumUsuario);
      }
}
