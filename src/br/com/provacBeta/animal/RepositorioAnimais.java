package br.com.provacBeta.animal;

import java.sql.SQLException;



public interface RepositorioAnimais {
	
	
	public void inserir(Animal ani) throws SQLException, AnimalExistenteException;

	public void remover(String numero) throws SQLException, AnimalInexistenteException;

	public Animal procurar(String numero) throws SQLException, AnimalInexistenteException;

    public void atualizar(Animal ani) throws SQLException, AnimalInexistenteException;

    public boolean existe(String numero) throws  SQLException;
}
