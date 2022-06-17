package br.com.vitor.rainbowsix.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitor.rainbowsix.dto.AgenteDto;
import br.com.vitor.rainbowsix.modelo.Agente;
import br.com.vitor.rainbowsix.repository.SaudeAgenteRepository;
import br.com.vitor.rainbowsix.repository.VelocidadeAgenteRepository;
import br.com.vitor.rainbowsix.service.AgenteService;
import br.com.vitor.rainbowsix.service.SaudeAgenteService;
import br.com.vitor.rainbowsix.service.VelocidadeAgenteService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "agente")
@Api(value = "Agente API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {
		"agente" }, description = "Agentes API")
public class AgenteController {

	@Autowired
	private AgenteService agenteService;

	@Autowired
	private SaudeAgenteService saudeAgenteService;

	@Autowired
	private VelocidadeAgenteService velocidadeAgenteService;

	@Autowired
	SaudeAgenteRepository saudeRepository;

	@Autowired
	VelocidadeAgenteRepository velocidadeRepository;

	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> listarTodosOsAgentes() {
		List<Agente> agentes = this.agenteService.listarTodosOsAgentesAsc();
		return ResponseEntity.ok(agentes);
	}

	@RequestMapping(value = "/listarTodosPorNome", method = RequestMethod.GET, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> listarTodosOsAgentesPorNomeAsc() {
		List<Agente> agentes = this.agenteService.listarTodosOsAgentesPorNome();
		return ResponseEntity.ok(agentes);
	}

	@RequestMapping(value = "/criar", method = RequestMethod.POST, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Agente> criarAgente(@RequestBody AgenteDto agenteDto) {
		Agente agente = agenteDto.converter(velocidadeAgenteService, saudeAgenteService);
		this.agenteService.salvarAgente(agente);
		return ResponseEntity.ok(agente);
	}

	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Agente> atualizarAgente(@PathVariable Integer id, @RequestBody AgenteDto agenteDto) {
		
		Optional<Agente> possivelAgente = agenteService.acharPorId(id);
		
		if(possivelAgente.isPresent()) {
			Agente agente = agenteDto.atualizar(id, agenteService,velocidadeAgenteService, saudeAgenteService);
			this.agenteService.salvarAgente(agente);
			return ResponseEntity.ok(agente);
		}
		
		return ResponseEntity.notFound().build();
	}

	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> remover(@PathVariable Integer id) {
		Optional<Agente> optional = agenteService.acharPorId(id);

		if (optional.isPresent()) {
			agenteService.deletarPelaId(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}

	}
}
