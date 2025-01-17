package edu.dcc192.projeto;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;;

@SpringBootApplication
public class ProjetoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctx = SpringApplication.run(ProjetoApplication.class, args);

		UsuarioRepository rep = ctx.getBean(UsuarioRepository.class);
		rep.save(new Usuario("admin", "admin"));
	}

}
