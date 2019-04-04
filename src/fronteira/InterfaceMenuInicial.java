package fronteira;

public class InterfaceMenuInicial {
	InterfaceLogin interfaceLogin = new InterfaceLogin();
	InterfaceBusca interfaceBusca = new InterfaceBusca();
	MenuProduto menuProduto = new MenuProduto();
	
	public void mostra() {
		System.out.println("1- Buscar | 2- Entrar");
	}
	
	public void selecionarOpcao(int entrada) throws Exception {
		switch(entrada) {
			case 1:
				this.interfaceBusca.mostra();
				break;
			case 2:
				if(this.interfaceLogin.realizarLogin()) {
					this.menuProduto.selecionarOpcao();
				}
				break;
			default:
				System.out.println("Opcao Invalida");
		}
	}
	
}
