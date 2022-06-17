package br.com.vitor.rainbowsix.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import br.com.vitor.rainbowsix.modelo.Mapa;
import br.com.vitor.rainbowsix.modelo.ModoDeJogo;
import br.com.vitor.rainbowsix.service.MapaService;
import br.com.vitor.rainbowsix.service.ModoDeJogoService;
import io.swagger.annotations.Api;

@RestController
@RequestMapping(value = "associar")
@Api(value = "Agente API", produces = MediaType.APPLICATION_JSON_VALUE, tags = {"associar mapas e modos"}, description = "Mapas_Modos")
public class AssociarMapaEModoDeJogoController {

	@Autowired
	MapaService mapaService;

	@Autowired
	ModoDeJogoService modoService;

	@RequestMapping(value = "/mapaEModoDeJogo", method = RequestMethod.POST, produces = {MediaType.APPLICATION_JSON_VALUE})
	public ResponseEntity<?> associar(@RequestParam String nomeMapa, @RequestParam String nomeModo) {
		
		String nomeMapaAjustado = StringUtils.capitalize(nomeMapa);
		String nomeModoAjustado = StringUtils.capitalize(nomeModo);
		
		Optional<Mapa> mapaOptional = mapaService.buscarPorNomeUnico(nomeMapaAjustado);
		Optional<ModoDeJogo> modoOptional = modoService.buscarPorNomeUnico(nomeModoAjustado);
		
		if(mapaOptional.isPresent() && modoOptional.isPresent()) {
			Mapa mapa = mapaOptional.get();
			ModoDeJogo modo = modoOptional.get();
			mapa.getModos().add(modo);
			mapaService.salvarMapa(mapa);
			return ResponseEntity.ok().build();
		}
		
		return ResponseEntity.status(HttpStatus.NOT_FOUND).build();	
	}


}