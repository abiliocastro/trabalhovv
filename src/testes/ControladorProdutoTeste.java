package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;
import controlador.ControladorProduto;
import excecoes.*;

class ControladorProdutoTeste {
	private ControladorProduto cp = new ControladorProduto();
	
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
		assertThrows(PrecoInvalidoExceptio.class, () -> {
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
		assertThrows(lojaFornecedoraInvalidaException.class, () -> {
			cp.cadastrarProduto("Celular Ruim",5000,8,null);
		}); 
	}
	@Test
	void cadastrarProdutoNomeEmpresaInvalidoEspaco() {
		assertThrows(lojaFornecedoraInvalidaException.class, () -> {
			cp.cadastrarProduto("Celular Ruim",5000,8," ");
		}); 
	}
	@Test
	void cadastrarProdutoNomeEmpresaInvalidoVazio() {
		assertThrows(lojaFornecedoraInvalidaException.class, () -> {
			cp.cadastrarProduto("Celular Ruim",5000,8,"");
		}); 
	}
}
