package br.com.portifolioLira.curso.resources;

import br.com.portifolioLira.curso.entities.User;
import br.com.portifolioLira.curso.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;


@RestController
@RequestMapping(value = "/users")
public class UserResource {

    @Autowired
    private UserService userService;

    @GetMapping
    public ResponseEntity<List<User>> findAll() {

        List<User> list = userService.findAll();
        return ResponseEntity.ok().body(list);
        //Versão mokada do retorno
        // User u = new User(1L, "Maria", "maria@gmail.com", "9999999", "12345");
        //return ResponseEntity.ok().body(u);
    }

    @GetMapping (value = "/{id}") // Isso indica que permite receber um valor na URL
    public ResponseEntity<User> findById(@PathVariable Long id) { // para o Spring aceitar esse valor vindo da URL precisa colocar a notação @PathVariable
        User user = userService.findById(id);
        return ResponseEntity.ok().body(user);
    }

    //usado para fazer o Insert, tem que usar o POST no INSOMNIA
    @PostMapping
    public ResponseEntity<User> insert(@RequestBody User user){
        userService.insert(user);
        URI uri = ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("/{id}")
                .buildAndExpand(user.getId())
                .toUri();
        return ResponseEntity.created(uri).body(user); //ResposeEntity.create
    }
}
