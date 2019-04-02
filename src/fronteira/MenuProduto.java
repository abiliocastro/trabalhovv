package fronteira;

import java.util.Scanner;

import controlador.ControladorProduto;

public class MenuProduto {
	private static ControladorProduto cp = new ControladorProduto();
		
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		System.out.println("1- Listar | 2- Cadastrar | 3- Editar | 4- Excluir | 0 - Sair\nDigite a opc:");
		int entrada = Integer.parseInt(sc.nextLine());
		
		switch (entrada) {
		case 0:
			System.out.println("Ádios joputa");
			break;
		case 1:
			break;
		case 2:		
			try {
				System.out.println("Digite o nome do produto: ");
				String nome = sc.nextLine();
				System.out.println("Digite o preço do produto: ");
				float preco = Float.parseFloat(sc.nextLine());
				System.out.println("Digite a quantidade do produto: ");
				int quantidade = Integer.parseInt(sc.nextLine());
				System.out.println("Digite a loja fornecedora do produto: ");
				String lojaFornecedora= sc.nextLine();
				
				cp.cadastrarProduto(nome, preco, quantidade, lojaFornecedora);
			}catch (NumberFormatException e) {
				System.out.println("formato da entrada invalida");
			}catch (Exception e) {
				
			}finally {
				
			}
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
