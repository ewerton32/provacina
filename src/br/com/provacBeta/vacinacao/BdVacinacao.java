package br.com.provacBeta.vacinacao;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.provacBeta.propriedade.ArrayPropriedades;
import br.com.provacBeta.propriedade.Propriedade;
import br.com.provacBeta.propriedade.PropriedadeExistenteException;
import br.com.provacBeta.propriedade.RepositorioPropriedades;
import br.com.provacBeta.usuario.Usuario;
import br.com.provacBeta.usuario.UsuarioExistenteException;
import br.com.provacBeta.usuario.UsuarioInexistenteException;
import br.com.provacBeta.util.ConnectionManager;

public class BdVacinacao implements RepositorioVacinacoes{
	private static BdVacinacao instance;
    private static Connection connection;
    private static Statement statement;

    private BdVacinacao(){
    }

    public synchronized static BdVacinacao getInstance() {
        if (instance == null) {
            instance = new BdVacinacao();
        }
        return instance;
    }
       
    public void inserir(Vacinacao vac) throws SQLException, VacinacaoExistenteException {
        try {
        	if (this.existe(vac.getId_vacinacao())) {
        		throw new VacinacaoExistenteException("BDContas => inserirConta  - Conta já cadastrada: " + vac.getId_vacinacao());
        	}
            Statement statement = ConnectionManager.preparaStatement();
            if (vac != null) {
                statement.executeUpdate("INSERT INTO propriedade VALUES ('" +
                                         ")");
            }
        } catch (SQLException e) {
            throw new SQLException("BDContas => inserirConta: " + e);
	    }

    }

	public void remover(String numero) throws  SQLException, VacinacaoInexistenteException {
        try{
            Statement statement = ConnectionManager.preparaStatement();
		    int resultado = statement.executeUpdate("DELETE FROM CONTAS WHERE numero='" + numero + "'");
		    if (resultado == 0) {
                throw new VacinacaoInexistenteException("Conta não cadastrada: " + numero);
            }
		} catch(SQLException e){
            throw new SQLException("BDContas => removerConta: " + e);
		} 
	}

	public Vacinacao procurar(String numero) throws SQLException, VacinacaoInexistenteException{
		Vacinacao vacinacao = null;
        try {
            Statement statement = ConnectionManager.preparaStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM CONTAS WHERE numero = '" + numero + "'");
            if (resultset.next()) {
            	vacinacao = new Vacinacao(resultset.getString("idVacinacao"), resultset.getString("dataVacinacao")); 
            			              
            } else {
                throw new VacinacaoInexistenteException("Conta não cadastrada: " + numero);
            }
			resultset.close();
        } catch (SQLException e) {
			throw new SQLException("BDContas => procurarConta: " + e);
		} 
		return vacinacao;
	}

	public void atualizar(Vacinacao vacinacao) throws  SQLException, VacinacaoInexistenteException {
		
	    try {
    	    Statement statement = ConnectionManager.preparaStatement();
            if (vacinacao != null) {
                int resultado = statement.executeUpdate("UPDATE CONTAS SET saldo = " +
               	                                        " WHERE numero = '" + vacinacao.getId_vacinacao()+ "'");
                if (resultado == 0) {
                    throw new VacinacaoInexistenteException("Conta não cadastrada: " + vacinacao.getId_vacinacao());
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

	

	

}
