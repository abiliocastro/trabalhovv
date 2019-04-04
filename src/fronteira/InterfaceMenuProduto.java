package fronteira;

import java.util.Scanner;
import controlador.ControladorProduto;
import entidade.Produto;
import excecoes.IdInexistenteException;

public class InterfaceMenuProduto {
	private Scanner sc;
	private ControladorProduto cp = new ControladorProduto();
	
	public InterfaceMenuProduto() {
		cp = new ControladorProduto();
		sc = new Scanner(System.in);
	}
		
	public void mostrar() {
		System.out.println("1- Listar | 2- Cadastrar | 3- Editar | 4- Excluir | 0 - Sair\nDigite a opc:");
	}
	
	public void lerOpcao() {
		boolean continuar = true;
		while(continuar) {	
			try {
				this.mostrar();
				int entrada = Integer.parseInt(sc.nextLine());
				
				if(entrada == 0) {
					continuar = false;
				}else {
					selecionarOpcao(entrada);
				}
			} catch (NumberFormatException e) {
				System.out.println("formato da entrada invalida");
				lerOpcao();
			}
		}
	}
	
	public void selecionarOpcao(int entrada) {
		switch (entrada) {
			case 1:
				this.opcaoListar();
				break;
			case 2:		
				this.opcaoCadastro();
				break;
			case 3:
				this.opcaoEditar();
				break;
			case 4:
				this.opcaoExcluir();
				break;
			default:
				System.out.println("Opcao invalida!");
			}		
	}
	
	public void opcaoCadastro() {
		try {
			System.out.println("Digite o nome do produto: ");
			String nome = sc.nextLine();
			System.out.println("Digite o preco do produto: ");
			float preco = Float.parseFloat(sc.nextLine());
			System.out.println("Digite a quantidade do produto: ");
			int quantidade = Integer.parseInt(sc.nextLine());
			System.out.println("Digite a loja fornecedora do produto: ");
			String lojaFornecedora= sc.nextLine();
			
			if(cp.cadastrarProduto(nome, preco, quantidade, lojaFornecedora)) {
				System.out.println("produto cadastrado com sucesso");
			}
		}catch (NumberFormatException e) {
			System.out.println("formato da entrada invalida");
			opcaoCadastro();
		}catch (Exception e) {
			System.out.println(e.getMessage());
			opcaoCadastro();
		}finally {
		}
	}
	
	public void opcaoEditar() {
		try {
			System.out.println("Digite o ID do produto: ");
			int id = Integer.parseInt(sc.nextLine());
			
			if(cp.existeId(id)) {
				System.out.println("Digite o nome do produto: ");
				String nome = sc.nextLine();
				System.out.println("Digite o preco do produto: ");
				float preco = Float.parseFloat(sc.nextLine());
				System.out.println("Digite a quantidade do produto: ");
				int quantidade = Integer.parseInt(sc.nextLine());
				System.out.println("Digite a loja fornecedora do produto: ");
				String lojaFornecedora= sc.nextLine();
				
				if(cp.editarProduto(id, nome, preco, quantidade, lojaFornecedora)) {
					System.out.println("produto editado com sucesso");
				}
			}
		} catch (NumberFormatException e) {
			System.out.println("formato da entrada invalida");
			opcaoEditar();
		} catch (Exception e) {
			System.out.println(e.getMessage());
			opcaoEditar();
		}finally {
		}
	}
	
	public void opcaoExcluir() {
		try {
			System.out.println("Digite o ID do produto: ");
			int id = Integer.parseInt(sc.nextLine());
			
			if(cp.removerProduto(id)) {
				System.out.println("Produto excluido");
			}
		} catch (NumberFormatException e) {
			System.out.println("formato da entrada invalida");
		} catch (IdInexistenteException e) {
			System.out.println("id inexistente");
		} catch (Exception e) {
			System.out.println(e.getMessage());
		}
		
	}
	
	public void opcaoListar() {
		for (Produto p: cp.listarProdutos()) {
			System.out.println(p.toString());
		}
	}
	
}
