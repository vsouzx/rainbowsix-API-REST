package br.com.vitor.rainbowsix.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.vitor.rainbowsix.modelo.SaudeAgente;
import br.com.vitor.rainbowsix.repository.SaudeAgenteRepository;

@Service
public class SaudeAgenteService {

	@Autowired
	private SaudeAgenteRepository saudeRepository;
	
	public List<SaudeAgente> listarTiposDeSaude() {	
		return saudeRepository.findAll(Sort.by("id").ascending());
	}
	
	
	public SaudeAgente salvarTipoDeSaude(SaudeAgente saude) {
		return saudeRepository.save(saude);
	}
	
	public SaudeAgente buscarPorNome(String nome) {
		return saudeRepository.findByNome(nome);
	}
	
	
}
