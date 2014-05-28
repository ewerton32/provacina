package br.com.provacBeta.vacinacao;

import br.com.provacBeta.fachada.Fachada;

import java.sql.SQLException;
import java.util.Collection;


public interface RepositorioVacinacoes {
	public void inserir(Vacinacao vac) throws SQLException, VacinacaoExistenteException;

	public void remover(String id_vacinacao) throws SQLException, VacinacaoInexistenteException;

	public Vacinacao procurar(String id_vacinacao) throws SQLException, VacinacaoInexistenteException;

    public void atualizar(Vacinacao vac) throws SQLException, VacinacaoInexistenteException;

    public boolean existe(String id_vacinacao)throws SQLException;

}
