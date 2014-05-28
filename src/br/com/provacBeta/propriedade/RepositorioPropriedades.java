package br.com.provacBeta.propriedade;

import java.sql.SQLException;

public interface RepositorioPropriedades {
		
    //Métodos a serem implementados;
	public void inserir(Propriedade prop) throws PropriedadeExistenteException, SQLException ;
	
	public void remover(String numero) throws PropriedadeInexistenteException, SQLException ;
	
	public Propriedade procurar(String numero) throws PropriedadeInexistenteException, SQLException ;
    
	public void atualizar(Propriedade prop) throws PropriedadeInexistenteException, SQLException ;
    
	public boolean existe(String numero)throws SQLException ;


}
