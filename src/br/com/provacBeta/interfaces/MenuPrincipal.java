package br.com.provacBeta.interfaces;


import java.sql.SQLException;

import br.com.provacBeta.animal.Animal;
import br.com.provacBeta.animal.AnimalExistenteException;
import br.com.provacBeta.animal.AnimalInexistenteException;
import br.com.provacBeta.fachada.Fachada;
import br.com.provacBeta.propriedade.Propriedade;
import br.com.provacBeta.propriedade.PropriedadeExistenteException;
import br.com.provacBeta.propriedade.PropriedadeInexistenteException;
import br.com.provacBeta.usuario.Usuario;
import br.com.provacBeta.usuario.UsuarioExistenteException;
import br.com.provacBeta.usuario.UsuarioInexistenteException;
import br.com.provacBeta.vacinacao.Vacinacao;
import br.com.provacBeta.vacinacao.VacinacaoExistenteException;
import br.com.provacBeta.vacinacao.VacinacaoInexistenteException;

public class MenuPrincipal {

	  static Fachada fachada = Fachada.obterInstancia();

	  public static void main(String[] args) {

	    int opcao = -1;


	    do{
	      opcao = TelasGerais.telaAcesso();
	      switch(opcao){
            case 1 : telaFuncionario();
	        case 2 : telaCriador();
	        case 3 : sair();
	        default : System.out.println("\nSaindo do sistema");
	      }
	    }while(opcao != 3);



	  }
	  
	  public static void telaCriador(){
		  int opcao = -1;

		    do{
		      opcao = TelasGerais.telaCriador();
		      switch(opcao){
		        case 1 : manipularAnimais();break;
		        case 2 : exibirPropriedades();break;
		        case 3 : exibirUsuarios();break;
		        case 4 : manipularVacinacoes();break;
		        case 5 : sair();
		        default : System.out.println("\nSaindo do sistema");
		      }
		    }while(opcao != 5);


	 }


	  public static void telaFuncionario(){
		  int opcao = -1;

		    do{
		      opcao = TelasGerais.telaFuncionario();
		      switch(opcao){

		        case 1 : manipularAnimais();break;
		        case 2 : manipularPropriedadesFunc();break;
		        case 3 : manipularUsuariosFunc();break;
		        case 4 : manipularVacinacoes();break;
		        case 5 : sair();
		        default : System.out.println("\nSaindo do sistema");
		      }
		    }while(opcao != 5);


	  }


	 

	  public static void exibirPropriedades(){
		  String numero;
		  Propriedade p = null;
		  numero = TelasPropriedades.lerNumEscrPropriedade();

		  try{
		  p = fachada.procurarPropriedade(numero);
		  TelasPropriedades.mostrarPropriedade(p);
		  }catch(PropriedadeInexistenteException ex){
			  System.out.println(ex.getMessage());
		  } catch (SQLException e) {
			
			e.printStackTrace();
		}
	  }


	  public static void exibirUsuarios(){

		  String numero;
		  Usuario u  = null;
		  numero = TelasUsuarios.lerId_Usuario();

		  try{
		  u = fachada.procurarUsuario(numero);
		  TelasUsuarios.mostrarUsuario(u);
		  }catch(UsuarioInexistenteException ex){
			  System.out.println(ex.getMessage());
		  } catch (SQLException e) {
			
			e.printStackTrace();
		}
	  }


