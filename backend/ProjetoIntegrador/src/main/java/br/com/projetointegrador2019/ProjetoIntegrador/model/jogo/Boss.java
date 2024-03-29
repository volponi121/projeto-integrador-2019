package br.com.projetointegrador2019.ProjetoIntegrador.model.jogo;

import java.io.Serializable;
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
@Table(name = "BOSS")
public class Boss implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id", unique = true, nullable = false)
	private Long id;
	
	@Column(name = "nome", length = 80, nullable = false)
	private String nome;
	
	@Column(name = "descricao", length = 3000, nullable = false)
	private String descricao;

	@ManyToMany
	@JoinTable(name = "BOSS_CAMPANHA", joinColumns = { @JoinColumn(name = "fk_idCampanha") }, inverseJoinColumns = {
			@JoinColumn(name = "fk_idBoss") })
	private List<Campanha> campanhasBosses = new ArrayList<Campanha>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public List<Campanha> getCampanhasBosses() {
		return campanhasBosses;
	}

	public void setCampanhasBosses(List<Campanha> campanhasBosses) {
		this.campanhasBosses = campanhasBosses;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((campanhasBosses == null) ? 0 : campanhasBosses.hashCode());
		result = prime * result + ((descricao == null) ? 0 : descricao.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
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
		Boss other = (Boss) obj;
		if (campanhasBosses == null) {
			if (other.campanhasBosses != null)
				return false;
		} else if (!campanhasBosses.equals(other.campanhasBosses))
			return false;
		if (descricao == null) {
			if (other.descricao != null)
				return false;
		} else if (!descricao.equals(other.descricao))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

}
