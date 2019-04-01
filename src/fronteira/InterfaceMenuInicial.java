package fronteira;

public class InterfaceMenuInicial {
	
	public void mostra() {
		System.out.println("1- Buscar | 2- Entrar");
	}
	
	public String selecionarOpcao(int entrada) {
		switch(entrada) {
		case 1:
			return this.busca();
		case 2:
			return this.entrar();
		default:
			return "Invalida";
		}
	}
	
	public String mostrarInicial() {
		return "1- Buscar | 2- Entrar";
	}
	
	private String busca() {
		return "Digite um termo de busca: ";
	}
	
	private String entrar() {
		return "di";
	}
}
