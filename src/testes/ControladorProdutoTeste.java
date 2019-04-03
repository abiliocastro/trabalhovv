package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.fail;

import org.junit.jupiter.api.Test;
import controlador.ControladorProduto;
import excecoes.*;
import fronteira.Main;

class ControladorProdutoTeste {
	private ControladorProduto cp = new ControladorProduto();
	
	//TESTES DE CADASTRO DE PRODUTO
	@Test
	void cadastrarProduto() throws Exception {
		assertEquals(true, cp.cadastrarProduto("Celular Ruim",5000,8,"Chico Cell"));
	}

	//Testando campo NOME
	@Test
	void cadastrarProdutoNomeInvalidoNulo() {
		assertThrows(NomeInvalidoException.class, () -> {
			cp.cadastrarProduto(null,5000,8,"Chico Cell");
		}); 
	}
	
	@Test
	void cadastrarProdutoNomeInvalidoEspaco() {
		assertThrows(NomeInvalidoException.class, () -> {
			cp.cadastrarProduto(" ",5000,8,"Chico Cell");
		}); 
	}
	
	@Test
	void cadastrarProdutoNomeInvalidoVazio() {
		assertThrows(NomeInvalidoException.class, () -> {
			cp.cadastrarProduto("",5000,8,"Chico Cell");
		}); 
	}
	
	//Testando campo PRECO
	@Test
	void cadastrarProdutoPrecoInvalidoNegativo() {
		assertThrows(PrecoInvalidoException.class, () -> {
			cp.cadastrarProduto("Celular Ruim",-5000,8,"Chico Cell");
		});
	}
	
	//Testando campo QUANTIDADE
	@Test
	void cadastrarProdutoQuantidadeInvalidaNegativa() {
		assertThrows(QuantidadeInvalidaException.class, () -> {
			cp.cadastrarProduto("Celular Ruim",5000,-8,"Chico Cell");
		});
	}
	
	//Testando campo NOME EMPRESA
	@Test
	void cadastrarProdutoNomeEmpresaInvalidoNulo() {
		assertThrows(LojaFornecedoraInvalidaException.class, () -> {
			cp.cadastrarProduto("Celular Ruim",5000,8,null);
		}); 
	}
	
	@Test
	void cadastrarProdutoNomeEmpresaInvalidoEspaco() {
		assertThrows(LojaFornecedoraInvalidaException.class, () -> {
			cp.cadastrarProduto("Celular Ruim",5000,8," ");
		}); 
	}
	
	@Test
	void cadastrarProdutoNomeEmpresaInvalidoVazio() {
		assertThrows(LojaFornecedoraInvalidaException.class, () -> {
			cp.cadastrarProduto("Celular Ruim",5000,8,"");
		}); 
	}
	
	//TESTES DE EDIÇÃO DE PRODUTO
	@Test
	void editarProduto() throws Exception {
		Main.inicializarSistema();
		assertEquals(true, cp.editarProduto(2, "Iphone eh Ruim Sim", 8000f, 2, "ChicoCell"));
	}
	
	@Test
	void idInvalido() {
		fail("Ainda nao implementado");
	}
	
	@Test
	void idInexistente() {
		fail("Ainda nao implementado");
	}
}
