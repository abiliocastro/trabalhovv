package testes.integracao;


import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;

import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import entidade.Administrador;
import fronteira.database.Conexao;
import fronteira.database.RepositorioAdministrador;


public class RepositorioAdministradorTeste {
	@Mock
	Conexao con = Mockito.mock(Conexao.class);
	
	@Mock
	Connection c = Mockito.mock(Connection.class);
	
	@Mock
	Statement statement = Mockito.mock(Statement.class);
	
	@Mock
	PreparedStatement preStatement = Mockito.mock(PreparedStatement.class);
	
	private Administrador adminstrador;
	
	@Mock
	ResultSet resultSet = Mockito.mock(ResultSet.class);
	
	@Before
	public void setUp() {
		Mockito.when(con.getConexao()).thenReturn(c);		
	}
	@Before
	public void setObterAdministrador() throws SQLException {
		
		adminstrador = new Administrador();
		adminstrador.setNomeDeUsuario("Admin");
		adminstrador.setSenha("Admin");
		
		Mockito.when(preStatement.executeUpdate()).thenReturn(1);
		Mockito.when(resultSet.getString("nome")).thenReturn(adminstrador.getNomeDeUsuario());
		Mockito.when(resultSet.getString("senha")).thenReturn(adminstrador.getSenha());
		Mockito.doNothing().when(preStatement).close();
		
	}
	
	@Before
	public void setObterAdministradores() throws SQLException {
		Mockito.when(c.createStatement()).thenReturn(statement);
		Mockito.when(statement.executeQuery(Mockito.any(String.class))).thenReturn(resultSet);
		Mockito.when(resultSet.next()).thenReturn(true, false);
	}
	
	@Test
	public void obterAdministradores() {
		RepositorioAdministrador repoAdmins = RepositorioAdministrador.getInstance();
		repoAdmins.setConexao(con);
		assertFalse(repoAdmins.obterAdministradores().isEmpty());
	}
	
	@Test
	public void obterAdministrador() throws SQLException {
		RepositorioAdministrador repoAdmins = RepositorioAdministrador.getInstance();
		repoAdmins.setConexao(con);
		Administrador admLido = repoAdmins.obterAdmnistrador("admin");
		
		assertEquals(admLido.getNomeDeUsuario(),adminstrador.getNomeDeUsuario());
	}
	

}