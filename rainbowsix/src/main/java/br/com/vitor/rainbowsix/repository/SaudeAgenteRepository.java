package br.com.vitor.rainbowsix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vitor.rainbowsix.modelo.SaudeAgente;

public interface SaudeAgenteRepository extends JpaRepository<SaudeAgente, Long>{

	SaudeAgente findByNome(String saude);

}
