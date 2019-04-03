package excecoes;

public class SenhaIncorretaException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "senha incorreta";
	}

}
