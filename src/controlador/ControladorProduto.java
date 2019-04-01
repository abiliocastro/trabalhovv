package controlador;

import java.util.ArrayList;
import entidade.Produto;
import entidade.RepositorioProduto;

public class ControladorProduto {
	static long id = 0;
	RepositorioProduto repProdutos = new RepositorioProduto();
	
	void cadastrarProduto(String nome, float preco, int quantidade, String lojaFornecedora) {
		Produto novoProduto = new Produto(this.id, nome, preco, quantidade, lojaFornecedora);
		this.id++;
	}
	
	/*void editarProduto(int id) {
		for (Produto produtoEditavel : ) {
			if(produtoEditavel.getId() == id) {
				
			}
		}
	}
	*/
		
}
