package controlador;

import entidade.Administrador;
import excecoes.UsuarioInvalidoException;
import fronteira.RepositorioAdministrador;

public class ControladorLogin {
	static RepositorioAdministrador repoAdmins;
	
	public ControladorLogin() {
		repoAdmins = RepositorioAdministrador.getInstance();
	}
	
	public void realizarLogin(String nomeDeUsuario, String senha) throws Exception {
		Administrador admin = repoAdmins.obterAdmnistrador(nomeDeUsuario);
		if(admin != null) {
			
		}
		throw new UsuarioInvalidoException(); 
	}
	
}	