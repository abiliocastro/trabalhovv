package fronteira;

public class InterfaceMenuInicial {
	InterfaceLogin interfaceLogin = new InterfaceLogin();
	InterfaceBusca interfaceBusca = new InterfaceBusca();
	
	public void mostra() {
		System.out.println("1- Buscar | 2- Entrar");
	}
	
	public void selecionarOpcao(int entrada) throws Exception {
		switch(entrada) {
			case 1:
				this.interfaceBusca.mostra();
				break;
			case 2:
				this.interfaceLogin.realizarLogin();
				break;
			default:
				System.out.println("Opcao Invalida");
		}
	}
	
}
