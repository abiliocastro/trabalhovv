package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import fronteira.InterfaceBusca;

class InterfaceBuscaTeste {
	InterfaceBusca menuBusca = new InterfaceBusca();
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(baos);
	PrintStream old = System.out;
	String os = System.getProperty("os.name").toLowerCase();
	
	@Test
	void interfaceBusca() {
		this.mudarSaida();
		menuBusca.mostra();
		String mostrado = this.capturarSaida();
		String esperado;
		if(os.equals("linux"))
			esperado = "Digite um termo de busca:\n";
		else
			esperado  = "Digite um termo de busca:\r\n";
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