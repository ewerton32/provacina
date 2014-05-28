package br.com.provacBeta.guiProvacina;

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
import javax.swing.JTextField;

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

public class TelaFuncionario extends JFrame {

	// Criação do usuario acessante
	private Usuario usuarioAcessante;

	// Icone
	private Icon imagem;

	// Labels norte
	private JLabel jlTopo;

	private JLabel jlMarca;

	// Labels campos;
	private JLabel jlNome;

	private JLabel jlCpf;

	private JLabel jlEmail;

	private JLabel jlTipo;

	private JLabel jlTelefone;

	// Botões de opções
	private JButton btAnimal;

	private JButton btPropriedade;

	private JButton btUsuario;

	private JButton btVacinacao;

	// Botões ações
	private JButton sair;

	private JButton acessar;

	// Botão dadosFuncionario
	private JButton dadosFuncionario;

	// Sub-paineis
	private JPanel campoNorte;

	private JPanel campoEsquerdo;

	private JPanel campoDireito;

	private JPanel campoCentro;

	private JPanel campoSul;

	// Paineis externos
	private JPanel painelOpcoes = new JPanel(new FlowLayout(FlowLayout.RIGHT));

	private PainelAviso painelAviso = new PainelAviso();

	// Paineis de manipulação de animais

	private PainelCadastrarAnimal cadastroAnimal = new PainelCadastrarAnimal(
			campoCentro);

	private PainelAtualizarAnimal atualizarAnimal = new PainelAtualizarAnimal(
			campoCentro);

	private PainelRemoverAnimal removerAnimal = new PainelRemoverAnimal(
			campoCentro);

	private PainelProcurarAnimal procuraAnimal = new PainelProcurarAnimal(
			campoCentro);

	private PainelOpcoesAnimal opcoesAnimal = new PainelOpcoesAnimal(this,
			usuarioAcessante);

	// Paineis de manipulação de propriedades
	private PainelCadastrarPropriedade cadastroPropriedade = new PainelCadastrarPropriedade(
			campoCentro);

	private PainelAtualizarPropriedade atualizarPropriedade = new PainelAtualizarPropriedade(
			campoCentro);

	private PainelProcurarPropriedade procurarPropriedade = new PainelProcurarPropriedade(
			campoCentro);

	private PainelRemoverPropriedade removerPropriedade = new PainelRemoverPropriedade(
			campoCentro);

	private PainelOpcoesPropriedade opcoesPropriedade = new PainelOpcoesPropriedade(
			campoCentro);

	// Paineis de manipulações de usuarios
	private PainelCadastrarUsuario cadastroUsuario = new PainelCadastrarUsuario(
			campoCentro);

	private PainelAtualizarUsuario atualizarUsuario = new PainelAtualizarUsuario(
			campoCentro);

	private PainelOpcoesUsuario opcoesUsuario = new PainelOpcoesUsuario(
			campoCentro);

	private PainelProcurarUsuario procurarUsuario = new PainelProcurarUsuario(
			campoCentro);

	private PainelRemoverUsuario removerUsuario = new PainelRemoverUsuario(
			campoCentro);

	// Paineis de manipulação de vacinações
	private PainelCadastrarVacinacao cadastroVacinacao = new PainelCadastrarVacinacao(
			campoCentro);

	private PainelAtualizarVacinacao atualizarVacinacao = new PainelAtualizarVacinacao(
			campoCentro);

	private PainelOpcoesVacinacao opcoesVacinacao = new PainelOpcoesVacinacao(
			campoCentro);

	private PainelProcurarVacinacao procuraVacinacao = new PainelProcurarVacinacao(
			campoCentro);

	private PainelRemoverVacinacao removerVacinacao = new PainelRemoverVacinacao(
			campoCentro);

	// Criação de Cores padronizadas
	private Color corFormulario = Color.decode("#6F9890");

	private Color corDiferente = Color.decode("#336666");

	private Color corFonte = Color.decode("#FFFFFF");

	private Color corDestaque = Color.decode("#5C8B7C");

	private Color corAtencao = Color.ORANGE;

	// Aviso do painelOpcao
	private JTextField aviso = new JTextField("Clique em um dos botões acima");

