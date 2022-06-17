package br.com.vitor.rainbowsix.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import br.com.vitor.rainbowsix.modelo.ModoDeJogo;
import br.com.vitor.rainbowsix.repository.ModoDeJogoRepository;

@Service
public class ModoDeJogoService {

	@Autowired
	private ModoDeJogoRepository modoRepository;
	
	public List<ModoDeJogo> listarTodosOsModos() {	
		return modoRepository.findAll(Sort.by("id").ascending());
	}
	
	public ModoDeJogo salvarModoDeJogo(ModoDeJogo modo) {
		return modoRepository.save(modo);
	}
	
	public Optional<ModoDeJogo> buscarPorNomeUnico(String nome) {
		return modoRepository.findByNome(nome);
	}

	public Optional<ModoDeJogo> acharPorId(Integer id) {
		return modoRepository.findById(id);
	}

	public void deletarPelaId(Integer id) {
		modoRepository.deleteById(id);
	}
	
	
}
