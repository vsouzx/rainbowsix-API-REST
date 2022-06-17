package br.com.vitor.rainbowsix.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.util.StringUtils;

import br.com.vitor.rainbowsix.modelo.Mapa;
import br.com.vitor.rainbowsix.service.MapaService;

public class MapaDto {

	@NotNull @NotBlank
	private String nome;
	
	@NotNull @NotBlank
	private String localizacao;
	
	public Mapa converter() {
		Mapa mapa = new Mapa();
		String nomeAjustado = StringUtils.capitalize(this.nome);
		mapa.setNome(nomeAjustado);
		mapa.setLocalizacao(this.localizacao);

		return mapa;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}

	public Mapa atualizar(Integer id, MapaService mapaService) {
		Mapa mapa = mapaService.acharPorId(id).get();
		mapa.setLocalizacao(localizacao);
		mapa.setNome(nome);
		return mapa;
	}




}
