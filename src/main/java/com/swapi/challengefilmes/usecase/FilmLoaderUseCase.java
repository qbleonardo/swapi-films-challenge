package com.swapi.challengefilmes.usecase;

import com.swapi.challengefilmes.domain.Filmes;
import com.swapi.challengefilmes.exception.SwapiGenericException;
import com.swapi.challengefilmes.external.feign.SwapiClient;
import com.swapi.challengefilmes.external.feign.response.SwapiResponse;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.Objects;

@Slf4j
@Component
@RequiredArgsConstructor
public class FilmLoaderUseCase {

    private final SwapiClient swapiClient;

    @PostConstruct
    public void run() {
        ResponseEntity<SwapiResponse> films = swapiClient.getAllFilms();

        if (Objects.equals(films.getStatusCode(), HttpStatus.OK) && Objects.nonNull(films.getBody())) {
            log.info("Quantidade de filmes: {}", films.getBody().getCount());

            films.getBody().getResults().forEach(Filmes::appendFilmes);
        } else {
            throw new SwapiGenericException(films.getStatusCode(), "Retorno da requisição à API Swapi mal-sucedida!");
        }

    }
}