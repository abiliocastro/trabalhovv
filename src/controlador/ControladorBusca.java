package controlador;

import java.sql.SQLException;
import java.util.ArrayList;
import entidade.Produto;
import excecoes.NomeInvalidoException;
import fronteira.database.Conexao;
import fronteira.database.RepositorioProduto;

public class ControladorBusca {
		RepositorioProduto repositorioDeProduto;
		ArrayList<Produto> produtosBuscados;
		
		public ControladorBusca() {
			repositorioDeProduto = RepositorioProduto.getInstance();
		} 
		public boolean validarNome(String nome) {
			if(nome == null || !nome.matches("^[a-zA-Z$][a-zA-Z_ $0-9]*$") || nome.length() > 255) {
				return false;
			}
			return true;
		}
		
		public ArrayList<Produto> buscarProduto(String termoBuscado) throws NomeInvalidoException {
			try {
				repositorioDeProduto.setConexao(new Conexao());
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			if(!validarNome(termoBuscado)) {
				throw new NomeInvalidoException();
			}
			System.out.println("ok");
			return repositorioDeProduto.buscarProdutos(termoBuscado);
				
		}		
}