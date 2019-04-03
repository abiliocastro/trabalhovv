package fronteira;

public class Main {
	static RepositorioAdministrador repoAdmins;
	
	public static void main(String[] args) {
		inicializarSistema();
	}
	
	public static void inicializarSistema() {
		inicializarUsuarios();
		menuProduto();
	}
	
	public static void menuProduto() {
		MenuProduto mp = new MenuProduto();
		mp.SelecionarOpcao();
	}
	
	public static void inicializarUsuarios() {
		repoAdmins = RepositorioAdministrador.getInstance();
		repoAdmins.cadastrarAdministrador("abilio", "luke");
		repoAdmins.cadastrarAdministrador("leandro", "mlteamor");
		repoAdmins.cadastrarAdministrador("douglas", "senha12");
	}

}
