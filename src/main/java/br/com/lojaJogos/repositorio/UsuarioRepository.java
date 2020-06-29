package br.com.lojaJogos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.lojaJogos.model.Usuario;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

	@Query("Select u from Usuario u where u.login like %:filtro% ")
	public List<Usuario> findByFiltro(@Param("filtro") String filtro);
	
}
