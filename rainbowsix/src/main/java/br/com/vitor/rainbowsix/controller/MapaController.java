package br.com.vitor.rainbowsix.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitor.rainbowsix.dto.MapaDto;
import br.com.vitor.rainbowsix.modelo.Mapa;
import br.com.vitor.rainbowsix.modelo.ModoDeJogo;
import br.com.vitor.rainbowsix.service.MapaService;
import br.com.vitor.rainbowsix.service.ModoDeJogoService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "mapa")
@Api(value = "Agente API", tags = {"mapa"}, description = "Mapas API")
public class MapaController {

	@Autowired
	private MapaService mapaService;
	
	@Autowired
	private ModoDeJogoService modoService;

	@RequestMapping(value = "/listarTodos", method = RequestMethod.GET)
	public ResponseEntity<List<Mapa>> listarTodosOsMapas() {
		List<Mapa> mapas = this.mapaService.listarTodosOsMapas();
		return ResponseEntity.ok(mapas);
	}


	@RequestMapping(value = "/procurarPorNome/{nome}", method = RequestMethod.GET)
	public ResponseEntity<Mapa> procurarMapaPorNome(@PathVariable String nome) {
		String nomeAjustado = StringUtils.capitalize(nome);
		Optional<Mapa> mapaOptional = this.mapaService.buscarPorNomeUnico(nomeAjustado);
		if (mapaOptional.isPresent()) {
			Mapa mapa = mapaOptional.get();
			return ResponseEntity.ok(mapa);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}

	@RequestMapping(value = "/criar", method = RequestMethod.POST)
	public ResponseEntity<Mapa> criarMapa(@RequestBody MapaDto mapaDto) {
		Mapa mapa = mapaDto.converter();
		this.mapaService.salvarMapa(mapa);
		return ResponseEntity.ok(mapa);
	}
	
	@RequestMapping(value = "/listarMapasPorModo", method = RequestMethod.GET)
	public ResponseEntity<List<Mapa>> listarMapasPorModo(@RequestParam String nomeModo) {

		String nomeModoAjustado = StringUtils.capitalize(nomeModo);
		
		Optional<ModoDeJogo> modoOptional = modoService.buscarPorNomeUnico(nomeModoAjustado);
		
		if(modoOptional.isPresent()) {
			ModoDeJogo modo = modoOptional.get();
			List<Mapa> mapas = modo.getMapas();
			return ResponseEntity.ok(mapas);
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
	}
	
	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<Mapa> atualizarMapa(@PathVariable Integer id, @RequestBody MapaDto mapaDto) {
		
		Optional<Mapa> possivelMapa = mapaService.acharPorId(id);
		
		if(possivelMapa.isPresent()) {
			Mapa mapa = mapaDto.atualizar(id, mapaService);
			this.mapaService.salvarMapa(mapa);
			return ResponseEntity.ok(mapa);
		}
		return ResponseEntity.notFound().build();
	}

	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> removerMapa(@PathVariable Integer id) {
		Optional<Mapa> possivelMapa = mapaService.acharPorId(id);

		if (possivelMapa.isPresent()) {
			mapaService.deletarPelaId(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}