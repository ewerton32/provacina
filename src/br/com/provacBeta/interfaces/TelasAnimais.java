package br.com.provacBeta.interfaces;

import javax.swing.JOptionPane;

import br.com.provacBeta.animal.Animal;
import br.com.provacBeta.fachada.Fachada;
import br.com.provacBeta.propriedade.Propriedade;
import br.com.provacBeta.util.Util;

/**
 * @author     aluno
 */
public class TelasAnimais {



	static Fachada fachada = Fachada.obterInstancia();

	  public static int lerOpcaoAnimal(){
		int opcao = 0 ;
	  	System.out.println("");
	  	System.out.println("====== MENU ANIMAIS =====");
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
			// TODO: handle exception
		}

	    return opcao;
	  }
	  public static Animal lerAnimal(){


		//Aquisição de dados
	    System.out.println("Digite o numero do animal: ");
	    String numero = Util.readStr();
	    System.out.println("Digite o nome do animal: ");
	    String nome = Util.readStr();
	    System.out.println("Digite a data de nascimento do animal:");
	    String dataNasc = Util.readStr();
	    System.out.println("Digite o peso do animal:");
	    double peso = Util.readDbl();
	    System.out.println("Especifique a finalidade do animal");
	    String finalidade = Util.readStr();

	    String numPropriedade = TelasPropriedades.lerNumEscrPropriedade();
	    Propriedade p = new Propriedade(null,null,0,numPropriedade);
	    Animal a = new Animal(numero, nome, p, dataNasc, peso, finalidade);


	       return a;

	  }

	  public static String lerNumAnimal(){
		    System.out.print("Digite o numero do animal: ");
		    String num = Util.readStr();

		    return num;
		  }
	  public static String lerNomeAnimal(){
		    System.out.print("Digite o nome do Animal: ");
		    String nome = Util.readStr();

		    return nome;
		  }


	  public static String lerDatNascAnimal(){
	    System.out.print("Digite a data de nascimento do Animal: ");
	    String dataNasc = Util.readStr();

	    return dataNasc;
	  }
	  public static String lerFinalAnimal(){
		    System.out.print("Digite a finalidade do Animal: ");
		    String dataNasc = Util.readStr();

		    return dataNasc;
		  }
	  public static double lerPesoAnimal(){
		    System.out.print("Digite o nome do Animal: ");
		    double peso = Util.readDbl();

		    return peso;
		  }
	  public static void mostrarAnimal(Animal a){
		JOptionPane.showMessageDialog(null,a,"Dados do Animal",JOptionPane.INFORMATION_MESSAGE);
		System.out.println(a);

	  }
}
