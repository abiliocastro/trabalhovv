package excecoes;

public class UsuarioInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	@Override
	public String getMessage() {
		return "usuario invalido";
	}
}
