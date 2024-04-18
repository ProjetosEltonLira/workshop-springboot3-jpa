package br.com.portifolioLira.curso.resources.exceptions;

import br.com.portifolioLira.curso.services.exceptions.ResourceNotFoundException;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import java.io.Serializable;
import java.time.Instant;

@ControllerAdvice //isso que vai interceptar as exceções que acontecerem
public class ResourceExceptionHandler  {

    //Intercepta qualquer exceção do tipo ResourceNotFoundException
    @ExceptionHandler(ResourceNotFoundException.class)
    public ResponseEntity<StandardError> resourceNotFound(ResourceNotFoundException exception, HttpServletRequest request){
        String msgErro = "Resource not found";
        HttpStatus httpStatus = HttpStatus.NOT_FOUND;
        StandardError bodyErro = new StandardError(Instant.now(),httpStatus.value(),msgErro,exception.getMessage(),request.getRequestURI());
        return ResponseEntity.status(httpStatus).body(bodyErro);
    }

}
