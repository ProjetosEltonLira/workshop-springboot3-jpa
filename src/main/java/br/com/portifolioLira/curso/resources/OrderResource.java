package br.com.portifolioLira.curso.resources;


import br.com.portifolioLira.curso.entities.Order;
import br.com.portifolioLira.curso.services.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/orders")
public class OrderResource {

    @Autowired
    private OrderService orderService;

    @GetMapping
    public ResponseEntity<List<Order>> findAll() {

        List<Order> list = orderService.findAll();
        return ResponseEntity.ok().body(list);
        //Versão mokada do retorno
        // User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
        //return ResponseEntity.ok().body(u);
    }

    @GetMapping (value = "/{id}") // Isso indica que permite receber um valor na URL
    public ResponseEntity<Order> findById(@PathVariable Long id) { // para o Spring aceitar esse valor vindo da URL precisa colocar a notação @PathVariable
        Order order= orderService.findById(id);
        return ResponseEntity.ok().body(order);
    }
}
