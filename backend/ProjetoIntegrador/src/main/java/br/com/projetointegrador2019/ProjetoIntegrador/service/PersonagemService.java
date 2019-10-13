package br.com.projetointegrador2019.ProjetoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetointegrador2019.ProjetoIntegrador.model.jogo.Personagem;
import br.com.projetointegrador2019.ProjetoIntegrador.repository.PersonagemRepository;

@Service
public class PersonagemService {
	
	@Autowired
	private PersonagemRepository personagemRepository;
	
	public void montarPersonagem(Personagem personagem) {
		Personagem newPersonagem = new Personagem();
		newPersonagem.setNome(personagem.getNome());
		newPersonagem.setClasse(personagem.getClasse());
		
		
	}

	public void save(Personagem novoPersonagem) {
		personagemRepository.saveAndFlush(novoPersonagem);
	}

	public List<Personagem> findAll() {
		return personagemRepository.findAll();
	}
}
