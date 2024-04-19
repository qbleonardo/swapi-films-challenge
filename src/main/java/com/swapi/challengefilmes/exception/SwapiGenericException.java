package com.swapi.challengefilmes.exception;

import lombok.Getter;
import org.springframework.http.HttpStatusCode;

@Getter
public class SwapiGenericException extends RuntimeException{

    private final HttpStatusCode httpStatusCode;
    public SwapiGenericException(HttpStatusCode httpStatusCode, String message) {
        super(message);
        this.httpStatusCode = httpStatusCode;
    }

}
