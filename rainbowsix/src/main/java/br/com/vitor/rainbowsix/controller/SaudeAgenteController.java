package br.com.vitor.rainbowsix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitor.rainbowsix.modelo.SaudeAgente;
import br.com.vitor.rainbowsix.repository.SaudeAgenteRepository;
import br.com.vitor.rainbowsix.repository.VelocidadeAgenteRepository;
import br.com.vitor.rainbowsix.service.SaudeAgenteService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "saudeAgente")
@Api(value = "Agente API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Saude Agente"}, description = "Saude API")
public class SaudeAgenteController {

	@Autowired 
	private SaudeAgenteService saudeService;
	
	@Autowired 
	SaudeAgenteRepository saudeRepository;
	
	@Autowired 
	VelocidadeAgenteRepository velocidadeRepository;
	
	@RequestMapping(value = "/listar", 
					method = RequestMethod.GET, 
					produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> listarTodosOsTiposDeSaude(){
		List<SaudeAgente> saudesDisponiveis = this.saudeService.listarTiposDeSaude();
		return ResponseEntity.ok(saudesDisponiveis);
	}
	
	@RequestMapping(value = "/criar", 
					method = RequestMethod.POST, 
					produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<SaudeAgente> criarTipoDeSaude(@RequestBody SaudeAgente saudeForm){
		SaudeAgente saude = this.saudeService.salvarTipoDeSaude(saudeForm);
		return ResponseEntity.ok(saude);
	}
}
