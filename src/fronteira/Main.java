package fronteira;

import java.util.Scanner;

public class Main {
	static RepositorioAdministrador repoAdmins;
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		InterfaceMenuInicial menuInicial = new InterfaceMenuInicial();
		inicializarSistema();

		boolean sair = false;
		while(!sair) {
			System.out.println("PROC_BUSC 0.1");
			menuInicial.mostra();
			int opcao = entrada.nextInt();
			menuInicial.selecionarOpcao(opcao);
		}
		
		entrada.close();	
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