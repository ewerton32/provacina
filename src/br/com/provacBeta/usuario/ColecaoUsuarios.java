package br.com.provacBeta.usuario;

import java.util.HashMap;

import br.com.provacBeta.util.Contato;

public class ColecaoUsuarios implements RepositorioUsuarios{

    private HashMap usuarios;
    
	private static ColecaoUsuarios instance;
	
	
	
	public ColecaoUsuarios() {
		usuarios = new HashMap <String, Usuario>();
	}
	
	public synchronized static ColecaoUsuarios getInstance() {
		if (instance == null) {
			instance = new ColecaoUsuarios();
		} 
		return instance;
	}
     
	public boolean existe(String numero) {
		boolean achou = false;
		if (usuarios.containsKey(numero)) {
			achou = true;
		}
		return achou;
	}
	
	public void atualizar(Usuario u) 
    throws UsuarioInexistenteException {
		if (existe(u.getIdUsuario())) {
			usuarios.remove(u);
			usuarios.put(u.getIdUsuario(),u);
		} else {
			throw new UsuarioInexistenteException("Usuário nao encontrado");
		}
	}
	
	public void inserir(Usuario u) throws UsuarioExistenteException {
		
		if (!existe(u.getIdUsuario())) {
			usuarios.put(u.getIdUsuario(),u);
		} else {
			throw new UsuarioExistenteException("Usuário já cadastrado");
		}
	}
	
	public Usuario procurar(String numero) throws UsuarioInexistenteException {
		Usuario u = null;
		if (existe(numero)) {
			u = (Usuario) usuarios.get(numero);
		} else {
			throw new UsuarioInexistenteException("Usuário nao encontrado");
		}
		return u;
	}
	
	public void remover(String numero) throws UsuarioInexistenteException {
		if (existe(numero)) {
			usuarios.remove(numero);
		} else {
			throw new UsuarioInexistenteException("Usuário não encontrado");
		}
	}
	
}
