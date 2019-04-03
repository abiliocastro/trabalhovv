package fronteira;

import java.util.Scanner;

import entidade.Produto;

public class Main {
	static RepositorioAdministrador repoAdmins;
	static RepositorioProduto repoProdutos;
	
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
			menuInicial.selecionarOpcao(opcao);
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
		repoProdutos = RepositorioProduto.getInstance();
		repoProdutos.cadastrar(1,"Iphone Ruim", 5000f, 8, "Chico Cell");
		repoProdutos.cadastrar(4,"Iphone Ruim", 5000f, 8, "Chico Cell");
		repoProdutos.cadastrar(2,"Celular Ruim", 5000f, 8, "Chico Cell");	
		

		repoProdutos.cadastrar(1,"Televisao", 340.99f, 1, "Jose Moveis");
		repoProdutos.cadastrar(1,"Televisao", 340.99f, 1, "Outro");
		repoProdutos.cadastrar(3,"banana", 349.0f, 4, "Outro");
	}
}