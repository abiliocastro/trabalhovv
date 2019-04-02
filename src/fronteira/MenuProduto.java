package fronteira;

import java.util.Scanner;

import controlador.ControladorProduto;

public class MenuProduto {
	private static ControladorProduto cp = new ControladorProduto();
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1- Listar | 2- Cadastrar | 3- Editar | 4- Excluir | 0 - Sair\nDigite a opc:");
		int entrada = sc.nextInt();
		
		switch (entrada) {
		case 0:
			System.out.println("Ádios joputa");
			break;
		case 1:
			break;
		case 2:			
			System.out.println("Digite o nome do produto: ");
			String nome = sc.next();
			System.out.println("Digite o preço do produto: ");
			float preco = sc.nextFloat();
			System.out.println("Digite a quantidade do produto: ");
			int quantidade = sc.nextInt();
			System.out.println("Digite a loja fornecedora do produto: ");
			String lojaFornecedora= sc.next();
			
			cp.cadastrarProduto(nome, preco, quantidade, lojaFornecedora);
			break;
		case 3:
			break;
		case 4:
			break;
		
		default:
			System.out.println("Opção invalida!");
		}
		
	}
	
}
