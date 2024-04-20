package br.com.portifolioLira.curso.services.exceptions;

public class DataBaseException extends RuntimeException{

    public DataBaseException(String mensagem){
        super(mensagem);
    }
}
