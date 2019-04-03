package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controlador.ControladorBusca;
import entidade.Produto;
import fronteira.RepositorioProduto;

class ControladorBuscaTeste {
	ControladorBusca contBusc = new ControladorBusca();
	static RepositorioProduto repositorioDeProduto = RepositorioProduto.getInstance();
	
	@Test
	void buscarProduto() {
		ArrayList<Produto> produtosBuscado = new ArrayList<Produto>(); 
		Produto P = new Produto(1,"Televisao", 340.99f, 1, "Jose Moveis");
		Produto P1 = new Produto(2,"Televisao", 349.0f, 4, "Outro");
		
		repositorioDeProduto.getProdutos().add(P);
		repositorioDeProduto.getProdutos().add(P1);
		String atual = "Televisao";
		produtosBuscado = contBusc.buscarProduto(atual);
		for (Produto produto : produtosBuscado) {
			assertEquals(produto.getNome(), atual);
		}
	}

	@Test
	void buscarProdutoNulo() {
		ArrayList<Produto> produtosBuscado = new ArrayList<Produto>(); 
		Produto P = null;				
		repositorioDeProduto.getProdutos().add(P);
		String atual = "ass";
		produtosBuscado = contBusc.buscarProduto(atual);
		for (Produto produto : produtosBuscado) {
			assertNotNull(produto);
		}
	}
}
