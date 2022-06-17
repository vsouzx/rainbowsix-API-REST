package br.com.vitor.rainbowsix.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.StringUtils;

import br.com.vitor.rainbowsix.modelo.ModoDeJogo;
import br.com.vitor.rainbowsix.service.ModoDeJogoService;

public class ModoDeJogoDto {

	@NotNull @NotBlank
	private String nome;
	
	@NotNull @NotBlank
	private String duracao;
	
	public ModoDeJogo converter() {
		ModoDeJogo modo = new ModoDeJogo();
		String nomeAjustado = StringUtils.capitalize(this.nome);
		modo.setNome(nomeAjustado);
		modo.setDuracao(this.duracao);
		
		return modo;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDuracao() {
		return duracao;
	}

	public void setDuracao(String duracao) {
		this.duracao = duracao;
	}

	public ModoDeJogo atualizar(Integer id, ModoDeJogoService modoService) {
		ModoDeJogo modo = modoService.acharPorId(id).get();
		modo.setNome(nome);
		modo.setDuracao(duracao);
		return modo;
	}
}