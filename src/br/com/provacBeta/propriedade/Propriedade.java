package br.com.provacBeta.propriedade;
import br.com.provacBeta.fachada.Fachada;
import br.com.provacBeta.usuario.Usuario;
import br.com.provacBeta.util.Endereco;
import java.util.Collection;

/**
 * @author      aluno
 */
public class Propriedade {
	/**
	 * @author Ewerton Otávio
	 *
	 *
	 *
	 */

	private String nome;
	private Endereco endereco;
	private Usuario criador;
    private double area;
    private String numEscritura;

    /**
	 * @Construtor da classe Propriedade;
	 *
	 * @param string
	 * @param area
	 * @param numEscritura
	 * @param nome
	 * @param usuario
	 *
	 */
    

    /**
	 * @Construtor da classe Propriedade;
	 * @param nome
	 * @param endereco
	 * @param area
	 * @param numEscritura
	 */

    public Propriedade(String nome, Endereco endereco, Usuario usuario, double area, String numEscritura) {
    	
    	this.setNome(nome);
    	this.setEndereco(endereco);
    	this.setArea(area);
    	this.setNumEscritura(numEscritura);
    	this.setCriador(usuario);
    }
    public Propriedade(String nome, Usuario usuario, String numUsuario, double area, String numEscritura) {
    	
    	numUsuario = usuario.getIdUsuario();
    	this.setNome(nome);
    	this.setArea(area);
    	this.setNumEscritura(numEscritura);
    	this.setCriador(usuario);
    }
	public Propriedade(String nome, Endereco endereco, double area, String numEscritura) {

		this.setNome(nome);
		this.setEndereco(endereco);
		this.setArea(area);
		this.setNumEscritura(numEscritura);
	}
	public Propriedade(String nome, double area, String numEscritura) {
		
		this.setNome(nome);		
		this.setArea(area);
		this.setNumEscritura(numEscritura);
	}
	/**
	 * @return     Returns the area.
	 */
	public double getArea() {
		return area;
	}
	/**
	 * @param area     The area to set.
	 */
	public void setArea(double area) {		
			this.area = area;		
	}
	/**
	 * @return     Returns the endereco.
	 */
	public Endereco getEndereco() {
		return endereco;
	}
	/**
	 * @param endereco     The endereco to set.
	 */
	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}
	/**
	 * @return     Returns the numEscritura.
	 */
	public String getNumEscritura() {
		return numEscritura;
	}
	/**
	 * @param numEscritura     The numEscritura to set.
	 */
	public void setNumEscritura(String numEscritura) {
		this.numEscritura = numEscritura;
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
	 * @return    Returns the criador.
	 */
	public Usuario getCriador() {
		return criador;
	}
	/**
	 * @param criador    The criador to set.
	 */
	public void setCriador(Usuario criador) {
		this.criador = criador;
	}

	public String toString(){
		String resp;
		resp = "\n+++++ DADOS DA PROPRIEDADE +++++\n" +
		       "\nNOME DA PROPRIEDADE: " + getNome() +
		       "\nNÚMERO DA ESCRITURA DA PROPRIEDADE: " + getNumEscritura() +
		       "\nÁREA DA PROPRIEDADE: " + getArea()+
		       getEndereco() +
		       getCriador();
		return resp;
	}

	public boolean equals(Object o){
		boolean resp = false;
		if(o instanceof Propriedade){
			Propriedade p = (Propriedade)o;
			if(p.getArea()==getArea()){
				if(p.getEndereco() == null && getEndereco() == null ||
				   p.getEndereco().equals(getEndereco())){
					if(p.getCriador() == null && getCriador() == null||
					   p.getCriador().equals(getCriador())){
						if(p.getNome() == null && getNome() == null ||
						   p.getNome().equals(getNome())){
							if(p.getNumEscritura() == null && getNumEscritura() == null ||
							   p.getNumEscritura().equals(getNumEscritura())){
								resp= true;
							}
						}
					}
				}
			}
		}return resp;
	}

}
