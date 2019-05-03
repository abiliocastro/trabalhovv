package controlador;

import java.util.ArrayList;

import entidade.Produto;
import excecoes.IdInexistenteException;
import excecoes.IdInvalidoException;
import excecoes.LojaFornecedoraInvalidaException;
import excecoes.NomeInvalidoException;
import excecoes.PrecoInvalidoException;
import excecoes.QuantidadeInvalidaException;
import fronteira.database.RepositorioProduto;

public class ControladorProduto {
	RepositorioProduto repProdutos = RepositorioProduto.getInstance();
	static long id = 0;
	
	public boolean validarNome(String nome) {
		if(nome == null || !nome.matches("^[a-zA-Z$][a-zA-Z_ $0-9]*$") || nome.length() > 255) {
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
		if(lojaFornecedora == null || !lojaFornecedora.matches("^[a-zA-Z$][a-zA-Z_ $0-9]*$")|| lojaFornecedora.length() > 255) {
			return false;
		}
		return true;
	}
	
	public boolean validarId(long id) {
		if(id < 0) {
			return false;
		}
		return true;
	}
	
	public boolean cadastrarProduto(String nome, float preco, int quantidade, String lojaFornecedora) throws Exception{
		if(!validarNome(nome)) {
			throw new NomeInvalidoException();
		}
		if(!validarPreco(preco)) {
			throw new PrecoInvalidoException();
		}
		if(!validarQuantidade(quantidade)) {
			throw new QuantidadeInvalidaException();
		}
		if(!validarLojaFornecedor(lojaFornecedora)) {
			throw new LojaFornecedoraInvalidaException();
		}
		
		repProdutos.cadastrar(ControladorProduto.id, nome, preco, quantidade, lojaFornecedora);
		id++;
		return true;
	}
	
	public boolean existeId(long id) throws Exception {
		if(!validarId(id)) {
			throw new IdInvalidoException();
		}
		
		for (Produto p : repProdutos.getProdutos()) {
			if(p.getId() == id) {
				return true;
			}
		}
		throw new IdInexistenteException();
	}
	
	public boolean editarProduto(long id, String nome, float preco, int quantidade, String lojaFornecedora) throws Exception {
		if(!validarNome(nome)) {
			throw new NomeInvalidoException();
		}
		if(!validarPreco(preco)) {
			throw new PrecoInvalidoException();
		}
		if(!validarQuantidade(quantidade)) {
			throw new QuantidadeInvalidaException();
		}
		if(!validarLojaFornecedor(lojaFornecedora)) {
			throw new LojaFornecedoraInvalidaException();
		}
		
		if(repProdutos.editar(id, nome, preco, quantidade, lojaFornecedora)) {
			return true;
		} else {
			throw new IdInexistenteException();
		}
	}
	
	public boolean removerProduto(long id) throws Exception{
		if(!validarId(id)) {
			throw new IdInvalidoException();
		}
		
		if(repProdutos.removerProduto(id)) {
			return true;
		}else {
			throw new IdInexistenteException();
		}
	}
	
	public ArrayList<Produto> listarProdutos(){
		return repProdutos.getProdutos();
	}

}
