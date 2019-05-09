package testes.integracao;

import java.sql.Connection;
import java.sql.PreparedStatement;

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
	private PreparedStatement stmt = Mockito.mock(PreparedStatement.class);
	
	RepositorioProduto rp = RepositorioProduto.getInstance();
	
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
	public void setLer() {
	//	Mockito.when(methodCall)
	}
	
	@Test
	public void cadastrar() throws Exception {
		rp.setConexao(con);
		rp.cadastrar("BigBig o bombom", 1.50F, 30, "Loja do Manel");
		Mockito.verify(stmt, Mockito.times(1)).executeUpdate();
	}
	@Test
	public void lerProdutos() {
		rp.setConexao(con);
		//rp.lerProdutos();
		
	}
	
}
