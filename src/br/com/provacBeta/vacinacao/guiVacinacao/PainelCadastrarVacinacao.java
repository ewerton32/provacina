package br.com.provacBeta.vacinacao.guiVacinacao;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelCadastrarVacinacao extends JPanel {

//	Label nome do painel
	private JLabel nomePainel = new JLabel("   Cadastro de vacina�oes");
    
	//defini��o de labels
	private JLabel numAnimal = new JLabel("Identifica��o do animal:");  
	private JLabel IdVacinacao = new JLabel("Identifica��o da vacina��o:"); 
	private JLabel dataVac = new JLabel("Data da vacina��:"); 
	private JLabel idUsuario = new JLabel("Identificador do usu�rio:"); 
	private JLabel referVacina = new JLabel("Refer�ncia da vacina:");
	
	
	// 
	private String [] tipoVacina = {"Tipifique a vacina��o","Doen�a1","Doen�a2","Doen�a3","Doen�a4","Doen�a5",};
	private JComboBox listaTipoVacinacao = new JComboBox(tipoVacina);
	
	
	//defini��o de campos
	private JTextField campoNumAnimal = new JTextField(20);	
	private JTextField campoIdVac = new JTextField(20);
	private JTextField campoDataVac = new JTextField(20);
	private JTextField campoIdUsuario = new JTextField(20);
	private JTextField campoRefVacina = new JTextField(20);
	
	
	//Defini��o de sub-paineis
	private JPanel painelNumAnimal = new JPanel();
	private JPanel painelCampoNumAnimal = new JPanel();
	private JPanel painelIdVac = new JPanel();
	private JPanel painelCampoIdVac = new JPanel();
	private JPanel painelDataVac = new JPanel();
	private JPanel painelCampoDataVac = new JPanel();
	private JPanel painelIdUsuario = new JPanel();
	private JPanel painelCampoIdUsuario = new JPanel();
	private JPanel painelRefVacina = new JPanel();
	private JPanel painelCampoRefVacina = new JPanel();
	
	private JPanel painelBtVacina = new JPanel();
	
	private JPanel painelTipoVacina = new JPanel();
		
	//bot�o cadastrar endere�o
	private JButton botaoVacina = new JButton("Cadastre a vacina usada");
	

	//Cores padr�o do sistema
	private Color corFormulario = Color.decode("#6F9890");
	private Color corDiferente = Color.decode("#336666");
	private Color corFonte = Color.decode("#FFFFFF");
    private Color corDestaque = Color.decode("#5C8B7C");
	private Color corAtencao = Color.ORANGE;
	
	
	public PainelCadastrarVacinacao (JPanel painelCentro){
		setLayout(new GridLayout(10,2));		
		
//		numAnimal numAnimal dataVac idUsuario referVacina 
		
		numAnimal.setForeground(corFonte);
		dataVac.setForeground(corFonte);
		idUsuario.setForeground(corFonte);
		IdVacinacao.setForeground(corFonte);
		referVacina.setForeground(corFonte);
		
		painelBtVacina.add(botaoVacina);		
		painelBtVacina.setBackground(corFormulario);
		
		painelNumAnimal.add(numAnimal);
		painelNumAnimal.setBackground(corFormulario);
		painelCampoNumAnimal.add(campoNumAnimal);
		painelCampoNumAnimal.setBackground(corFormulario);
		
		painelIdUsuario.add(idUsuario);
		painelIdUsuario.setBackground(corDiferente);
		painelCampoIdUsuario.add(campoIdUsuario);
		painelCampoIdUsuario.setBackground(corDiferente);
		
		painelTipoVacina.add(listaTipoVacinacao);
		painelTipoVacina.setBackground(corFormulario);
		
		painelDataVac.add(dataVac);
		painelDataVac.setBackground(corFormulario);
		painelCampoDataVac.add(campoDataVac);
		painelCampoDataVac.setBackground(corFormulario);
		
		painelIdVac.add(IdVacinacao);
		painelIdVac.setBackground(corFormulario);
		painelCampoIdVac.add(campoIdVac);
		painelCampoIdVac.setBackground(corFormulario);
		
		painelRefVacina.add(referVacina);
		painelRefVacina.setBackground(corDiferente);
		painelCampoRefVacina.add(campoRefVacina);
		painelCampoRefVacina.setBackground(corDiferente);
		
		
		
		nomePainel.setForeground(corFonte);
		
		JLabel espaco = new JLabel("         ");
		
		add(nomePainel);
		add(espaco);		
		add(painelNumAnimal);
		add(painelCampoNumAnimal);
		add(painelIdUsuario);
		add(painelCampoIdUsuario);		
		add(painelDataVac);
		add(painelCampoDataVac);		
		add(painelRefVacina);
		add(painelCampoRefVacina);		
		add(painelTipoVacina);
		add(painelBtVacina);
		
		setBackground(corDestaque );
	   
	}
}
