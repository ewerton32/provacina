package br.com.provacBeta.propriedade.guiPropriedade;

import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelCadastrarPropriedade extends JPanel{
	
	private JButton btEndereco = new JButton("Cadastre o endereço");
	
	private JLabel nomePainel = new JLabel("Cadastro de propriedade");
	private JLabel nomePropriedade = new JLabel("Digite o nome de sua propriedade:");  
	private JLabel numEscrituraPropriedade = new JLabel("Digite o numero da escritura da propriedade:"); 
	private JLabel numCriadorPropriedade = new JLabel("Digite identificador do proprietario:"); 
	private JLabel areaPropriedade = new JLabel("Digite a área da propriedade:"); 
	
	
	private JTextField campoNomePropriedade = new JTextField(20);	
	private JTextField campoNumEscrituraPropriedade = new JTextField(20);
	private JTextField campoNumCriador = new JTextField(20);
	private JTextField campoAreaPropriedade = new JTextField(20);
	
	
	private JPanel painelNomeOperacao = new JPanel(new FlowLayout(FlowLayout.LEFT));
	private JPanel painelNomePropriedade = new JPanel();
	private JPanel painelCampoNomePropriedade = new JPanel();
	private JPanel painelNumEscrituraPropriedade = new JPanel();
	private JPanel painelCampoNumEscrituraPropriedade = new JPanel();
	private JPanel painelNumCriador = new JPanel();
	private JPanel painelCampoNumCriador = new JPanel();
	private JPanel painelAreaPropriedade = new JPanel();
	private JPanel painelCampoAreaPropriedade = new JPanel();
	private JPanel painelEndereco = new JPanel(new FlowLayout(FlowLayout.RIGHT));
	

	
	private Color corFormulario = Color.decode("#6F9890");
	private Color corDiferente = Color.decode("#336666");
	private Color corFonte = Color.decode("#FFFFFF");
    private Color corDestaque = Color.decode("#5C8B7C");
	private Color corAtencao = Color.ORANGE;
	
	
	public PainelCadastrarPropriedade (JPanel painelCentro){
		setLayout(new GridLayout(10,1));   
		
		
		nomePainel.setForeground(corFonte);
		nomePropriedade.setForeground(corFonte);
		numEscrituraPropriedade.setForeground(corFonte);
		numCriadorPropriedade.setForeground(corFonte);
		areaPropriedade.setForeground(corFonte);
		
		painelNomeOperacao.add(nomePainel);
		painelNomeOperacao.setBackground(corDestaque);
		
		painelNomePropriedade.add(nomePropriedade);
		painelNomePropriedade.setBackground(corDiferente);
		painelCampoNomePropriedade.add(campoNomePropriedade);
		painelCampoNomePropriedade.setBackground(corFormulario);
		
		painelNumEscrituraPropriedade.add(numEscrituraPropriedade);
		painelNumEscrituraPropriedade.setBackground(corDiferente);
		painelCampoNumEscrituraPropriedade.add(campoNumEscrituraPropriedade);
		painelCampoNumEscrituraPropriedade.setBackground(corFormulario);
		
		painelAreaPropriedade.add(areaPropriedade);
		painelAreaPropriedade.setBackground(corDiferente);
		painelCampoAreaPropriedade.add(campoAreaPropriedade);
		painelCampoAreaPropriedade.setBackground(corFormulario);
		
		painelNumCriador.add(numCriadorPropriedade);
		painelNumCriador.setBackground(corDiferente);
		painelCampoNumCriador.add(campoNumCriador);
		painelCampoNumCriador.setBackground(corFormulario);
		
		painelEndereco.add(btEndereco);
		painelEndereco.setBackground(corDiferente);
		
		add(painelNomeOperacao);
		add(painelNomePropriedade);
		add(painelCampoNomePropriedade);
		add(painelNumEscrituraPropriedade);
		add(painelCampoNumEscrituraPropriedade);
		add(painelAreaPropriedade);
		add(painelCampoAreaPropriedade);
		add(painelNumCriador);
		add(painelCampoNumCriador);
		add(painelEndereco);
		
		
		setBackground(corDestaque );
	   
	}

}
