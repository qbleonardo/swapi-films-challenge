package com.swapi.challengefilmes.exception;

public class FilmeNotFoundException extends RuntimeException{

    public FilmeNotFoundException(String message) {
        super(message);
    }
}
