package testes;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fronteira.RepositorioAdministrador;

class RepositorioAdministradoTeste {
	RepositorioAdministrador repoAdmin = RepositorioAdministrador.getInstance();
	@Test
	void cadastrarAdmin() {
		assertTrue(repoAdmin.cadastrarAdministrador("Joao", "123"));
	}
	
	@Test
	void obterAdmnistrador() {
		repoAdmin.cadastrarAdministrador("Joao", "123");
		assertNotNull(repoAdmin.obterAdmnistrador("Joao"));
	}

}
