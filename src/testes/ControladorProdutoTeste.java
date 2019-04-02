package testes;

import static org.junit.Assert.assertEquals;

import org.junit.jupiter.api.Test;
import controlador.ControladorProduto;

class ControladorProdutoTeste {
	
	private ControladorProduto cp = new ControladorProduto();
	
	@Test
	void cadastrarProduto() {
		assertEquals("Cadastrado com Sucesso", cp.cadastrarProduto("Celular Ruim", 5000, 8, "Chico Cell"));
	}
	
	@Test
	void cadastrarProdutoNomeVazio() {
		assertEquals("Cadastrado com Sucesso", cp.cadastrarProduto(" ", 5000, 8, "Chico Cell"));
	}
}
