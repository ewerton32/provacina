package br.com.provacBeta.interfaces;
import br.com.provacBeta.util.Util;
public class TelasGerais {

	public static int telaAcesso(){
		int opcao=0;
		System.out.println("");
		System.out.println("+++++ SISTEMA PROVACINA +++++");
	    System.out.println("");
	    System.out.println("-----  TELA DE ACESSO  -----");
	    System.out.println("1 - Funcion�rio ");
	    System.out.println("2 - Criador ");
	    System.out.println("3 - Sair");
	    System.out.print("Escolha uma opcao: ");
	    try {
	    opcao = Util.readInt();
		} catch (Exception e) {
			e.getMessage();
			// TODO: handle exception
		}

		return opcao;

	}

	public static String identificarFuncion�rio(){
    	System.out.println("");
		System.out.println("+++++ SISTEMA PROVACINA +++++");
	    System.out.println("");
	    System.out.println("-----  TELA DE IDENTIFICA��O  -----");

	    System.out.print("Digite seu loguin: ");
	    String loguin = Util.readStr();
	    System.out.print("Digite seu Cpf: ");
	    System.out.print("Digite sua senha: ");
	    String senha = Util.readStr();
	    String cpf = Util.readStr();
	    String resp = loguin + senha + cpf;
	    return resp;

	}

    public static String IdentificarCriador(){
    	System.out.println("");
		System.out.println("+++++ SISTEMA PROVACINA +++++");
	    System.out.println("");
	    System.out.println("-----  TELA DE IDENTIFICA��O  -----");
	    System.out.print("Digite sua senha: ");
	    String senha = Util.readStr();
	    System.out.print("Digite seu loguin: ");
	    String loguin = Util.readStr();
	    return loguin + senha;


	}



	public static int telaFuncionario(){
		 int opcao = 0;
		System.out.println("");
		System.out.println("+++++ SISTEMA PROVACINA +++++");
	    System.out.println("");
	    System.out.println("-----  FUNCION�RIO  -----");
	    System.out.println("1 - Manipular dados de Animais ");
	    System.out.println("2 - Manipular dados de Propriedade ");
	    System.out.println("3 - Manipular dados de Usu�rios");
	    System.out.println("4 - Manipular dados de Vacina��es");
	    System.out.println("5 - Sair");
	    System.out.print("Escolha uma opcao: ");
	    try {
        	opcao = Util.readInt();
		} catch (Exception e) {
			System.out.println("\nOp��o invalida!");
			// TODO: handle exception
		}return opcao;
	}



    public static int telaCriador(){
    	int opcao=0;
    	System.out.println("");
	    System.out.println("+++++ SISTEMA PROVACINA +++++");
        System.out.println("");
        System.out.println("-----  CRIADOR  -----");
        System.out.println("1 - Manipular dados de Animais ");
        System.out.println("2 - Exibir Dados da Propriedade ");
        System.out.println("3 - Exibir Dados do Usu�rio");
        System.out.println("4 - Manipular dados de Vacina��es");
        System.out.println("5 - Sair");
        System.out.print("Escolha uma opcao: ");


        try {
        	opcao = Util.readInt();
		} catch (Exception e) {
			System.out.println("Op��o Invalida!");
			// TODO: handle exception
		}
    return opcao;
    }

}
