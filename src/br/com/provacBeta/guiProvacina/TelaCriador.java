package br.com.provacBeta.guiProvacina;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import br.com.provacBeta.animal.guiAnimal.PainelAtualizarAnimal;
import br.com.provacBeta.animal.guiAnimal.PainelCadastrarAnimal;
import br.com.provacBeta.animal.guiAnimal.PainelOpcoesAnimal;
import br.com.provacBeta.animal.guiAnimal.PainelProcurarAnimal;
import br.com.provacBeta.animal.guiAnimal.PainelRemoverAnimal;
import br.com.provacBeta.propriedade.guiPropriedade.PainelAtualizarPropriedade;
import br.com.provacBeta.propriedade.guiPropriedade.PainelCadastrarPropriedade;
import br.com.provacBeta.propriedade.guiPropriedade.PainelOpcoesPropriedade;
import br.com.provacBeta.propriedade.guiPropriedade.PainelProcurarPropriedade;
import br.com.provacBeta.propriedade.guiPropriedade.PainelRemoverPropriedade;
import br.com.provacBeta.usuario.Usuario;
import br.com.provacBeta.usuario.guiUsuario.PainelAtualizarUsuario;
import br.com.provacBeta.usuario.guiUsuario.PainelCadastrarUsuario;
import br.com.provacBeta.usuario.guiUsuario.PainelOpcoesUsuario;
import br.com.provacBeta.usuario.guiUsuario.PainelProcurarUsuario;
import br.com.provacBeta.usuario.guiUsuario.PainelRemoverUsuario;
import br.com.provacBeta.util.Contato;
import br.com.provacBeta.vacinacao.guiVacinacao.PainelAtualizarVacinacao;
import br.com.provacBeta.vacinacao.guiVacinacao.PainelCadastrarVacinacao;
import br.com.provacBeta.vacinacao.guiVacinacao.PainelOpcoesVacinacao;
import br.com.provacBeta.vacinacao.guiVacinacao.PainelProcurarVacinacao;
import br.com.provacBeta.vacinacao.guiVacinacao.PainelRemoverVacinacao;



public class TelaCriador extends JFrame{

	private String Operacoes[] = {"Escolha uma opera��o","Cadastrar animal","Alterar animal","Procurar animal","Remover animal"};

	//Cria��o do usuario acessante
	private Usuario usuarioAcessante;

	//Icone
	private Icon imagem;

	//Lista de op��es
	private JComboBox listaOpcoes;

	//Labels norte
	private JLabel jlIcone;
	private JLabel jlMarca;

    //Labels campos;
    private JLabel jlNome;
    private JLabel jlCpf;
    private JLabel jlEmail;
    private JLabel jlTipo;
    private JLabel jlTelefone;
    private JLabel jlEspaco;



    //Bot�es de op��es
    private JButton btAnimal;
    private JButton btPropriedade;
    private JButton btUsuario;
    private JButton btVacinacao;

    //Bot�es a��es
    private JButton sair;
    private JButton acessar;
    private JButton voltar;
    //Bot�o dadosFuncionario
    private JButton dadosFuncionario;

    //Sub-paineis
    private JPanel campoNorte;
    private JPanel campoEsquerdo;
    private JPanel campoDireito;
    private JPanel campoCentro;
    private JPanel campoCentroGenerico;
    private JPanel campoSul;


