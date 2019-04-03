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
			try {
				menuInicial.selecionarOpcao(opcao);
			} catch (Exception e) {
				System.out.println(e.getMessage());
			}
		}
		
		entrada.close();	
	}
	
	public static void inicializarSistema() {
		inicializarUsuarios();
	}
	
	public static void inicializarUsuarios() {
		repoAdmins = RepositorioAdministrador.getInstance();
		repoAdmins.cadastrarAdministrador("abilio", "luke");
		repoAdmins.cadastrarAdministrador("leandro", "mlteamor");
		repoAdmins.cadastrarAdministrador("douglas", "senha12");
	}
	
}