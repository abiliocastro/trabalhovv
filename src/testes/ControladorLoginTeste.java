package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import controlador.ControladorLogin;
import excecoes.SenhaIncorretaException;
import excecoes.UsuarioInexistenteException;
import excecoes.UsuarioInvalidoException;
import fronteira.Main;

class ControladorLoginTeste {
	ControladorLogin cl = new ControladorLogin();
	
	@Test
	void usuarioInexistente() {
		assertThrows(UsuarioInexistenteException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("chico", "isso");
		});
	}
	
	@Test
	void senhaIncorreta() {
		assertThrows(SenhaIncorretaException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("abilio", "errada");
		});
	}
	
	@Test
	void usuarioInvalido() {
		assertThrows(UsuarioInvalidoException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("123abilio", "luke");
		});
		assertThrows(UsuarioInvalidoException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("_leandro", "mlteamor");
		});
		assertThrows(UsuarioInvalidoException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("@abilio", "luke");
		});
		assertThrows(UsuarioInvalidoException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin(" ", "luke");
		});
		assertThrows(UsuarioInvalidoException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("", "luke");
		});
	}
	
	@Test
	void logado() throws Exception {
		Main.inicializarSistema();
		assertTrue(cl.realizarLogin("abilio", "luke"));
		assertTrue(cl.realizarLogin("leandro", "mlteamor"));
		assertTrue(cl.realizarLogin("douglas", "senha12"));
	}
	
}
