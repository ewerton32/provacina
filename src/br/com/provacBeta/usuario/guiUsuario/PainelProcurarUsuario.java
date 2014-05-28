package br.com.provacBeta.usuario.guiUsuario;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.provacBeta.fachada.Fachada;
import br.com.provacBeta.usuario.Usuario;
import br.com.provacBeta.usuario.UsuarioInexistenteException;

public class PainelProcurarUsuario extends JPanel {
	private JLabel nomePainel = new JLabel("Procurar usuário");	
	private JLabel informe = new JLabel("Digite o numero do usuário");	
	private  JTextField campoNumUsuario = new JTextField(20);
	private JPanel painelProcurar;
    
    
	private JPanel painelId = new JPanel();
	private JPanel painelinforme = new JPanel();
	private JPanel painelNumUsuario = new JPanel();    
	private Color corFormulario = Color.decode("#6F9890");
	private Color corDiferente = Color.decode("#336666");
	private Color corFonte = Color.decode("#FFFFFF");
	private Color corDestaque = Color.decode("#5C8B7C");
	
	
	private JButton procurar = new JButton("Procurar usuario");
	

	

	
	private class TratadorProcurar implements ActionListener{

		public void actionPerformed(ActionEvent evento) {
			String numero = campoNumUsuario.getText();
			
			if(evento.getSource() == procurar){				
				try {
					Usuario usu = Fachada.obterInstancia().procurarUsuario(numero);
					JOptionPane.showMessageDialog(null, usu);
				} catch (UsuarioInexistenteException e) {					
					e.printStackTrace();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public PainelProcurarUsuario(JPanel painelCentro){
      
      setBackground(corDiferente );
      setLayout(new GridLayout(6,1));
      
      nomePainel.setForeground(corFonte);
      informe.setForeground(corFonte);
      painelinforme.add(informe);
      painelinforme.setBackground(corDiferente);
      painelId.add(nomePainel);
      painelId.setBackground(corDiferente);
      painelProcurar= new JPanel();
      painelProcurar.add(procurar);
      painelProcurar.setBackground(corDiferente);
      JLabel espaco = new JLabel("   ");
      
      TratadorProcurar handlerProcura = new TratadorProcurar();
      procurar.addActionListener(handlerProcura);
      
      
      add(painelId);
      add(espaco);
      add(painelinforme);     
      painelNumUsuario.add(campoNumUsuario);
      painelNumUsuario.setBackground(corDiferente);;
      add(painelNumUsuario);
      add(painelProcurar);
      }

}
