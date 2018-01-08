package pt.caseclosed.model;

public class Utilizador {

	public String username = "";
	public String password = "";
	public String acesso = "";
	public String email = "";
	public String nome = "";

	public Utilizador(String username, String password, String acesso, String email, String nome) {
		super();
		this.acesso = acesso;
		this.email = email;
		this.nome = nome;
		this.username = username;
		this.password = password;
		
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getAcesso() {
		return acesso;
	}
	public void setAcesso(String acesso) {
		this.acesso = acesso;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}

	@Override
	public String toString()
	{
		return nome;
	}
}

