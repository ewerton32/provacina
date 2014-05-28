package br.com.provacBeta.vacinacao;

import java.util.Collection;
import java.util.Iterator;

/**
 * @author      Ewerton Otávio de Castro
 */
public class Vacina {
	
	private String referenciaVac;
	private String loteVac;
	private String dataFab;
	private String dataVal;
	private String formula;
	private String nome;
	
	
	public String toString(){
		String resp;
		resp = "\n\n+++++++ VACINA ++++++" + 
		       "\nNOME: " + this.getNome() + 
		       "\nREFERÊNCIA: " + this.getReferenciaVac() +
		       "\nLOTE: " + this.getLoteVac() +
		       "\nFÓRMULA: " + this.getFormula() +
		       "\nDATA DE FABRICAÇÃO: "+ this.getDataFab() +
		       "\nDATA DE VALIDADE: " +getDataVal();
		return resp;
	}
	
	
	
	
	/**
	 * @return     Returns the dataFab.
	 */
	public String getDataFab() {
		return dataFab;
	}
	/**
	 * @param dataFab     The dataFab to set.
	 */
	public void setDataFab(String dataFab) {
		this.dataFab = dataFab;
	}
	/**
	 * @return     Returns the dataVal.
	 */
	public String getDataVal() {
		return dataVal;
	}
	/**
	 * @param dataVal     The dataVal to set.
	 */
	public void setDataVal(String dataVal) {
		this.dataVal = dataVal;
	}
	/**
	 * @return     Returns the formula.
	 */
	public String getFormula() {
		return formula;
	}
	/**
	 * @param formula     The formula to set.
	 */
	public void setFormula(String formula) {
		this.formula = formula;
	}
	/**
	 * @return     Returns the loteVac.
	 */
	public String getLoteVac() {
		return loteVac;
	}
	/**
	 * @param loteVac     The loteVac to set.
	 */
	public void setLoteVac(String loteVac) {
		this.loteVac = loteVac;
	}
	/**
	 * @return     Returns the referenciaVac.
	 */
	public String getReferenciaVac() {
		return referenciaVac;
	}
	/**
	 * @param referenciaVac     The referenciaVac to set.
	 */
	public void setReferenciaVac(String referenciaVac) {
		this.referenciaVac = referenciaVac;
	}
	public Vacina(String nome, String referenciaVac, String loteVac, String dataFab, String dataVal, String formula) {
		super();
		this.setReferenciaVac(referenciaVac);
		this.setDataFab(dataFab);
		this.setDataVal(dataVal);
		this.setFormula(formula);
		this.setNome(nome);
	}
	/**
	 * @return     Returns the nome.
	 */
	public String getNome() {
		return nome;
	}
	/**
	 * @param nome     The nome to set.
	 */
	public void setNome(String nome) {
		this.nome = nome;
	}
	/**
	 */
	private Vacinacao vacinacao = null;


	/**
	 * Getter of the property <tt>vacinacao</tt>
	 * @return     Returns the vacinacao.
	 */
	public Vacinacao getVacinacao() {
		return vacinacao;
	}




	/**
	 * Setter of the property <tt>vacinacao</tt>
	 * @param vacinacao     The vacinacao to set.
	 */
	public void setVacinacao(Vacinacao vacinacao) {
		this.vacinacao = vacinacao;
	}
	/**
	 */
	private Collection vacinacao1;


	/**
	 * Getter of the property <tt>vacinacao1</tt>
	 * @return   Returns the vacinacao1.
	 */
	public Collection getVacinacao1() {
		return vacinacao1;
	}




	/**
	 * Setter of the property <tt>vacinacao1</tt>
	 * @param vacinacao1   The vacinacao1 to set.
	 */
	public void setVacinacao1(Collection vacinacao1) {
		this.vacinacao1 = vacinacao1;
	}
	

}
