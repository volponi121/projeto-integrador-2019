package br.com.projetointegrador2019.ProjetoIntegrador.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetointegrador2019.ProjetoIntegrador.model.jogo.Boss;
import br.com.projetointegrador2019.ProjetoIntegrador.model.jogo.Campanha;
import br.com.projetointegrador2019.ProjetoIntegrador.service.CampanhaService;

@RestController
@RequestMapping("/campanhas")
public class CampanhaController {
	
	@Autowired
	private CampanhaService campanhaService;
	
	@GetMapping("/all")
	public List<Campanha> getCampanhas() {
		return campanhaService.findAll();
	}
	
	@PostMapping("/new")
	public ResponseEntity<String> newCampanha(@Valid @RequestBody Campanha novaCampanha){
		campanhaService.save(novaCampanha);
		return ResponseEntity.status(HttpStatus.OK).body("Campanha cadastrado com sucesso.");
	}
	
	@PutMapping("/edit")
	public ResponseEntity<String> editCampanha(@Valid @RequestBody Campanha novaCampanha){
		if(campanhaService.findById(novaCampanha.getId()) != null) {
			campanhaService.delete(novaCampanha);
			campanhaService.save(novaCampanha);
			return ResponseEntity.status(HttpStatus.OK).body("Campanha alterada com sucesso.");
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Campanha não encontrada.");
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteCampanha(@Valid @RequestBody Campanha novaCampanha){
		campanhaService.delete(novaCampanha);
		return ResponseEntity.status(HttpStatus.OK).body("Campanha excluida com sucesso.");
	}
}
