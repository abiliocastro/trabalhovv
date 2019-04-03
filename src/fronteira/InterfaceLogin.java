package fronteira;

import java.util.Scanner;

import controlador.ControladorLogin;

public class InterfaceLogin {
	private Scanner entrada;
	private ControladorLogin controladorLogin;
	
	public InterfaceLogin() {
		entrada = new Scanner(System.in);
		controladorLogin = new ControladorLogin();
	}
	
	public void realizarLogin() {
		System.out.println("LOGIN");
		System.out.print("Usuario: ");
		String login = entrada.nextLine();
		System.out.print("Senha: ");
		String senha = entrada.nextLine();
	}
	
}
