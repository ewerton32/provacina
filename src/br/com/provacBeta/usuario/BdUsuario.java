
package br.com.provacBeta.usuario;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import br.com.provacBeta.util.ConnectionManager;
import br.com.provacBeta.util.Contato;

public class BdUsuario implements RepositorioUsuarios{
	
	private static BdUsuario instance;
    private static Connection connection;
    private static Statement statement;

    private BdUsuario(){
    }

    public synchronized static BdUsuario getInstance() {
        if (instance == null) {
            instance = new BdUsuario();
        }
        return instance;
    }
       
    public void inserir(Usuario usuario) throws SQLException, UsuarioExistenteException {
        try {
        	if (this.existe(usuario.getIdUsuario())) {
        		throw new UsuarioExistenteException("BDProvacina => inserirUsuario  - Usuário já cadastrada: " + usuario.getIdUsuario());
        	}
            Statement statement = ConnectionManager.preparaStatement();
        	
            if (usuario != null) {
            	String a = "INSERT INTO TABELA_USUARIO VALUES( " + usuario.getIdUsuario() + 
                        ", '" + usuario.getNome()+"'"+                      
                        ", '" + usuario.getCpf()+"'"+
                        ", '" + usuario.getRg()+"'"+
                        ", '" + usuario.getTipo()+"'"+
                        ", '" + usuario.getLogin()+"'"+                       
                        ", '" + usuario.getSenha()+"'"+
            	        ", '" + usuario.getDataNasc()+"');";
            	
                statement.executeUpdate(a);
                System.out.println(a);
                }
        } catch (SQLException e) {
            throw new SQLException("BdUsuario => inserirUsuario: " + e);
	    }

    }

	public void remover(String numero) throws UsuarioInexistenteException, SQLException {
        try{
            Statement statement = ConnectionManager.preparaStatement();
		    int resultado = statement.executeUpdate("DELETE FROM TABELA_USUARIO WHERE NUMERO_USUARIO =" + numero );
		    if (resultado == 0) {
                throw new UsuarioInexistenteException("Usuário não cadastrado: " + numero);
            }
		} catch(SQLException e){
            throw new SQLException("BDUsuario => removerUsuario: " + e);
		} 
	}
	

	public Usuario procurar(String numeroUsuario) throws UsuarioInexistenteException, SQLException {
		Usuario usuario = null;
        try {
            Statement statement = ConnectionManager.preparaStatement();
            String a = "SELECT * FROM TABELA_USUARIO WHERE numero_usuario = " + numeroUsuario + ";";
            ResultSet resultset = statement.executeQuery(a);
            System.out.println(a);
            if (resultset.next()) {
            	usuario = new Usuario(resultset.getString("nome_usuario"),
            			              resultset.getString("numero_usuario"),
            			              resultset.getString("cpf_usuario"), 
            			              resultset.getString("rg_usuario"),            			              
            			              resultset.getString("tipo_usuario"), 
            			              resultset.getString("login_usuario"), 
            			              resultset.getString("senha_usuario"),
            			              resultset.getString("datanasc_usuario")
            			              );
            	
            } else {
                throw new UsuarioInexistenteException("Usuário não cadastrada: " + numeroUsuario);
            }
			resultset.close();
        } catch (SQLException e) {
			throw new SQLException("BDUsuario => procurarUsuario: " + e);
		} 
		return usuario;
	}

	public void atualizar(Usuario usuario) throws SQLException, UsuarioInexistenteException {
		
	    try {
    	    Statement statement = ConnectionManager.preparaStatement();
            if (usuario != null) {
            	
            	String a = "UPDATE TABELA_USUARIO SET nome_usuario = '" +usuario.getNome() + "'," +
                " numero_usuario = "+usuario.getIdUsuario() + "," +
                " cpf_usuario = '" + usuario.getCpf()+"',"+
                " rg_usuario = '" + usuario.getRg()+"',"+
                " tipo_usuario = '" + usuario.getTipo()+"',"+
                " login_usuario = '" + usuario.getLogin() +"',"+
                " senha_usuario = '" + usuario.getSenha()+"',"+
                " datanasc_usuario = '" + usuario.getDataNasc()+
                "' WHERE numero_usuario= " + usuario.getIdUsuario()+"";
            	
            	System.out.println(a);
                int resultado = statement.executeUpdate(a);
                if (resultado == 0) {
                    throw new UsuarioInexistenteException("Usuário não cadastrada: " + usuario.getIdUsuario());
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
            String a = "SELECT * FROM TABELA_USUARIO WHERE numero_usuario = " + numero + ";";
            System.out.println(a);
            ResultSet resultset = statement.executeQuery(a);
            resposta = resultset.next();
			resultset.close();
        } catch (SQLException e) {
			throw new SQLException("BDProvacina => existeUsuario: "+e);
		} 
        return resposta;
    }

    public RepositorioUsuarios getUsuario() throws SQLException, UsuarioExistenteException {
    	ArrayUsuarios resposta = new ArrayUsuarios();
        try {
            Statement statement = ConnectionManager.preparaStatement();
            ResultSet resultset = statement.executeQuery("SELECT * FROM TABELA_USUARIO");
            while (resultset.next()) {
            	Usuario usuario = new Usuario(resultset.getString("numero_usuario"), 
            			                      resultset.getString("nome_usuario"),
            			                      resultset.getString("cpf_usuario"), 
            			                      resultset.getString("rg_usuario"),
            			                      resultset.getString("tipo_usuario"), 
            			                      resultset.getString("login_usuario"), 
            			                      resultset.getString("senha_usuario"), 
            			                      resultset.getString("datanasc_usuario"),
            			                      null);
                resposta.inserir(usuario);
            }
			resultset.close();
        } catch (SQLException e) {
			throw new SQLException("BDUsuário => getUsuário: " + e);
		} finally {
			ConnectionManager.liberaRecursos();
		}
        return resposta;
    }
    
    public void liberaRecursos() {
		ConnectionManager.liberaRecursos();
	}	
    
    public static void main(String[] args) {
    	Contato c = new Contato("","","","","","");
    	Usuario usuarioTeste = new Usuario("CECA","433","fsdff","fsfdf","dfsdfds","fsdfsdf","sfdf","fdsds",c);
		
    	try {
			BdUsuario.getInstance().inserir(usuarioTeste);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (UsuarioExistenteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
