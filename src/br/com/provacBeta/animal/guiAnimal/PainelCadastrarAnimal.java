package br.com.provacBeta.animal.guiAnimal;

import java.awt.Color;
import java.awt.GridLayout;

import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.provacBeta.animal.Animal;

public class PainelCadastrarAnimal extends JPanel {
	
	
    private static Animal animal;
    
//    private static Animal setAnimal(Animal esseAnimal){
//    	animal = esseAnimal;
//    }
    public static Animal getAnimal(){
    	return animal;
    }	
	private JLabel nomePainel = new JLabel("Cadastro de Animais");
	private JLabel nomeAnimal = new JLabel("Digite o nome do animal:");  
	private JLabel numeroAnimal = new JLabel("Digite o numero do animal:"); 
	private JLabel datanascAnimal = new JLabel("Digite a data de nascimento do animal:"); 
	private JLabel finalidadeAnimal = new JLabel("Digite a finalidade do animal:"); 
	private JLabel pesoAnimal = new JLabel("Digite o peso do animal:"); 
	private JLabel NumPropriedade = new JLabel("Digite o número da propriedade:"); 
			
	private JTextField campoNomeAnimal = new JTextField(20);	
	private JTextField campoNumeroAnimal = new JTextField(20);
	private JTextField campoDatanascAnimal = new JTextField(20);
	private JTextField campoFinalidadeAnimal = new JTextField(20);
	private JTextField campoPesoAnimal = new JTextField(20);
	private JTextField campoNumPropriedade = new JTextField(20);
		
	private JPanel painelNome = new JPanel();
	private JPanel painelCampoNome = new JPanel();
	private JPanel painelNumero = new JPanel();
	private JPanel painelCampoNumero = new JPanel();
	private JPanel painelDataNasc= new JPanel();
	private JPanel painelCampoDataNasc = new JPanel();
	private JPanel painelFinalidade = new JPanel();
	private JPanel painelCampoFinalidade = new JPanel();
	private JPanel painelPeso = new JPanel();
	private JPanel painelCampoPeso = new JPanel();
	private JPanel painelNumProp = new JPanel();
	private JPanel painelCampoNumProp = new JPanel();
	private JPanel painelVazio = new JPanel();
	

	
	private Color corFormulario = Color.decode("#6F9890");
	private Color corDiferente = Color.decode("#336666");
	private Color corFonte = Color.decode("#FFFFFF");
    private Color corDestaque = Color.decode("#5C8B7C");
	private Color corAtencao = Color.ORANGE;
	
	
	
	
	
	public PainelCadastrarAnimal (JPanel painelCentro){
		setLayout(new GridLayout(7,2));   
		
		nomeAnimal.setForeground(corFonte);
		numeroAnimal.setForeground(corFonte);
		datanascAnimal.setForeground(corFonte);
		finalidadeAnimal.setForeground(corFonte);
		pesoAnimal.setForeground(corFonte);
				
		painelNome.add(nomeAnimal);
		painelNome.setBackground(corFormulario);
		painelCampoNome.add(campoNomeAnimal);
		painelCampoNome.setBackground(corFormulario);
		
		painelNumero.add(numeroAnimal);
		painelNumero.setBackground(corDiferente);
		painelCampoNumero.add(campoNumeroAnimal);
		painelCampoNumero.setBackground(corDiferente);
		
		painelDataNasc.add(datanascAnimal);
		painelDataNasc.setBackground(corFormulario);
		painelCampoDataNasc.add(campoDatanascAnimal);
		painelCampoDataNasc.setBackground(corFormulario);
		
		painelFinalidade.add(finalidadeAnimal);
		painelFinalidade.setBackground(corDiferente);
		painelCampoFinalidade.add(campoFinalidadeAnimal);
		painelCampoFinalidade.setBackground(corDiferente);
		
		painelPeso.add(pesoAnimal);
		painelPeso.setBackground(corFormulario);
		painelCampoPeso.add(campoPesoAnimal);
		painelCampoPeso.setBackground(corFormulario);
		nomePainel.setForeground(corFonte);

		painelNumProp.add(NumPropriedade);
		painelNumProp.setBackground(corDiferente);
		painelCampoNumProp.add(campoNumPropriedade);
		painelCampoNumProp.setBackground(corDiferente);
		NumPropriedade.setForeground(corFonte);
		
		painelVazio.setBackground(corDestaque);
		
	
		
		add(nomePainel);
		add(painelVazio);
		add(painelNome);
		add(painelCampoNome);
		add(painelNumero);
		add(painelCampoNumero);
		add(painelDataNasc);
		add(painelCampoDataNasc);
		add(painelFinalidade);
		add(painelCampoFinalidade);
		add(painelPeso);
		add(painelCampoPeso);
		add(painelNumProp);
		add(painelCampoNumProp);		
		
		setBackground(corDestaque);
	   
	}
	
}
