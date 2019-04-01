package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import fronteira.Menu;

class Menus {
	Menu menu = new Menu();
	
	@Test
	void menuInicial() {
		assertEquals("1- Buscar | 2- Entrar", menu.mostrarInicial());
	}
	
	@Test
	void opcaoBusca() {
		assertEquals("Digite um termo de busca: ", menu.selecionarOpcao(1));
	}

}
