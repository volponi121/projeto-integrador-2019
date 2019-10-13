package br.com.projetointegrador2019.ProjetoIntegrador.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import br.com.projetointegrador2019.ProjetoIntegrador.model.usuario.Usuario;
import br.com.projetointegrador2019.ProjetoIntegrador.service.UsuarioService;

@RestController
@RequestMapping("/usuario")
public class UsuarioController {
	
	@Autowired
	private UsuarioService usuarioService;
	
	
	@PostMapping("/new")
	public ResponseEntity<String> newUsuario(@Valid @RequestBody Usuario novoUsuario){
		if(usuarioService.findByLogin(novoUsuario.getLogin()) != null) {
			return ResponseEntity.status(HttpStatus.CONFLICT).body("Usuário já cadastrado.");
		}
		usuarioService.save(novoUsuario);
		return ResponseEntity.status(HttpStatus.OK).body("Usuário cadastrado com sucesso.");
	}
	
	
}
