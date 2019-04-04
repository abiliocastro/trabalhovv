package testes;

import static org.junit.Assert.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import org.junit.jupiter.api.Test;
import controlador.ControladorProduto;
import excecoes.*;
import fronteira.Main;
import fronteira.RepositorioProduto;

class ControladorProdutoTeste {
	private ControladorProduto cp = new ControladorProduto();
	private RepositorioProduto repProdutos = RepositorioProduto.getInstance();
	
//TESTES DE CADASTRO DE PRODUTO
 	//Testando sucesso cadastro
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
	
	//Testando campo LISTAR
	@Test
	void listarProduto() {
		cp = new ControladorProduto();
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
	void editarProdutoidInexistente() {
		assertThrows(IdInexistenteException.class, () -> {
			cp.editarProduto(9999, "Iphone eh Ruim Sim", 8000f, 2, "ChicoCell");
		});
	}

	void editarProdutoIdInvalido() {
		assertThrows(IdInvalidoException.class, () -> {
			cp.editarProduto(-1, "Iphone eh Ruim Sim", 8000f, 2, "ChicoCell");
		});
	}
	
	//Testando edicao campo NOME
	@Test
	void editarProdutoNomeInvalidoNulo() {
		assertThrows(NomeInvalidoException.class, () -> {
			cp.editarProduto(2, null, 8000f, 2, "ChicoCell");
		}); 
	}
	
	@Test
	void editarProdutoNomeInvalidoEspaco() {
		assertThrows(NomeInvalidoException.class, () -> {
			cp.editarProduto(2, " ", 8000f, 2, "ChicoCell");
		}); 
	}
	
	@Test
	void editarProdutoNomeInvalidoVazio() {
		assertThrows(NomeInvalidoException.class, () -> {
			cp.editarProduto(2, "", 8000f, 2, "ChicoCell");
		}); 
	}
	
	//Testando edicao campo PRECO
	@Test
	void editarProdutoPrecoInvalidoNegativo() {
		assertThrows(PrecoInvalidoException.class, () -> {
			cp.editarProduto(3, "Celular Ruim",-5000,8,"Chico Cell");
		});
	}
	
	//Testando edicao campo QUANTIDADE
	@Test
	void editarProdutoQuantidadeInvalidaNegativa() {
		assertThrows(QuantidadeInvalidaException.class, () -> {
			cp.editarProduto(3, "Celular Ruim",5000,-8,null);
		});
	}
	
	//Testando edicao campo NOME EMPRESA
	@Test
	void editarProdutoNomeEmpresaInvalidoNulo() {
		assertThrows(LojaFornecedoraInvalidaException.class, () -> {
			cp.editarProduto(3, "Celular Ruim",5000,8,null);
		}); 
	}
	
	@Test
	void editarProdutoNomeEmpresaInvalidoEspaco() {
		assertThrows(LojaFornecedoraInvalidaException.class, () -> {
			cp.editarProduto(3,"Celular Ruim",5000,8," ");
		}); 
	}
	
	@Test
	void editarProdutoNomeEmpresaInvalidoVazio() {
		assertThrows(LojaFornecedoraInvalidaException.class, () -> {
			cp.editarProduto(3,"Celular Ruim",5000,8,"");
		}); 
	}

//TESTES DE EXCLUSAO DE PRODUTO
	
	//Testando Excluir Sucesso
	@Test
	void exluirProduto() throws Exception {
		Main.inicializarSistema();
		assertEquals(true, cp.removerProduto(0));
	}
	
	//Testando campo ID
	@Test
	void exluirProdutoIdInvalidoNegativo() {
		assertThrows(IdInvalidoException.class, () -> {
			cp.removerProduto(-3);
		}); 
	}
	
	@Test
	void exluirProdutoIdInvalidoInexistente() {
		assertThrows(IdInexistenteException.class, () -> {
			cp.removerProduto(999);
		}); 
	}

//TESTE LISTAR PRODUTOS
	//Testando listar correto
	@Test
	void listarProdutos() {
		Main.inicializarSistema();
		assertEquals(repProdutos.getProdutos(), cp.listarProdutos());
	}
	
	//Testando listar produtos Nulo
	@Test
	void listarProdutosNulo() {
		
	}
	
}
