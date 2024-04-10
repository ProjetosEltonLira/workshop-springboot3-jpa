package br.com.portifolioLira.curso.resources;

import br.com.portifolioLira.curso.entities.Product;
import br.com.portifolioLira.curso.services.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
@RequestMapping(value = "/products")
public class ProductResource {

    @Autowired
    private ProductService productService;

    @GetMapping
    public ResponseEntity<List<Product>> findAll() {

        List<Product> list = productService.findAll();
        return ResponseEntity.ok().body(list);
        //Versão mokada do retorno
        // Product u = new Product(1L, "Maria", "maria@gmail.com", "9999999", "12345");
        //return ResponseEntity.ok().body(u);
    }

    @GetMapping (value = "/{id}") // Isso indica que permite receber um valor na URL
    public ResponseEntity<Product> findById(@PathVariable Long id) { // para o Spring aceitar esse valor vindo da URL precisa colocar a notação @PathVariable
        Product product = productService.findById(id);
        return ResponseEntity.ok().body(product);
    }
}
