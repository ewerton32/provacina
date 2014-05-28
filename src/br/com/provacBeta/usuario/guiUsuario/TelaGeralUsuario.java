package br.com.provacBeta.usuario.guiUsuario;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.provacBeta.usuario.Usuario;
import br.com.provacBeta.util.Contato;



public class TelaGeralUsuario extends JFrame{


	//Criação do usuario acessante
	private Usuario usuarioAcessante;
	//Icone
	private Icon imagem;
	//Labels norte
	private JLabel jlTopo;
	private JLabel jlMarca;
    //Botões ações
    private JButton sair;
    private JButton seguir;
    //Sub-paineis
    private JPanel campoNorte;
    private JPanel campoEsquerdo;
    private JPanel campoDireito;
    private JPanel campoCentro;
    private JPanel campoSul;    
    //Criação de Cores padronizadas
    private Color corFormulario = Color.decode("#6F9890");
	private Color corDiferente = Color.decode("#336666");
	private Color corFonte = Color.decode("#FFFFFF");
	private Color corDestaque = Color.decode("#5C8B7C");
	private Color corAtencao = Color.ORANGE;
	
	private PainelCadastrarUsuario cadastroUsuario;
 
	
	public TelaGeralUsuario(Usuario usuario, JPanel painel){
    	super("Gerenciamento de usuários");
    	usuarioAcessante = usuario;
    	setLayout(new BorderLayout());
    	getContentPane().setBackground(corFormulario);

    	//Inicialização de campos
    	campoNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));
    	campoEsquerdo = new JPanel(new GridLayout(10,1));
    	campoDireito = new JPanel(new FlowLayout());
    	campoCentro = new JPanel(new FlowLayout());
    	campoSul = new JPanel(new FlowLayout(FlowLayout.LEFT));

        // Adicona econfigura o label icone no campo norte
        imagem = new ImageIcon(getClass().getResource("imagens/Figura1.gif"));
    	jlTopo = new JLabel(imagem);
    	jlMarca = new JLabel("");
    	jlMarca.setForeground(Color.WHITE);
    	campoNorte.add(jlTopo);
    	campoNorte.add(jlMarca);
    	campoNorte.setBackground(corFormulario);


    	// Adiciona-se Labels ao campo esquerdo
        JLabel espaco2 = new JLabel("     ");
    	campoEsquerdo.add(espaco2);   	
    	campoEsquerdo.setBackground(corDestaque);

        //Adiciona componentes ao campo central
    
    	campoCentro.setBackground(corDestaque );
    	
    	//Adiciona componentes ao campo direito
        JLabel espaco = new JLabel("     ");
        campoDireito.add(espaco);
        campoDireito.setBackground(corDestaque);

        
        //Adicona-se componentes ao campo sul
    	sair = new JButton("Sair");
    	TratadorSair handlerSair = new TratadorSair();
    	sair.addActionListener(handlerSair);
        campoSul.add(sair);

        seguir = new JButton("Seguir");       
        
        seguir.addActionListener(
            new ActionListener(){
        		 public void actionPerformed(ActionEvent evento) {
        	         
        			 if(evento.getSource() == seguir){
        		       
        	        }        			
        		}	
        	}
        );
//        campoSul.add(seguir);
        campoSul.setBackground(Color.WHITE);
        
        cadastroUsuario = new PainelCadastrarUsuario(null);

    	//Adiciona os pauneis aos respectivos campos
    	add(campoNorte,  BorderLayout.NORTH);
    	add(campoEsquerdo,  BorderLayout.WEST);
    	add(campoDireito,  BorderLayout.EAST);
    	add((JPanel)painel,  BorderLayout.CENTER);
    	add(campoSul,  BorderLayout.SOUTH);

        
    	setResizable(false);
    	setSize(600,450);
		setVisible(true);	
    }    

    private class TratadorSeguir implements ItemListener, ActionListener{

    	public void actionPerformed(ActionEvent evento) {


    	}

		public void itemStateChanged(ItemEvent evento) {
		    if ( evento.getStateChange() == ItemEvent.SELECTED ){


        }
	  }
    }

    private class TratadorSair implements ActionListener{
	      // processa eventos de campo de texto
     public void actionPerformed( ActionEvent event )//ActionEvent evento executa após precionar Enter
     {
  	   setVisible(false);
//
     } // fim do método actionPerformed
  } // fim da classe TextFieldHandler interna private
    

    public static void main(String[] args) {
    	Contato c = new Contato("6767767","76767667","otavio.souto@gmail.com","4343443","43433434","4343rere");
	    Usuario usuarioChave = new Usuario("Ewerton Otávio de Castro Souto","1234","1234","1234","funcionario","1234","1234","03/10/1981",c);
    	TelaGeralUsuario tela = new TelaGeralUsuario(usuarioChave, null);
    	tela.setAlwaysOnTop(false);
	}

}
