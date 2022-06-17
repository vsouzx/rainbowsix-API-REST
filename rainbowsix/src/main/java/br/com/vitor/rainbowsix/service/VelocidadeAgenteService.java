package br.com.vitor.rainbowsix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.vitor.rainbowsix.modelo.VelocidadeAgente;
import br.com.vitor.rainbowsix.repository.VelocidadeAgenteRepository;

@Service
public class VelocidadeAgenteService {

	@Autowired
	private VelocidadeAgenteRepository velocidadeRepository;
	
	public List<VelocidadeAgente> listarTiposDeVelocidade() {	
		return this.velocidadeRepository.findAll(Sort.by("id").ascending());
	}
	
	public VelocidadeAgente salvarTipoDeVelocidade(VelocidadeAgente velocidade) {
		return this.velocidadeRepository.save(velocidade);
	}
	
	public VelocidadeAgente buscarPorNome(String nome) {
		return this.velocidadeRepository.findByNome(nome);
	}
	
}
