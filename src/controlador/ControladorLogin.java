package controlador;

import java.util.regex.Pattern;

import entidade.Administrador;
import excecoes.SenhaIncorretaException;
import excecoes.UsuarioInexistenteException;
import excecoes.UsuarioInvalidoException;
import fronteira.RepositorioAdministrador;

public class ControladorLogin {
	static RepositorioAdministrador repoAdmins;
	
	public ControladorLogin() {
		repoAdmins = RepositorioAdministrador.getInstance();
	}
	
	public boolean realizarLogin(String nomeDeUsuario, String senha) throws Exception {
		if(Pattern.matches("^[a-zA-Z$][a-zA-Z_$0-9]*$", nomeDeUsuario)) {
			Administrador admin = repoAdmins.obterAdmnistrador(nomeDeUsuario);
			if(admin != null) {
				if(admin.getSenha().equals(senha)) {
					return true;
				}
				throw new SenhaIncorretaException();
			}
			throw new UsuarioInexistenteException();
		}
		throw new UsuarioInvalidoException();
		 
	}
	
}	