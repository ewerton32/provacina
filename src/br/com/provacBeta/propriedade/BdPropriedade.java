package br.com.provacBeta.propriedade;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.provacBeta.fachada.Fachada;
import br.com.provacBeta.usuario.Usuario;
import br.com.provacBeta.usuario.UsuarioInexistenteException;
import br.com.provacBeta.util.ConnectionManager;
import br.com.provacBeta.util.Endereco;



public class BdPropriedade implements RepositorioPropriedades {
    private Fachada fachada;
	private static BdPropriedade instance;
    private static Connection connection;
    private static Statement statement;

    private BdPropriedade() {
    }

    public synchronized static BdPropriedade getInstance() {
        if (instance == null) {
            instance = new BdPropriedade();
        }
        return instance;
    }
       
    public void inserir(Propriedade propriedade) throws SQLException, PropriedadeExistenteException {
        try {
        	if (this.existe(propriedade.getNumEscritura())) {
        		throw new PropriedadeExistenteException("BDprovacina => inserirPropriedade  - Propriedade já cadastrada: " + propriedade.getNumEscritura());
        	}
            Statement statement = ConnectionManager.preparaStatement();
            if (propriedade != null) {
            	String a = "INSERT INTO Tabela_propriedade VALUES ("+ propriedade.getNumEscritura()+","+
                                                                  "'"+propriedade.getNome()+"',"+
                                                                      propriedade.getArea()+","+
                                                                      fachada.procurarUsuario(propriedade.getCriador().getIdUsuario())+");";
            	
                statement.executeUpdate(a);
                System.out.println(a);
            }
        } catch (SQLException e) {
            throw new SQLException("BDProvacinas => inserirPropriedade: " + e);
	    } catch (UsuarioInexistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

    }

	public void remover(String numero) throws PropriedadeInexistenteException, SQLException {
        try{
            Statement statement = ConnectionManager.preparaStatement();
		    int resultado = statement.executeUpdate("DELETE FROM CONTAS WHERE numero='" + numero + "'");
		    if (resultado == 0) {
                throw new PropriedadeInexistenteException("Conta não cadastrada: " + numero);
            }
		} catch(SQLException e){
            throw new SQLException("BDContas => removerConta: " + e);
		} 
	}

	public Propriedade procurar(String numero) throws PropriedadeInexistenteException, SQLException {
		Propriedade propriedade = null;
        try {
            Statement statement = ConnectionManager.preparaStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM CONTAS WHERE numero = '" + numero + "'");
            if (resultset.next()) {
            	propriedade = new Propriedade(resultset.getString("nome"),  resultset.getDouble("area"), resultset.getString("numeroEscritura"));
            } else {
                throw new PropriedadeInexistenteException("Conta não cadastrada: " + numero);
            }
			resultset.close();
        } catch (SQLException e) {
			throw new SQLException("BDContas => procurarConta: " + e);
		} 
		return propriedade;
	}

	public void atualizar(Propriedade propriedade) throws PropriedadeInexistenteException, SQLException {
	    try {
    	    Statement statement = ConnectionManager.preparaStatement();
            if (propriedade != null) {
                int resultado = statement.executeUpdate("UPDATE CONTAS SET saldo = " +
               	                                        " WHERE numero = '" + propriedade.getNumEscritura()+ "'");
                if (resultado == 0) {
                    throw new PropriedadeInexistenteException("Conta não cadastrada: " +propriedade.getNumEscritura());
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
            ResultSet resultset = statement.executeQuery("SELECT * FROM Tabela_propriedade WHERE numero_propriedade = " + numero );
            resposta = resultset.next();
			resultset.close();
        } catch (SQLException e) {
			throw new SQLException("BDContas => existeConta: "+e);
		} 
        return resposta;
    }

    public RepositorioPropriedades getPropriedades() throws SQLException, PropriedadeExistenteException {
    	ArrayPropriedades resposta = new ArrayPropriedades();
        try {
            Statement statement = ConnectionManager.preparaStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM CONTAS");
            while (resultset.next()) {
            	Propriedade propriedade = new Propriedade(resultset.getString("nome"), 
            		                   resultset.getDouble("area"),
                                       resultset.getString("numeroEscritura"));
                resposta.inserir(propriedade);
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
    public static void main(String[] args) {
    	Usuario usu = new Usuario("Ewerton","1234","1234","1234","1234","1234","1234","1234");
    	Endereco endereco = new Endereco("rua","numero","bairro","cep","cidade","estado","pais");
    	Propriedade propri = new Propriedade("Fazenda Nova",usu,usu.getIdUsuario(),5444,"1234");
		try {
			BdPropriedade.getInstance().inserir(propri);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (PropriedadeExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
    

}
