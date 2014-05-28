package br.com.provacBeta.usuario;
import br.com.provacBeta.util.Contato;

/**
 * Classe abstrata Usuário - Serve como esqueleto às classes de todos os tipos de usuários do Sistema;
 * @author      (Ewerton Otavio de Castro Souto)
 * @version      (versão preliminar)
 */
public class Usuario
{
	// Atributos - atributos a sertem erdados pelas sub-classes.
	private String nome;
	private String idUsuario;
	private String cpf;
	private String rg;
	private String tipo;
	private String login;
	private String senha;
	private String dataNasc;
	private Contato contato;
	
	
	
	

	public Usuario(String nome, 
			String idUsuario, 
			String cpf, 
			String rg, 
			String tipo, 
			String login, 
			String senha, 
			String dataNasc 
			) {
		
		this.setNome(nome);
		this.setIdUsuario(idUsuario);
		this.setCpf(cpf);
		this.setRg(rg);
		this.setTipo(tipo);
		this.setLogin(login);
		this.setSenha(senha);
		this.setDataNasc(dataNasc);
		
		
		
	}
	public Usuario(String nome, 
			       String idUsuario, 
			       String cpf, 
			       String rg, 
			       String tipo, 
			       String login, 
			       String senha, 
			       String dataNasc, 
			       Contato contato) {
		
		this.setNome(nome);
		this.setIdUsuario(idUsuario);
		this.setCpf(cpf);
		this.setRg(rg);
		this.setTipo(tipo);
		this.setLogin(login);
		this.setSenha(senha);
		this.setDataNasc(dataNasc);
		this.setContato(contato);
				
		
	}



	public String toString(){
		String resp;
		resp ="\n\n++++ DADOS DO USUÁRIO ++++" + 
		      "\nNOME USUÁRIO: " + this.getNome()+
		      "\nIDENTIFICADOR DO USUÁRIO: " + this.getIdUsuario()+
		      "\nTIPO DO USUÁRIO: " + this.getTipo()+
		      "\nDATA DE NASCIMENTO DO USUÁRIO: " + this.getDataNasc()+
		       getContato();
		     
		return resp;
	}
	
	
	public Usuario(String nome, String idUsuario, String tipo, String senha, String dataNasc, Contato contato, String login) {
		
		this.setNome(nome);
		this.setIdUsuario(idUsuario);
		this.setTipo(tipo);
		this.setLogin(login);
		this.setSenha(senha);
		this.setDataNasc(dataNasc);
		this.setContato(contato);
		
	}

	/**
	 * Metodo para retornar o valor do nome do usuário;
	 * @param Sem     parametro;
	 * @return     		O valor do atributo "nome" atualizado;
	 */
	
	public String getNome()
	{
		return nome;
	}
	
	
	/**
	 * @param nome     The nome to set.
	 */
	public void setNome(String nome)
	{
		this.nome = nome;
	}
		
	
	/**
	 * @return     Returns the idUsuario.
	 */
	public String getIdUsuario()
	{
		return idUsuario;
	}
	
	
	
	/**
	 * @param idUsuario     The idUsuario to set.
	 */
	public void setIdUsuario(String idUsuario)
	{
		this.idUsuario = idUsuario;
	}
	
	
	/**
	 * @return     Returns the tipo.
	 */
	public String getTipo(){
	
		return tipo;
	}
	
	
	/**
	 * @param tipo     The tipo to set.
	 */
	public void setTipo(String tipo)
	{
		this.tipo = tipo;
	}
	
	
	
	/**
	 * @return     Returns the senha.
	 */
	public String getSenha()
	{
		return senha;
	}
	
	/**
	 * @param senha     The senha to set.
	 */
	public void setSenha(String senha)
	{
		this.senha = senha;
	}
	
	/**
	 * @return     Returns the dataNasc.
	 */
	public String getDataNasc()
	{
		return dataNasc;
	}
	
	/**
	 * @param dataNasc     The dataNasc to set.
	 */
	public void setDataNasc(String dataNasc)
	{
		this.dataNasc = dataNasc;
	}
	
	/**
	 * @return     Returns the contato.
	 */
	public Contato getContato()
	{
		return contato;
	}
	
	/**
	 * @param contato     The contato to set.
	 */
	public void setContato(Contato contato)
	{
		this.contato = contato;
	}

	/**
	 * @return     Returns the login.
	 */
	public String getLogin() {
		return login;
	}

	/**
	 * @param login     The login to set.
	 */
	public void setLogin(String login) {
		this.login = login;
	}

	

	/**
	 * Getter of the property <tt>propriedade</tt>
	 * @return     Returns the propriedade.
	 */
	


	public String getCpf() {
		return cpf;
	}



	/**
	 * @param cpf  The cpf to set.
	 */
	public void setCpf(String cpf) {
		this.cpf = cpf;
	}



	/**
	 * @return  Returns the rg.
	 */
	public String getRg() {
		return rg;
	}



	/**
	 * @param rg  The rg to set.
	 */
	public void setRg(String rg) {
		this.rg = rg;
	}
	
}
