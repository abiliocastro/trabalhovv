package excecoes;

public class lojaFornecedoraInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public lojaFornecedoraInvalidaException() {
	
	}
	
	@Override
	public String getMessage() {
		return "Loja invalida";
	}

}
