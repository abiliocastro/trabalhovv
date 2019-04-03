package excecoes;

public class IdInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "id invalido";
	}
}
