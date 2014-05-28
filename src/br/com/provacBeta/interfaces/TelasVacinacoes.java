package br.com.provacBeta.interfaces;


import javax.swing.JOptionPane;

import br.com.provacBeta.animal.Animal;
import br.com.provacBeta.fachada.Fachada;
import br.com.provacBeta.usuario.Usuario;
import br.com.provacBeta.util.Util;
import br.com.provacBeta.vacinacao.Vacina;
import br.com.provacBeta.vacinacao.Vacinacao;

/**
 * @author     aluno
 */
public class TelasVacinacoes {

	static Fachada fachada = Fachada.obterInstancia();

	  public static int lerOpcaoVacinavao(){
		int opcao = 0;
		System.out.println("");
	  	System.out.println("====== MENU VACINACÕES =====");
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
 	  public static Vacinacao lerVacinacao(){


		//aquisição de valores para a variável(Objeto) Vacinação
	    System.out.println("--INSIRA OS DADOS DA VACINAÇÃO --");
		System.out.println("Digite a identificação da vacinação: ");
	    String id_vacinacao = Util.readStr();
	    System.out.println("Digite a data da vacinação: ");
	    String dataVac = Util.readStr();

	    //aquisição de valores para a variável(Objeto) Vacina do objeto Vacinacao
	    System.out.println("digite o nome da vacina usada: ");
	    String nomeVac = Util.readStr();
	    System.out.println("digite a referência da vacina usada: ");
	    String referenciaVac = Util.readStr();
	    System.out.println("digite o lote da vacina usada: ");
	    String loteVac = Util.readStr();
	    System.out.println("digite a data de fabricação da vacina: ");
	    String dataFab = Util.readStr() ;
	    System.out.println("digite a data de validade da vacina: ");
	    String dataVal = Util.readStr();
	    System.out.println("digite a formula da vacina: ");
	    String formula = Util.readStr();






	    String idUsuario = TelasUsuarios.lerId_Usuario();
	    String numAnimal = TelasAnimais.lerNumAnimal();
	    Animal animal = new Animal(numAnimal, null, null, 00, null);
	    Usuario usuario = new Usuario(null, idUsuario, null, null, null, null, null);
	    Vacina vacina = new Vacina(nomeVac, referenciaVac, loteVac, dataFab, dataVal, formula);
	    Vacinacao vo = new Vacinacao(id_vacinacao, vacina, dataVac, usuario, animal);

	    return vo;
	  }
	  public static String lerId_vacinacao(){
		  System.out.println("Digite a identificação da vacinação: ");
		    String id_vacinacao = Util.readStr();

		    return id_vacinacao;
		  }
	  public static String lerDataVac(){
		  System.out.println("Digite a data da vacinação: ");
		    String dataVac = Util.readStr();

		    return dataVac;
		  }
	  public static String lerNomeVacina(){
		  System.out.println("digite o nome da vacina usada: ");
		    String nome = Util.readStr();

	    return nome;
	  }
 	  public static String lerRefVacina(){
 		 System.out.println("digite a referência da vacina usada: ");
 	    String referenciaVac = Util.readStr();

		    return referenciaVac;
		  }
 	  public String lerLoteVacina(){
 		 System.out.println("digite o lote da vacina usada: ");
 	     String loteVac = Util.readStr();

		    return loteVac;
		  }
 	  public String lerDataFabVacina(){
 		 System.out.println("digite a data de fabricação da vacina: ");
 	     String dataFab = Util.readStr() ;

		    return dataFab;
		  }
	  public String lerDataValVacina(){
		  System.out.println("digite a data de validade da vacina: ");
		    String dataVal = Util.readStr();

		    return dataVal;
		  }
	  public String lerFormulaVacina(){
		  System.out.println("digite a formula da vacina: ");
		    String formula = Util.readStr();

		    return formula;
		  }
	  public static void mostrarVacinacao(Vacinacao vo){
		JOptionPane.showMessageDialog(null,vo,"Dados da vacinacao",JOptionPane.INFORMATION_MESSAGE);
		System.out.println(vo);

	  }
}
