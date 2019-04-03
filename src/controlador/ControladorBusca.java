package controlador;

import java.util.ArrayList;

import entidade.Produto;
import fronteira.RepositorioProduto;

public class ControladorBusca {
		RepositorioProduto repositorioDeProduto;
		ArrayList<Produto> produtosBuscados;
		
		public ControladorBusca() {
			repositorioDeProduto = RepositorioProduto.getInstance();
			//todosProdutos = ;
		} 
	
		public ArrayList<Produto> buscarProduto(String termoBuscado) {
			produtosBuscados = new ArrayList<Produto>();
			for (Produto produto : repositorioDeProduto.getProdutos()) {
				if(produto.match(termoBuscado)) {
					produtosBuscados.add(produto);
				}
			}
			return produtosBuscados;
		}
}