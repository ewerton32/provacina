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

public class PainelRemoverUsuario extends JPanel {
	
	private JLabel nomePainel = new JLabel("Remover usuário");	
	private JLabel informe = new JLabel("Digite o numero do usuário");	
    private JTextField campoNumUsuario = new JTextField(20);
    private JPanel painelRemover = new JPanel();
    private JButton remover = new JButton("Remover usuario");
    
    JPanel painelId = new JPanel();
    JPanel painelinforme = new JPanel();
    JPanel painelNumUsuario = new JPanel();    
    Color corFormulario = Color.decode("#6F9890");
	Color corDiferente = Color.decode("#336666");
	Color corFonte = Color.decode("#FFFFFF");
	Color corDestaque = Color.decode("#5C8B7C");
	
	
	
	private class TratadorProcurar implements ActionListener{

		public void actionPerformed(ActionEvent evento) {
			String numero = campoNumUsuario.getText();
			
			if(evento.getSource() == remover){				
				try {
					Fachada.obterInstancia().removerUsuario(numero);
					JOptionPane.showMessageDialog(null, "Usuario removido com sucesso");
				} catch (UsuarioInexistenteException e) {					
					e.printStackTrace();
				} catch (SQLException e) {					
					e.printStackTrace();
				}
			}
		}
		
	}
	
	
	public PainelRemoverUsuario(JPanel painelCentro){
      
      setBackground(corDiferente );
      setLayout(new GridLayout(6,1));
      
      nomePainel.setForeground(corFonte);
      informe.setForeground(corFonte);
      painelinforme.add(informe);
      painelinforme.setBackground(corDiferente);
      painelId.add(nomePainel);
      painelId.setBackground(corDiferente);
      painelRemover.add(remover);
      painelRemover.setBackground(corDiferente);
      JLabel espaco = new JLabel("   ");
      
      TratadorProcurar handlerRemover = new TratadorProcurar();
      remover.addActionListener(handlerRemover);
      add(painelId);
      add(espaco);
      add(painelinforme);
      painelNumUsuario.add(campoNumUsuario);
      painelNumUsuario.setBackground(corDiferente);;
      add(painelNumUsuario);
      add(painelRemover);
      }

}
