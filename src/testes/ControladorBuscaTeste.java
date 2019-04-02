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
		Produto P = new Produto(1,"as", 34.0f, 4, "Jose");
		Produto P1 = new Produto(2,"as", 34.0f, 4, "Jose");
		
		repositorioDeProduto.getProdutos().add(P);
		repositorioDeProduto.getProdutos().add(P1);
		
		
		String atual = "as";
		produtosBuscado = contBusc.buscarProduto(atual);
		for (Produto produto : produtosBuscado) {
			assertEquals(produto.getNome(), atual);
		}
	}

}
