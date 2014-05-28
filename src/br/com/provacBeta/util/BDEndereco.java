package br.com.provacBeta.util;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.provacBeta.animal.Animal;
import br.com.provacBeta.animal.AnimalExistenteException;
import br.com.provacBeta.animal.AnimalInexistenteException;
import br.com.provacBeta.animal.ArrayAnimais;
import br.com.provacBeta.animal.BdAnimal;
import br.com.provacBeta.animal.RepositorioAnimais;
import br.com.provacBeta.propriedade.Propriedade;

public class BDEndereco {
	private static BDEndereco instance;
    private static Connection connection;
    private static Statement statement;

    private BDEndereco() {
    	
    }

    public synchronized static BDEndereco getInstance() {
        if (instance == null) {
            instance = new BDEndereco();
        }
        return instance;
    }
       
    public void inserir(Animal animal) throws SQLException, AnimalExistenteException {
        try {
        	if (this.existe(animal.getNumero())) {
        		throw new AnimalExistenteException("BDAnimal => inserirAnimal  - Animal já cadastrado: " + animal.getNumero());
        	}
            Statement statement = ConnectionManager.preparaStatement();
            if (animal != null) {
            	int numeroAnimal = Integer.parseInt(animal.getNumero());
            	int numeroPropriedade = Integer.parseInt(animal.getPropriedade().getNumEscritura());
                statement.executeUpdate("INSERT INTO TABELA_ANIMAL VALUES ("  +numeroAnimal+"" +
                		                                                  ",'"+animal.getNome()+"'" +
                		                                                  ", "+numeroPropriedade+"," +
                		                                                  ",'"+animal.getDataNasc()+"'"+
                		                                                  ", "+animal.getPeso()+" "+
                		                                                  ",'"+animal.getFinalidade()+"')");
            }
        } catch (SQLException e) {
            throw new SQLException("BDContas => inserirConta: " + e);
	    }

    }

	public void remover(String numero) throws AnimalInexistenteException, SQLException {
        try{
            Statement statement = ConnectionManager.preparaStatement();
		    int resultado = statement.executeUpdate("DELETE FROM TABELA_ANIMAL WHERE NUMERO_ANIMAL = " + numero );
		    if (resultado == 0) {
                throw new AnimalInexistenteException("Animal não cadastrado: " + numero);
            }
		} catch(SQLException e){
            throw new SQLException("BDAnimais => removerAnimal: " + e);
		} 
	}

	public Animal procurar(String numero) throws AnimalInexistenteException, SQLException {
		Animal animal = null;
		Propriedade propriedade = null;
        try {
            Statement statement = ConnectionManager.preparaStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM TABELA_ANIMAL WHERE numero = '" + numero + "'");
            if (resultset.next()) {
            	propriedade = new Propriedade(null,00,"numero_escritura");
            	animal = new Animal(resultset.getString("numero_animal"),            			            
            			            resultset.getString("nome_animal"),
            			            (Propriedade)resultset.getObject(propriedade.getNumEscritura()),
            			            resultset.getString("dataNasc_animal"), 
            			            resultset.getDouble("peso_animal"), 
            			            resultset.getString("finalidade_animal"));
            } else {
                throw new AnimalInexistenteException("Animal não cadastrado: " + numero);
            }
			resultset.close();
        } catch (SQLException e) {
			throw new SQLException("BDContas => procurarConta: " + e);
		} 
		return animal;
	}

	public void atualizar(Animal animal) throws AnimalInexistenteException, SQLException {
	    try {
    	    Statement statement = ConnectionManager.preparaStatement();
            if (animal != null) {
                int resultado = statement.executeUpdate("UPDATE TABELA_ANIMAL SET nome_animal = " +
               	                                        " WHERE numero_animal = '" + animal.getNumero() + "'");
                if (resultado == 0) {
                    throw new AnimalInexistenteException("Conta não cadastrada: " +animal.getNumero());
                }
            }
        } catch (SQLException e) {
		    throw new SQLException("BDContas => atualizarConta: "+ e);
	    }
	}

	public boolean existe(String numero) throws SQLException {
        boolean resposta = false;
        try {
            Statement statement = ConnectionManager.preparaStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM CONTAS WHERE numero = '" + numero + "'");
            resposta = resultset.next();
			resultset.close();
        } catch (SQLException e) {
			throw new SQLException("BDContas => existeConta: "+e);
		} 
        return resposta;
    }

    public RepositorioAnimais getContas() throws SQLException, AnimalExistenteException {
    	ArrayAnimais resposta = new ArrayAnimais();
        try {
            Statement statement = ConnectionManager.preparaStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM CONTAS");
            while (resultset.next()) {
            Animal animal = new Animal(resultset.getString("numero"), 
            		                   resultset.getString("numero"),
            		                   resultset.getString("numero"),
                                       resultset.getDouble("saldo"),
                                       resultset.getString("numero"));
                resposta.inserir(animal);
            }
			resultset.close();
        } catch (SQLException e) {
			throw new SQLException("BDContas => getContas: " + e);
		} finally {
			ConnectionManager.liberaRecursos();
		}
        return resposta;
    }
    
    public void liberaRecursos() {
		ConnectionManager.liberaRecursos();
	}

}
