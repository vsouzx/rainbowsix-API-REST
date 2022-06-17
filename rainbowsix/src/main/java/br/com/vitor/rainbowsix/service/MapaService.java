package br.com.vitor.rainbowsix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.vitor.rainbowsix.modelo.Mapa;
import br.com.vitor.rainbowsix.repository.MapaRepository;

@Service
public class MapaService {

	@Autowired
	private MapaRepository mapaRepository;
	
	public List<Mapa> listarTodosOsMapas() {	
		return mapaRepository.findAll(Sort.by("id").ascending());
	}
	
	public Mapa salvarMapa(Mapa mapa) {
		return mapaRepository.save(mapa);
	}
	
	public Optional<Mapa> buscarPorNomeUnico(String nome) {
		return mapaRepository.findByNomeLike(nome);
	}

	public Optional<Mapa> acharPorId(Integer id) {
		return mapaRepository.findById(id);
	}

	public void deletarPelaId(Integer id) {
		mapaRepository.deleteById(id);
	}
	
}