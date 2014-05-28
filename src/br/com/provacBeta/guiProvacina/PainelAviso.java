package br.com.provacBeta.guiProvacina;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class PainelAviso extends JPanel {
	
	
    private JTextField aviso = new JTextField("Clique em um dos botões acima");
    //Criação de Cores padronizadas
    private Color corFormulario = Color.decode("#6F9890");
	private Color corDiferente = Color.decode("#336666");
	private Color corFonte = Color.decode("#FFFFFF");
	private Color corDestaque = Color.decode("#5C8B7C");
	private Color corAtencao = Color.ORANGE;
    public PainelAviso(){
		add(aviso);
		aviso.setBackground(corAtencao);
		setBackground(corDiferente);
		setLayout(new FlowLayout(FlowLayout.RIGHT));
	}

}
