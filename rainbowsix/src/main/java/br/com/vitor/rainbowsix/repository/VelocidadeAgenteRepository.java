package br.com.vitor.rainbowsix.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.vitor.rainbowsix.modelo.VelocidadeAgente;

public interface VelocidadeAgenteRepository extends JpaRepository<VelocidadeAgente, Long>{

	VelocidadeAgente findByNome(String velocidade);

}
