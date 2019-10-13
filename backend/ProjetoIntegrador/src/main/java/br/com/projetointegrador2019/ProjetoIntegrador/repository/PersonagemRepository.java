package br.com.projetointegrador2019.ProjetoIntegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import br.com.projetointegrador2019.ProjetoIntegrador.model.jogo.Personagem;

public interface PersonagemRepository extends JpaRepository<Personagem, Long>{
	
}
