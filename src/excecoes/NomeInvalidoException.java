package excecoes;

public class NomeInvalidoException extends Exception{

	private static final long serialVersionUID = 1L;

	public NomeInvalidoException() {
		
	}
	
	public String getMensage() {
		return("Nome invalido");
	}
}
