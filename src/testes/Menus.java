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
	String os = System.getProperty("os.name").toLowerCase();
	
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
		String esperado;
		if(os.equals("linux"))
			esperado = "LOGIN\nUsuário: Senha: ";
		else
			esperado = "LOGIN\r\nUsuário: Senha: ";
		assertTrue(Pattern.matches(esperado, mostrado));
	}
	
	@Test
	void opcaoInvalida3() {
		this.mudarSaida();
		menuInicial.selecionarOpcao(3);
		String mostrado = this.capturarSaida();
		String esperado;
		if(os.equals("linux"))
			esperado = "Opção Inválida\n";
		else
			esperado = "Opção Inválida\r\n";
		assertEquals(esperado, mostrado);
	}
	
	@Test
	void opcaoInvalidaNegativa() {
		this.mudarSaida();
		menuInicial.selecionarOpcao(-1);
		String mostrado = this.capturarSaida();
		String esperado;
		if(os.equals("linux"))
			esperado = "Opção Inválida";
		else
			esperado = "Opção Inválida\r\n";
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
