package br.com.provacBeta.usuario.guiUsuario;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import br.com.provacBeta.fachada.Fachada;
import br.com.provacBeta.usuario.Usuario;
import br.com.provacBeta.usuario.UsuarioExistenteException;

public class PainelCadastrarUsuario extends JPanel {
	
	private Fachada fachada = Fachada.obterInstancia();
		
	private static Usuario usu;
	//Label nome do painel   
	
	private JLabel nomePainel = new JLabel("     Cadastro de Usuários");
    
	//definição de labels
	private JLabel nomeUsuario = new JLabel("Nome do usuário:");  
	private JLabel IdUsuario = new JLabel("Id do usuário:"); 
	private JLabel tipoUsuario = new JLabel("Tipo do usuário:"); 
	private JLabel CpfUsuario = new JLabel("Cpf do usuário:"); 
	private JLabel RgUsuario = new JLabel("Rg do usuário:"); 
	private JLabel loginUsuario = new JLabel("Login do usuário:"); 
	private JLabel senhaUsuario = new JLabel("Senha do usuário:"); 
	private JLabel dataNascUsuario = new JLabel("Data de nascimento:"); 
	
	//
	private String [] tipos = {"Tipifique o usuário","Funcionário","Criador"};
	private JComboBox listaTipoUsuario = new JComboBox(tipos);
	
	
	//definição de campos
	private JTextField campoNomeUsuario = new JTextField(15);	
	private JTextField campoIdUsuario = new JTextField(15);
	private JTextField campoCpfUsuario = new JTextField(15);
	private JTextField campoRgUsuario = new JTextField(15);
	private JTextField campologinUsuario = new JTextField(15);
	private JTextField campoSenhaUsuario = new JTextField(15);
	private JTextField campoDataNascUsuario = new JTextField(15);
	
	//Definição de sub-paineis
	
	private JPanel painelNomePainel = new JPanel();
	private JPanel painelEspaco = new JPanel();
	private JPanel painelNome = new JPanel();
	private JPanel painelCampoNome = new JPanel();
	private JPanel painelId = new JPanel();
	private JPanel painelCampoId = new JPanel();
	private JPanel painelDataNasc = new JPanel();
	private JPanel painelCampoDataNasc = new JPanel();
	private JPanel painelCpf = new JPanel();
	private JPanel painelCampoCpf = new JPanel();
	private JPanel painelRg = new JPanel();
	private JPanel painelCampoRg = new JPanel();
	private JPanel painellogin = new JPanel();
	private JPanel painelCampoLogin = new JPanel();
	private JPanel painelSenha = new JPanel();
	private JPanel painelCampoSenha = new JPanel();
	private JPanel painelTipo = new JPanel();
	private JPanel painelCampoTipo = new JPanel();
	private JPanel painelBtContato = new JPanel();
	private JPanel painelBtCadastrar = new JPanel();
	
	
	//botão cadastrar endereço
	private JButton botaoContato = new JButton("Cadastre seus contatos");
	
//	Botões ações
    private JButton sair;
    private JButton cadastrar;

	//Cores padrão do sistema
	private Color corFormulario = Color.decode("#6F9890");
	private Color corDiferente = Color.decode("#336666");
	private Color corFonte = Color.decode("#FFFFFF");
    private Color corDestaque = Color.decode("#5C8B7C");
    
    
    public void limpaCampos(){
    	campoNomeUsuario.setText("");
    	campoIdUsuario.setText("");
    	campoCpfUsuario.setText("");
    	campoRgUsuario.setText("");
    	campologinUsuario.setText("");
    	campoSenhaUsuario.setText("");
    	campoDataNascUsuario.setText("");
    }
    
    public boolean isNumeric(String valorNumerico) {
		boolean numerico = false;
		if (valorNumerico != null &&
			valorNumerico.trim().length() > 0) {
			valorNumerico = valorNumerico.trim();
			for (int i = 0; i < valorNumerico.length(); i++) {
				char caracter = valorNumerico.charAt(i);
				numerico = Character.isDigit(caracter);
				if (!numerico) {
					break;
				}
			}
		}
		return numerico;
	}

    	
    private class TratadorCadastrar implements ActionListener{
        private JPanel essePainel;
    	
