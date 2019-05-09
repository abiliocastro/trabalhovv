package testes.integracao;


import static org.junit.Assert.assertEquals;

import java.beans.Statement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import entidade.Produto;
import fronteira.database.Conexao;
import fronteira.database.RepositorioProduto;

public class RepositorioProdutoTeste {
	@Mock
	Conexao con = Mockito.mock(Conexao.class);
	
	@Mock
	private Connection c = Mockito.mock(Connection.class);
	
	@Mock
	private PreparedStatement stmt = Mockito.mock(PreparedStatement.class);
	
	@Mock
	private ResultSet resultSet = Mockito.mock(ResultSet.class);
	
	@Mock
	private Statement statement = Mockito.mock(Statement.class);
	
	Produto produto = null;
	
	@Before
	public void setUp() throws Exception {
		Mockito.when(con.getConexao()).thenReturn(c);
		Mockito.when(c.prepareStatement(Mockito.startsWith("INSERT"))).thenReturn(stmt);
		Mockito.doNothing().when(stmt).setString(Mockito.eq(1), Mockito.any(String.class));
		Mockito.doNothing().when(stmt).setFloat(Mockito.eq(2), Mockito.any(Float.class));
		Mockito.doNothing().when(stmt).setInt(Mockito.eq(3), Mockito.any(Integer.class));
		Mockito.doNothing().when(stmt).setString(Mockito.eq(4), Mockito.any(String.class));		
		Mockito.when(stmt.executeUpdate()).thenReturn(1);
		Mockito.doNothing().when(stmt).close();
		
	}
	@Before
	public void setLer() throws SQLException {
		//Mockito.when(con.getConexao()).thenReturn(c);
		Mockito.when(c.createStatement().executeQuery("SELECT")).thenReturn(resultSet);
		
		produto = new Produto(1, "TV", 1500, 2, "EletroMoveis");
		
		Mockito.when(resultSet.next()).thenReturn(true);
		
		Mockito.when(resultSet.getInt(1)).thenReturn((int) produto.getId());
		Mockito.when(resultSet.getString(2)).thenReturn(produto.getNome());
		Mockito.when(resultSet.getFloat(3)).thenReturn(produto.getPreco());
		Mockito.when(resultSet.getInt(4)).thenReturn(produto.getQuantidade());
		Mockito.when(resultSet.getString(5)).thenReturn(produto.getLojaFornecedora());
		
		Mockito.when(resultSet.next()).thenReturn(false);
	}
	
	@Test
	public void cadastrar() throws Exception {
		RepositorioProduto rp = RepositorioProduto.getInstance();
		rp.setConexao(con);
		rp.cadastrar("BigBig o bombom", 1.50F, 30, "Loja do Manel");
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
	}
	
	@Test
	public void lerProdutos() {
		RepositorioProduto rp = RepositorioProduto.getInstance();
		rp.setConexao(con);
		rp.lerProdutos();
		assertEquals(produto.getNome(), "TV");
		
	}
	
}
