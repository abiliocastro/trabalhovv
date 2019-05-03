package fronteira.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conexao {

	private final String url = "jdbc:postgresql://localhost:5432/busca_produtos";
    private final String usuario = "seu_nome_usuario";
    private final String senha = "sua_senha";
    private Connection conexao;
    
    /**
     * Connect to the PostgreSQL database
     *
     * @return a Connection object
     * @throws java.sql.SQLException
     */
    public Conexao() throws SQLException {
        this.conexao = DriverManager.getConnection(url, usuario, senha);
    }
    
    public Connection getConexao() {
    	return this.conexao;
    }
	
}
