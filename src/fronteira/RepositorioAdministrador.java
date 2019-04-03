package fronteira;

import java.util.ArrayList;
import entidade.Administrador;

public class RepositorioAdministrador {
	
	private ArrayList<Administrador> administradores;

	private static RepositorioAdministrador repositorioAdministrador = new RepositorioAdministrador();
	
	private RepositorioAdministrador() {
		administradores = new ArrayList<>();
	}
	
	public static RepositorioAdministrador getInstance() {
		return repositorioAdministrador;
	}
	
	public ArrayList<Administrador> obterAdministradores() {
		return administradores;
	}
	
	public void cadastrarAdministrador(String nomeDeUsuario, String senha) {
		Administrador novoAdministrador = new Administrador(nomeDeUsuario, senha);
		this.administradores.add(novoAdministrador);
	}
	
	public Administrador obterAdmnistrador(String nomeDeUsuario) {
		for (Administrador administrador : this.administradores) {
			if(administrador.getNomeDeUsuario().equals(nomeDeUsuario)) {
				return administrador;
			}
		}
		return null;
	}
	
}
