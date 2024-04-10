package br.com.portifolioLira.curso.repositories;

import br.com.portifolioLira.curso.entities.Category;
import org.springframework.data.jpa.repository.JpaRepository;


public interface CategoryRepository extends JpaRepository<Category,Long> {
    //só com essa definição a classe UserRepository já tem a implementação do JpaRepository, que consegue salvar, consultar, alterar e deletar registros.
}
