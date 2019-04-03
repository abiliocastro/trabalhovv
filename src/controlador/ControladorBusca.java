package controlador;

import java.util.ArrayList;

import entidade.Produto;
import fronteira.RepositorioProduto;

public class ControladorBusca {
		static RepositorioProduto repositorioDeProduto;
		ArrayList<Produto> produtosBuscados;
		
		public ControladorBusca() {
			repositorioDeProduto = RepositorioProduto.getInstance();
			produtosBuscados = new ArrayList<Produto>();
		}
		
		public ArrayList<Produto> buscarProduto(String produtoBuscado) {
			for (Produto produto : repositorioDeProduto.getProdutos()) {
				if(produto.getNome().equals(produtoBuscado)) {
					produtosBuscados.add(produto);
				}
			}
			return produtosBuscados;
		}
}
