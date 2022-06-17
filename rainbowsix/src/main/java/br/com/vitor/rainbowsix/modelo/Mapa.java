package br.com.vitor.rainbowsix.modelo;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.UniqueConstraint;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
public class Mapa {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "mapa_id")
	private Integer id;

	@Column(unique = true, nullable = false)
	private String nome;
	
	@Column(unique = false, nullable = false)
	private String localizacao;
	
	@ManyToMany
	@JoinTable(
			name="modos_mapas",
			uniqueConstraints = @UniqueConstraint(columnNames = { "modoDeJogo_id", "mapa_id" }),
			joinColumns = @JoinColumn(name = "mapa_id"),
			inverseJoinColumns = @JoinColumn(name = "modoDeJogo_id")
			)	
	@JsonIgnore
	private List<ModoDeJogo> modos;

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public List<ModoDeJogo> getModos() {
		return modos;
	}

	public void setModos(List<ModoDeJogo> modos) {
		this.modos = modos;
	}

	public String getLocalizacao() {
		return localizacao;
	}

	public void setLocalizacao(String localizacao) {
		this.localizacao = localizacao;
	}
	
	
}
