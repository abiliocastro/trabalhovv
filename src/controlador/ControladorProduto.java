package controlador;

import java.util.ArrayList;

import entidade.Produto;
import excecoes.NomeInvalidoException;
import excecoes.PrecoInvalidoExceptio;
import excecoes.QuantidadeInvalidaException;
import excecoes.lojaFornecedoraInvalidaException;
import fronteira.RepositorioProduto;

public class ControladorProduto {
	RepositorioProduto repProdutos = RepositorioProduto.getInstance();
	static long id = 0;
	
	public boolean validarNome(String nome) {
		if(nome == null || nome.equals("") || nome.equals(" ")) {
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
		if(lojaFornecedora == null || lojaFornecedora.equals("") || lojaFornecedora.equals(" ")) {
			return false;
		}
		return true;
	}
	
	public boolean cadastrarProduto(String nome, float preco, int quantidade, String lojaFornecedora) throws Exception{
		if(!validarNome(nome)) {
			throw new NomeInvalidoException();
		}
		if(!validarPreco(preco)) {
			throw new PrecoInvalidoExceptio();
		}
		if(!validarQuantidade(quantidade)) {
			throw new QuantidadeInvalidaException();
		}
		if(!validarLojaFornecedor(lojaFornecedora)) {
			throw new lojaFornecedoraInvalidaException();
		}
		
		repProdutos.cadastrar(this.id, nome, preco, quantidade, lojaFornecedora);
		id++;
		return true;
	}
	
	public boolean removerProduto(int id) {
		if(repProdutos.existeProduto(id)) {
			repProdutos.removerProduto(id);
		}
		return false;
	}
	
	public ArrayList<Produto> listarProdutos(){
		return repProdutos.getProdutos();
	}
}
