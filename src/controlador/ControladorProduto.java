package controlador;

import fronteira.RepositorioProduto;

public class ControladorProduto {
	RepositorioProduto repProdutos = new RepositorioProduto();
	static long id = 0;
	
	public String cadastrarProduto(String nome, float preco, int quantidade, String lojaFornecedora) {
		try {
			if(nome.equals(null)) {
				return "nome invalido!";
			}
			repProdutos.cadastrar(this.id, nome, preco, quantidade, lojaFornecedora);
			return "Cadastrado com Sucesso";
		}catch (Exception e) {
			return e.getMessage();
		}
		
	}
	public String removerProduto(int id) {
		if(repProdutos.removerProduto(id)) { 
			return "Produto Removido com Sucesso!";
		}
		return "Falha ao Remover Produto!";
	}
}
