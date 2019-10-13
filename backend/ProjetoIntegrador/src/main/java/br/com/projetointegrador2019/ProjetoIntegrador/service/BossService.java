package br.com.projetointegrador2019.ProjetoIntegrador.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import br.com.projetointegrador2019.ProjetoIntegrador.model.jogo.Boss;
import br.com.projetointegrador2019.ProjetoIntegrador.repository.BossRepository;

@Service
public class BossService {

	@Autowired
	private BossRepository bossRepository;

	public void save(Boss boss) {
		bossRepository.saveAndFlush(boss);
	}

	public Boss findById(Long id) {
		return bossRepository.findById(id).get();
	}

	public void delete(Boss boss) {
		bossRepository.delete(boss);
	}

	public List<Boss> findAll() {
		return bossRepository.findAll();
	}
}
