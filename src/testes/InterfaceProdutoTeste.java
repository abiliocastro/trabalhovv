package testes;

import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import org.junit.jupiter.api.Test;

import fronteira.InterfaceMenuProduto;
import fronteira.Main;

public class InterfaceProdutoTeste{
	
	InterfaceMenuProduto mp = new InterfaceMenuProduto();
	ByteArrayOutputStream baos = new ByteArrayOutputStream();
	PrintStream ps = new PrintStream(baos);
	PrintStream old = System.out;
	String os = System.getProperty("os.name").toLowerCase();
	
	// TESTE DA INTERFACE DE PRODUTO
	// Testando menu
	@Test
	void MenuProdutomostrar() throws Exception {
		this.mudarSaida();
		mp.mostrar();
		String mostrado = this.capturarSaida();
		String esperado;
		if(os.equals("linux"))
			esperado = "1- Listar | 2- Cadastrar | 3- Editar | 4- Excluir | 0 - Sair\nDigite a opc:\n";
		else
			esperado  = "1- Listar | 2- Cadastrar | 3- Editar | 4- Excluir | 0 - Sair\r\nDigite a opc:\r\n";
		assertEquals(esperado, mostrado);
	}

	// Testando saida do caso cadastrar
	@Test
	void menuProdutoCadastrar() throws Exception {
		Main.inicializarSistema();
		this.mudarSaida();
		mp.selecionarOpcao(2);
		String mostrado = this.capturarSaida();
		String esperado;
		if(os.equals("linux"))
			esperado = "Digite o nome do produto: \nDigite o preco do produto: \nDigite a quantidade do produto: \nDigite a loja fornecedora do produto: \nproduto cadastrado com sucesso\n";
		else
			esperado = "Digite o nome do produto: \r\nDigite o preco do produto: \r\nDigite a quantidade do produto: \r\nDigite a loja fornecedora do produto: \r\nproduto cadastrado com sucesso\r\n";
		assertEquals(esperado, mostrado);
	}
	
	@Test
	void menuProdutoEditar() throws Exception {
		Main.inicializarSistema();
		this.mudarSaida();
		mp.selecionarOpcao(2);
		String mostrado = this.capturarSaida();
		System.out.println(mostrado);
		String esperado;
		if(os.equals("linux"))
			esperado = "Digite o nome do produto: \nDigite o preco do produto: \nDigite a quantidade do produto: \nDigite a loja fornecedora do produto: \nproduto cadastrado com sucesso\n";
		else
			esperado = "Digite o nome do produto: \r\nDigite o preco do produto: \r\nDigite a quantidade do produto: \r\nDigite a loja fornecedora do produto: \r\nproduto cadastrado com sucesso\r\n";
		assertEquals(esperado, mostrado);
	}
	
	@Test
	void menuProdutoExcluirIdExistente() {
		Main.inicializarSistema();
		System.out.println("DIGITE UM ID DE PRODUTO EXISTENTE");
		this.mudarSaida();
		mp.opcaoExcluir();
		String mostrado = this.capturarSaida();
		String esperado;
		if(os.equals("linux"))
			esperado = "Digite o ID do produto: \nProduto excluido\n";
		else
			esperado = "Digite o ID do produto: \r\nProduto excluido\r\n";
		assertEquals(esperado, mostrado);
	}
	
	@Test
	void menuProdutoExcluirIdInvalido() {
		Main.inicializarSistema();
		System.out.println("DIGITE UM ID INVALIDO (_,@,#,nome)");
		this.mudarSaida();
		mp.opcaoExcluir();
		String mostrado = this.capturarSaida();
		String esperado;
		if(os.equals("linux"))
			esperado = "Digite o ID do produto: \nformato da entrada invalida\n";
		else
			esperado = "Digite o ID do produto: \r\nformato da entrada invalida\r\n";
		assertEquals(esperado, mostrado);
	}
	
	@Test
	void menuProdutoExcluirIdInexistente() {
		Main.inicializarSistema();
		System.out.println("DIGITE UM ID INEXISTENTE (-1,999999)");
		this.mudarSaida();
		mp.opcaoExcluir();
		String mostrado = this.capturarSaida();
		String esperado;
		if(os.equals("linux"))
			esperado = "Digite o ID do produto: \nid inexistente\n";
		else
			esperado = "Digite o ID do produto: \r\nid inexistente\r\n";
		assertEquals(esperado, mostrado);
	}
	
	private void mudarSaida() {
		System.setOut(ps);
	}
	
	private String capturarSaida() {
		String capturado = baos.toString();
		System.out.flush();
		System.setOut(old);
		return capturado;
	}


}