    //Paineis externos
    public JPanel painelOpcoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));
    private PainelAviso painelAviso = new PainelAviso();

    // Paineis de manipula��o de animais

    private PainelCadastrarAnimal cadastroAnimal = new PainelCadastrarAnimal(campoCentro);
    private PainelAtualizarAnimal atualizarAnimal = new PainelAtualizarAnimal(campoCentro);
    private PainelRemoverAnimal removerAnimal = new PainelRemoverAnimal(campoCentro);
    private PainelProcurarAnimal procuraAnimal = new PainelProcurarAnimal(campoCentro);
    private PainelOpcoesAnimal opcoesAnimal = new PainelOpcoesAnimal(this, usuarioAcessante);

    //Paineis de manipula��o de propriedades
    private PainelCadastrarPropriedade cadastroPropriedade = new PainelCadastrarPropriedade(campoCentro);
    private PainelAtualizarPropriedade atualizarPropriedade = new PainelAtualizarPropriedade(campoCentro);
    private PainelProcurarPropriedade procurarPropriedade = new PainelProcurarPropriedade(campoCentro);
    private PainelRemoverPropriedade removerPropriedade = new PainelRemoverPropriedade(campoCentro);
    private PainelOpcoesPropriedade opcoesPropriedade = new PainelOpcoesPropriedade(campoCentro);

    //Paineis de manipula��es de usuarios
    private PainelCadastrarUsuario cadastroUsuario = new PainelCadastrarUsuario(campoCentro);
    private PainelAtualizarUsuario atualizarUsuario = new PainelAtualizarUsuario(campoCentro);
    private PainelOpcoesUsuario opcoesUsuario = new PainelOpcoesUsuario(campoCentro);
    private PainelProcurarUsuario procurarUsuario = new PainelProcurarUsuario(campoCentro);
    private PainelRemoverUsuario removerUsuario = new PainelRemoverUsuario(campoCentro);

    //Paineis de manipula��o de vacina��es
    private PainelCadastrarVacinacao cadastroVacinacao = new PainelCadastrarVacinacao(campoCentro);
    private PainelAtualizarVacinacao atualizarVacinacao = new PainelAtualizarVacinacao(campoCentro);
    private PainelOpcoesVacinacao opcoesVacinacao = new PainelOpcoesVacinacao(campoCentro);
    private PainelProcurarVacinacao procuraVacinacao = new PainelProcurarVacinacao(campoCentro);
    private PainelRemoverVacinacao removerVacinacao = new PainelRemoverVacinacao(campoCentro);


    private Color corFormulario = Color.decode("#6F9890");
    private Color corDiferente = Color.decode("#336666");
    private Color corFonte = Color.decode("#FFFFFF");
    private Color corDestaque = Color.decode("#5C8B7C");
	private Color corAtencao = Color.ORANGE;

    //construtor TelaFuncionario
    public TelaCriador(Usuario usuario){
    	super("Tela de acesso do Criador");
    	usuarioAcessante = usuario;

    	setLayout(new BorderLayout());

    	getContentPane().setBackground(corFormulario);


    	//Inicializa��o de campos
    	campoNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));

    	campoEsquerdo = new JPanel(new GridLayout(10,2));

    	campoDireito = new JPanel(new FlowLayout());

    	campoCentro = new JPanel(new GridLayout(7,1));

    	campoSul = new JPanel(new FlowLayout(FlowLayout.LEFT));



        // Adicona econfigura o label icone no campo norte
        imagem = new ImageIcon(getClass().getResource("imagens/Figura1.gif"));
    	jlIcone = new JLabel(imagem);
    	jlMarca = new JLabel("");
    	jlMarca.setForeground(Color.WHITE);
    	campoNorte.add(jlIcone);
    	campoNorte.add(jlMarca);
    	campoNorte.setBackground(corFormulario);




    	//Adiciona-se Labels ao campo esquerdo
    	jlNome = new JLabel("   NOME : "+usuarioAcessante.getNome()+"   ");
    	jlNome .setForeground(corFonte);

        jlCpf = new JLabel("   CPF : "+usuarioAcessante.getCpf()+"   ");
        jlCpf.setForeground(corFonte);

//        jlEmail = new JLabel("   RG : "+usuarioAcessante.getRg()+"   ");
//        jlEmail.setForeground(corFonte);

        jlTipo = new JLabel("   FUN��O : "+usuarioAcessante.getTipo()+"   ");
        jlTipo.setForeground(corFonte);

//        jlTelefone = new JLabel("   TELEFONE : "+usuarioAcessante.getContato().getTelefone()+"   ");
//        jlTelefone.setForeground(corFonte);
//        jlTelefone.setForeground(corFonte);

        jlEspaco = new JLabel("                                                                      ");



        dadosFuncionario = new JButton("Exibir dados pessoais");
        TratadorExibirDadosPropriedade handlerExibirDados = new TratadorExibirDadosPropriedade(this);
        dadosFuncionario.addActionListener(handlerExibirDados);
        dadosFuncionario.setBackground(corDiferente);
        dadosFuncionario.setForeground(corFonte);

    	campoEsquerdo.add(jlTipo);
    	campoEsquerdo.add(jlNome);
    	campoEsquerdo.add(jlCpf);
