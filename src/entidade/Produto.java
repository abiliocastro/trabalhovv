package entidade;

public class Produto implements Comparable<Produto>{

	private long id;
	private String nome; 
	private float preco;
	private int quantidade;
	private String lojaFornecedora;

	public Produto(long id, String nome, float preco, int quantidade, String lojaFornecedora) {
		this.id = id;
		this.nome = nome;
		this.preco = preco;
		this.quantidade = quantidade;
		this.lojaFornecedora = lojaFornecedora;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}

	public int getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}

	public String getLojaFornecedora() {
		return lojaFornecedora;
	}

	public void setLojaFornecedora(String lojaFornecedora) {
		this.lojaFornecedora = lojaFornecedora;
	}
	
	
	@Override
	public String toString() {
		return "[id=" + id + ", nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade
				+ ", lojaFornecedora=" + lojaFornecedora + "]";
	}
	
	
	
	public boolean match(String padrao) {
		boolean nomeMatch = this.nome.toLowerCase().contains(padrao.toLowerCase());
		if(nomeMatch) {
			return true;
		} 
		return false;
	}

	@Override
	public int compareTo(Produto outroProduto) {
		return this.nome.toLowerCase().compareTo(outroProduto.getNome().toLowerCase());
	}
}
