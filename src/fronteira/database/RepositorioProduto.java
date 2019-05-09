package fronteira.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;

import entidade.Produto;

public class RepositorioProduto {
	private ArrayList<Produto> produtos; 
	private static RepositorioProduto uniqueInstance = new RepositorioProduto();
	private Conexao conexao;
	
	private RepositorioProduto() {
		produtos = new ArrayList<Produto>();
	}
	
	public static RepositorioProduto getInstance() {
		return uniqueInstance;
	}
	
	public void setConexao(Conexao conexao) {
		this.conexao = conexao;
	}
	
	public boolean cadastrar(String nome, float preco, int quantidade, String lojaFornecedora) {
		String comandoSQL = "INSERT INTO produto(nome,preco,quantidade ,loja) VALUES (?, ?, ?,?);";
		try {
			Connection conn = conexao.getConexao();
			PreparedStatement preparedStatemet = conn.prepareStatement(comandoSQL);
			preparedStatemet.setString(1, nome);
			preparedStatemet.setFloat(2,preco);
			preparedStatemet.setInt(3, quantidade);
			preparedStatemet.setString(4, lojaFornecedora);
			
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
