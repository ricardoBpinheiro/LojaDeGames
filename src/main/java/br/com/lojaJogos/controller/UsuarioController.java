package br.com.lojaJogos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import br.com.lojaJogos.model.Usuario;
import br.com.lojaJogos.repositorio.UsuarioRepository;

@RequestMapping(value="/usuario")
@RestController
public class UsuarioController {

	@Autowired
	private UsuarioRepository repository;
	
	@RequestMapping(value="/find/{filtro}",method=RequestMethod.GET)
	List<Usuario> findByFiltro(@PathVariable("filtro") String filtro) {
		return repository.findByFiltro(filtro);
	}
}
