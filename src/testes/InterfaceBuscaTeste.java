package testes;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;
import org.junit.jupiter.api.Test;
import fronteira.InterfaceBusca;
import fronteira.Main;

class InterfaceBuscaTeste {
	InterfaceBusca interfaceBusca = new InterfaceBusca();
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(baos);
	PrintStream old = System.out;
	String os = System.getProperty("os.name").toLowerCase();
	
	@Test
	void interfaceBusca() {
		System.out.println("DIGITE UM TERMO QUE EXISTE NO REPOSITORIO");
		this.mudarSaida();
		interfaceBusca.mostra();
		String mostrado = this.capturarSaida();
		String esperado;
		if(os.equals("linux"))
			esperado = "^[Digite um termo de busca:\nProdutos encontrados:\n$][a-zA-Z$][a-zA-Z_$0-9]*[\n][a-zA-Z$][a-zA-Z_$0-9]*[\n]$";
		else
			esperado  = "^Digite um termo de busca:\r\nProdutos encontrados:\r\n[a-zA-Z0-9]+$";
		//assertEquals(esperado, mostrado);
		assertTrue(Pattern.matches(esperado, mostrado));
		
	}
	
	@Test
	void realizarBuscaProdutoNaoEncontrado() {
		System.out.println("DIGITE UM TERMO QUE NÃO EXISTE NO REPOSITORIO");
		Main.inicializarSistema();
		this.mudarSaida();
		interfaceBusca.mostra();
		String mostrado = this.capturarSaida();
		String esperado = null;
		if(os.equals("linux")) {
			esperado = "Digite um termo de busca:\nNao foram encontrados produtos com o termo pesquisado\n";
		}else {
			esperado = "Digite um termo de busca:\r\nNao foram encontrados produtos com o termo pesquisado\r\n";	
		}	
		assertEquals(esperado, mostrado);
	}
	
//	private void simularEntrada(String entrada) {
//		ByteArrayInputStream in = new ByteArrayInputStream(entrada.getBytes());
//		System.setIn(in);
//		System.setIn(System.in);
//	}
	
	private void mudarSaida() {
		System.setOut(ps);
	}
	
	private String capturarSaida() {
		String capturado = baos.toString();
		System.out.flush();
		System.setOut(old);
		return capturado;
	}
	

}
