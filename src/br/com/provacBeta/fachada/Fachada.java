package br.com.provacBeta.fachada;

import java.awt.HeadlessException;
import java.sql.SQLException;

import javax.swing.JOptionPane;

import br.com.provacBeta.animal.Animal;
import br.com.provacBeta.animal.AnimalExistenteException;
import br.com.provacBeta.animal.AnimalInexistenteException;
import br.com.provacBeta.animal.ColecaoAnimais;
import br.com.provacBeta.animal.RepositorioAnimais;
import br.com.provacBeta.interfaces.TelasUsuarios;
import br.com.provacBeta.propriedade.ColecaoPropriedade;
import br.com.provacBeta.propriedade.Propriedade;
import br.com.provacBeta.propriedade.PropriedadeExistenteException;
import br.com.provacBeta.propriedade.PropriedadeInexistenteException;
import br.com.provacBeta.propriedade.RepositorioPropriedades;
import br.com.provacBeta.usuario.BdUsuario;
import br.com.provacBeta.usuario.ColecaoUsuarios;
import br.com.provacBeta.usuario.RepositorioUsuarios;
import br.com.provacBeta.usuario.Usuario;
import br.com.provacBeta.usuario.UsuarioExistenteException;
import br.com.provacBeta.usuario.UsuarioInexistenteException;
import br.com.provacBeta.vacinacao.ColecaoVacinacoes;
import br.com.provacBeta.vacinacao.RepositorioVacinacoes;
import br.com.provacBeta.vacinacao.Vacinacao;
import br.com.provacBeta.vacinacao.VacinacaoExistenteException;
import br.com.provacBeta.vacinacao.VacinacaoInexistenteException;

/**
 * @author Ewerton Otavio de Castro
 */
public class Fachada {
	private static Fachada instancia;

	private RepositorioAnimais animais;

	private RepositorioPropriedades propriedades;

	private RepositorioUsuarios usuarios;

	private RepositorioVacinacoes vacinacoes;

	protected Fachada() {
		initCadastro();
	}

	public void initCadastro() {

		// animais = ArrayAnimais.getInstance();
		animais = ColecaoAnimais.getInstance();
		// animais = BdAnimal.getInstance();

		// propriedades = ArrayPropriedades.getInstance();
		propriedades = ColecaoPropriedade.getInstance();
		// propriedades = BdPropriedade.getInstance();

		// usuarios = ArrayUsuarios.getInstance();
		usuarios = ColecaoUsuarios.getInstance();
		// usuarios = BdUsuario.getInstance();

		// vacinacoes = ArrayVacinacoes.getInstance();
		vacinacoes = ColecaoVacinacoes.getInstance();
		// vacinacoes = BdVacinacao.getInstance();
	}

	public static Fachada obterInstancia() {
		if (instancia == null) {
			instancia = new Fachada();
		}
		return instancia;
	}

	// metodos para manipular cada um dos cadastros de Animais;

	public void atualizarAnimal(Animal ani) throws AnimalInexistenteException,
			SQLException {
		animais.atualizar(ani);

	}

	public void inserirAnimal(Animal ani) throws AnimalExistenteException,
			SQLException {
		String numeroProp = ani.getPropriedade().getNumEscritura();
		if (propriedades.existe(numeroProp)) {
			animais.inserir(ani);
			System.out
					.println("Propriedade já cadastrada:\n O animal  foi cadastrado.");
		} else {
			JOptionPane.showMessageDialog(null,
					"Propriedade inexistente! \nAnimal não cadastrado",
					"Erro! ", JOptionPane.ERROR_MESSAGE);
			System.out
					.println("Propriedade inexistente \nAnimal não cadastrado");
		}
	}

	public Animal procurarAnimal(String numero)
			throws AnimalInexistenteException, SQLException {
		Animal a = animais.procurar(numero);
		try {
			String numProp = a.getPropriedade().getNumEscritura();
			a.setPropriedade(propriedades.procurar(numProp));
		} catch (PropriedadeInexistenteException ex) {
			ex.getMessage();
		}
		return a;
	}

	public void removerAnimal(String numero) throws AnimalInexistenteException,
			SQLException {
		animais.remover(numero);
	}

	// metodos para manipular cada um dos cadastros de Propriedades;