//    	campoEsquerdo.add(jlEmail);
//    	campoEsquerdo.add(jlTelefone);
    	campoEsquerdo.setBackground(corDiferente);
    	campoEsquerdo.setBackground(corDestaque);



        //  Adicona-se labels ao campo central
    	TratadorOpcao handlerOpcao = new TratadorOpcao(this);

    	btAnimal = new JButton("Manipular animais");
        btAnimal.setForeground(corFormulario);
        btAnimal.setToolTipText("Manipular dados de animais");
        btAnimal.addActionListener(handlerOpcao);
        btAnimal.setBackground(corDiferente);
        btAnimal.setForeground(corFonte);

        TratadorExibirDadosPropriedade handlerExibirDadosPropriedde = new TratadorExibirDadosPropriedade(this);
        btPropriedade = new JButton("Exibir dados da propriedade");
        btPropriedade.setForeground(corFormulario);
        btPropriedade.setToolTipText("Exibir dados da propriedades");
        btPropriedade.addActionListener(handlerExibirDadosPropriedde);
        btPropriedade.setBackground(corDiferente);
        btPropriedade.setForeground(corFonte);

        TratadorEscolhaUsuario handlerEscolha = new TratadorEscolhaUsuario(this);
        btUsuario = new JButton("Exibir dados do usu�rio");
        btUsuario.setForeground(corFormulario);
        btUsuario.setToolTipText("Exibir dados de usu�rios");
        btUsuario.addActionListener(handlerEscolha);
        btUsuario.setBackground(corDiferente);
        btUsuario.setForeground(corFonte);

        btVacinacao = new JButton("Manipular vacina��es");
        btVacinacao.setForeground(corFormulario);
        btVacinacao.setToolTipText("Manipular dados de vacina��es");
        btVacinacao.addActionListener(handlerOpcao);
        btVacinacao.setBackground(corDiferente);
        btVacinacao.setForeground(corFonte);

        JLabel informe = new JLabel("* Clique em um dos bot�es a cima e escolha a opera��o");
        informe.setForeground(corFonte);

        //Adiciona componentes ao campo central

        JLabel espaco = new JLabel("     ");
        campoDireito.add(espaco);
        campoDireito.setBackground(corDestaque);


        //Adiciona componentes ao campo central
        listaOpcoes = new JComboBox(Operacoes);
        listaOpcoes.setBackground(corFormulario);
        listaOpcoes.setForeground(corFonte);
    	campoCentro.add(btAnimal);
    	campoCentro.add(btPropriedade);
    	campoCentro.add(btUsuario);
    	campoCentro.add(btVacinacao);
    	campoCentro.setBackground(corDiferente);
    	campoCentro.setToolTipText("Escolha uma opera��o e clique em seguir");
    	painelOpcoes.setBackground(corDiferente);
    	painelOpcoes.add(painelAviso);
    	campoCentro.add(painelOpcoes);






        //Adicona-se labels ao campo sul
    	sair = new JButton("Sair");
    	TratadorSair handlerSair = new TratadorSair();
    	sair.addActionListener(handlerSair);
        acessar = new JButton("Seguir");
        voltar = new JButton("Voltar");
        TratadorVoltar handlerVoltar = new TratadorVoltar(this);
        voltar.addActionListener(handlerVoltar);
        campoSul.add(sair);
        campoSul.add(acessar);
        campoSul.setBackground(Color.WHITE);


    	//Adiciona os pauneis aos respectivos campos

    	add(campoNorte ,  BorderLayout.NORTH);
    	add(campoEsquerdo ,  BorderLayout.WEST);
    	add(campoDireito ,  BorderLayout.EAST);
    	add(campoCentro ,  BorderLayout.CENTER);
    	add(campoSul ,  BorderLayout.SOUTH);


    	setResizable(false);
		setSize(600,450);
		setVisible(true);
    }

    private class TratadorOpcao implements ActionListener{
    	private JLabel info;
    	private TelaCriador tela;
    	public TratadorOpcao(TelaCriador t){
    		tela = t;
    	}
    	public void actionPerformed(ActionEvent evento) {


        if(evento.getSource() == btAnimal){
			    info = new JLabel("Animais");
			    info.setForeground(corFonte);
			    tela.painelOpcoes.removeAll();
				tela.painelOpcoes.add(info);
				tela.painelOpcoes.add(opcoesAnimal);
				tela.setVisible(true);
				tela.repaint();

		}else if(evento.getSource() == btPropriedade){

			    info = new JLabel("Clique em seguir para exibir os dados da propriedades");
    			info.setForeground(corFonte);
    			info.setSize(120, 200);
			    tela.painelOpcoes.removeAll();
			    tela.painelOpcoes.add(info);
			    tela.setVisible(true);
			    tela.repaint();

		}else if(evento.getSource() == btUsuario){
			    info = new JLabel("Clique em seguir para exibir os dados do usu�rio");
			    info.setSize(120, 200);
			    info.setForeground(corFonte);
     			tela.painelOpcoes.removeAll();
     			tela.painelOpcoes.add(info);
	    	    tela.setVisible(true);
	    	    tela.repaint();

        }else if(evento.getSource() == btVacinacao){
        	    info = new JLabel("Vacina��es");
        	    info.setForeground(corFonte);
        	    tela.painelOpcoes.removeAll();
        	    tela.painelOpcoes.add(info);
    		    tela.painelOpcoes.add(opcoesVacinacao);
	    	    tela.setVisible(true);
	    	    tela.repaint();
		}



    }
    }
    private class TratadorSeguir implements ActionListener{

    	public void actionPerformed(ActionEvent arg0) {


    	}
    }

    private class TratadorSair implements ActionListener{
	      // processa eventos de campo de texto
     public void actionPerformed( ActionEvent event )//ActionEvent evento executa ap�s precionar Enter
     {
  	   System.exit(1);
//
     } // fim do m�todo actionPerformed
  } // fim da classe TextFieldHandler interna private


    private class TratadorEscolhaUsuario implements ActionListener{
    	private TelaCriador tela;
    	public TratadorEscolhaUsuario(TelaCriador essaTela){
    		tela = essaTela;
    	}
    	public void actionPerformed(ActionEvent arg0) {
    	JOptionPane.showMessageDialog(tela, usuarioAcessante,"Dados do criador",JOptionPane.INFORMATION_MESSAGE);

    	}
    }

    private class TratadorExibirDadosPropriedade implements ActionListener{
    	private TelaCriador tela;
    	public TratadorExibirDadosPropriedade(TelaCriador essaTela){
    		tela = essaTela;
    	}
    	
    	public void actionPerformed(ActionEvent evento) {
    	   if(evento.getSource() == btPropriedade){
    		   tela.remove(tela.campoCentro);
    		   tela.add(procurarPropriedade, BorderLayout.CENTER);
    		   setVisible(true);
    		   tela.campoSul.add(voltar);
    		   tela.setVisible(true);
    	   }
    	}
    }

    private class TratadorVoltar implements ActionListener{
    	private TelaCriador tela;
    	public TratadorVoltar(TelaCriador essaTela){
    		tela = essaTela;
    	}
    	public void actionPerformed(ActionEvent evento) {
    		if(evento.getSource() == voltar){
    			setVisible(false);
    			tela = new TelaCriador(usuarioAcessante);
    		}

    	}
    	
    }

    public static void main(String[]args) {

    	Contato c = new Contato("6767767","76767667","otavio.souto@gmail.com","4343443","43433434","4343rere");
	    Usuario usuarioChave = new Usuario("Ewerton ","1234","1234","1234","Criador","1234","1234","03/10/1981",c);
	    Contato cb = new Contato("6767767","76767667","otavio.souto@gmail.com","4343443","43433434","4343rere");
	    Usuario usuarioChave2 = new Usuario("Ewisson ","1235","1235","1235","funcionario","1235","1235","03/10/1981",cb);
    	TelaCriador tela = new TelaCriador(usuarioChave);
	}

}
