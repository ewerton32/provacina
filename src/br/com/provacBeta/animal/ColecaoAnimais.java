package br.com.provacBeta.animal;

import java.util.HashMap;

public class ColecaoAnimais implements RepositorioAnimais{
	
	private HashMap animais;
	
	private static ColecaoAnimais instance;
	
	public ColecaoAnimais() {
		animais = new HashMap <String, Animal>();
	}
	
	public synchronized static ColecaoAnimais getInstance() {
		if (instance == null) {
			instance = new ColecaoAnimais();
		} 
		return instance;
	}
     
	public boolean existe(String numero) {
		boolean achou = false;
		if (animais.containsKey(numero)) {
			achou = true;
		}
		return achou;
	}
	
	public void atualizar(Animal a) 
    throws AnimalInexistenteException {
		if (existe(a.getNumero())) {
			animais.remove(a);
			animais.put(a.getNumero(),a);
		} else {
			throw new AnimalInexistenteException("Animal nao encontrado");
		}
	}
	
	public void inserir(Animal a) throws AnimalExistenteException {
		if (!existe(a.getNumero())) {
			animais.put(a.getNumero(),a);
		} else {
			throw new AnimalExistenteException("Animal já cadastrado");
		}
	}
	
	public Animal procurar(String numero) throws AnimalInexistenteException {
		Animal a = null;
		if (existe(numero)) {
			a = (Animal) animais.get(numero);
		} else {
			throw new AnimalInexistenteException("Animal nao encontrado");
		}
		return a;
	}
	
	public void remover(String numero) throws AnimalInexistenteException {
		if (existe(numero)) {
			animais.remove(numero);
		} else {
			throw new AnimalInexistenteException("Animal nao encontrado");
		}
	}
}
