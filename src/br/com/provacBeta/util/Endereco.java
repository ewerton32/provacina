package br.com.provacBeta.util;

import br.com.provacBeta.propriedade.Propriedade;

/**
 * @author      aluno
 */
public class Endereco {
	private Propriedade propriedade;
	private String rua;
	private String numero;
	private String bairro;
	private String cep;
	private String cidade;
	private String estado;
	private String pais;
	
	// Construtor adicionando o atributo de tipo Propriedade; 
	public Endereco(Propriedade propriedade,String numEscreitura , String rua, String numero, String bairro, String cep, String cidade, String estado, String pais) {

		numEscreitura = propriedade.getNumEscritura();
		this.setRua(rua);
		this.setNumero(numero);
		this.setBairro(bairro);
		this.setCep(cep);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setPais(pais);
	}
	//Construtor simples da classe endereco;
	public Endereco(String rua, String numero, String bairro, String cep, String cidade, String estado, String pais) {
	
		this.setRua(rua);
		this.setNumero(numero);
		this.setBairro(bairro);
		this.setCep(cep);
		this.setCidade(cidade);
		this.setEstado(estado);
		this.setPais(pais);
	}
	/**
	 * @param inexistente
	 * @return String resp
	 */
	public String toString(){
		String resp;
		resp = "\n\n++++ ENDEREÇO ++++" + 
		       "\nRUA DA PROPRIEDADE: " + this.getRua() + 
		       "\nNUMERO DA PROPRIEDADE: " + this.getNumero() +
		       "\nBAIRRO DA PROPRIEDADE: " + this.getBairro() +
		       "\nCEP DA PROPRIEDADE: " + this.getCep() +
		       "\nCIDADE DA PROPRIEDADE: " + this.getCidade()+
		       "\nESTAO DA PROPRIEDADE: " + this.getEstado() +
		       "\nPAÍS DA PROPRIEDADE: " + this.getPais();
		return resp;
	}
	/**
	 * @return     Returns the bairro.
	 */
	public String getBairro() {
		return bairro;
	}
	/**
	 * @param bairro     The bairro to set.
	 */
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	/**
	 * @return     Returns the cep.
	 */
	public String getCep() {
		return cep;
	}
	/**
	 * @param cep     The cep to set.
	 */
	public void setCep(String cep) {
		this.cep = cep;
	}
	/**
	 * @return     Returns the cidade.
	 */
	public String getCidade() {
		return cidade;
	}
	/**
	 * @param cidade     The cidade to set.
	 */
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	/**
	 * @return     Returns the estado.
	 */
	public String getEstado() {
		return estado;
	}
	/**
	 * @param estado     The estado to set.
	 */
	public void setEstado(String estado) {
		this.estado = estado;
	}
	/**
	 * @return     Returns the numero.
	 */
	public String getNumero() {
		return numero;
	}
	/**
	 * @param numero     The numero to set.
	 */
	public void setNumero(String numero) {
		this.numero = numero;
	}
	/**
	 * @return     Returns the pais.
	 */
	public String getPais() {
		return pais;
	}
	/**
	 * @param pais     The pais to set.
	 */
	public void setPais(String pais) {
		this.pais = pais;
	}
	/**
	 * @return     Returns the rua.
	 */
	public String getRua() {
		return rua;
	}
	/**
	 * @param rua     The rua to set.
	 */
	public void setRua(String rua) {
		this.rua = rua;
	}
	/**
	 * @return     Returns the propriedade.
	 */
	public Propriedade getPropriedade() {
		return propriedade;
	}
	/**
	 * @param propriedade     The propriedade to set.
	 */
	public void setPropriedade(Propriedade propriedade) {
		this.propriedade = propriedade;
	}
	


}
