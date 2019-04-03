package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controlador.ControladorBusca;
import entidade.Produto;
import fronteira.Main;
import fronteira.RepositorioProduto;

class ControladorBuscaTeste {
	ArrayList<Produto> produtosBuscado;
	static RepositorioProduto repositorioDeProduto = RepositorioProduto.getInstance();
	ControladorBusca contBusc = new ControladorBusca();
	
	@Test
	void buscarProduto() {
		Main.inicializarSistema();
		produtosBuscado = contBusc.buscarProduto("Iphone");
		if(!produtosBuscado.isEmpty()) {
			for (Produto produto : produtosBuscado) {
				System.out.println(produto.getNome());
				assertTrue(produto.getNome().equals("xxx"));
			}
		} else {
			System.out.println("Array Vazio");
		}
		
	}

	@Test
	void buscarProdutoNulo() {
		ArrayList<Produto> produtosBuscado = new ArrayList<Produto>(); 
		Produto P = null;				
		repositorioDeProduto.getProdutos().add(P);
		String atual = null;
		produtosBuscado = contBusc.buscarProduto(atual);
		for (Produto produto : produtosBuscado) {
			assertNotNull(produto);
		}
	}
}
