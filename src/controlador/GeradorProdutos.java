package controlador;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Random;


import entidade.Produto;
import fronteira.database.RepositorioProduto;

public class GeradorProdutos {
	private ArrayList<String> listaNomesFornecedores;
	private ArrayList<String> listaNomesProdutos;
	RepositorioProduto repProdutos = RepositorioProduto.getInstance();
	
	public GeradorProdutos() {
		listaNomesFornecedores = new ArrayList<>();
		listaNomesProdutos = new ArrayList<>();
		
		
	}
	
	public void GerarProdutosAleatorios(int qddProdutosGerados,int precoMaximoProduto,int qtdMaximoProduto) throws IOException {		
		try {
			Random random = new Random();
			File arquivoProdutos = new File("lista de produtos.txt");
			File arquivoFornecedores = new File("lista de fornecedores.txt");
	
			FileReader lerArquivoProdutos = new FileReader(arquivoProdutos);
			FileReader lerArquivoFornecedores  = new FileReader(arquivoFornecedores);
			
			BufferedReader bufferArquivoProdutos = new BufferedReader(lerArquivoProdutos);
			BufferedReader bufferArquivoFornecedores = new BufferedReader(lerArquivoFornecedores);

			String palavraProduto = bufferArquivoProdutos.readLine();
			String palavraFornecedor = bufferArquivoFornecedores.readLine();
			
			while (palavraProduto!=null){
				palavraProduto = bufferArquivoProdutos.readLine();
				listaNomesProdutos.add(palavraProduto);
			}
						
			while (palavraFornecedor !=null){
				palavraFornecedor  = bufferArquivoFornecedores.readLine();
				listaNomesFornecedores.add(palavraFornecedor);
			}
			
			int posProdutos = listaNomesProdutos.size();
			int posFornecedores = listaNomesFornecedores.size();
			int id =0;
			
			while(id<qddProdutosGerados) {	
				int numeroDoProduto = random.nextInt(posProdutos);
				int numeroDoFornecedor = random.nextInt(posFornecedores);	
				float qtdPreco = (random.nextFloat() * precoMaximoProduto)+1;
				DecimalFormat df = new DecimalFormat("00.00");
				String str = df.format(qtdPreco);
				qtdPreco = conveterVirgulaParaPonto(str);
				int qtdQuantidade = random.nextInt(qtdMaximoProduto) +1 ;
				String nomeDoProduto = listaNomesProdutos.get(numeroDoProduto);
				String nomeDoFornecedor = listaNomesFornecedores.get(numeroDoFornecedor);
	
				repProdutos.cadastrar(nomeDoProduto, qtdPreco, qtdQuantidade, nomeDoFornecedor);
				id++;
			}
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	float conveterVirgulaParaPonto(String numero) {
		String retorno = new String();
		for (int i = 0; i < numero.length(); i++) {
			if(numero.charAt(i)==(',')) {
				retorno += ".";
			}else{
				retorno += numero.charAt(i);
			}
		}
		return Float.parseFloat(retorno);
		
	}
	
}
	

