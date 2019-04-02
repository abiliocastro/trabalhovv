package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import java.util.regex.Pattern;

import org.junit.jupiter.api.Test;

class InterfaceLoginTeste {
	InterfaceLoginTeste interfaceLogin = new InterfaceLoginTeste();
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(baos);
	PrintStream old = System.out;
	String os = System.getProperty("os.name").toLowerCase();
	
	@Test
	void realizarLogin() {
		this.mudarSaida();
		interfaceLogin.realizarLogin();
		
		String mostrado = this.capturarSaida();
		String esperado;
		if(os.equals("linux"))
			esperado = "login ou senha Invalido!";
		else
			esperado = "login ou senha Invalido!";
		assertTrue(Pattern.matches(esperado, mostrado));
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
