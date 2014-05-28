package br.com.provacBeta.util;

import br.com.provacBeta.usuario.Usuario;

/**
 * @author      Ewerton Otávio de Castro
 */


public class Contato {
	
	private Usuario usuario;
	private String telefone;
	private String celular;
	private String email;
	private String fax;
	private String pabx;
	private String radioFrequncia;
		
	//Construtor da classe Contato adicionando atributo dp tipo Usuário
	public Contato(Usuario usuario, String telefone, String celular, String email, String fax, String pabx, String radioFrequncia) {
		this.setUsuario(usuario);
		this.setTelefone(telefone);
		this.setCelular(celular);
		this.setEmail(email);
		this.setFax(fax);
		this.setPabx(pabx);
		this.setRadioFrequncia(radioFrequncia);
	}
	
    public String toString(){
    	String resp;
    	
    	resp = "\n\n++++++ CONTATO ++++++ " +
    		   "\nTELEFONE DO USUÁRIO:  " + this.getTelefone()+
    	       "\nCELULAR DO USUÁRIO:  " +this.getCelular()+
    	       "\nE-MAIL DO USUÁRIO: " +this.getEmail()+
    	       "\nFAX DO USUÁRIO: " +this.getFax()+
    	       "\nPABX DO USUÁRIO: " +this.getPabx()+
    	       "\nFREQUÊNCIA DE RADIO DO USUÁRIO: " +this.getRadioFrequncia();
    	return resp; 	
		
	}
	
    public boolean equals(Object obj){
    	boolean resp = false;
    	if(obj instanceof Contato){
    		Contato c = (Contato)obj;
    		if(c.getTelefone()==null && getTelefone()==null ||
    		   c.getTelefone() == getTelefone()){
    			if(c.getCelular() == null && getCelular() == null ||
    				c.getCelular() == getCelular()){
    				if(c.getEmail() == null && getEmail() == null ||
    				    c.getEmail()==getEmail()){
    					if(c.getFax() == null && getFax() == null ||
    					    c.getFax() == getFax()){
    						resp = true;
    					}
    				 }    				
    		     }
    		}
    	}return resp;
    }
	/**
	 * @return     Returns the celular.
	 */
	public String getCelular() {
		return celular;
	}
	/**
	 * @param celular     The celular to set.
	 */
	public void setCelular(String celular) {
		this.celular = celular;
	}
	/**
	 * @return     Returns the email.
	 */
	public String getEmail() {
		return email;
	}
	/**
	 * @param email     The email to set.
	 */
	public void setEmail(String email) {
		this.email = email;
	}
	/**
	 * @return     Returns the fax.
	 */
	public String getFax() {
		return fax;
	}
	/**
	 * @param fax     The fax to set.
	 */
	public void setFax(String fax) {
		this.fax = fax;
	}
	/**
	 * @return     Returns the pabx.
	 */
	public String getPabx() {
		return pabx;
	}
	/**
	 * @param pabx     The pabx to set.
	 */
	public void setPabx(String pabx) {
		this.pabx = pabx;
	}
	public String getRadioFrequencia() {
		return radioFrequncia;
	}
	public void setRadioFrequencia(String radioFrequncia) {
		this.radioFrequncia = radioFrequncia;
	}
	/**
	 * @return     Returns the telefone.
	 */
	public String getTelefone() {
		return telefone;
	}
	/**
	 * @param telefone     The telefone to set.
	 */
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
	public Contato(String telefone, String celular, String email, String fax, String pabx, String radioFrequncia) {
	
		this.setTelefone(telefone);
		this.setCelular(celular);
		this.setEmail(email);
		this.setFax(fax);
		this.setPabx(pabx);
		this.setRadioFrequencia(radioFrequncia);
	}
	/**
	 * @return    Returns the radioFrequncia.
	 */
	public String getRadioFrequncia() {
		return radioFrequncia;
	}
	/**
	 * @param radioFrequncia    The radioFrequncia to set.
	 */
	public void setRadioFrequncia(String radioFrequncia) {
		this.radioFrequncia = radioFrequncia;
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
}
