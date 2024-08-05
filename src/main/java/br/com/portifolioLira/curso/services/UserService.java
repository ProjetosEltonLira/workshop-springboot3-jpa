package br.com.portifolioLira.curso.services;


import br.com.portifolioLira.curso.entities.User;
import br.com.portifolioLira.curso.repositories.UserRepository;
import br.com.portifolioLira.curso.services.exceptions.DataBaseException;
import br.com.portifolioLira.curso.services.exceptions.ResourceNotFoundException;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository repository;

    public List<User> findAll(){
        return repository.findAll();
    }

    public User findById(Long id){
        Optional<User> optUser = repository.findById(id); //O findById retorna um Optional
        //return optUser.get();
        //orElseThrow (tenta pegar o valor, se der erro, lança exceção)
        return optUser.orElseThrow(() -> new ResourceNotFoundException(id));
    }

    public User insert(User user){
        return repository.save(user);
    }

    public void delete(Long id){
        try {
            repository.deleteById(id);
        }
        catch (EmptyResultDataAccessException e){
            throw new ResourceNotFoundException(id);
        }
        catch (DataIntegrityViolationException e){ //Exceção da minha camada de serviços.
            throw new DataBaseException(e.getMessage());
        }
    }
    public User update(Long id, User user){
       try {
           User entity = repository.getReferenceById(id);
           updateData(entity, user);
           return repository.save(entity);
       }
       catch (EntityNotFoundException e){ //Tratar os casos que o ID não exista
           throw new ResourceNotFoundException(id);
       }
    }

    public void updateData(User entity, User user) {
        entity.setEmail(user.getEmail());
        entity.setName(user.getName());
        entity.setPhone(user.getPhone());
    }


}
