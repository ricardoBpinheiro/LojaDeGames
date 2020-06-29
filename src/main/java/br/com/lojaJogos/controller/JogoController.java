package br.com.lojaJogos.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.lojaJogos.model.Jogo;
import br.com.lojaJogos.repositorio.JogoRepository;

@RequestMapping(value = "/jogo")
@RestController
public class JogoController {
	@Autowired
	private JogoRepository repository;

	@RequestMapping(value = "/find/{filtro}", method = RequestMethod.GET)
	List<Jogo> findByFiltro(@PathVariable("filtro") String filtro) {
		return repository.findByFiltro(filtro);

	}

	@RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
	void deleteById(@PathVariable("id") Long id) {
		Optional<Jogo> jogo = repository.findById(id);
		repository.delete(jogo.get());
	}

	@RequestMapping(value = "/{nome}/{estilo}/{plataforma}", method = RequestMethod.POST)
	Jogo criaJogo(@PathVariable("nome") String nome, @PathVariable("estilo") String estilo,
			@PathVariable("plataforma") String plataforma) {
		Jogo jogo = new Jogo();
		jogo.setNome(nome);
		jogo.setPlataforma(plataforma);
		jogo.setEstilo(estilo);
		return repository.save(jogo);
	}

	@RequestMapping(value = "/{id}/{nome}/{estilo}/{plataforma}", method = RequestMethod.PUT)
	Jogo atualizaJogo(@PathVariable("id") Long id,@PathVariable("nome") String nome, @PathVariable("estilo") String estilo,
			@PathVariable("plataforma") String plataforma) {
		Jogo jogo = repository.findById(id).get();
		jogo.setNome(nome);
		jogo.setPlataforma(plataforma);
		jogo.setEstilo(estilo);
		return repository.save(jogo);
	}
}
