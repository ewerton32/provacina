package br.com.provacBeta.animal;
/**
 * @author      Ewerton Otavio de Castro Souto
 * @category      Sistem de Acompanhamento de Rebanho Bovino --- ProVac
 * @classe      ArrayAnimais implenta a inteface RepositorioAnimais; *
 */
public class ArrayAnimais implements RepositorioAnimais {
;
	
		/**
		 */
		private Animal[] animal;
	    private int indice;
	    private final static int tamCache = 100;
	    private static ArrayAnimais instance;
	
	    public ArrayAnimais() {
	      indice = 0;
	      animal = new Animal[tamCache];
	    }
	    
	    /**
		 * @return     Returns the instance.
		 */
	    public synchronized static ArrayAnimais getInstance() {
			if (instance == null) {
				instance = new ArrayAnimais();
			}
			return instance;
		}
	
	    /**
	     * @Implementa��o do Metodo atualizar implementa��o da interface RepositorioAnimais
	     */
	    public void atualizar(Animal ani) 
	      throws AnimalInexistenteException {
	      int i = procurarIndice(ani.getNumero());
	      if (i != -1) {
	              animal[i] = ani;
	      } else {
	    	  throw new AnimalInexistenteException("Animal nao encontrado");
	      }
	    }
	    
	
	    /**
	     * @Implementa��o do Metodo existe implementa��o da interface RepositorioAnimais
	     */
	    public boolean existe(String numero) {
	      boolean resp = false; //valor defalt do metodo � false
	
	      int i = this.procurarIndice(numero);
	      if(i != -1){
	            resp = true;
	      }
	
	      return resp;
	    }
	
	    /**
	     * @Implementa��o do Metodo Inserir implementa��o da interface RepositorioAnimais
	     */
	    public void inserir(Animal ani)
	    throws AnimalExistenteException {
	        if (existe(ani.getNumero())) {
	        	throw new AnimalExistenteException("Animal j� cadastrado");	
	        } else {
	        	animal[indice] = ani;
	            indice = indice + 1;	
	        }
	    }
	
	    /**
	     * @Implementa��o do Metodo procurar implementa��o da interface RepositorioAnimais
	     */
	    public Animal procurar(String numero) 
	      throws AnimalInexistenteException {
	      Animal ani = null;
	      if (existe(numero)) {
	          int i = this.procurarIndice(numero);
	        ani = animal[i];
	      } else {
	    	  throw new AnimalInexistenteException("Animal nao encontrado");
	      }
	
	      return ani;
	    }
	
	    private int procurarIndice(String numero) {
	      int     i = 0;
	      int     ind = -1;
	      boolean achou = false;
	      while ((i < indice) && !achou) {
	        if ((animal[i].getNumero()).equals(numero)) {
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
	    public void remover(String numero)
	      throws AnimalInexistenteException {
	      if (existe(numero)) {
	          int i = this.procurarIndice(numero);
	          animal[i] = animal[indice - 1];
	          animal[indice - 1] = null;
	          indice = indice - 1;
	      } else {
	    	  throw new AnimalInexistenteException("Animal nao encontrado");
	      }
	    }
}