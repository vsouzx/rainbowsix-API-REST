package br.com.vitor.rainbowsix.modelo;

public enum Posicao {
	ATAQUE ("ATAQUE"),
	DEFESA ("DEFESA");
	
	public String getName() {
		return name;
	}

	private final String name;
	
	Posicao(String name){
		this.name = name;
	}
}
