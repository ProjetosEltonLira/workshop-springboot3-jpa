package br.com.portifolioLira.curso.repositories;


import br.com.portifolioLira.curso.entities.OrderItem;
import br.com.portifolioLira.curso.entities.pk.OrderItemPK;
import org.springframework.data.jpa.repository.JpaRepository;


public interface OrderItemRepository extends JpaRepository<OrderItem, OrderItemPK> {

    //só com essa definição a classe UserRepository já tem a implementação do JpaRepository, que consegue salvar, consultar, alterar e deletar registros.

}