    	public TratadorCadastrar(Usuario usuario ){
        	usu = usuario;
        }
        public void actionPerformed(ActionEvent evento) {
  	         
        	String nome, id, data, cpf, rg, tipo, login, senha  ;
			   
    		nome = campoNomeUsuario.getText();
    		id = campoIdUsuario.getText();
    		data = campoDataNascUsuario.getText();
    		cpf = campoCpfUsuario.getText();
    		rg = campoRgUsuario.getText();
    		login = campologinUsuario.getText();
    		senha = campoSenhaUsuario.getText();    		
    		tipo = (String)listaTipoUsuario.getSelectedItem();		        				
    		
    		Usuario usu = new Usuario(nome,cpf,cpf,rg,tipo,login,senha,data);   
    	    
        	
  			 if(evento.getSource() == cadastrar){
  				 
  		       JOptionPane.showMessageDialog(null, usu);
  		       
  		       try {
				Fachada.obterInstancia().inserirUsuario(usu);
			} catch (UsuarioExistenteException e) {					
				e.printStackTrace();
			} catch (SQLException e) {					
				e.printStackTrace();
			}
  	        }        			
  		 }
    	
    }
    
	public PainelCadastrarUsuario (JPanel painelCentro){
		setLayout(new GridLayout(9,2));
				
	
    
//		usuario para ser adicionado no sistema		 		
		
        cadastrar = new JButton("Cadastrar usuário");       
        TratadorCadastrar handlerCadastro = new TratadorCadastrar(usu);
        cadastrar.addActionListener(handlerCadastro);  
		
		nomeUsuario.setForeground(corFonte);
		IdUsuario.setForeground(corFonte);
		dataNascUsuario.setForeground(corFonte);
		CpfUsuario.setForeground(corFonte);
		RgUsuario.setForeground(corFonte);
		loginUsuario.setForeground(corFonte);
		senhaUsuario.setForeground(corFonte);
		tipoUsuario.setForeground(corFonte);		
				
		painelNomePainel.add(nomePainel);
		painelNomePainel.setBackground(corDestaque);
		
		JLabel espaco = new JLabel("                                       ");
		painelEspaco.setBackground(corDestaque);
		painelEspaco.add(espaco);
		painelBtContato.add(botaoContato);		
		painelBtContato.setBackground(corDestaque);
		
		painelNome.add(nomeUsuario);
		painelNome.setBackground(corDiferente);
		painelCampoNome.add(campoNomeUsuario);
		painelCampoNome.setBackground(corDiferente);
		
		painelId.add(IdUsuario);
		painelId.setBackground(corFormulario);
		painelCampoId.add(campoIdUsuario);
		painelCampoId.setBackground(corFormulario);
		
		painelTipo.add(tipoUsuario);
		painelTipo.setBackground(corFormulario);
		painelCampoTipo.add(listaTipoUsuario);		
		painelCampoTipo.setBackground(corFormulario);
				
		painelDataNasc.add(dataNascUsuario);
		painelDataNasc.setBackground(corFormulario);
		painelCampoDataNasc.add(campoDataNascUsuario);
		painelCampoDataNasc.setBackground(corFormulario);
		
		painelCpf.add(CpfUsuario);
		painelCpf.setBackground(corFormulario);
		painelCampoCpf.add(campoCpfUsuario);
		painelCampoCpf.setBackground(corFormulario);
		
		painelRg.add(RgUsuario);
		painelRg.setBackground(corDiferente);
		painelCampoRg.add(campoRgUsuario);
		painelCampoRg.setBackground(corDiferente);		
		
		painellogin.add(loginUsuario);
		painellogin.setBackground(corDiferente);
		painelCampoLogin.add(campologinUsuario);
		painelCampoLogin.setBackground(corDiferente);
		
		painelSenha.add(senhaUsuario);
		painelSenha.setBackground(corFormulario);
		painelCampoSenha.add(campoSenhaUsuario);
		painelCampoSenha.setBackground(corFormulario);		
		
		painelBtCadastrar.add(cadastrar);
		painelBtCadastrar.setBackground(corDestaque);
		
		nomePainel.setForeground(corFonte);
		

		//adissionando os campos à tela 
		add(painelNomePainel);
		add(painelEspaco);		
		add(painelTipo);
		add(painelCampoTipo);
		add(painelNome);
		add(painelCampoNome);
		add(painelCpf);
		add(painelCampoCpf);
		add(painelRg);
		add(painelCampoRg);
		add(painelDataNasc);
		add(painelCampoDataNasc);
		add(painellogin);
		add(painelCampoLogin);
		add(painelSenha);
		add(painelCampoSenha);
		add(painelBtContato);		
		add(painelBtCadastrar);
		
		setBackground(corDestaque);	
        setVisible(true);  
	}
}
