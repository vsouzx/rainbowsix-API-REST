package br.com.vitor.rainbowsix.form;

public class TokenDto {

	private String tipo;
	private String token;
	
	
	public TokenDto(String token, String tipo) {
		this.token = token;
		this.tipo = tipo;
	}
	
	public String getTipo() {
		return tipo;
	}
	public void setTipo(String tipo) {
		this.tipo = tipo;
	}
	public String getToken() {
		return token;
	}
	public void setToken(String token) {
		this.token = token;
	}
	
	
	
}
