package br.com.portifolioLira.curso.repositories;

import br.com.portifolioLira.curso.entities.Category;
import br.com.portifolioLira.curso.entities.Product;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ProductRepository extends JpaRepository<Product,Long> {
    //só com essa definição a classe UserRepository já tem a implementação do JpaRepository, que consegue salvar, consultar, alterar e deletar registros.
}
