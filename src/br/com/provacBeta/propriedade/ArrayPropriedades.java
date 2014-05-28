package br.com.provacBeta.propriedade;

/**
 * @author      aluno
 */
public class ArrayPropriedades implements RepositorioPropriedades {
	
	/**
	 */
	private Propriedade[] propriedades;
	private int indice;
	private final static int tamCache = 100;
	private static ArrayPropriedades instance;
	/**
	 * @construtor da classe ArrayPropriedades
	 *
	 */
	public ArrayPropriedades(){
		indice = 0;
        propriedades = new Propriedade[tamCache];	}
	
	public synchronized static ArrayPropriedades getInstances(){
		if (instance == null){
			instance = new ArrayPropriedades();			
		}
		return instance;
		
	}

	public void atualizar(Propriedade p)
	throws PropriedadeInexistenteException{
	int i = procurarIndice(p.getNumEscritura());
	if (i != -1){
		propriedades[i] = p;
	}else{throw new PropriedadeInexistenteException("A propriedade não foi encontrada;");
	}
	
	}
	
	 public boolean existe(String numEscritura) {
         boolean resp = false;

         int i = this.procurarIndice(numEscritura);
         if(i != -1){
               resp = true;
         }

         return resp;
       }
	 
	 public void inserir(Propriedade p) 
     throws PropriedadeExistenteException {
		   	 
		 if (existe(p.getNumEscritura())) {
       		throw new PropriedadeExistenteException("Propriedade já cadastrado");	
       } else {
    	 	propriedades[indice] = p;
       	 	indice = indice + 1;	
       	 	
       }
   }
	 public Propriedade procurar(String numEscritura) 
     throws PropriedadeInexistenteException {
		
     Propriedade p = null;
     if (existe(numEscritura)) {
         int i = this.procurarIndice(numEscritura);
       p = propriedades[i];   
       
       
     } else {
   	  throw new PropriedadeInexistenteException("Propriedade não encontrada");
     }

       return p;
     }
	 
	//
	private int procurarIndice(String numEscritura){
		int    i = 0;
		int  ind = -1;
		boolean achou = false;
		while((i < indice) && !achou){
			if(propriedades[i].getNumEscritura().equals(numEscritura))
			{
				ind = i;
				achou = true;
			}
			i = i+1;
		}
		return ind;
	}
	
	public void remover(String numEscritura)
    throws PropriedadeInexistenteException {
    if (existe(numEscritura)) {
        int i = this.procurarIndice(numEscritura);
        propriedades[i] = propriedades[indice - 1];
        propriedades[indice - 1] = null;
        indice = indice - 1;
    } else {
  	  throw new PropriedadeInexistenteException("Propriedade nao encontrado");
    }
  }
	
	
	
	
	


}
