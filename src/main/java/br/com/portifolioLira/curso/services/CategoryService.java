package br.com.portifolioLira.curso.services;


import br.com.portifolioLira.curso.entities.Category;
import br.com.portifolioLira.curso.repositories.CategoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CategoryService {

    @Autowired
    private CategoryRepository categoryRepository;

    public List<Category> findAll(){
        return categoryRepository.findAll();
    }

    public Category findById(Long id){
        Optional<Category> optUser = categoryRepository.findById(id); //O findById retorna um Optional
        return optUser.get();
    }


}
