package br.com.provacBeta.vacinacao;


/**
 * @author      Ewerton Otavio de Castro Souto
 * @category      Sistem de Acompanhamento de Rebanho Bovino --- ProVac ---
 * @classe      ArrayVacinacoes implenta a inteface RepositorioVacinacoes;
 */
public class ArrayVacinacoes implements RepositorioVacinacoes {
	/**
	 */
	private Vacinacao[] vacinacao;
    private int indice;
    private final static int tamCache = 100;
    private static ArrayVacinacoes instance;
    public ArrayVacinacoes() {
      indice = 0;
      vacinacao = new Vacinacao[tamCache];
    }
    /**
	 * @return     Returns the instance.
	 */
    public synchronized static ArrayVacinacoes getInstance() {
		if (instance == null) {
			instance = new ArrayVacinacoes();
		}
		return instance;
	}
    /**
     * @Implementa��o do Metodo atualizar implementa��o da interface RepositorioAnimais
     */
    public void atualizar(Vacinacao vac) 
      throws VacinacaoInexistenteException {
    	int i = procurarIndice(vac.getId_vacinacao());
      if (i != -1) {
              vacinacao[i] = vac;
      } else {
    	  throw new VacinacaoInexistenteException("Vacinacao nao encontrada");
      }
    }
    /**
     * @Implementa��o do Metodo existe implementa��o da interface RepositorioAnimais
     */
    public boolean existe(String Id_vacinacao) {
      boolean resp = false; //valor defalt do metodo � false

      int i = this.procurarIndice(Id_vacinacao);
      if(i != -1){
            resp = true;
      }

      return resp;
    }
    /**
     * @Implementa��o do Metodo Inserir implementa��o da interface RepositorioAnimais
     */
    public void inserir(Vacinacao vac)
      throws VacinacaoExistenteException {
        if (existe(vac.getId_vacinacao())) {
        	throw new VacinacaoExistenteException("Vacinacao j� cadastrado");	
        } else {
        	vacinacao[indice] = vac;
            indice = indice + 1;	
        }
    }
    /**
     * @Implementa��o do Metodo procurar implementa��o da interface RepositorioAnimais
     */
    public Vacinacao procurar(String id_vacinacao) 
      throws VacinacaoInexistenteException {
    	Vacinacao vac = null;
      if (existe(id_vacinacao)) {
          int i = this.procurarIndice(id_vacinacao);
        vac = vacinacao[i];
      } else {
    	  throw new VacinacaoInexistenteException("Vacinac�o nao encontrado");
      }

      return vac;
    }
    private int procurarIndice(String id_vacinacao) {
      int     i = 0;
      int     ind = -1;
      boolean achou = false;
      while ((i < indice) &&!achou) {
        if ((vacinacao[i].getId_vacinacao()).equals(id_vacinacao)) {
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
    public void remover(String id_vacinacao)
      throws VacinacaoInexistenteException {
      if (existe(id_vacinacao)) {
          int i = this.procurarIndice(id_vacinacao);
          vacinacao[i] = vacinacao[indice - 1];
          vacinacao[indice - 1] = null;
          indice = indice - 1;
      } else {
    	  throw new VacinacaoInexistenteException("Vacinacao nao encontrado");
      }
    }
}
