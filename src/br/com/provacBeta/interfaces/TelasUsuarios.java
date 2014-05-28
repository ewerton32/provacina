package br.com.provacBeta.interfaces;



import javax.swing.JOptionPane;

import br.com.provacBeta.usuario.Usuario;
import br.com.provacBeta.util.Contato;
import br.com.provacBeta.util.Util;

public class TelasUsuarios {

	  public static int lerOpcaoUsuario(){
		int opcao = 0;
	  	System.out.println("");
	  	System.out.println("====== MENU FUNCION�RIO =====");
	    System.out.println("1 - Cadastrar ");
	    System.out.println("2 - Remover ");
	    System.out.println("3 - Atualizar ");
	    System.out.println("4 - Procurar ");
	    System.out.println("5 - Retornar ");
	    System.out.print("Escolha uma opcao: ");
	    try {
        	opcao = Util.readInt();
		} catch (Exception e) {
			System.out.println("Op��o Invalida!");
			// TODO: handle exception
		}


	    return opcao;
	  }
 	  public static Usuario lerUsuario(){
		Contato c;
		Usuario u;

		System.out.println("Digite o identificador do usu�rio: ");
	    String idUsuario = Util.readStr();
	    System.out.println("Digite o nome do usu�rio: ");
	    String nome = Util.readStr();
	    System.out.println("Digite o CPF do usu�rio: ");
	    String cpf = Util.readStr();
	    System.out.println("Digite o RG do usu�rio: ");
	    String rg = Util.readStr();
	    System.out.println("Digite a data de nascimento do usu�rio: ");
	    String dataNasc = Util.readStr();
	    System.out.println("Digite o login do usu�rio: ");
	    String login = Util.readStr();
	    System.out.println("digite a senha do usu�rio: ");
	    String senha = Util.readStr();
	    System.out.println("digite o tipo do usu�rio: ");
	    String tipo = Util.readStr();
	    //aquisi�� de valores para a vari�vel(Objeto) contato do do objeto Usu�rio
	    System.out.println("digite o telefone do usu�rio: ");
	    String telefone = Util.readStr();
	    System.out.println("digite o celular do usu�rio: ");
	    String celular = Util.readStr();
	    System.out.println("digite o email do usu�rio: ");
	    String email = Util.readStr();
	    System.out.println("digite o fax do usu�rio: ");
	    String fax = Util.readStr() ;
	    System.out.println("digite o pabx do usu�rio: ");
	    String pabx = Util.readStr();
	    System.out.println("digite a radioFrequncia do usu�rio: ");
	    String radioFrequencia = Util.readStr();



	    c = new Contato( telefone, celular, email, fax, pabx, radioFrequencia);
	    u = new Usuario(nome, idUsuario,cpf ,rg , tipo, login, senha, dataNasc, c);

	    return u;
	  }
	  public static String lerId_Usuario(){
		    System.out.print("Digite o identificador do usu�rio: ");
		    String idUsuario = Util.readStr();

		    return idUsuario;
		  }
	  public static String lerNomeUsuario(){
		    System.out.print("Digite o nome do usu�rio: ");
		    String nome = Util.readStr();

		    return nome;
		  }
	  public static String lerDatNascUsuario(){
	    System.out.print("Digite a data de nascimento do usu�rio: ");
	    String dataNasc = Util.readStr();

	    return dataNasc;
	  }
 	  public static String lerLoginUsuario(){
		    System.out.print("Digite o login do usu�rio: ");
		    String login = Util.readStr();

		    return login;
		  }
 	  public String lerSenhaUsuario(){
		    System.out.print("Digite a senha do Usu�rio: ");
		    String senha = Util.readStr();

		    return senha;
		  }
 	  public String lerTipoUsuario(){
		    System.out.print("Digite o tipo de Usu�rio: ");
		    String tipo = Util.readStr();

		    return tipo;
		  }
	  public String lerTelefoneUsuario(){
		    System.out.print("Digite a senha do Usu�rio: ");
		    String tel = Util.readStr();

		    return tel;
		  }
	  public String lerCelularUsuario(){
		    System.out.print("Digite a senha do Usu�rio: ");
		    String tel = Util.readStr();

		    return tel;
		  }
	  public String lerEmailUsuario(){
		    System.out.print("Digite a senha do Usu�rio: ");
		    String email = Util.readStr();

		    return email;
		  }
	  public String lerFaxUsuario(){
		    System.out.print("Digite a senha do Usu�rio: ");
		    String fax = Util.readStr();

		    return fax;
		  }
	  public String lerPabxUsuario(){
		    System.out.print("Digite a senha do Usu�rio: ");
		    String pabx = Util.readStr();

		    return pabx;
		  }
	  public String lerRadiofUsuario(){
		    System.out.print("Digite a senha do Usu�rio: ");
		    String rf = Util.readStr();

		    return rf;
		  }
	  public static void mostrarUsuario(Usuario u){
		  JOptionPane.showMessageDialog(null,u,"Dados do Usuario",JOptionPane.INFORMATION_MESSAGE);
		System.out.println(u);

	  }

}
