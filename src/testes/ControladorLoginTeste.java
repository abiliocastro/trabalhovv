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
	void usuarioInvalidoComecandoNumero() {
		assertThrows(UsuarioInvalidoException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("123abilio", "luke");
		});
	}
	
	@Test
	void usuarioInvalidoComecandoArroba() {
		assertThrows(UsuarioInvalidoException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("@abilio", "luke");
		});
	}
	
	@Test
	void usuarioInvalidoComecandoUnderline() {
		assertThrows(UsuarioInvalidoException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("_leandro", "mlteamor");
		});
	}
	
	@Test
	void usuarioInvalidoEspaco() {
		assertThrows(UsuarioInvalidoException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin(" ", "luke");
		});
	}
	
	@Test
	void usuarioInvalidoVazio() {
		assertThrows(UsuarioInvalidoException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("", "luke");
		});
	}
	
	
	@Test
	void usuarioInexistente() {
		assertThrows(UsuarioInexistenteException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("chico", "luke");
		});
		assertThrows(UsuarioInexistenteException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("antonio", "mlteamor");
		});
		assertThrows(UsuarioInexistenteException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("francisco", "senha12");
		});
	}
	
	@Test
	void senhaIncorreta() {
		assertThrows(SenhaIncorretaException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("abilio", "errada");
		});
		assertThrows(SenhaIncorretaException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("abilio", " ");
		});
		assertThrows(SenhaIncorretaException.class, () -> {
			Main.inicializarSistema();
			cl.realizarLogin("abilio", "");
		});
	}
	
	@Test
	void logado() throws Exception {
		Main.inicializarSistema();
		assertTrue(cl.realizarLogin("abilio", "maicao1234"));
		assertTrue(cl.realizarLogin("leandro", "pegador1234"));
		assertTrue(cl.realizarLogin("douglas", ""));
	}
	
}
