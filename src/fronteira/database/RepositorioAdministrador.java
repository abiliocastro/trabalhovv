package fronteira.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import entidade.Administrador;

public class RepositorioAdministrador {
	
	private ArrayList<Administrador> administradores;
	private static RepositorioAdministrador repositorioAdministrador = new RepositorioAdministrador();
	private Conexao conexao;
	
	private RepositorioAdministrador() {
		administradores = new ArrayList<>();
	}
	
	public static RepositorioAdministrador getInstance() {
		return repositorioAdministrador;
	}
	public void setConexao(Conexao conexao) {
		this.conexao = conexao;
	}
	
	public ArrayList<Administrador> obterAdministradores() {
		String sql = "SELECT * FROM administrador";
		try {
			Connection conn = conexao.getConexao();
			Statement stm = conn.createStatement();
			ResultSet rs = stm.executeQuery(sql);
			while(rs.next()) {
				Administrador novoAdm = new Administrador();
				novoAdm.setNomeDeUsuario(rs.getString("nome"));
				novoAdm.setSenha(rs.getString("senha"));
				administradores.add(novoAdm);
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return administradores;
	}
	
	public boolean cadastrarAdministrador(String nomeDeUsuario, String senha) {
		Administrador novoAdministrador = new Administrador(nomeDeUsuario, senha);
		if(administradores.add(novoAdministrador)) {
			return true;
		}
		return false;
	}
	
	public Administrador obterAdmnistrador(String nomeDeUsuario) {
		String sql = "SELECT * FROM administrador WHERE nome = ?";
		try {
			Connection conn = conexao.getConexao();
			PreparedStatement pstm = conn.prepareStatement(sql);
			pstm.setString(1, nomeDeUsuario);
			ResultSet rs = pstm.executeQuery();
			if(rs.next()) {
				Administrador admin = new Administrador();
				admin.setNomeDeUsuario(rs.getString("nome"));
				admin.setSenha(rs.getString("senha"));
				return admin;
			} else {
				return null;
			}
			
		} catch (Exception e) {
			e.printStackTrace(System.out);
			return null;
		}
	}
	
}
