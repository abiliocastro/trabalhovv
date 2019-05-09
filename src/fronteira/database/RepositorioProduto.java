package fronteira.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
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
	
	public ArrayList<Produto> lerProdutos(){
		String comandoSQL = "SELECT * FROM produto";
		try {
			Connection conn = conexao.getConexao();
			Statement stmt = conn.createStatement();
			ResultSet rs = stmt.executeQuery(comandoSQL);
			while(rs.next()) {
				Produto produto = new Produto();
				produto.setId(rs.getLong("id"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setLojaFornecedora(rs.getString("loja"));
				this.produtos.add(produto);
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return this.produtos;
	}
	
	public Produto lerProduto(long id){
		Produto produto = null;
		String comandoSQL = "SELECT * FROM produto WHERE id = ?";
		try {
			Connection conn = conexao.getConexao();
			PreparedStatement preparedStatemet = conn.prepareStatement(comandoSQL);
			preparedStatemet.setLong(1, id);
			ResultSet rs = preparedStatemet.executeQuery();
			while(rs.next()) {
				produto = new Produto();
				produto.setId(rs.getInt("id"));
				produto.setNome(rs.getString("nome"));
				produto.setPreco(rs.getFloat("preco"));
				produto.setQuantidade(rs.getInt("quantidade"));
				produto.setLojaFornecedora(rs.getString("loja"));
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return produto;
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
		String comandoSQL = "UPDATE produto SET nome = ?, preco = ?, quantidade = ?, loja = ? WHERE id = ?";
		try {
			Connection conn = conexao.getConexao();
			PreparedStatement preparedStatemet = conn.prepareStatement(comandoSQL);
			preparedStatemet.setString(1, nome);
			preparedStatemet.setFloat(2,preco);
			preparedStatemet.setInt(3, quantidade);
			preparedStatemet.setString(4, lojaFornecedora);
			preparedStatemet.setLong(5, id);
			int qtdRowsAffected  = preparedStatemet.executeUpdate();
			preparedStatemet.close();
			conn.close();
			if(qtdRowsAffected>0)
				return true;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return false;
	}
	
	public boolean removerProduto(long id) {
		String comandoSQL = "DELETE FROM produto WHERE id = ?";
		try {
			Connection conn = conexao.getConexao();
			PreparedStatement preparedStatemet = conn.prepareStatement(comandoSQL);
			preparedStatemet.setLong(1, id);
			int rowAffected = preparedStatemet.executeUpdate();
			if(rowAffected>0) {
				return true;
			}
			conn.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return false;
	}	
	
}
