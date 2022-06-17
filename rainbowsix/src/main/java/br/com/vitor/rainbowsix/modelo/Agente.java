package br.com.vitor.rainbowsix.modelo;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

@Entity
public class Agente {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer id;

	@Column(unique = true, nullable = false)
	private String nome;
	
	@ManyToOne
	@JoinColumn(unique = false, nullable = false)
	private VelocidadeAgente velocidade;
	
	@ManyToOne
	@JoinColumn(unique = false, nullable = false)
	private SaudeAgente saude;

	@Column(unique = true, nullable = false)
	private String nomeHabilidade;
	
	@Column(unique = true, nullable = false)
	private String detalheHabilidade;
	
	@Column(unique = false, nullable = false)
	@Enumerated(EnumType.STRING)
	private Posicao posicao;

	
	public Agente() {
		super();
	}

	public Agente(String nome) {
		super();
		this.nome = nome;
	}

	public Agente(String nome, VelocidadeAgente velocidade, SaudeAgente saude, String nomeHabilidade,
			String detalheHabilidade, Posicao posicao) {
		super();
		this.nome = nome;
		this.velocidade = velocidade;
		this.saude = saude;
		this.nomeHabilidade = nomeHabilidade;
		this.detalheHabilidade = detalheHabilidade;
		this.posicao = posicao;
	}


	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public VelocidadeAgente getVelocidade() {
		return velocidade;
	}

	public void setVelocidade(VelocidadeAgente velocidade) {
		this.velocidade = velocidade;
	}

	public SaudeAgente getSaude() {
		return saude;
	}

	public void setSaude(SaudeAgente saude) {
		this.saude = saude;
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

	public Posicao getPosicao() {
		return posicao;
	}

	public void setPosicao(Posicao posicao) {
		this.posicao = posicao;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}
	
}
