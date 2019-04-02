package fronteira;

import java.util.Scanner;

public class InterfaceLogin {
	private Scanner entrada;
	
	public InterfaceLogin() {
		entrada = new Scanner(System.in);
	}
	
	public void realizarLogin() {
		System.out.println("LOGIN");
		System.out.print("Usuário: ");
		this.entrada.nextLine();
		System.out.print("Senha: ");
		this.entrada.nextLine();
	}

}
