package testes.integracao;


import static org.junit.Assert.assertFalse;
import static org.junit.jupiter.api.Assertions.assertEquals;
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
	
	@Mock
	ResultSet resultSet = Mockito.mock(ResultSet.class);
	
	@Before
	public void setUp() {
		Mockito.when(con.getConexao()).thenReturn(c);		
	}
	@Before
	public void setObterAdministrador() throws SQLException {
		Mockito.when(c.prepareStatement(Mockito.startsWith("SELECT"))).thenReturn(preStatement);
		
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
	public void obterAdministrador() {
		RepositorioAdministrador repoAdmins = RepositorioAdministrador.getInstance();
		repoAdmins.setConexao(con);
		assert(repoAdmins.obterAdmnistrador("jose"));
	}
	

}
