package controlador;

import java.util.ArrayList;
import entidade.Produto;
import fronteira.database.RepositorioProduto;

public class ControladorBusca {
		RepositorioProduto repositorioDeProduto;
		ArrayList<Produto> produtosBuscados;
		
		public ControladorBusca() {
			repositorioDeProduto = RepositorioProduto.getInstance();
		} 
	
		public ArrayList<Produto> buscarProduto(String termoBuscado) {
			produtosBuscados = new ArrayList<Produto>();
			for (Produto produto : repositorioDeProduto.lerProdutos()) {
				if(termoBuscado != null) {
					if(produto.match(termoBuscado)) {
						produtosBuscados.add(produto);
					}
				}
			}
			return produtosBuscados;
			
		}		
}