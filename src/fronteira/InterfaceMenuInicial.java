package fronteira;

public class InterfaceMenuInicial {
	InterfaceLogin interfaceLogin = new InterfaceLogin();
	
	public void mostra() {
		System.out.println("1- Buscar | 2- Entrar");
	}
	
	public void selecionarOpcao(int entrada) throws Exception {
		switch(entrada) {
			case 1:
				this.busca();
				break;
			case 2:
				this.interfaceLogin.realizarLogin();
				break;
			default:
				System.out.println("Opcao Invalida");
		}
	}
	
	private void busca() {
		System.out.print("Digite um termo de busca: ");
	}
	
}
