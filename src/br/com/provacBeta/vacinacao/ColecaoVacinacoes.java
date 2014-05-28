package br.com.provacBeta.vacinacao;

import java.util.HashMap;

public class ColecaoVacinacoes implements RepositorioVacinacoes{

	
private HashMap vacinacoes;
	
	private static ColecaoVacinacoes instance;
	
	public ColecaoVacinacoes() {
		vacinacoes = new HashMap <String, Vacinacao>();
	}
	
	public synchronized static ColecaoVacinacoes getInstance() {
		if (instance == null) {
			instance = new ColecaoVacinacoes();
		} 
		return instance;
	}
     
	public boolean existe(String numero) {
		boolean achou = false;
		if (vacinacoes.containsKey(numero)) {
			achou = true;
		}
		return achou;
	}
	
	public void atualizar(Vacinacao v) 
    throws VacinacaoInexistenteException {
		if (existe(v.getId_vacinacao())) {
			vacinacoes.remove(v);
			vacinacoes.put(v.getId_vacinacao(),v);
		} else {
			throw new VacinacaoInexistenteException("Vacinacao nao encontrado");
		}
	}
	
	public void inserir(Vacinacao v) throws VacinacaoExistenteException {
		if (!existe(v.getId_vacinacao())) {
			vacinacoes.put(v.getId_vacinacao(),v);
		} else {
			throw new VacinacaoExistenteException("Vacinacao já cadastrado");
		}
	}
	
	public Vacinacao procurar(String numero) throws VacinacaoInexistenteException {
		Vacinacao v = null;
		if (existe(numero)) {
			v = (Vacinacao) vacinacoes.get(numero);
		} else {
			throw new VacinacaoInexistenteException("Vacinacao nao encontrado");
		}
		return v;
	}
	
	public void remover(String numero) throws VacinacaoInexistenteException {
		if (existe(numero)) {
			vacinacoes.remove(numero);
		} else {
			throw new VacinacaoInexistenteException("Vacinacao nao encontrado");
		}
	}
	
	
	
}
