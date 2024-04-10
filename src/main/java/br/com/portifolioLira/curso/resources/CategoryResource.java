package br.com.portifolioLira.curso.resources;

import br.com.portifolioLira.curso.entities.Category;
import br.com.portifolioLira.curso.services.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/categories")
public class CategoryResource {

    @Autowired
    private CategoryService CategoryService;

    @GetMapping
    public ResponseEntity<List<Category>> findAll() {

        List<Category> list = CategoryService.findAll();
        return ResponseEntity.ok().body(list);
        //Versão mokada do retorno
        // Category u = new Category(1L, "Maria", "maria@gmail.com", "9999999", "12345");
        //return ResponseEntity.ok().body(u);
    }

    @GetMapping (value = "/{id}") // Isso indica que permite receber um valor na URL
    public ResponseEntity<Category> findById(@PathVariable Long id) { // para o Spring aceitar esse valor vindo da URL precisa colocar a notação @PathVariable
        Category Category = CategoryService.findById(id);
        return ResponseEntity.ok().body(Category);
    }
}
