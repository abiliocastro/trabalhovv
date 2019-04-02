package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

import fronteira.InterfaceMenuInicial;

class Menus {
	InterfaceMenuInicial menuInicial = new InterfaceMenuInicial();
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(baos);
	PrintStream old = System.out;
	
	@Test
	void menuInicial() {
		this.mudarSaida();
		menuInicial.mostra();
		String mostrado = this.capturarSaida();
		String esperado = "1- Buscar | 2- Entrar\r\n";
		assertEquals(esperado, mostrado);
	}
	
	@Test
	void opcaoBusca() {
		this.mudarSaida();
		menuInicial.selecionarOpcao(1);
		String mostrado = this.capturarSaida();
		String esperado = "Digite um termo de busca: ";
		assertEquals(esperado, mostrado);
	}
	
	@Test
	void opcaoEntrar() {
		this.mudarSaida();
		menuInicial.selecionarOpcao(2);
		String mostrado = this.capturarSaida();
		assertTrue(Pattern.matches("LOGIN\r\nUsuário: Senha: ", mostrado));
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
