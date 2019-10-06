package br.com.projetointegrador2019.ProjetoIntegrador.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetointegrador2019.ProjetoIntegrador.model.usuario.Usuario;
import br.com.projetointegrador2019.ProjetoIntegrador.repository.UsuarioRepository;

@Service
public class UsuarioService {
	
	@Autowired
	private UsuarioRepository usuarioRepository;
	
	public Usuario findByLogin(String login) {
		return usuarioRepository.findByLogin(login);
	}

	public void save(Usuario novoUsuario) {
		usuarioRepository.saveAndFlush(novoUsuario);
	}

}
