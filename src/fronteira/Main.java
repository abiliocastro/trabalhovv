package fronteira;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import controlador.ControladorProduto;
import controlador.GeradorProdutos;
import fronteira.database.RepositorioAdministrador;

public class Main {
	static RepositorioAdministrador repoAdmins;
	static ControladorProduto controladorProduto = new ControladorProduto();
	
	public static void main(String[] args){
		Scanner entrada = new Scanner(System.in);
		InterfaceMenuInicial menuInicial = new InterfaceMenuInicial();
		try {
			inicializarSistema();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			
		}
		boolean sair = false;
		String opcao ;
		while(!sair) {
			try {
				System.out.println("PROC_BUSC 0.1");
				menuInicial.mostra(); 	
				opcao = entrada.nextLine();
				menuInicial.selecionarOpcao(opcao);
				
			}catch (InputMismatchException e) {
				System.out.println("Opcao invalida");
				
			} catch (Exception e) {
				System.out.println(e.getMessage());
				
			}
		}
		
		entrada.close();	
	}
	
	public static void inicializarSistema() throws IOException {
		inicializarUsuarios();
		//inicializarProdutos();
		//gerarProdutoAleatorios();
	}
		
	public static void inicializarUsuarios() {
		repoAdmins = RepositorioAdministrador.getInstance();
		repoAdmins.cadastrarAdministrador("abilio", "luke");
		repoAdmins.cadastrarAdministrador("leandro", "mlteamor");
		repoAdmins.cadastrarAdministrador("douglas", "");
		
	}
	public static void inicializarProdutos() {
		try {
			controladorProduto.cadastrarProduto("Iphone Ruim", 5000f, 8, "Chico Cell");
			controladorProduto.cadastrarProduto("Iphone Ruim 2", 5000f, 8, "Chico Cell");
			controladorProduto.cadastrarProduto("Celular Ruim", 5000f, 8, "Chico Cell");
			controladorProduto.cadastrarProduto("Televisao", 340.99f, 1, "Jose Moveis");
			controladorProduto.cadastrarProduto("Televisao 2", 340.99f, 1, "Outro");
			controladorProduto.cadastrarProduto("Banana", 1.5f, 880, "Toim das Frutas");
			controladorProduto.cadastrarProduto("ata", 2.5f, 880, "Toim das Frutas");
		} catch (Exception e) {
			e.getMessage();
		}
		
	}
	public static void gerarProdutoAleatorios() {
		GeradorProdutos geradorProdutos = new GeradorProdutos();
		
			try {
				int qddProdutosGerados = 1000;
				int precoMaximoProduto = 5000;
				int qtdMaximoProduto = 250;
				
				
				System.out.println("Gerando "+qddProdutosGerados+" Produtos Aguarde...");
				geradorProdutos.GerarProdutosAleatorios(qddProdutosGerados,precoMaximoProduto,qtdMaximoProduto);
				System.out.println(qddProdutosGerados+" produtos cadastrado no banco de dados!");
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		
		
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}