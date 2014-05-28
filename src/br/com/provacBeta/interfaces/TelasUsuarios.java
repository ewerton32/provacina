package br.com.provacBeta.interfaces;



import javax.swing.JOptionPane;

import br.com.provacBeta.usuario.Usuario;
import br.com.provacBeta.util.Contato;
import br.com.provacBeta.util.Util;

public class TelasUsuarios {

	  public static int lerOpcaoUsuario(){
		int opcao = 0;
	  	System.out.println("");
	  	System.out.println("====== MENU FUNCIONÁRIO =====");
	    System.out.println("1 - Cadastrar ");
	    System.out.println("2 - Remover ");
	    System.out.println("3 - Atualizar ");
	    System.out.println("4 - Procurar ");
	    System.out.println("5 - Retornar ");
	    System.out.print("Escolha uma opcao: ");
	    try {
        	opcao = Util.readInt();
		} catch (Exception e) {
			System.out.println("Opção Invalida!");
			// TODO: handle exception
		}


	    return opcao;
	  }
 	  public static Usuario lerUsuario(){
		Contato c;
		Usuario u;

		System.out.println("Digite o identificador do usuário: ");
	    String idUsuario = Util.readStr();
	    System.out.println("Digite o nome do usuário: ");
	    String nome = Util.readStr();
	    System.out.println("Digite o CPF do usuário: ");
	    String cpf = Util.readStr();
	    System.out.println("Digite o RG do usuário: ");
	    String rg = Util.readStr();
	    System.out.println("Digite a data de nascimento do usuário: ");
	    String dataNasc = Util.readStr();
	    System.out.println("Digite o login do usuário: ");
	    String login = Util.readStr();
	    System.out.println("digite a senha do usuário: ");
	    String senha = Util.readStr();
	    System.out.println("digite o tipo do usuário: ");
	    String tipo = Util.readStr();
	    //aquisiçã de valores para a variável(Objeto) contato do do objeto Usuário
	    System.out.println("digite o telefone do usuário: ");
	    String telefone = Util.readStr();
	    System.out.println("digite o celular do usuário: ");
	    String celular = Util.readStr();
	    System.out.println("digite o email do usuário: ");
	    String email = Util.readStr();
	    System.out.println("digite o fax do usuário: ");
	    String fax = Util.readStr() ;
	    System.out.println("digite o pabx do usuário: ");
	    String pabx = Util.readStr();
	    System.out.println("digite a radioFrequncia do usuário: ");
	    String radioFrequencia = Util.readStr();



	    c = new Contato( telefone, celular, email, fax, pabx, radioFrequencia);
	    u = new Usuario(nome, idUsuario,cpf ,rg , tipo, login, senha, dataNasc, c);

	    return u;
	  }
	  public static String lerId_Usuario(){
		    System.out.print("Digite o identificador do usuário: ");
		    String idUsuario = Util.readStr();

		    return idUsuario;
		  }
	  public static String lerNomeUsuario(){
		    System.out.print("Digite o nome do usuário: ");
		    String nome = Util.readStr();

		    return nome;
		  }
	  public static String lerDatNascUsuario(){
	    System.out.print("Digite a data de nascimento do usuário: ");
	    String dataNasc = Util.readStr();

	    return dataNasc;
	  }
 	  public static String lerLoginUsuario(){
		    System.out.print("Digite o login do usuário: ");
		    String login = Util.readStr();

		    return login;
		  }
 	  public String lerSenhaUsuario(){
		    System.out.print("Digite a senha do Usuário: ");
		    String senha = Util.readStr();

		    return senha;
		  }
 	  public String lerTipoUsuario(){
		    System.out.print("Digite o tipo de Usuário: ");
		    String tipo = Util.readStr();

		    return tipo;
		  }
	  public String lerTelefoneUsuario(){
		    System.out.print("Digite a senha do Usuário: ");
		    String tel = Util.readStr();

		    return tel;
		  }
	  public String lerCelularUsuario(){
		    System.out.print("Digite a senha do Usuário: ");
		    String tel = Util.readStr();

		    return tel;
		  }
	  public String lerEmailUsuario(){
		    System.out.print("Digite a senha do Usuário: ");
		    String email = Util.readStr();

		    return email;
		  }
	  public String lerFaxUsuario(){
		    System.out.print("Digite a senha do Usuário: ");
		    String fax = Util.readStr();

		    return fax;
		  }
	  public String lerPabxUsuario(){
		    System.out.print("Digite a senha do Usuário: ");
		    String pabx = Util.readStr();

		    return pabx;
		  }
	  public String lerRadiofUsuario(){
		    System.out.print("Digite a senha do Usuário: ");
		    String rf = Util.readStr();

		    return rf;
		  }
	  public static void mostrarUsuario(Usuario u){
		  JOptionPane.showMessageDialog(null,u,"Dados do Usuario",JOptionPane.INFORMATION_MESSAGE);
		System.out.println(u);

	  }

}
