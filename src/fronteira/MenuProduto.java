package fronteira;

import java.util.Scanner;

import controlador.ControladorProduto;

public class MenuProduto {
	private Scanner sc;
	private ControladorProduto cp = new ControladorProduto();
	
	public MenuProduto() {
		cp = new ControladorProduto();
		sc = new Scanner(System.in);
	}
		
	public void SelecionarOpcao() {
		System.out.println("1- Listar | 2- Cadastrar | 3- Editar | 4- Excluir | 0 - Sair\nDigite a opc:");
		
		try {
			int entrada = Integer.parseInt(sc.nextLine());
		
			switch (entrada) {
			case 0:
				System.out.println("Ádios joputa");
				break;
			case 1:
				break;
			case 2:		
				this.OpcaoCadastro();
				break;
			case 3:
				break;
			case 4:
				break;
			
			default:
				System.out.println("Opção invalida!");
			}
		} catch (NumberFormatException e) {
			System.out.println("formato da entrada invalida");
			SelecionarOpcao();
		}
	}
	
	public void OpcaoCadastro() {
		try {
			System.out.println("Digite o nome do produto: ");
			String nome = sc.nextLine();
			System.out.println("Digite o preço do produto: ");
			float preco = Float.parseFloat(sc.nextLine());
			System.out.println("Digite a quantidade do produto: ");
			int quantidade = Integer.parseInt(sc.nextLine());
			System.out.println("Digite a loja fornecedora do produto: ");
			String lojaFornecedora= sc.nextLine();
			
			System.out.println(cp.cadastrarProduto(nome, preco, quantidade, lojaFornecedora));
		}catch (NumberFormatException e) {
			System.out.println("formato da entrada invalida");
			OpcaoCadastro();
		}catch (Exception e) {
			System.out.println("Um erro foi encontrado: "+e.getMessage());
		}finally {
		}
	}
	
}
