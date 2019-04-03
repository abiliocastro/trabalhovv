package fronteira;

import java.util.ArrayList;
import entidade.Produto;

public class RepositorioProduto {
	private ArrayList<Produto> produtos; 
	 
	private static RepositorioProduto uniqueInstance = new RepositorioProduto();
	
	private RepositorioProduto() {
		produtos = new ArrayList<Produto>();
	}
	
	public static RepositorioProduto getInstance() {
		return uniqueInstance;
	}
	
	public void cadastrar(long id, String nome, float preco, int quantidade, String lojaFornecedora) {
		Produto novoProduto = new Produto(id, nome, preco, quantidade, lojaFornecedora);
		produtos.add(novoProduto);
	}
	
	public boolean editar(long id, String nome, float preco, int quantidade, String lojaFornecedora) {
		for (Produto produto : produtos) {
			if(produto.getId() == id) {
				produto.setNome(nome);
				produto.setPreco(preco);
				produto.setQuantidade(quantidade);
				produto.setLojaFornecedora(lojaFornecedora);
				return true;
			}
		}
		return false;
	}
	
	public boolean removerProduto(int id) {
		return produtos.remove(id)!=null;
	}
	
	public ArrayList<Produto> getProdutos(){
		return this.produtos;
	}
	
}
