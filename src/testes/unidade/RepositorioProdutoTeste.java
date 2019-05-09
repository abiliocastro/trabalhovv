package testes.unidade;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import fronteira.database.RepositorioProduto;

class RepositorioProdutoTeste {
	RepositorioProduto repoProdu = RepositorioProduto.getInstance();
	@Test
	void cadastrarTeste() {
		assertTrue(repoProdu.cadastrar("Celular Ruim", 5000, 8, "Chico Cell"));
	}
	@Test
	void editarTeste() {
		repoProdu.cadastrar("Celular Ruim", 5000, 8, "Chico Cell");
		assertTrue(repoProdu.editar(1,"Iphone Ruim", 5000, 8, "Chico cell"));
	}
	@Test
	void removerProdutoTeste() {
		repoProdu.cadastrar("Celular Ruim", 5000, 8, "Chico Cell");
		assertTrue(repoProdu.removerProduto(1));
	}
	
	
}
