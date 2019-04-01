package testes;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import fronteira.InterfaceMenuInicial;

class Menus {
	InterfaceMenuInicial menuInicial = new InterfaceMenuInicial();
	
//	@Test
//	void menuInicial() {
//		assertEquals("1- Buscar | 2- Entrar", menuInicial.mostra());
//	}
	
	@Test
	void opcaoBusca() {
		assertEquals("Digite um termo de busca: ", menuInicial.selecionarOpcao(1));
	}

}
