package fronteira;

import java.util.ArrayList;

import entidade.Administrador;

public class RepositorioAdministrador {
	private ArrayList<Administrador> listaDeAdmin;
	
	public RepositorioAdministrador() {
		listaDeAdmin = new ArrayList<Administrador>();
	}
	public boolean adicionarAdminstrador(String login,String senha) {
		Administrador admin = new Administrador(login, senha);
		if(listaDeAdmin.add(admin)) {
			return true;
		}
		return false;
		
	}
	public Administrador buscarAdmin(String login) {
		for (Administrador administrador : listaDeAdmin) {
			if(administrador.getNomeDeUsuario().equals(login)) {
				return administrador;
			}
		}
		return null;
	}
	public ArrayList<Administrador> getListaDeAdmin() {
		return listaDeAdmin;
	}
	public void setListaDeAdmin(ArrayList<Administrador> listaDeAdmin) {
		this.listaDeAdmin = listaDeAdmin;
	}
	
	
	
	
}
