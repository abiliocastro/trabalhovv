package fronteira;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import controlador.ControladorBusca;
import entidade.Produto;

public class InterfaceBusca {
	private ControladorBusca controladorBusca;
	private Scanner entrada;
	private ArrayList<Produto> viewProdutos;
	
	public InterfaceBusca() {
		controladorBusca = new ControladorBusca();
		entrada = new Scanner(System.in);
	} 
	
	public void mostra() {
		System.out.println("Digite um termo de busca:");
		String produtoBuscado = entrada.nextLine();
		
		viewProdutos = controladorBusca.buscarProduto(produtoBuscado);
		if(viewProdutos.size()>0) {
			System.out.println("Produtos encontrados:");
			Collections.sort(viewProdutos);
			for (Produto produto : viewProdutos) {
				System.out.println(produto.toString());
			}
		}else{
			System.out.println("Nao foram encontrados produtos com o termo pesquisado");
		}
	}	
}