package br.com.vitor.rainbowsix.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vitor.rainbowsix.modelo.ModoDeJogo;

public interface ModoDeJogoRepository extends JpaRepository<ModoDeJogo, Integer>{

	Optional<ModoDeJogo> findByNome(String nome);
	Optional<ModoDeJogo> findByNomeLike(String string);

}
