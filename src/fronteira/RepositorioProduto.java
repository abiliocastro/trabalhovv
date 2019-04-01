package fronteira;

import java.util.ArrayList;

import entidade.Produto;

public class RepositorioProduto {
	ArrayList<Produto> produtos = new ArrayList<Produto>();
	
	public void cadastrar(long id, String nome, float preco, int quantidade, String lojaFornecedora) {
		Produto novoProduto = new Produto(id, nome, preco, quantidade, lojaFornecedora);
		produtos.add(novoProduto);
	}
	
}
