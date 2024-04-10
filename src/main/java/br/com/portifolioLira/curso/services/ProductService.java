package br.com.portifolioLira.curso.services;


import br.com.portifolioLira.curso.entities.Product;
import br.com.portifolioLira.curso.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository ProductRepository;

    public List<Product> findAll(){
        return ProductRepository.findAll();
    }

    public Product findById(Long id){
        Optional<Product> optProduct = ProductRepository.findById(id); //O findById retorna um Optional
        return optProduct.get();
    }
}
