package br.com.vitor.rainbowsix.dto;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import br.com.vitor.rainbowsix.modelo.Agente;
import br.com.vitor.rainbowsix.modelo.Posicao;
import br.com.vitor.rainbowsix.modelo.SaudeAgente;
import br.com.vitor.rainbowsix.modelo.VelocidadeAgente;
import br.com.vitor.rainbowsix.service.AgenteService;
import br.com.vitor.rainbowsix.service.SaudeAgenteService;
import br.com.vitor.rainbowsix.service.VelocidadeAgenteService;

public class AgenteDto {

	@NotNull @NotBlank
	private String nome;
	
	@NotNull @NotBlank
	private Posicao posicao;
	
	@NotNull @NotBlank
	private String nomeHabilidade;
	
	@NotNull @NotBlank
	private String detalheHabilidade;
	
	@NotNull @NotBlank
	private String tipoVelocidade;
	
	@NotNull @NotBlank
	private String tipoSaude;

	
	public Agente converter(VelocidadeAgenteService velocidadeService, SaudeAgenteService saudeService) {
		Agente agente = new Agente();

		agente.setNome(this.nome);
		agente.setNomeHabilidade(this.nomeHabilidade);
		agente.setDetalheHabilidade(this.detalheHabilidade);
		
		VelocidadeAgente velocidade = velocidadeService.buscarPorNome(tipoVelocidade);
		agente.setVelocidade(velocidade);
		
		SaudeAgente saude = saudeService.buscarPorNome(tipoSaude);
		agente.setSaude(saude);
		
		agente.setPosicao(this.posicao);
		return agente;
	}


	public String getNome() {
		return nome;
	}


	public void setNome(String nome) {
		this.nome = nome;
	}


	public Posicao getPosicao() {
		return posicao;
	}


	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}


	public String getNomeHabilidade() {
		return nomeHabilidade;
	}


	public void setNomeHabilidade(String nomeHabilidade) {
		this.nomeHabilidade = nomeHabilidade;
	}


	public String getDetalheHabilidade() {
		return detalheHabilidade;
	}


	public void setDetalheHabilidade(String detalheHabilidade) {
		this.detalheHabilidade = detalheHabilidade;
	}


	public String getTipoVelocidade() {
		return tipoVelocidade;
	}


	public void setTipoVelocidade(String tipoVelocidade) {
		this.tipoVelocidade = tipoVelocidade;
	}


	public String getTipoSaude() {
		return tipoSaude;
	}


	public void setTipoSaude(String tipoSaude) {
		this.tipoSaude = tipoSaude;
	}
	
	public Agente atualizar(Integer id, AgenteService agenteService, VelocidadeAgenteService velocidadeService, SaudeAgenteService saudeService) {
		Agente agente = agenteService.acharPorId(id).get();
		agente.setNome(nome);
		agente.setNomeHabilidade(nomeHabilidade);
		agente.setDetalheHabilidade(detalheHabilidade);
		agente.setPosicao(posicao);
		
		VelocidadeAgente velocidade = velocidadeService.buscarPorNome(tipoVelocidade);
		agente.setVelocidade(velocidade);
		
		SaudeAgente saude = saudeService.buscarPorNome(tipoSaude);
		agente.setSaude(saude);
		
		return agente;
	}
}
