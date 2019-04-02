package controlador;

import fronteira.RepositorioProduto;

public class ControladorProduto {
	RepositorioProduto repProdutos = new RepositorioProduto();
	static long id = 0;
	
	public boolean validarNome(String nome) {
		if(nome.equals(null) || nome.equals("") || nome.equals(" ")) {
			return false;
		}
		return true;
	}
	
	public boolean validarPreco(float preco){
		if(preco < 0 || preco > 999999999) {
			return false;
		}
		return true;
	}
	
	public boolean validarQuantidade(int quantidade) {
		if(quantidade < 0 || quantidade > 999999999){
			return false;
		}
		return true;
	}
	
	public boolean validarLojaFornecedor(String lojaFornecedora) {
		if(lojaFornecedora.equals(null) || lojaFornecedora.equals("") || lojaFornecedora.equals(" ")) {
			return false;
		}
		return true;
	}
	
	public boolean cadastrarProduto(String nome, float preco, int quantidade, String lojaFornecedora) throws Exception{
		if(!validarNome(nome)) {
			throw new Exception("Nome invalido");
		}
		if(!validarPreco(preco)) {
			throw new Exception("Preco invalido");
		}
		if(!validarQuantidade(quantidade)) {
			throw new Exception("Quantidade invalido");
		}
		if(!validarLojaFornecedor(lojaFornecedora)) {
			throw new Exception("Loja invalido");
		}
		
		repProdutos.cadastrar(this.id, nome, preco, quantidade, lojaFornecedora);
		id++;
		return true;
	}
}
