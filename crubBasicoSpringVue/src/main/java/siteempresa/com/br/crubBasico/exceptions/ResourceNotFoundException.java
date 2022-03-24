package siteempresa.com.br.crubBasico.exceptions;

public class ResourceNotFoundException extends RuntimeException {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	
	public ResourceNotFoundException(Object id){
		super ("Recurso Não encontrado com id = " + id);
	}
	
}
