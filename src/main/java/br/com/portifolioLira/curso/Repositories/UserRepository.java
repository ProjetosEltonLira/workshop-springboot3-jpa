package br.com.portifolioLira.curso.Repositories;

import br.com.portifolioLira.curso.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;

public interface UserRepository extends JpaRepository<User,Long> {

    //só com essa definição a classe UserRepository já tem a implementação do JpaRepository, que consegue salvar, consultar, alterar e deletar registros.
}
