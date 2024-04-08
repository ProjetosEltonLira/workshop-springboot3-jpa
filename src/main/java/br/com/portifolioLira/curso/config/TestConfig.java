package br.com.portifolioLira.curso.config;

import br.com.portifolioLira.curso.Repositories.UserRepository;
import br.com.portifolioLira.curso.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Arrays;

@Configuration //representa uma configuração
@Profile("test") //Deve ser igual ao nome que está no arquivo application.properties spring.profiles.active=test
//Esse objeto serve para implementar o database seeding.
public class TestConfig implements CommandLineRunner {

    @Autowired //O spring resolve a dependencia entre o TesteConfig e o UserRepository
    private UserRepository userRepository;


    //CommandLineRunner em tempo de execução, roda o comando abaixo.
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");

        userRepository.saveAll(Arrays.asList(u1, u2));
    }
}
