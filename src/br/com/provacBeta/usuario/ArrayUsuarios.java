package br.com.provacBeta.usuario;


/**
 * @author      aluno
 */
public class ArrayUsuarios implements RepositorioUsuarios{
	
	/**
	 */
	private Usuario[] usuario;
    private int indice;
    private final static int tamCache = 100;
    private static ArrayUsuarios instance;

    public ArrayUsuarios() {
      indice = 0;
      usuario = new Usuario[tamCache];
    }
    
    /**
	 * @return     Returns the instance.
	 */
    public synchronized static ArrayUsuarios getInstance() {
		if (instance == null) {
			instance = new ArrayUsuarios();
		}
		return instance;
	}

    /**
     * @Implementa��o do Metodo atualizar implementa��o da interface RepositorioAnimais
     */
    public void atualizar(Usuario usu) 
      throws UsuarioInexistenteException {
    	int i = procurarIndice(usu.getIdUsuario());
      if (i != -1) {
              usuario[i] = usu;
      } else {
    	  throw new UsuarioInexistenteException("Usu�rio nao encontrado");
      }
    }
    

    /**
     * @Implementa��o do Metodo existe implementa��o da interface RepositorioAnimais
     */
    public boolean existe(String idUsuario) {
      boolean resp = false; //valor defalt do metodo � false

      int i = this.procurarIndice(idUsuario);
      if(i != -1){
            resp = true;
      }

      return resp;
    }

    /**
     * @Implementa��o do Metodo Inserir implementa��o da interface RepositorioAnimais
     */
    public void inserir(Usuario usu)
      throws UsuarioExistenteException {
        if (existe(usu.getIdUsuario())) {
        	throw new UsuarioExistenteException("Usu�rio j� cadastrado");	
        } else {
        	usuario[indice] = usu;
            indice = indice + 1;	
        }
    }

    /**
     * @Implementa��o do Metodo procurar implementa��o da interface RepositorioAnimais
     */
    public Usuario procurar(String numero) 
      throws UsuarioInexistenteException {
    	Usuario ani = null;
      if (existe(numero)) {
          int i = this.procurarIndice(numero);
        ani = usuario[i];
      } else {
    	  throw new UsuarioInexistenteException("Usu�rio nao encontrado");
      }

      return ani;
    }

    private int procurarIndice(String idUsuario) {
      int     i = 0;
      int     ind = -1;
      boolean achou = false;
      while ((i < indice) && !achou) {
        if ((usuario[i].getIdUsuario()).equals(idUsuario)) {
            ind = i;
            achou = true;
        }
        i = i + 1;
      }
      return ind;
    }
     /**
      * @Implementa��o do Metodo Remover implementa��o da interface RepositorioAnimais
      */
    public void remover(String idUsuario)
      throws UsuarioInexistenteException {
      if (existe(idUsuario)) {
          int i = this.procurarIndice(idUsuario);
          usuario[i] = usuario[indice - 1];
          usuario[indice - 1] = null;
          indice = indice - 1;
      } else {
    	  throw new UsuarioInexistenteException("Usu�rio nao encontrado");
      }
    }

}
