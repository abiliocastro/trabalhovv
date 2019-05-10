package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import entidade.Produto;
import fronteira.database.Conexao;
import fronteira.database.RepositorioProduto;

public class ControladorBusca {
		RepositorioProduto repositorioDeProduto;
		ArrayList<Produto> produtosBuscados;
		
		public ControladorBusca() {
			repositorioDeProduto = RepositorioProduto.getInstance();
		} 
	
		public ArrayList<Produto> buscarProduto(String termoBuscado) {
			try {
				repositorioDeProduto.setConexao(new Conexao());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return repositorioDeProduto.buscarProdutos(termoBuscado);
			
		}		
}