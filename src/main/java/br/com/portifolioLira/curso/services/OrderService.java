package br.com.portifolioLira.curso.services;

import br.com.portifolioLira.curso.entities.Order;
import br.com.portifolioLira.curso.repositories.OrderRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class OrderService {

    @Autowired
    private OrderRepository orderRepository;

    public List<Order> findAll(){
        return orderRepository.findAll();
    }

    public Order findById(Long id){
        Optional<Order> optOrder = orderRepository.findById(id); //O findById retorna um Optional
        return optOrder.get();
    }


}
