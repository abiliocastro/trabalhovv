package fronteira;

import java.util.Scanner;

import controlador.ControladorProduto;

public class Main {
	static RepositorioAdministrador repoAdmins;
	static ControladorProduto controladorProduto = new ControladorProduto();
	
	public static void main(String[] args) {
		Scanner entrada = new Scanner(System.in);
		InterfaceMenuInicial menuInicial = new InterfaceMenuInicial();
		inicializarSistema();
		InterfaceBusca ib = new InterfaceBusca();
		
		
		
		ib.mostra();
		
		boolean sair = true;
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
		inicializarProdutos();
	}
		
	public static void inicializarUsuarios() {
		repoAdmins = RepositorioAdministrador.getInstance();
		repoAdmins.cadastrarAdministrador("abilio", "luke");
		repoAdmins.cadastrarAdministrador("leandro", "mlteamor");
		repoAdmins.cadastrarAdministrador("douglas", "senha12");
		
	}
	public static void inicializarProdutos() {
		try {
			controladorProduto.cadastrarProduto("Iphone Ruim", 5000f, 8, "Chico Cell");
			controladorProduto.cadastrarProduto("Iphone Ruim 2", 5000f, 8, "Chico Cell");
			controladorProduto.cadastrarProduto("Celular Ruim", 5000f, 8, "Chico Cell");
			controladorProduto.cadastrarProduto("Televisao", 340.99f, 1, "Jose Moveis");
			controladorProduto.cadastrarProduto("Televisao 2", 340.99f, 1, "Outro");
			controladorProduto.cadastrarProduto("Banana", 1.5f, 880, "Toim das Frutas");
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
}