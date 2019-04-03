package controlador;

import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import entidade.Produto;
import fronteira.RepositorioProduto;

public class ControladorBusca {
		static RepositorioProduto repositorioDeProduto;
		ArrayList<Produto> produtosBuscados;
		private static Pattern buscarP;
		
		public ControladorBusca() {
			repositorioDeProduto = RepositorioProduto.getInstance();
			produtosBuscados = new ArrayList<Produto>();
		}
		
		public ArrayList<Produto> buscarProduto(String produtoBuscado) {
			try {
				buscarP = Pattern.compile(produtoBuscado);
				if(repositorioDeProduto.getProdutos().size()>0) {
					for (Produto produto : repositorioDeProduto.getProdutos()) {
						Matcher m = buscarP.matcher(produto.getNome());
						if(m.find()) {
							produtosBuscados.add(produto);
						}
					}
				}	
			}catch (Exception e) {}
			return produtosBuscados;
		}
}