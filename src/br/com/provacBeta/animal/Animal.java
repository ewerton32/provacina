package br.com.provacBeta.animal;

import br.com.provacBeta.propriedade.Propriedade;

/**
 * @author      aluno
 */
public class Animal {

	/**
	 * @author Ewerton Otavio de Castro Souto
	 * @category Sistem de Acompanhamento de Rebanho Bovino --- ProVac
	 * @classe Classe básica Animal;	 *
	 */
	
	private String numero;
	private String nome;
	private Propriedade propriedade;
	private String dataNasc;
    private double peso;
    private String finalidade;
    
    
    public String toString(){
    	String resp;
    	resp = "\n++++ DADOS DO ANIMAL ++++" + 
    	       "\nNOME: " + this.getNome() +
    	       "\nNUMERO: " + this.getNumero() +
    	       "\nDATA DE NASCIMENTO: " + this.getDataNasc() +
    	       "\nPESO: " + this.getPeso()+ " Kgs"+
    	       "\nFINALIDADE: " + this.getFinalidade()+
    	       "" + this.getPropriedade();
        return resp;    	
    }
    
    //Construtore adicionando um atributo tipo propriedade
	public Animal(String numero, String nome, Propriedade propriedade, String dataNasc, double peso, String finalidade) {
		
		this.setNumero(numero);
		this.setNome(nome);
		this.setPropriedade(propriedade);
		this.setDataNasc(dataNasc);
		this.setPeso(peso);
		this.setFinalidade(finalidade);
	}

    //Construtor comum 
	public Animal(String numero, String nome, String dataNasc, double peso, String finalidade) {
	
	
		this.setNumero(numero);
		this.setNome(nome);
		this.setDataNasc(dataNasc);
		this.setPeso(peso);
		this.setFinalidade(finalidade);
	}
	
	
	/**
	 * @return     Returns the dataNasc.
	 */
	public String getDataNasc() {
		return dataNasc;
	}
	/**
	 * @param dataNasc     The dataNasc to set.
	 */
	public void setDataNasc(String dataNasc) {
		this.dataNasc = dataNasc;
	}
	/**
	 * @return     Returns the finalidade.
	 */
	public String getFinalidade() {
		return finalidade;
	}
	/**
	 * @param finalidade     The finalidade to set.
	 */
	public void setFinalidade(String finalidade) {
		this.finalidade = finalidade;
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
	 * @return     Returns the peso.
	 */
	public double getPeso() {
		return peso;
	}
	/**
	 * @param peso     The peso to set.
	 */
	public void setPeso(double peso) {
		try {
			this.peso = peso;	
		} catch (Exception e) {
			System.out.println("Peso invalido!");
			// TODO: handle exception
		}
		
		
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
	 * @return    Returns the propriedade.
	 */
	public Propriedade getPropriedade() {
		return propriedade;
	}


	/**
	 * @param propriedade    The propriedade to set.
	 */
	public void setPropriedade(Propriedade propriedade) {
		this.propriedade = propriedade;
	}
	
	
    

}
