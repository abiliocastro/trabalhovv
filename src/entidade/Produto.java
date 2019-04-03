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
		return "Produto [id=" + id + ", nome=" + nome + ", preco=" + preco + ", quantidade=" + quantidade
				+ ", lojaFornecedora=" + lojaFornecedora + "]";
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((lojaFornecedora == null) ? 0 : lojaFornecedora.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + Float.floatToIntBits(preco);
		result = prime * result + quantidade;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Produto other = (Produto) obj;
		if (id != other.id)
			return false;
		if (lojaFornecedora == null) {
			if (other.lojaFornecedora != null)
				return false;
		} else if (!lojaFornecedora.equals(other.lojaFornecedora))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (Float.floatToIntBits(preco) != Float.floatToIntBits(other.preco))
			return false;
		if (quantidade != other.quantidade)
			return false;
		return true;
	}

	@Override
	public int compareTo(Produto outroProduto) {
		return this.nome.compareTo(outroProduto.getNome().toLowerCase());
	}
}
