package fronteira;

import java.util.Scanner;

import controlador.ControladorLogin;

public class InterfaceLogin {
	private Scanner entrada;
	private ControladorLogin controladorLogin;
//	private MenuProduto menuProduto;
	
	public InterfaceLogin() {
		entrada = new Scanner(System.in);
		controladorLogin = new ControladorLogin();
//		menuProduto = new MenuProduto();
	}
	
	public void realizarLogin() throws Exception {
		boolean usuarioInvalido;
		String nomeDeUsuario;
		System.out.println("LOGIN");
		System.out.print("Usuario: ");
		do {
			nomeDeUsuario = entrada.nextLine();
			if(!controladorLogin.validaUsuario(nomeDeUsuario)) {
				System.out.println("Usuario invalido. Digite novamente o nome do usuario");
				System.out.print("Usuario: ");
				usuarioInvalido = true;
			} else {
				usuarioInvalido = false;
			}
		} while(usuarioInvalido);
		System.out.print("Senha: ");
		String senha = entrada.nextLine();
//		if(controladorLogin.realizarLogin(nomeDeUsuario, senha)) {
//			menuProduto.selecionarOpcao();
//		}
	}
	
}
