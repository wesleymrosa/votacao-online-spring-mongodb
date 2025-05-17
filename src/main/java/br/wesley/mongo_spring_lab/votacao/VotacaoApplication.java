package br.wesley.mongo_spring_lab.votacao;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@OpenAPIDefinition(
		info = @Info(
				title = "Sistema de Votação Online",
				version = "1.0",
				description = "API para cadastro de candidatos, registro de votos e apuração de resultados",
				contact = @Contact(name = "Wesley", email = "wesley@example.com")
		)
)
public class VotacaoApplication {

	public static void main(String[] args) {
		SpringApplication.run(VotacaoApplication.class, args);
	}
}
