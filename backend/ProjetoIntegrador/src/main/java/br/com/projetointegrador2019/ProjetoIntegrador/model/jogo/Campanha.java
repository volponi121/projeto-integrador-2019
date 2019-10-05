package br.com.projetointegrador2019.ProjetoIntegrador.model.jogo;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "CAMPANHA")
public class Campanha implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "historia_campanha", length = 3000, nullable = false)
	private String historiaCampanha;
	
	@Column(name = "tempo_estimado")
	private LocalDateTime tempoEstimado;

	@ManyToMany
	@JoinTable(name = "BOSS_CAMPANHA", joinColumns = { @JoinColumn(name = "fk_idBoss") }, inverseJoinColumns = {
			@JoinColumn(name = "fk_idCampanha") })
	private List<Boss> campanhasBosses = new ArrayList<>();

	@ManyToMany
	@JoinTable(name = "CAMPANHA_PERSONAGEM", joinColumns = {
			@JoinColumn(name = "fk_idPersonagem") }, inverseJoinColumns = { @JoinColumn(name = "fk_idCampanha") })
	private List<Personagem> personagens = new ArrayList<>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getHistoriaCampanha() {
		return historiaCampanha;
	}

	public void setHistoriaCampanha(String historiaCampanha) {
		this.historiaCampanha = historiaCampanha;
	}

	public LocalDateTime getTempoEstimado() {
		return tempoEstimado;
	}

	public void setTempoEstimado(LocalDateTime tempoEstimado) {
		this.tempoEstimado = tempoEstimado;
	}

	public List<Boss> getCampanhasBosses() {
		return campanhasBosses;
	}

	public void setCampanhasBosses(List<Boss> campanhasBosses) {
		this.campanhasBosses = campanhasBosses;
	}

	public List<Personagem> getPersonagens() {
		return personagens;
	}

	public void setPersonagens(List<Personagem> personagens) {
		this.personagens = personagens;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campanhasBosses == null) ? 0 : campanhasBosses.hashCode());
		result = prime * result + ((historiaCampanha == null) ? 0 : historiaCampanha.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((personagens == null) ? 0 : personagens.hashCode());
		result = prime * result + ((tempoEstimado == null) ? 0 : tempoEstimado.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Campanha other = (Campanha) obj;
		if (campanhasBosses == null) {
			if (other.campanhasBosses != null)
				return false;
		} else if (!campanhasBosses.equals(other.campanhasBosses))
			return false;
		if (historiaCampanha == null) {
			if (other.historiaCampanha != null)
				return false;
		} else if (!historiaCampanha.equals(other.historiaCampanha))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (personagens == null) {
			if (other.personagens != null)
				return false;
		} else if (!personagens.equals(other.personagens))
			return false;
		if (tempoEstimado == null) {
			if (other.tempoEstimado != null)
				return false;
		} else if (!tempoEstimado.equals(other.tempoEstimado))
			return false;
		return true;
	}

}
