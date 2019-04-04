package testes;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import fronteira.InterfaceMenuInicial;

class Menus {
	InterfaceMenuInicial menuInicial = new InterfaceMenuInicial();
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(baos);
	PrintStream old = System.out;
	String os = System.getProperty("os.name").toLowerCase();
	
	// TESTES DA INTERFACE MENU INICIAL
	@Test
	void menuInicial() {
		this.mudarSaida();
		menuInicial.mostra();
		String mostrado = this.capturarSaida();
		String esperado;
		if(os.equals("linux"))
			esperado = "1- Buscar | 2- Entrar\n";
		else
			esperado  = "1- Buscar | 2- Entrar\r\n";
		assertEquals(esperado, mostrado);
	}
	
	@Test
	void opcaoInvalida3() throws Exception {
		this.mudarSaida();
		menuInicial.selecionarOpcao(3);
		String mostrado = this.capturarSaida();
		String esperado;
		if(os.equals("linux"))
			esperado = "Opcao Invalida\n";
		else
			esperado = "Opcao Invalida\r\n";
		assertEquals(esperado, mostrado);
	}
	
	@Test
	void opcaoInvalidaNegativa() throws Exception {
		this.mudarSaida();
		menuInicial.selecionarOpcao(-1);
		String mostrado = this.capturarSaida();
		String esperado;
		if(os.equals("linux"))
			esperado = "Opcao Invalida\n";
		else
			esperado = "Opcao Invalida\r\n";
		assertEquals(esperado, mostrado);
	}
	
	// TESTES DA INTERFACE MENU PRODUTO
	
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
