package br.com.lojaJogos.carga;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import br.com.lojaJogos.model.Jogo;
import br.com.lojaJogos.model.Usuario;
import br.com.lojaJogos.repositorio.UsuarioRepository;
import br.com.lojaJogos.repositorio.JogoRepository;

@Component
public class RepositoryTest implements ApplicationRunner{

	@Autowired
	private UsuarioRepository usuarioRepository;
	
	@Autowired
	private JogoRepository jogoRepository;
	
	@Override
	public void run(ApplicationArguments args) throws Exception {
		System.out.println(">>> Iniciando carga de dados...");
		
		Usuario u1 = new Usuario();
		u1.setLogin("pinheiro");
		u1.setNome("Ricardo Bertuol Pinheiro");
		u1.setEmail("pinheiro@gmail.com");
		u1.setPassword("pinheiro123");
		
		Usuario u2 = new Usuario();
		u2.setLogin("otto");
		u2.setNome("Weiven Gabriel Otto");
		u2.setEmail("otto@gmail.com");
		u2.setPassword("otto123");
		
		Jogo j1 = new Jogo();
		j1.setNome("Csgo");
		j1.setEstilo("FPS");
		j1.setPlataforma("PC");
		
		Jogo j2 = new Jogo();
		j2.setNome("Tibia");
		j2.setEstilo("RPG");
		j2.setPlataforma("PC");
		
		Jogo j3 = new Jogo();
		j3.setNome("Point Blank");
		j3.setEstilo("FPS");
		j3.setPlataforma("PC");
		
		usuarioRepository.saveAndFlush(u1);  // Salva e automaticamente ja da refresh
		usuarioRepository.saveAndFlush(u2);
		jogoRepository.saveAndFlush(j1);
		jogoRepository.saveAndFlush(j2);
		jogoRepository.saveAndFlush(j3);
		
		System.out.println(">>> Carga finalizada");
		
	}

}
