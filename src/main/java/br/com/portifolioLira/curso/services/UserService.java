package br.com.portifolioLira.curso.services;

import br.com.portifolioLira.curso.entities.User;
import br.com.portifolioLira.curso.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public User findById(Long id){
        Optional<User> optUser = userRepository.findById(id); //O findById retorna um Optional
        return optUser.get();
    }


}
