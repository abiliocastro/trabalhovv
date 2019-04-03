package controlador;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidade.Produto;
import fronteira.RepositorioProduto;

public class ControladorBusca {
		RepositorioProduto repositorioDeProduto;
		ArrayList<Produto> produtosBuscados;
		private Pattern buscarP;
		
		public ControladorBusca() {
			repositorioDeProduto = RepositorioProduto.getInstance();
		} 
	
		public ArrayList<Produto> buscarProduto(String produtoBuscado) {
			try {
				produtosBuscados = new ArrayList<Produto>();
				System.out.println(produtoBuscado);
				buscarP = Pattern.compile(produtoBuscado);
				if(repositorioDeProduto.getProdutos().size()>0) {
					for (Produto produto : repositorioDeProduto.getProdutos()) {
						Matcher m = buscarP.matcher(produto.getNome());
						if(m.find()) {
							produtosBuscados.add(produto);
						}
					}
				}	
			}catch (Exception e) {
				e.printStackTrace(System.out);
			}
			return produtosBuscados;
		}
}