	public void setAviso(String aviso) {
		this.aviso = new JTextField(aviso);
	}

	public JTextField getAviso() {
		return aviso;
	}

	// construtor TelaFuncionario
	public TelaFuncionario(Usuario usuario, Object painel, Object objGenerico) {
		super("Tela de acesso ao Funcionário");
		usuarioAcessante = usuario;

		setLayout(new BorderLayout());

		getContentPane().setBackground(corFormulario);

		// Inicialização de campos
		campoNorte = new JPanel(new FlowLayout(FlowLayout.LEFT));

		campoEsquerdo = new JPanel(new GridLayout(10, 1));

		campoDireito = new JPanel(new FlowLayout());

		campoCentro = new JPanel(new GridLayout(7, 1));

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
		jlNome = new JLabel("   NOME : " + usuarioAcessante.getNome() + "   ");
		jlNome.setForeground(corFonte);

		jlCpf = new JLabel("   CPF : " + usuarioAcessante.getCpf() + "   ");
		jlCpf.setForeground(corFonte);

		jlEmail = new JLabel("   RG : " + usuarioAcessante.getRg() + "   ");
		jlEmail.setForeground(corFonte);

		jlTipo = new JLabel("   FUNÇÃO : " + usuarioAcessante.getTipo() + "   ");
		jlTipo.setForeground(corFonte);

		JLabel espaco2 = new JLabel("     ");
		dadosFuncionario = new JButton("Exibir dados pessoais");
		TratadorExibirDados handlerExibirDados = new TratadorExibirDados(this);
		dadosFuncionario.addActionListener(handlerExibirDados);
		dadosFuncionario.setBackground(corDiferente);
		dadosFuncionario.setForeground(corFonte);

		campoEsquerdo.add(jlTipo);
		campoEsquerdo.add(jlNome);
		campoEsquerdo.add(jlCpf);
		campoEsquerdo.add(espaco2);
		campoEsquerdo.add(dadosFuncionario);
		campoEsquerdo.setBackground(corDestaque);

		TratadorOpcao handlerOpcao = new TratadorOpcao(this);

		// Adicona-se botões ao campo central e os configura
		btAnimal = new JButton("Manipular animais");
		btAnimal.setForeground(corFormulario);
		btAnimal.setToolTipText("Manipular dados de animais");
		btAnimal.addActionListener(handlerOpcao);
		btAnimal.setBackground(corDiferente);
		btAnimal.setForeground(corFonte);

		btPropriedade = new JButton("Manipular propriedades");
		btPropriedade.setForeground(corFormulario);
		btPropriedade.setToolTipText("Manipular dados propriedades");
		btPropriedade.addActionListener(handlerOpcao);
		btPropriedade.setBackground(corDiferente);
		btPropriedade.setForeground(corFonte);

		btUsuario = new JButton("Manipular usuários");
		btUsuario.setForeground(corFormulario);
		btUsuario.setToolTipText("Manipulat dados de usuários");
		btUsuario.addActionListener(handlerOpcao);
		btUsuario.setBackground(corDiferente);
		btUsuario.setForeground(corFonte);

		btVacinacao = new JButton("Manipular vacinações");
		btVacinacao.setForeground(corFormulario);
		btVacinacao.setToolTipText("Manipular dados de vacinações");
		btVacinacao.addActionListener(handlerOpcao);
		btVacinacao.setBackground(corDiferente);
		btVacinacao.setForeground(corFonte);

		// Adiciona componentes ao campo central
		JLabel espaco = new JLabel("     ");
		campoDireito.add(espaco);
		campoDireito.setBackground(corDestaque);

		// Adiciona componentes ao campo central

		campoCentro.add(btAnimal);
		campoCentro.add(btPropriedade);
		campoCentro.add(btUsuario);
		campoCentro.add(btVacinacao);
		campoCentro.setBackground(corDiferente);
		campoCentro.setToolTipText("Escolha uma operação e clique em seguir");
		campoCentro.setBackground(corDiferente);
		painelOpcoes.setBackground(corDiferente);
		painelOpcoes.add(painelAviso);
		campoCentro.add(painelOpcoes);

		// Adicona-se componentes ao campo sul
		sair = new JButton("Sair");
		TratadorSair handlerSair = new TratadorSair();
		sair.addActionListener(handlerSair);
		campoSul.add(sair);

		acessar = new JButton("Seguir");
		TratadorSeguir handlerAcessar = new TratadorSeguir();
		acessar.addActionListener(handlerAcessar);
		// campoSul.add(acessar);
		campoSul.setBackground(Color.WHITE);

		// Adiciona os pauneis aos respectivos campos
		add(campoNorte, BorderLayout.NORTH);
		add(campoEsquerdo, BorderLayout.WEST);
		add(campoDireito, BorderLayout.EAST);
		add(campoCentro, BorderLayout.CENTER);
		add(campoSul, BorderLayout.SOUTH);

		setResizable(false);
		setSize(600, 450);
		setVisible(true);

	}

