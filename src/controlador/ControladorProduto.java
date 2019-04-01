package controlador;

import fronteira.RepositorioProduto;

public class ControladorProduto {
	RepositorioProduto repProdutos = new RepositorioProduto();
	static long id = 0;
	
	public String cadastrarProduto(String nome, float preco, int quantidade, String lojaFornecedora) {
		repProdutos.cadastrar(this.id, nome, preco, quantidade, lojaFornecedora);
		return "Cadastrado com Sucesso";
	}
		
}
