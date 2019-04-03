package excecoes;

public class QuantidadeInvalidaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "Quantidade invalida";
	}

}
