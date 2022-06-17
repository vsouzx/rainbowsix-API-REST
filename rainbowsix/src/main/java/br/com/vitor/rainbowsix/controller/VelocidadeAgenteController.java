package br.com.vitor.rainbowsix.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitor.rainbowsix.modelo.VelocidadeAgente;
import br.com.vitor.rainbowsix.repository.SaudeAgenteRepository;
import br.com.vitor.rainbowsix.repository.VelocidadeAgenteRepository;
import br.com.vitor.rainbowsix.service.VelocidadeAgenteService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "velocidadeAgente")
@Api(value = "Agente API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"Velocidade Agente"}, description = "Velocidade API")
public class VelocidadeAgenteController {

	@Autowired 
	private VelocidadeAgenteService velocidadeService;
	
	@Autowired 
	SaudeAgenteRepository saudeRepository;
	
	@Autowired 
	VelocidadeAgenteRepository velocidadeRepository;
	
	@RequestMapping(value = "/listar", 
					method = RequestMethod.GET, 
					produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> listarTodosOsTiposDeVelocidade(){
		List<VelocidadeAgente> velocidadesDisponiveis = this.velocidadeService.listarTiposDeVelocidade();
		return ResponseEntity.ok(velocidadesDisponiveis);
	}
	
	@RequestMapping(value = "/criar", 
					method = RequestMethod.POST, 
					produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<VelocidadeAgente> criarTipoDeSaude(@RequestBody VelocidadeAgente velocidadeForm){
		VelocidadeAgente velocidade = this.velocidadeService.salvarTipoDeVelocidade(velocidadeForm);
		return ResponseEntity.ok(velocidade);
	}
}
