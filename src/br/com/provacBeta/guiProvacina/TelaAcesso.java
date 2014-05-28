package br.com.provacBeta.guiProvacina;

// Demonstrando a classe JLabel.
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.SQLException;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import javax.swing.SwingConstants;

import br.com.provacBeta.fachada.Fachada;
import br.com.provacBeta.usuario.Usuario;
import br.com.provacBeta.usuario.UsuarioExistenteException;
import br.com.provacBeta.usuario.UsuarioInexistenteException;
import br.com.provacBeta.util.Contato;

public class TelaAcesso extends JFrame //implements ActionListener
{


	       static Fachada fachada = Fachada.obterInstancia();
	       Color corFormulario = Color.decode("#6F9890");


	       private JLabel labelImagem;
	       private JLabel labelLogin;
	       
		   private JLabel labelSenha; // JLabel com texto e ícone adicionados
		   private JTextField campoLogin; // campo de texto com tamanho configurado
		   private JPasswordField campoSenha; // campo de senha com texto
		   private JButton botaoSair = new JButton("Sair");
		   private JButton botaoAcesso = new JButton("Acessar");
		   private JComboBox listaOpcoes;
		   private JPanel painelGeral;
		   private JPanel painelCentral;
		   private JPanel painelSul;

		   private JPanel pLImagem;
		   private JPanel pLLabelLogin;
		   private JPanel pLCampoLogin;
		   private JPanel pLLabelSenha;
		   private JPanel pLCampoSenha;
		   private JPanel pLocaBtSair;
		   private JPanel pLocaBtAcessar;

           private String nomes[] = {"Manipular animais","Manipular propriedades","Manipular vacinacoes","Manipular usuarios"};
		   // Construtor LabelFrame adiciona JLabels a JFrame



           public TelaAcesso(){
		      super( "Tela de cesso" );
		      setLayout( new FlowLayout() ); // configura o layout de frame
		      getContentPane().setBackground(corFormulario);


		          painelGeral = new JPanel(new BorderLayout());

		          GridLayout central = new GridLayout(4,1);
		          painelCentral = new JPanel(central);
		          painelSul = new JPanel();
		          Icon bug = new ImageIcon( getClass().getResource("imagens/Figura1.gif") );
			      labelImagem = new JLabel(); // construtor JLabel sem argument;
			      labelImagem.setIcon( bug ); // adiciona ícone a JLabel
			      labelImagem.setHorizontalTextPosition( SwingConstants.CENTER );
			      labelImagem.setVerticalTextPosition( SwingConstants.BOTTOM );

			      labelImagem.setToolTipText( "PROVACINA: " );



			      labelLogin = new JLabel("Digite seu identificador                            ");
			      labelLogin.setForeground(Color.white);
                  labelSenha = new JLabel("Digite sua senha                                      ");
			      labelSenha.setForeground(Color.white);
                  
			      // constrói textfield com 10 colunas
			      campoLogin = new JTextField(25 );

				  // constrói textfield com texto padrão e 21 colunas
				  campoSenha = new JPasswordField(25);
				  listaOpcoes = new JComboBox(nomes);
				  listaOpcoes.setMaximumRowCount(4);

				  // Definição de campos de alocação de componentes no frame principal
				  pLImagem = new JPanel();
				  pLLabelLogin = new JPanel();
				  pLCampoLogin = new JPanel();
				  pLLabelSenha = new JPanel();
				  pLCampoSenha = new JPanel();
				  pLocaBtSair = new JPanel();
				  pLocaBtAcessar = new JPanel();

				  pLImagem.add(labelImagem);
				  pLImagem.setBackground(corFormulario);
				  pLLabelLogin.add(labelLogin);
				  pLLabelLogin.setBackground(corFormulario);
				  pLCampoLogin.add(campoLogin);
				  pLCampoLogin.setBackground(corFormulario);
				  pLLabelSenha.add(labelSenha);
				  pLLabelSenha.setBackground(corFormulario);
				  pLCampoSenha.add(campoSenha);
				  pLCampoSenha.setBackground(corFormulario);
				  pLocaBtSair.setBackground(corFormulario);
				  pLocaBtSair.add(botaoSair);
				  pLocaBtAcessar.setBackground(corFormulario);
				  pLocaBtAcessar.add(botaoAcesso);


				  painelCentral.setBackground(Color.decode("#6F9890"));
				  painelCentral.add(pLLabelLogin);
				  painelCentral.add(pLCampoLogin);
				  painelCentral.add(pLLabelSenha);
				  painelCentral.add(pLCampoSenha);
				  painelGeral.setBackground(Color.decode("#6F9890"));
				  painelGeral.add(pLImagem, BorderLayout.NORTH);
				  painelGeral.add(painelCentral, BorderLayout.CENTER );

    		      painelSul.add(pLocaBtSair);
			      painelSul.add(pLocaBtAcessar);
			      painelSul.setBackground(Color.decode("#6F9890"));
			      painelGeral.add(painelSul,BorderLayout.SOUTH);

			      add(painelGeral);

				  //registra handlers de evento
			      HandlerAcesso  handlerAcesso = new HandlerAcesso ();
			      HandlerSair handlerSair = new HandlerSair();
				  botaoAcesso.addActionListener( handlerAcesso );//atribui um evento da classe TextFieldHandler ao campo textFild1
				  botaoSair.addActionListener( handlerSair );

				  //Configuração da Tela de cesso
				  setResizable(true);
				  setSize(600,450);
				  setVisible(true);
//				  passwordField.addActionListener( handler );
				  } // fim do construtor TextFieldFrame
			    // fim do construtor LabelFrame



