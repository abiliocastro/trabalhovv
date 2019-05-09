package controlador;

import java.sql.SQLException;
import java.util.ArrayList;

import entidade.Produto;
import excecoes.IdInexistenteException;
import excecoes.IdInvalidoException;
import excecoes.LojaFornecedoraInvalidaException;
import excecoes.NomeInvalidoException;
import excecoes.PrecoInvalidoException;
import excecoes.QuantidadeInvalidaException;
import fronteira.database.Conexao;
import fronteira.database.RepositorioProduto;

public class ControladorProduto {
	RepositorioProduto repProdutos = RepositorioProduto.getInstance();
	
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
		repProdutos.setConexao(new Conexao());
		repProdutos.cadastrar(nome, preco, quantidade, lojaFornecedora);
		return true;
	}
	
	public boolean existeId(long id) throws Exception {
		if(!validarId(id)) {
			throw new IdInvalidoException();
		}
		repProdutos.setConexao(new Conexao());
		if(repProdutos.lerProduto(id) != null) {
			return true;
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
		repProdutos.setConexao(new Conexao());
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
		repProdutos.setConexao(new Conexao());
		if(repProdutos.removerProduto(id)) {
			return true;
		}else {
			throw new IdInexistenteException();
		}
	}
	
	public ArrayList<Produto> listarProdutos(){
		try {
			repProdutos.setConexao(new Conexao());
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return repProdutos.lerProdutos();
	}

}
