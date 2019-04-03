package excecoes;

public class PrecoInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PrecoInvalidoException() {
	
	}
	
	@Override
	public String getMessage() {
		return "Preco Invalido";
	}

}