		private class HandlerAcesso implements ActionListener{
			      // processa eventos de campo de texto



	         public void actionPerformed( ActionEvent event ){//ActionEvent evento executa após precionar Enter

	        	   Usuario acessante;
	        	   char [] senha;
	        	   try{

	        		  acessante = fachada.procurarUsuario(campoLogin.getText());//busca o usuário através do login e da senha fornecida

	        		  if(acessante.getTipo().equalsIgnoreCase("funcionario") ){
                           senha = campoSenha.getPassword();
	        			  if(acessante.getSenha().equals(String.valueOf(senha))){

	        			      TelaFuncionario tf = new TelaFuncionario(acessante, null, null); //cria um objeto tela funcionário para que estiver acessando

	        			  }
	        		  }else if(acessante.getTipo().equalsIgnoreCase("criador")){
	        			 senha = campoSenha.getPassword();
	        			  if(acessante.getSenha().equals(String.valueOf(senha))){

	        			      TelaCriador tf = new TelaCriador(acessante);//cria um objeto tela criador para que estiver acessando

	        		       }
	        		  }
	        	      }catch(UsuarioInexistenteException ex){
	        			   JOptionPane.showMessageDialog(null,ex.getMessage(),null,JOptionPane.WARNING_MESSAGE);
	        		   } catch (SQLException e) {

						e.printStackTrace();
					}
	        	    setVisible(false);
//
		      } // fim do método actionPerformed
		} // fim da classe TextFieldHandler interna private



		private class HandlerSair implements ActionListener{
		      // processa eventos de campo de texto
           public void actionPerformed( ActionEvent event )//ActionEvent evento executa após precionar Enter
           {
        	   System.exit(1);
//
           } // fim do método actionPerformed
	    } // fim da classe TextFieldHandler interna private


		public static void main( String args[] )
	    {
				try{ 
//				   Contato c = new Contato("6767767","76767667","otavio.souto@gmail.com","4343443","43433434","4343rere");
				   Usuario usuarioChave = new Usuario("Ewerton ","1234","1234","1234","funcionario","1236","1234","03/10/1981");
				   fachada.inserirUsuario(usuarioChave);
		           }catch(UsuarioExistenteException ex){
		           }catch (SQLException e) {
				   }
			       TelaAcesso labelFrame = new TelaAcesso(); // cria LabelFrame
			       labelFrame.setDefaultCloseOperation( JFrame.EXIT_ON_CLOSE );

			       // carrega imagem do disco
				   ImageIcon icone = new ImageIcon("imagens/Figura1.gif");
		           // titulo da janela
				   labelFrame.setTitle("Janela de Teste");
		           // atribui imagem a janela
				   labelFrame.setIconImage(icone.getImage());
				   } // fim de main
	  	}







