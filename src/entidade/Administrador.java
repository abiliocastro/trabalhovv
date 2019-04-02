package entidade;

public class Administrador {
	private String nomeDeUsuario;
	private String senha;
	private boolean logado;
	
	public Administrador(String nomeDeUsuario, String senha) {
		this.nomeDeUsuario = nomeDeUsuario;
		this.senha = senha;
		this.logado = false;
	}

	public String getNomeDeUsuario() {
		return nomeDeUsuario;
	}
	
	public boolean isLogado() {
		return logado;
	}

	public void setLogado(boolean logado) {
		this.logado = logado;
	}

	public void setNomeDeUsuario(String nomeDeUsuario) {
		this.nomeDeUsuario = nomeDeUsuario;
	}
	
	public String getSenha() {
		return senha;
	}
	
	public void setSenha(String senha) {
		this.senha = senha;
	}

	@Override
	public String toString() {
		return "Administrador [nomeDeUsuario=" + nomeDeUsuario + ", senha=" + senha + ", logado=" + logado + "]";
	}
	
}
