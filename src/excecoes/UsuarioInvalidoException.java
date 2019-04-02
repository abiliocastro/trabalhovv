package excecoes;

public class UsuarioInvalidoException extends Exception {

	private static final long serialVersionUID = 1L;
	
	public UsuarioInvalidoException() {
	
	}
	
	@Override
	public String getMessage() {
		return "Usuário Inexistente";
	}

}
