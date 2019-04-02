package controlador;

import entidade.Administrador;
import fronteira.RepositorioAdministrador;

public class ControladorLogin {
	private Administrador admin;
	private RepositorioAdministrador repositorioDeAdminnistradores;
	public ControladorLogin() {
		repositorioDeAdminnistradores = new RepositorioAdministrador();
		admin = null;
	}
	
	public boolean entrar(String login,String senha) {	
		admin = repositorioDeAdminnistradores.buscarAdmin(login);
		if(admin!=null) {
			if(admin.getSenha().equals(senha)) {	
				return true;
			}
		}
		return false;
	}
	
	
}
