package testes;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
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
		String[] separado;
		String esperado = "Digite um termo de busca:Produtos encontrados:";
		if(os.equals("linux")) {
			separado = mostrado.split("\n");
			mostrado = separado[0] + separado[1];
		} else {
			separado = mostrado.split("\r\n");
			mostrado = separado[0] + separado[1];
		}
		assertEquals(esperado, mostrado);
	}
	
	@Test
	void realizarBuscaProdutoNaoEncontrado() {
		System.out.println("DIGITE UM TERMO QUE NÃO EXISTE NO REPOSITORIO");
	//	Main.inicializarSistema();
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