	public void atualizarPropriedade(Propriedade pro)
			throws PropriedadeInexistenteException {
		try {
			propriedades.atualizar(pro);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public void inserirPropriedade(Propriedade pro)
			throws PropriedadeExistenteException {
		String numUsuario = pro.getCriador().getIdUsuario();
		try {
			if (usuarios.existe(numUsuario)) {
				System.out.println("Criador já cadastrado:");
				try {
					propriedades.inserir(pro);
				} catch (SQLException e) {

					e.printStackTrace();
				}
				System.out.println("Propriedade cadastrada com sucesso.");
			} else {
				System.out.println("Criador pendente de Cadastro!!");
				JOptionPane.showMessageDialog(null,
						"Criador pendente de Cadastro!", "Erro!",
						JOptionPane.ERROR_MESSAGE, null);
				Usuario criador = TelasUsuarios.lerUsuario();
				pro.setCriador(criador);
				try {
					usuarios.inserir(criador);
				} catch (UsuarioExistenteException ex) {
					System.out.println(ex.getMessage());
				}
				try {
					propriedades.inserir(pro);
				} catch (SQLException e) {

					e.printStackTrace();
				}
				System.out.println("Criador e Propriedade cadastrados.");
			}
		} catch (HeadlessException e) {

			e.printStackTrace();
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	public Propriedade procurarPropriedade(String numero)
			throws PropriedadeInexistenteException, SQLException {
		Propriedade p = propriedades.procurar(numero);
		try {
			String numUsu = p.getCriador().getIdUsuario();
			p.setCriador(usuarios.procurar(numUsu));
		} catch (UsuarioInexistenteException ex) {
			ex.getMessage();
		}

		return p;

	}

	public void removerPropriedade(String numEscritura)
			throws PropriedadeInexistenteException {
		try {
			propriedades.remover(numEscritura);
		} catch (SQLException e) {

			e.printStackTrace();
		}
	}

	// metodos para manipular cada um dos cadastros de Usuarios;

	public void atualizarUsuario(Usuario usu)
			throws UsuarioInexistenteException, SQLException {
		usuarios.atualizar(usu);
	}

	public void inserirUsuario(Usuario usu) throws UsuarioExistenteException,
			SQLException {
		usuarios.inserir(usu);
	}

	public Usuario procurarUsuario(String numero)
			throws UsuarioInexistenteException, SQLException {
		return usuarios.procurar(numero);
	}

	public void removerUsuario(String numero)
			throws UsuarioInexistenteException, SQLException {
		usuarios.remover(numero);
	}

	// metodos para manipular cada um dos cadastros de Vacinações;

	public void atualizarVacinacao(Vacinacao vac)
			throws VacinacaoInexistenteException, SQLException {
		vacinacoes.atualizar(vac);
	}

	public void inserirVacinacao(Vacinacao vac)
			throws VacinacaoExistenteException, SQLException {
		String id_usuario = vac.getUsuario().getIdUsuario();
		String numero = vac.getAnimal().getNumero();
		if (usuarios.existe(id_usuario)) {
			System.out.println("Usuario Confirmado!");
			if (animais.existe(numero)) {
				System.out.println("Animal Confirmado!");
				vacinacoes.inserir(vac);
				System.out.println("Vacinação registrada;");
			} else {
				// System.out.println("Animal não encontrado!!");
				JOptionPane
						.showMessageDialog(
								null,
								"Animal não encontrado\n vacinação pendente de registro!!",
								"Erro!", JOptionPane.ERROR_MESSAGE);
			}
		} else {
			// System.out.println(" Usuário não encontrado \n Vacinação pendente
			// de Registro!!");
			JOptionPane
					.showMessageDialog(
							null,
							"Usuário não encontrado\n vacinação pendente de registro!!",
							"Erro!", JOptionPane.ERROR_MESSAGE);
		}
	}

	public Vacinacao procurarVacinacao(String numero)
			throws VacinacaoInexistenteException, SQLException {
		Vacinacao v = vacinacoes.procurar(numero);
		try {
			String numAni = v.getAnimal().getNumero();
			v.setAnimal(animais.procurar(numAni));

		} catch (AnimalInexistenteException ea) {
			ea.getMessage();
			// JOptionPane.showMessageDialog(null,null,"Animal
			// inexistente!!",JOptionPane.ERROR_MESSAGE);
		}
		try {
			String numUsu = v.getUsuario().getIdUsuario();
			v.setUsuario(usuarios.procurar(numUsu));
		} catch (UsuarioInexistenteException eu) {
			eu.getMessage();
			// JOptionPane.showMessageDialog(null,null,"Usuário
			// inexistente!!",JOptionPane.ERROR_MESSAGE);
		}

		return v;
	}

	public void removerVacinacao(String numero)
			throws VacinacaoInexistenteException, SQLException {
		vacinacoes.remover(numero);
	}

}