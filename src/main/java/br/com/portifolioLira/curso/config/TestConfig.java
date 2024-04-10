package br.com.portifolioLira.curso.config;

import br.com.portifolioLira.curso.entities.Order;
import br.com.portifolioLira.curso.entities.enums.OrderStatus;
import br.com.portifolioLira.curso.repositories.OrderRepository;
import br.com.portifolioLira.curso.repositories.UserRepository;
import br.com.portifolioLira.curso.entities.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.time.Instant;
import java.util.Arrays;

//Essa classe server para implementar o database seeding (Inserir dados no banco de dados).
@Configuration //representa uma configuração
@Profile("test") //Deve ser igual ao nome que está no arquivo application.properties spring.profiles.active=test

public class TestConfig implements CommandLineRunner {

    @Autowired //O spring resolve a dependencia entre o TesteConfig e o UserRepository
    private UserRepository userRepository;

    @Autowired //O spring resolve a dependencia entre o TesteConfig e o UserRepository
    private OrderRepository orderRepository;


    //CommandLineRunner em tempo de execução, roda o comando abaixo.
    @Override
    public void run(String... args) throws Exception {
        User u1 = new User(null, "Maria Brown", "maria@gmail.com", "988888888", "123456");
        User u2 = new User(null, "Alex Green", "alex@gmail.com", "977777777", "123456");
        User u3 = new User(null, "Maria Green", "Maria@gmail.com", "975555555", "123456");

        Order o1 = new Order(null, Instant.parse("2019-06-20T19:53:07Z"), OrderStatus.PAID, u1);
        Order o2 = new Order(null, Instant.parse("2019-07-21T03:42:10Z"), OrderStatus.WAITING_PAIMENT,u2);
        Order o3 = new Order(null, Instant.parse("2019-07-22T15:21:22Z"), OrderStatus.WAITING_PAIMENT,u3);

        userRepository.saveAll(Arrays.asList(u1, u2, u3));
        orderRepository.saveAll(Arrays.asList(o1, o2, o3));

    }
}
