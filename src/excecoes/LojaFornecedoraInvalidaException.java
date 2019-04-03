package excecoes;

public class LojaFornecedoraInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Loja invalida";
	}

}
