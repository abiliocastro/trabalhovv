package testes.integracao;

import java.sql.Connection;
import java.sql.PreparedStatement;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.invocation.InvocationOnMock;
import org.mockito.stubbing.Answer;

import fronteira.database.Conexao;
import fronteira.database.RepositorioProduto;

public class RepositorioProdutoTeste {
	@Mock
	private Conexao con = Mockito.mock(Conexao.class);
	
	@Mock
	private Connection c = Mockito.mock(Connection.class);
	
	@Mock
	private PreparedStatement stmt = Mockito.mock(PreparedStatement.class);
	
	@Before
	public void setUp() throws Exception {
		Mockito.when(con.getConexao()).thenReturn(c);
		Mockito.when(c.prepareStatement(Mockito.any(String.class))).thenReturn(stmt);
		
		Mockito.doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				System.out.println("isso");
				return null;
			}
		}).when(stmt).setString(Mockito.eq(1), Mockito.any(String.class));
		Mockito.doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		}).when(stmt).setFloat(Mockito.eq(2), Mockito.any(Float.class));
		Mockito.doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		}).when(stmt).setInt(Mockito.eq(3), Mockito.any(Integer.class));
		Mockito.doAnswer(new Answer<Void>() {
			@Override
			public Void answer(InvocationOnMock invocation) throws Throwable {
				return null;
			}
		}).when(stmt).setString(Mockito.eq(4), Mockito.any(String.class));
		
		Mockito.when(stmt.executeUpdate()).thenReturn(1);
		Mockito.doNothing().when(stmt).close();
	}
	
	@Test
	public void cadastrar() throws Exception {
		RepositorioProduto rp = RepositorioProduto.getInstance();
		rp.cadastrar("BigBig o bombom", 1.50F, 30, "Loja do Manel");
		Mockito.verify(stmt).executeUpdate();
	}
}
