package br.com.portifolioLira.curso.repositories;

import br.com.portifolioLira.curso.entities.Order;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderRepository extends JpaRepository<Order,Long> {

    //só com essa definição a classe UserRepository já tem a implementação do JpaRepository, que consegue salvar, consultar, alterar e deletar registros.

}
