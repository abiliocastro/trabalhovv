package excecoes;

public class PrecoInvalidoExceptio extends Exception {

	private static final long serialVersionUID = 1L;
	
	public PrecoInvalidoExceptio() {
	
	}
	
	@Override
	public String getMessage() {
		return "Preco Invalido";
	}

}
