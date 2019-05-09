package testes.unidade;

import static org.junit.jupiter.api.Assertions.*;
import java.io.ByteArrayOutputStream;
import java.io.PrintStream;
import org.junit.jupiter.api.Test;
import fronteira.InterfaceLogin;
import fronteira.Main;

class InterfaceLoginTeste {
	InterfaceLogin interfaceLogin = new InterfaceLogin();
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(baos);
	PrintStream old = System.out;
	String os = System.getProperty("os.name").toLowerCase();
	
	// TESTE DA INTERFACE DE LOGIN
	@Test
	void loginUsuarioSenhaCorreto() throws Exception {
		System.out.println("DIGITE UM USUARIO E SENHA CORRETO");
		Main.inicializarSistema();
		this.mudarSaida();
		interfaceLogin.realizarLogin();
		String mostrado = this.capturarSaida();
		String esperado;
		if(os.equals("linux"))
			esperado = "LOGIN\nUsuario: Senha: ";
		else
			esperado = "LOGIN\r\nUsuario: Senha: ";
		assertEquals(esperado, mostrado);
	}
	
	// Quando digita um usuario invalido uma vez
	@Test
	void loginUsuarioInvalidoSenhaCorreto() throws Exception {
		System.out.println("DIGITE UM USUARIO INVALIDO E DEPOIS UM USUARIO E SENHA CORRETO");
		Main.inicializarSistema();
		this.mudarSaida();
		interfaceLogin.realizarLogin();
		String mostrado = this.capturarSaida();
		String esperado;
		if(os.equals("linux"))
			esperado = "LOGIN\nUsuario: Usuario invalido. Digite novamente o nome do usuario\nUsuario: Senha: ";
		else
			esperado = "LOGIN\r\nUsuario: Usuario invalido. Digite novamente o nome do usuario\r\nUsuario: Senha: ";
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
