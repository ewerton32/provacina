package br.com.provacBeta.interfaces;

import javax.swing.JOptionPane;

import br.com.provacBeta.propriedade.Propriedade;
import br.com.provacBeta.usuario.Usuario;
import br.com.provacBeta.util.Endereco;
import br.com.provacBeta.util.Util;

public class TelasPropriedades {

	  public static int lerOpcaoPropriedades(){
		int opcao = 0;
	  	System.out.println("");
	  	System.out.println("====== MENU PROPRIEDADES =====");
	    System.out.println("1 - Cadastrar ");
	    System.out.println("2 - Remover ");
	    System.out.println("3 - Atualizar ");
	    System.out.println("4 - Procurar ");
	    System.out.println("5 - Retornar ");
	    System.out.print("Escolha uma opcao: ");
	    try {
        	opcao = Util.readInt();
		} catch (Exception e) {
			System.out.println("\nOpção Invalida!");
			
		}
	    return opcao;
	  }
 	  public static Propriedade lerPropriedades(){



		System.out.println("");
		System.out.println("Preencha os dados da propriedade");
		System.out.println("");
		System.out.println("Digite o numero da escritura da propriedade: ");
	    String numEscritura = Util.readStr();
	    System.out.println("Digite o nome da propriedade: ");
	    String nome = Util.readStr();
	    System.out.println("Digite a área da propriedade: ");
	    double area = Util.readDbl();

	    //aquisição de valores para a variável(Objeto) endereço do objeto Propriedade
	    System.out.println("");
	    System.out.println("Preencha os dados do endereço da propriedade");
	    System.out.println("");
	    System.out.println("digite a rua da propriedade: ");
	    String rua = Util.readStr();
	    System.out.println("digite o numero da propriedade: ");
	    String numero = Util.readStr();
	    System.out.println("digite o bairro da propriedade: ");
	    String bairro = Util.readStr();
	    System.out.println("digite a cidade da propriedade: ");
	    String cidade = Util.readStr() ;
	    System.out.println("digite o cep da propriedade: ");
	    String cep = Util.readStr();
	    System.out.println("digite o estado da propriedade: ");
	    String estado = Util.readStr();
	    System.out.println("digite o país da propriedade: ");
	    String pais = Util.readStr();

	    String idUsuario = TelasUsuarios.lerId_Usuario();
	    Endereco e = new Endereco( rua, numero, bairro,cep, cidade, estado, pais );
	    Usuario u = new Usuario(null, idUsuario, null, null, null, null, null);
	    Propriedade p = new Propriedade( nome, e, u, area, numEscritura);

	    return p;
	  }
	  public static String lerNumEscrPropriedade(){
		    System.out.print("Digite o numero da escritura da propriedade: ");
		    String numEscritura = Util.readStr();

		    return numEscritura;
		  }
	  public static String lerNomePropriedade(){
		    System.out.print("Digite o nome da propriedade: ");
		    String nome = Util.readStr();

		    return nome;
		  }
	  public static double lerAreaPropriedade(){
	         System.out.print("Digite a data de nascimento do usuário: ");
	         double area = Util.readDbl();

	         return area;
	  }
	  public static String lerRuaPropriedade(){
		    System.out.print("Digite o nome da rua da propriedade: ");
		    String rua = Util.readStr();

		    return rua;
		  }
	  public String lerNumeroPropriedade(){
		    System.out.print("Digite o numero da propriedade: ");
		    String numero = Util.readStr();

		    return numero;
		  }
	  public String lerBairroPropriedade(){
		    System.out.print("Digite o tipo de Usuário: ");
		    String bairro = Util.readStr();

		    return bairro;
		  }
	  public String lerCepPropriedade(){
		    System.out.print("Digite o CEP da propriedade: ");
		    String cep = Util.readStr();

		    return cep;
		  }
	  public String lerEstadoPropriedade(){
		    System.out.print("Digite o estado de localização da propriedade: ");
		    String estado= Util.readStr();

		    return estado;
		  }
	  public String lerPaisPropriedade(){
		    System.out.print("Digite o país de localização da propriedade: ");
		    String pais = Util.readStr();

		    return pais;
		  }

	  public static void mostrarPropriedade(Propriedade p){
		  JOptionPane.showMessageDialog(null,p,"Dados da propriedade:",JOptionPane.INFORMATION_MESSAGE);
		  System.out.println(p);

	   }

}