	  public static void manipularAnimais(){
		    int opcao = -1;
		    do{
		      opcao = TelasAnimais.lerOpcaoAnimal();
		      switch(opcao){

		       case 1: //cadastrar novo animal
		          Animal novo = TelasAnimais.lerAnimal();
		          try{
		            try {
						fachada.inserirAnimal(novo);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
		          }catch(AnimalExistenteException ex){
		            System.out.println(ex.getMessage());
		          }
		          break;

		       case 2: //remover animal existente
		          String numRemover = TelasAnimais.lerNumAnimal();
		          try{
		            try {
						fachada.removerAnimal(numRemover);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
		          }catch(AnimalInexistenteException ex){
		            System.out.println(ex.getMessage());
		          }
		          break;

		       case 3: //atualizar animal existente
		          String numAnimal = TelasAnimais.lerNumAnimal();
		          Animal atualizar = null;
		          try{
		            try {
						atualizar = fachada.procurarAnimal(numAnimal);
					} catch (SQLException e) {						
						e.printStackTrace();
					}
		            TelasAnimais.mostrarAnimal(atualizar);
                    atualizar = TelasAnimais.lerAnimal();
		            try {
						fachada.atualizarAnimal(atualizar);
					} catch (SQLException e) {						
						e.printStackTrace();
					}
		          }catch(AnimalInexistenteException ex){
		            System.out.println(ex.getMessage());
		          }
		          break;

		       case 4: //procurar animal existente
		          String numProcurar = TelasAnimais.lerNumAnimal();
		          Animal proc = null;
		          try{
		            try {
						proc = fachada.procurarAnimal(numProcurar);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
		            TelasAnimais.mostrarAnimal(proc);
		          }catch(AnimalInexistenteException ex){
		            System.out.println(ex.getMessage());
		          }
		          break;

		       case 5: //retornar ao menu principal
		          break;

		        default: System.out.println("Opção invalida");
		      }
		    }while(opcao != 5);
		  }

	  public static void manipularPropriedadesFunc(){
	    int opcao = -1;
	    do{
	      opcao = TelasPropriedades.lerOpcaoPropriedades();
	      switch(opcao){
	        case 1: //cadastrar nova propriedade
	          Propriedade nova = TelasPropriedades.lerPropriedades();
	          try {
	            fachada.inserirPropriedade(nova);
	           }catch (PropriedadeExistenteException ex) {
	            System.out.println(ex.getMessage());
	           }
	          break;

	        case 2: //remover propriedade existente
	          String numEscritura = TelasPropriedades.lerNumEscrPropriedade();
	          try {
	            fachada.removerPropriedade(numEscritura);
	          }catch (PropriedadeInexistenteException ex) {
	            System.out.println(ex.getMessage());
	          }
	          break;


	        case 3: //atualizar propriedaede existente
	            String numEscrAtualizar = TelasPropriedades.lerNumEscrPropriedade();
	            Propriedade atualizar = null;
	            try{
	              atualizar = fachada.procurarPropriedade(numEscrAtualizar);
	              TelasPropriedades.mostrarPropriedade(atualizar);
	              atualizar = TelasPropriedades.lerPropriedades();
	              fachada.atualizarPropriedade(atualizar);
	            }catch(PropriedadeInexistenteException ex){
	              System.out.println(ex.getMessage());
	            } catch (SQLException e) {
					
					e.printStackTrace();
				}
	            break;

	        case 4: //procurar propriedade existente
	            String numProcurar = TelasPropriedades.lerNumEscrPropriedade();
	            Propriedade procurada = null;
	            try {
	               try {
					procurada = fachada.procurarPropriedade(numProcurar);
				} catch (SQLException e) {
					
					e.printStackTrace();
				}
	               TelasPropriedades.mostrarPropriedade(procurada);
	            }catch (PropriedadeInexistenteException ex) {
	               System.out.println(ex.getMessage());
	            }
	            break;

	        case 5: //retornar ao menu principal
	          break;

	        default: System.out.println("Opcao invalida");
	      }
	    }while(opcao != 5);
	  }

	  public static void manipularUsuariosFunc(){
		    int opcao = -1;
		    do{
		      opcao = TelasUsuarios.lerOpcaoUsuario();
		      switch(opcao){
		        case 1: //cadastrar novo usuário
		          Usuario novo = TelasUsuarios.lerUsuario();
		          try{
		            fachada.inserirUsuario(novo);
		          }catch(UsuarioExistenteException ex){
		            System.out.println(ex.getMessage());
		          } catch (SQLException e) {
					
					e.printStackTrace();
				}
		          break;

		        case 2: //remover usuario existente
		          String numRemover = TelasUsuarios.lerId_Usuario();
		          try{
		            fachada.removerUsuario(numRemover);
		          }catch(UsuarioInexistenteException ex){
		            System.out.println(ex.getMessage());
		          } catch (SQLException e) {
					
					e.printStackTrace();
				}
		          break;

		        case 3: //atualizar usuario existente
		          String numAtualizar = TelasUsuarios.lerId_Usuario();
		          Usuario atualizar = null;
		          try{
		            atualizar = fachada.procurarUsuario(numAtualizar);
		            TelasUsuarios.mostrarUsuario(atualizar);
		            atualizar = TelasUsuarios.lerUsuario();
		            fachada.atualizarUsuario(atualizar);
		          }catch(UsuarioInexistenteException ex){
		            System.out.println(ex.getMessage());
		          } catch (SQLException e) {
				
					e.printStackTrace();
				}
		          break;

		        case 4: //procurar usuario existente
		          String idUsuProcurar = TelasUsuarios.lerId_Usuario();
		          Usuario proc = null;
		          try{
		            proc = fachada.procurarUsuario(idUsuProcurar);
		            TelasUsuarios.mostrarUsuario(proc);
		          }catch(UsuarioInexistenteException ex){
		            System.out.println(ex.getMessage());
		          } catch (SQLException e) {
					
					e.printStackTrace();
				}
		          break;

		        case 5: //retornar ao menu principal
		          break;

		        default: System.out.println("Opcao invalida");
		      }
		    }while(opcao != 5);
		  }
	  public static void manipularVacinacoes(){
		    int opcao = -1;
		    do{
		      opcao = TelasVacinacoes.lerOpcaoVacinavao();
		      switch(opcao){
		        case 1: //cadastrar novo processo de vacinação
		        	Vacinacao novo = TelasVacinacoes.lerVacinacao();
		          try{
		            try {
						fachada.inserirVacinacao(novo);
					} catch (SQLException e) {
						
						e.printStackTrace();
					}
		          }catch(VacinacaoExistenteException ex){
		            System.out.println(ex.getMessage());
		          }
		          break;

		        case 2: //remover processo de vacinação existente
		          String numRemover = TelasVacinacoes.lerId_vacinacao();
		          try{
		            fachada.removerVacinacao(numRemover);
		          }catch(VacinacaoInexistenteException ex){
		            System.out.println(ex.getMessage());
		          } catch (SQLException e) {
					
					e.printStackTrace();
				}
		          break;

		        case 3: //atualizar processo de vacinação existente
		          String numAtualizar = TelasVacinacoes.lerId_vacinacao();
		          Vacinacao atualizar = null;
		          try{
		            try {
						atualizar = fachada.procurarVacinacao(numAtualizar);
					} catch (SQLException e) {						
						e.printStackTrace();
					}
		            TelasVacinacoes.mostrarVacinacao(atualizar);
		            atualizar = TelasVacinacoes.lerVacinacao();
		            fachada.atualizarVacinacao(atualizar);
		          }catch(VacinacaoInexistenteException ex){
		            System.out.println(ex.getMessage());
		          } catch (SQLException e) {					
					e.printStackTrace();
				}
		          break;

		        case 4: //procurar processo de vacinação existente
		          String idVacProcurar = TelasVacinacoes.lerId_vacinacao();
		          Vacinacao proc = null;
		          try{
		            try {
						proc = fachada.procurarVacinacao(idVacProcurar);
					} catch (SQLException e) {						
						e.printStackTrace();
					}
		            TelasVacinacoes.mostrarVacinacao(proc);
		          }catch(VacinacaoInexistenteException ex){
		            System.out.println(ex.getMessage());
		          }
		          break;

		        case 5: //retornar ao menu principal
		          break;

		        default: System.out.println("Opção invalida");
		      }
		    }while(opcao != 5);
		  }
	  public static void sair(){

	  }

}
