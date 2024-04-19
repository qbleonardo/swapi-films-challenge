package com.swapi.challengefilmes.usecase;

import com.swapi.challengefilmes.domain.Filmes;
import com.swapi.challengefilmes.external.feign.SwapiClient;
import com.swapi.challengefilmes.external.feign.response.SwapiResponse;
import jakarta.annotation.PostConstruct;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

@Slf4j
@Component
@RequiredArgsConstructor
public class FilmLoaderUseCase {

    private final SwapiClient swapiClient;

    @PostConstruct
    public void run() {
        SwapiResponse films = swapiClient.getAllFilms();
        films.getResults().forEach(Filmes::appendFilmes);

        log.info("Quantidade de filmes: {}", films.getResults().size());
    }


}
