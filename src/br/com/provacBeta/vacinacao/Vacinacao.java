package br.com.provacBeta.vacinacao;

import br.com.provacBeta.animal.Animal;
import br.com.provacBeta.usuario.Usuario;
/**
 * @author      aluno
 */
public class Vacinacao {	
	
	//
	private String id_vacinacao;
	private Vacina vacina;
	private String dataVac;
	private Usuario usuario;
	private Animal animal;
	
	
	public Vacinacao(String id_vacinacao, String dataVac) {
		
		this.setId_vacinacao(id_vacinacao);
		this.setDataVac(dataVac);
		
		
	}
	public Vacinacao(String id_vacinacao, Vacina vacina, String dataVac, Usuario usuario, Animal animal) {
		
		this.setId_vacinacao(id_vacinacao);
		this.setVacina(vacina);
		this.setDataVac(dataVac);
		this.setUsuario(usuario);
		this.setAnimal(animal);
		
	}

	//Construtor adicionando o atributo de usuário;
	public Vacinacao(String id_vacinacao, Vacina vacina, String dataVac, Usuario usuario) {
		
		this.setId_vacinacao(id_vacinacao);
		this.setVacina(vacina);
		this.setDataVac(dataVac);
		this.setUsuario(usuario);
		
	}
	
	//Construtor simples;
	public Vacinacao(String id_vacinacao, Vacina vacina, String dataVac) {
		
		this.setId_vacinacao(id_vacinacao);
		this.setVacina(vacina);
		this.setDataVac(dataVac);
	}
	
	
	public String toString(){
		String resp;
		resp = "\n++++ VACINACÃO ++++\n" + 
		       "\nIDENTIFICAÇÃO: " + this.getId_vacinacao()+
		       "\nDATA: " + this.getDataVac()+
		       "" + this.getVacina()+
		       "" + this.getAnimal()+
		       "" + this.getUsuario();
		
		return resp;
	}
	
	public boolean equals(Object o){
		boolean resp = false;
		if(o instanceof Vacinacao){
			Vacinacao v = (Vacinacao)o;
			if(v.getId_vacinacao()==null && getId_vacinacao() == null || 
			   v.getId_vacinacao().equals(getId_vacinacao())){
				if(v.getDataVac() == null && getDataVac() == null ||
				    v.getDataVac().equals(getVacina())){
						if(v.getUsuario()==null && getUsuario()==null ||
						    v.getUsuario().equals(getUsuario())){
							if(v.getVacina()==null && getVacina()==null ||
								v.getVacina().equals(getVacina())){
								if(v.getAnimal() == null && getAnimal() == null ||
								    v.getAnimal().equals(getAnimal())){
									resp = true;	
								}								
						    }
				        }
				   }				
			  }			
		}return resp;
	}
	/**
	 * @return     Returns the dataVac.
	 */
	public String getDataVac() {
		return dataVac;
	}
	/**
	 * @param dataVac     The dataVac to set.
	 */
	public void setDataVac(String dataVac) {
		this.dataVac = dataVac;
	}
	/**
	 * @return     Returns the id_vacinacao.
	 */
	public String getId_vacinacao() {
		return id_vacinacao;
	}
	/**
	 * @param id_vacinacao     The id_vacinacao to set.
	 */
	public void setId_vacinacao(String id_vacinacao) {
		this.id_vacinacao = id_vacinacao;
	}
	/**
	 * @return     Returns the vacina.
	 */
	public Vacina getVacina() {
		return vacina;
	}
	/**
	 * @param vacina     The vacina to set.
	 */
	public void setVacina(Vacina vacina) {
		this.vacina = vacina;
	}


	
	/**
	 * @return    Returns the usuario.
	 */
	public Usuario getUsuario() {
		return usuario;
	}


	/**
	 * @param usuario    The usuario to set.
	 */
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}


	/**
	 * @return  Returns the animal.
	 */
	public Animal getAnimal() {
		return animal;
	}

	/**
	 * @param animal  The animal to set.
	 */
	public void setAnimal(Animal animal) {
		this.animal = animal;
	}


	
	
	

}
