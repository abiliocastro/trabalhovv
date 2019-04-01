package fronteira;

public class Menu {

	public String selecionarOpcao(int entrada) {
		switch(entrada) {
		case 1:
			return this.busca();
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
}
