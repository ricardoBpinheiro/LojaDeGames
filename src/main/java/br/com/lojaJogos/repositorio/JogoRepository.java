package br.com.lojaJogos.repositorio;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import br.com.lojaJogos.model.Jogo;

public interface JogoRepository extends JpaRepository<Jogo, Long> {

	@Query("Select u from Jogo u where u.nome like %:filtro% ")
	public List<Jogo> findByFiltro(@Param("filtro") String filtro);
		
	
}
