package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controlador.ControladorLogin;
import excecoes.UsuarioInvalidoException;

class ControladorLoginTeste {
	ControladorLogin cl = new ControladorLogin();
	
	@Test
	void usuarioInexistente() {
		assertThrows(UsuarioInvalidoException.class, () -> {
			cl.realizarLogin("chico", "isso");
		});
	}

}
