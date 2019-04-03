package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

import controlador.ControladorBusca;
import entidade.Produto;
import fronteira.Main;

class ControladorBuscaTeste {
	ControladorBusca contBusc = new ControladorBusca();
	ArrayList<Produto> produtosBuscado;
	
	@Test
	void buscarProduto() {
		Main.inicializarSistema();
		String termoBuscar = "ruim";
		produtosBuscado = contBusc.buscarProduto(termoBuscar);
		System.out.println(produtosBuscado.size());
		if(!produtosBuscado.isEmpty()) {
			for (Produto produto : produtosBuscado) {
				assertTrue(produto.getNome().toLowerCase().contains(termoBuscar.toLowerCase()));
			}
		} else {
			assertEquals(0, produtosBuscado.size());
		}
	}

	@Test
	void buscarProdutoNulo() { 			
		String atual = null;
		produtosBuscado = contBusc.buscarProduto(atual);
		assertTrue(produtosBuscado.isEmpty());
	}
}
