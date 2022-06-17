package br.com.vitor.rainbowsix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.vitor.rainbowsix.modelo.Agente;
import br.com.vitor.rainbowsix.repository.AgenteRepository;

@Service
public class AgenteService {

	@Autowired
	private AgenteRepository agenteRepository;
	
	public List<Agente> listarTodosOsAgentesAsc() {	
		return agenteRepository.findAll(Sort.by("id").ascending());
	}
	
	public List<Agente> listarTodosOsAgentesPorNome() {
		return agenteRepository.findAll(Sort.by("nome").ascending());
	}
	
	public Agente salvarAgente(Agente agente) {
		return agenteRepository.save(agente);
	}
	
	public Optional<Agente> acharPorId(Integer id) {
		return agenteRepository.findById(id);
	}
	
	public void deletarPelaId(Integer id) {
		agenteRepository.deleteById(id);
	}
	
}