	private class TratadorOpcao implements ActionListener {
		private TelaFuncionario tela;

		private JLabel info = new JLabel("Escolha uma operação");

		// Construtor da classe TratadorOpcao
		public TratadorOpcao(TelaFuncionario t) {
			tela = t;
		}

		public void actionPerformed(ActionEvent evento) {
			info.setForeground(corAtencao);

			if (evento.getSource() == btAnimal) {
				JLabel info = new JLabel("Animais");
				info.setForeground(corFonte);
				tela.painelOpcoes.removeAll();
				tela.painelOpcoes.add(info);
				tela.painelOpcoes.add(opcoesAnimal);
				tela.setVisible(true);
				tela.painelOpcoes.repaint();
			} else if (evento.getSource() == btPropriedade) {
				JLabel info = new JLabel("Propriedades");
				info.setForeground(corFonte);
				tela.painelOpcoes.removeAll();
				tela.painelOpcoes.add(info);
				tela.painelOpcoes.add(opcoesPropriedade);
				tela.painelOpcoes.repaint();
				tela.setVisible(true);
				tela.painelOpcoes.repaint();
			} else if (evento.getSource() == btUsuario) {
				JLabel info = new JLabel("Usuários");
				info.setForeground(corFonte);
				tela.painelOpcoes.removeAll();
				tela.painelOpcoes.add(info);
				tela.painelOpcoes.add(opcoesUsuario);
				tela.setVisible(true);
				tela.painelOpcoes.repaint();
			} else if (evento.getSource() == btVacinacao) {
				JLabel info = new JLabel("Vacinações");
				info.setForeground(corFonte);
				tela.painelOpcoes.removeAll();
				tela.painelOpcoes.add(info);
				tela.painelOpcoes.add(opcoesVacinacao);
				tela.setVisible(true);
				tela.painelOpcoes.repaint();
			}

		}

	}

	private class TratadorSeguir implements ItemListener, ActionListener {

		public void actionPerformed(ActionEvent evento) {

		}

		public void itemStateChanged(ItemEvent evento) {
			if (evento.getStateChange() == ItemEvent.SELECTED) {

			}

		}
	}

	private class TratadorSair implements ActionListener {
		// processa eventos de campo de texto
		public void actionPerformed(ActionEvent event)// ActionEvent evento
														// executa após
														// precionar Enter
		{
			System.exit(1);
			//
		} // fim do método actionPerformed
	} // fim da classe TextFieldHandler interna private

	private class TratadorExibirDados implements ActionListener {
		private TelaFuncionario tela;

		public TratadorExibirDados(TelaFuncionario essaTela) {
			tela = essaTela;
		}

		public void actionPerformed(ActionEvent evento) {

			if (evento.getSource() == dadosFuncionario) {
				JOptionPane.showMessageDialog(tela, tela.usuarioAcessante,
						"Dados do usuário", JOptionPane.INFORMATION_MESSAGE);
			}
		}
	}

	public static void main(String[] args) {
		Contato c = new Contato("6767767", "76767667",
				"otavio.souto@gmail.com", "4343443", "43433434", "4343rere");
		Usuario usuarioChave = new Usuario("Ewerton Otávio de Castro Souto",
				"1234", "1234", "1234", "funcionario", "1234", "1234",
				"03/10/1981", c);
		TelaFuncionario tela = new TelaFuncionario(usuarioChave, null, null);
		tela.setAlwaysOnTop(false);
	}

}
