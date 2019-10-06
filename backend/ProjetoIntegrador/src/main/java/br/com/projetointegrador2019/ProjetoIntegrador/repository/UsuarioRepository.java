package br.com.projetointegrador2019.ProjetoIntegrador.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.projetointegrador2019.ProjetoIntegrador.model.usuario.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query(value = "SELECT u FROM Usuario u WHERE u.login = :login")
	Usuario findByLogin(@Param("login") String login);

}
