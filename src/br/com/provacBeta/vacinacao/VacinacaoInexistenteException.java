package br.com.provacBeta.vacinacao;

public class VacinacaoInexistenteException extends Exception{
	public VacinacaoInexistenteException(String msg){
		super(msg);
	}
}
