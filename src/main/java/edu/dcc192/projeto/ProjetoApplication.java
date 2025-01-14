package edu.dcc192.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;;

@SpringBootApplication
public class ProjetoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ProjetoApplication.class, args);

		UsuarioRepository rep = ctx.getBean(UsuarioRepository.class);
		rep.save(new Usuario("ciro", "1234"));
		rep.save(new Usuario("jose", "1234"));
		rep.save(new Usuario("maria", "1234"));
	}

}
