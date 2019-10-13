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
import br.com.projetointegrador2019.ProjetoIntegrador.service.BossService;

@RestController
@RequestMapping("/boss")
public class BossController {

	@Autowired
	private BossService bossService;

	@GetMapping("/all")
	public List<Boss> getBosses() {
		return bossService.findAll();
	}

	@PostMapping("/new")
	public ResponseEntity<String> newBoss(@Valid @RequestBody Boss boss) {
		bossService.save(boss);
		return ResponseEntity.status(HttpStatus.OK).body("Boss cadastrado com sucesso.");
	}

	@PutMapping("/edit")
	public ResponseEntity<String> editBoss(@Valid @RequestBody Boss boss) {
		if (bossService.findById(boss.getId()) != null) {
			bossService.delete(boss);
			bossService.save(boss);
			return ResponseEntity.status(HttpStatus.OK).body("Boss alterada com sucesso.");
		}
		return ResponseEntity.status(HttpStatus.CONFLICT).body("Boss não encontrado.");
	}

	@DeleteMapping("/delete")
	public ResponseEntity<String> deleteBoss(@Valid @RequestBody Boss boss) {
		bossService.delete(boss);
		return ResponseEntity.status(HttpStatus.OK).body("Boss excluido com sucesso.");
	}
}
