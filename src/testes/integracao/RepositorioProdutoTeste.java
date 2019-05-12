package testes.integracao;

import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import fronteira.database.Conexao;
import fronteira.database.RepositorioProduto;

public class RepositorioProdutoTeste {
	@Mock
	Conexao con = Mockito.mock(Conexao.class);
	
	@Mock
	private Connection c = Mockito.mock(Connection.class);
	
	@Mock
	private PreparedStatement preStatement = Mockito.mock(PreparedStatement.class);
	
	@Mock
	private ResultSet resultSet = Mockito.mock(ResultSet.class);
	
	@Mock
	private Statement statement = Mockito.mock(Statement.class);
	

	@Before
	public void setUp() throws Exception {
		Mockito.when(con.getConexao()).thenReturn(c);		
		Mockito.when(preStatement.executeUpdate()).thenReturn(1);
		Mockito.doNothing().when(preStatement).close();	
	}
	
	@Before
	public void setCadastrar() throws SQLException {
		Mockito.when(c.prepareStatement(Mockito.startsWith("INSERT"))).thenReturn(preStatement);
	}
	
	@Before
	public void setLer() throws SQLException {
		Mockito.when(c.createStatement()).thenReturn(statement);
		Mockito.when(statement.executeQuery(Mockito.any(String.class))).thenReturn(resultSet);
		Mockito.when(resultSet.next()).thenReturn(true, false);
	}
	
	@Before
	public void setEditar() throws SQLException {
		Mockito.when(c.prepareStatement(Mockito.startsWith("UPDATE"))).thenReturn(preStatement);
	}
	
	@Before
	public void setDeletar() throws SQLException {
		Mockito.when(c.prepareStatement(Mockito.startsWith("DELETE"))).thenReturn(preStatement);
	}
	
	@Before
	public void setBuscar() throws SQLException {
		Mockito.when(resultSet.getLong("id")).thenReturn(8888L);
		Mockito.when(resultSet.getString("nome")).thenReturn("Produto Mockado");
		Mockito.when(resultSet.getFloat("preco")).thenReturn(69.69F);
		Mockito.when(resultSet.getInt("quantidade")).thenReturn(69);
		Mockito.when(resultSet.getString("loja")).thenReturn("Loja Mockada");
	}
	
	@Test
	public void cadastrar() throws Exception {
		RepositorioProduto rp = RepositorioProduto.getInstance();
		rp.setConexao(con);
		rp.cadastrar("BigBig o bombom", 1.50F, 30, "Loja do Manel");
		Mockito.verify(preStatement, Mockito.times(1)).executeUpdate();
	}
	
	@Test
	public void lerProdutos() {
		RepositorioProduto rp = RepositorioProduto.getInstance();
		rp.setConexao(con);
		boolean result = rp.lerProdutos().isEmpty(); 
		assertFalse(result);		
	}
	
	@Test
	public void editarProduto() {
		RepositorioProduto rp = RepositorioProduto.getInstance();
		rp.setConexao(con);
		boolean result = rp.editar(6000, "Product", 69.69F, 4, "Store");
		assertTrue(result);
	}
	
	@Test
	public void removerProduto() {
		RepositorioProduto rp = RepositorioProduto.getInstance();
		rp.setConexao(con);
		boolean result = rp.removerProduto(6000);
		assertTrue(result);
	}
	
	@Test
	public void buscarProdutos() {
		RepositorioProduto rp = RepositorioProduto.getInstance();
		rp.setConexao(con);
		boolean result = rp.buscarProdutos("@").isEmpty();
		assertFalse(result);
	}
	
}
