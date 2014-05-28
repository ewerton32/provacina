package br.com.provacBeta.propriedade;

import java.util.HashMap;

import br.com.provacBeta.animal.Animal;
import br.com.provacBeta.animal.AnimalExistenteException;
import br.com.provacBeta.animal.AnimalInexistenteException;
import br.com.provacBeta.animal.ColecaoAnimais;

public class ColecaoPropriedade implements RepositorioPropriedades {
	
private HashMap propriedades;
	
	private static ColecaoPropriedade instance;
	
	public ColecaoPropriedade() {
		propriedades = new HashMap <String, Propriedade>();
	}
	
	public synchronized static ColecaoPropriedade getInstance() {
		if (instance == null) {
			instance = new ColecaoPropriedade();
		} 
		return instance;
	}
     
	public boolean existe(String numero) {
		boolean achou = false;
		if (propriedades.containsKey(numero)) {
			achou = true;
		}
		return achou;
	}
	
	public void atualizar(Propriedade p) 
    throws PropriedadeInexistenteException {
		if (existe(p.getNumEscritura())) {
			propriedades.remove(p);
			propriedades.put(p.getNumEscritura(),p);
		} else {
			throw new PropriedadeInexistenteException("Propriedade nao encontrado");
		}
	}
	
	public void inserir(Propriedade p) throws PropriedadeExistenteException {
		if (!existe(p.getNumEscritura())) {
			propriedades.put(p.getNumEscritura(),p);
		} else {
			throw new PropriedadeExistenteException("Propriedade já cadastrado");
		}
	}
	
	public Propriedade procurar(String numero) throws PropriedadeInexistenteException {
		Propriedade p = null;
		if (existe(numero)) {
			p = (Propriedade) propriedades.get(numero);
		} else {
			throw new PropriedadeInexistenteException("Propriedade nao encontrado");
		}
		return p;
	}
	
	public void remover(String numero) throws PropriedadeInexistenteException {
		if (existe(numero)) {
			propriedades.remove(numero);
		} else {
			throw new PropriedadeInexistenteException("Animal nao encontrado");
		}
	}

}
