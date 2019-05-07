package fronteira.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
	
	public boolean cadastrar(long id, String nome, float preco, int quantidade, String lojaFornecedora) {
		Produto novoProduto = new Produto(id, nome, preco, quantidade, lojaFornecedora);
		String comandoSQL = "INSERT INTO produto(id,nome,preco,quantidade ,loja) VALUES (?,?, ?, ?,?);";
		Conexao conexao = null;
		try {
			conexao = new Conexao();
			Connection conn = conexao.getConexao();
			PreparedStatement preparedStatemet = conn.prepareStatement(comandoSQL);
			preparedStatemet.setInt(1, (int) novoProduto.getId());
			preparedStatemet.setString(2, novoProduto.getNome());
			preparedStatemet.setFloat(3, novoProduto.getPreco());
			preparedStatemet.setInt(4, novoProduto.getQuantidade());
			preparedStatemet.setString(5, novoProduto.getLojaFornecedora());
			
			int qtdRowsAffected  = preparedStatemet.executeUpdate();
			preparedStatemet.close();
			if(qtdRowsAffected>0) 
				return true;
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}finally {
			try {
				conexao.getConexao().close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		return false;
	}
	
	public boolean editar(long id, String nome, float preco, int quantidade, String lojaFornecedora) {
		for (Produto produto : this.produtos) {
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
	
	public boolean removerProduto(long id) {
		for (Produto produto : produtos) {
			if(produto.getId() == id) {
				produtos.remove(produto);
				return true;
			}
		}
		return false;
	}
	
	public ArrayList<Produto> getProdutos(){
		return this.produtos;
	}
	
	
	
	
}
