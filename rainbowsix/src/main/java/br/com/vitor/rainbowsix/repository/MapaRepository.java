package br.com.vitor.rainbowsix.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vitor.rainbowsix.modelo.Mapa;

public interface MapaRepository extends JpaRepository<Mapa, Integer>{

	Optional<Mapa> findByNome(String nome);
	Optional<Mapa> findByNomeLike(String nome);

}
