package excecoes;

public class IdInexistenteException extends Exception {

	private static final long serialVersionUID = 1L;

	@Override
	public String getMessage() {
		return "id inexistente";
	}
}
