package br.com.provacBeta.usuario;

import java.sql.SQLException;

public interface RepositorioUsuarios {
	
    //Métodos a serem implementados;	
	public void inserir(Usuario usa)throws SQLException, UsuarioExistenteException;
	public void remover(String id_usuario) throws SQLException, UsuarioInexistenteException;
	public Usuario procurar(String id_usuario)throws SQLException, UsuarioInexistenteException;
	public void atualizar(Usuario usu)throws SQLException, UsuarioInexistenteException;
	public boolean existe(String id_usuario)throws SQLException;
		
	
	

}
