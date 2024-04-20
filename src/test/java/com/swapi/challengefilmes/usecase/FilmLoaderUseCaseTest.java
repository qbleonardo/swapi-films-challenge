package com.swapi.challengefilmes.usecase;

import com.swapi.challengefilmes.exception.SwapiGenericException;
import com.swapi.challengefilmes.external.feign.SwapiClient;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;

import static com.swapi.challengefilmes.fixture.SwapiResponseFixture.getSwapiResponseFixture;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FilmLoaderUseCaseTest {

    @Mock
    SwapiClient swapiClient;

    @InjectMocks
    FilmLoaderUseCase filmLoaderUseCase;

    @Test
    @DisplayName("Teste para validar inicialização de método e carregamento de lista caso retorno da API Swapi seja RC 200")
    public void shouldInitializeMethodWithoutException(){
        when(swapiClient.getAllFilms()).thenReturn(ResponseEntity.ok(getSwapiResponseFixture()));

        Assertions.assertDoesNotThrow(() -> filmLoaderUseCase.run());
    }

    @Test
    @DisplayName("Teste para validar lançamento de exceção, caso a API do Swapi responda diferente de RC 200")
    public void shouldThrowSwapiGenericException(){
        when(swapiClient.getAllFilms()).thenReturn(new ResponseEntity<>(HttpStatusCode.valueOf(500)));

        Assertions.assertThrows(SwapiGenericException.class, () -> filmLoaderUseCase.run());
    }

}