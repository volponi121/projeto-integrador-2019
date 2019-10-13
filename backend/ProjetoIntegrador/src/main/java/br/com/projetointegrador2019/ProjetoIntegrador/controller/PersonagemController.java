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
import org.springframework.web.bind.annotation.RestController;

import br.com.projetointegrador2019.ProjetoIntegrador.model.jogo.Personagem;
import br.com.projetointegrador2019.ProjetoIntegrador.service.PersonagemService;

@RestController
public class PersonagemController {
	
	@Autowired
	private PersonagemService personagemService;
	
	@GetMapping("/all")
	public List<Personagem> getPersonagem() {
		return personagemService.findAll();
	}
	
	@PostMapping("/new")
	public ResponseEntity<String> newPersonagem(@Valid @RequestBody Personagem novoPersonagem){
		personagemService.save(novoPersonagem);
		return ResponseEntity.status(HttpStatus.OK).body("Personagem cadastrado com sucesso.");
	}
	
	@PutMapping("/edit")
	public ResponseEntity<String> editPersonagem(@Valid @RequestBody Personagem personagem){
		if(personagemService.findById(personagem.getId()) != null) {
			personagemService.delete(personagem);
			personagemService.save(personagem);
			return ResponseEntity.status(HttpStatus.OK).body("Personagem alterada com sucesso.");
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Personagem não encontrado.");
	}
	
	@DeleteMapping("/delete")
	public ResponseEntity<String> deletePersonagem(@Valid @RequestBody Personagem personagem){
		personagemService.delete(personagem);
		return ResponseEntity.status(HttpStatus.OK).body("Personagem excluida com sucesso.");
	}
}
