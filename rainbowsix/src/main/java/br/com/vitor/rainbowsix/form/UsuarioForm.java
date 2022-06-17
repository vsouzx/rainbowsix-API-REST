package br.com.vitor.rainbowsix.form;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;

public class UsuarioForm {

	private String username;
	private String senha;
	
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getSenha() {
		return senha;
	}
	public void setSenha(String senha) {
		this.senha = senha;
	}
	
	public UsernamePasswordAuthenticationToken converter() {
		// TODO Auto-generated method stub
		return new UsernamePasswordAuthenticationToken(username,senha);
	}
}
