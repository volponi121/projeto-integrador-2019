package br.com.projetointegrador2019.ProjetoIntegrador.service;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetointegrador2019.ProjetoIntegrador.model.jogo.Campanha;
import br.com.projetointegrador2019.ProjetoIntegrador.repository.CampanhaRepository;

@Service
public class CampanhaService {
	
	@Autowired
	private CampanhaRepository campanhaRepository;
	
	
	public void save(Campanha campanha) {
		campanhaRepository.saveAndFlush(campanha);
	}


	public  Campanha findById(Long id) {
		return campanhaRepository.findById(id).get();
	}


	public void delete(@Valid Campanha novaCampanha) {
		campanhaRepository.delete(novaCampanha);
	}


	public List<Campanha> findAll() {
		return campanhaRepository.findAll();
	}
}
