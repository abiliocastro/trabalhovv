package entidade;

import java.util.ArrayList;

public class RepositorioProduto {
	ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	void cadastrar(long id, String nome, float preco, int quantidade, String lojaFornecedora) {
		Produto novoProduto = new Produto(id, nome, preco, quantidade, lojaFornecedora);
		produtos.add(novoProduto);
	}
	
	void editar(long id, String nome, float preco, int quantidade, String lojaFornecedora) {
		
	}
	
	ArrayList<Produto> getProdutos(){
		return produtos;
	}
}
