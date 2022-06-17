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
import org.springframework.web.bind.annotation.RestController;

import br.com.vitor.rainbowsix.dto.ModoDeJogoDto;
import br.com.vitor.rainbowsix.modelo.ModoDeJogo;
import br.com.vitor.rainbowsix.service.ModoDeJogoService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "modoDeJogo")
@Api(value = "Agente API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"modo de jogo"}, description = "Modos de jogo API")
public class ModoDeJogoController {
	
	@Autowired 
	private ModoDeJogoService modoService;
	
	@RequestMapping(value = "/listarTodos", 
					method = RequestMethod.GET, 
					produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> listarTodosOsModosDeJogo(){
		List<ModoDeJogo> modos = this.modoService.listarTodosOsModos();
		return ResponseEntity.ok(modos);
	}

	@RequestMapping(value = "/procurarPorNome/{nome}", 
					method = RequestMethod.GET, 
					produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<ModoDeJogo> procurarModoPorNome(@PathVariable String nome){
		String nomeAjustado =StringUtils.capitalize(nome);
		Optional<ModoDeJogo> modo = this.modoService.buscarPorNomeUnico(nomeAjustado);
		if(modo.isPresent()) {
			ModoDeJogo modoDeJogo = modo.get();
			return ResponseEntity.ok(modoDeJogo);
		}
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
	}
	
	@RequestMapping(value = "/criar", 
					method = RequestMethod.POST)
	public ResponseEntity<ModoDeJogo> criarModoDeJogo(@RequestBody ModoDeJogoDto modoDto){
		ModoDeJogo modo = modoDto.converter();
		this.modoService.salvarModoDeJogo(modo);
		return ResponseEntity.ok(modo);
	}
	
	@RequestMapping(value = "/atualizar/{id}", method = RequestMethod.PUT, produces = { MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<ModoDeJogo> atualizarModoDeJogo(@PathVariable Integer id, @RequestBody ModoDeJogoDto modoDto) {
		Optional<ModoDeJogo> possivelModoDeJogo = modoService.acharPorId(id);
		
		if(possivelModoDeJogo.isPresent()) {
			ModoDeJogo modo = modoDto.atualizar(id, modoService);
			this.modoService.salvarModoDeJogo(modo);
			return ResponseEntity.ok(modo);
		}
		return ResponseEntity.notFound().build();
	}

	@RequestMapping(value = "/deletar/{id}", method = RequestMethod.DELETE, produces = {
			MediaType.APPLICATION_JSON_VALUE })
	public ResponseEntity<?> removerModoDeJogo(@PathVariable Integer id) {
		Optional<ModoDeJogo> possivelModoDeJogo = modoService.acharPorId(id);

		if (possivelModoDeJogo.isPresent()) {
			modoService.deletarPelaId(id);
			return ResponseEntity.ok().build();
		} else {
			return ResponseEntity.notFound().build();
		}
	}
}