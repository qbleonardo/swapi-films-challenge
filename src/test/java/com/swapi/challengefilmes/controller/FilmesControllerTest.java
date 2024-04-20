package com.swapi.challengefilmes.controller;

import com.swapi.challengefilmes.domain.DescriptionRequest;
import com.swapi.challengefilmes.domain.Filmes;
import com.swapi.challengefilmes.usecase.DescriptionFilmsUseCase;
import com.swapi.challengefilmes.usecase.RetrieveFilmsUseCase;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import java.util.List;

import static com.swapi.challengefilmes.fixture.FilmesFixture.getNewHopeFixture;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

@ExtendWith(MockitoExtension.class)
class FilmesControllerTest {

    @InjectMocks
    FilmesController filmesController;

    @Mock
    DescriptionFilmsUseCase descriptionFilmsUseCase;

    @Mock
    RetrieveFilmsUseCase retrieveFilmsUseCase;

    @Test
    @DisplayName("Teste para validar retorno 200 de endpoint para recuperar filme por id de lançamento")
    public void shouldGetFilmByIdLancamentoReturnOK(){
        when(retrieveFilmsUseCase.executeGetFilmByIdLancamento(4)).thenReturn(getNewHopeFixture());

        ResponseEntity<Filmes> filmByIdLancamento = filmesController.getFilmByIdLancamento(4);

        assertEquals(HttpStatus.OK, filmByIdLancamento.getStatusCode());
    }

    @Test
    @DisplayName("Teste para validar retorno 200 de endpoint para recuperar lista de filmes")
    public void shouldGetAllFilmsReturnOK() {
        when(retrieveFilmsUseCase.executeGetAllFilms(false)).thenReturn(List.of(getNewHopeFixture()));

        ResponseEntity<List<Filmes>> allFilms = filmesController.getAllFilms(false);

        assertEquals(HttpStatus.OK, allFilms.getStatusCode());
    }

    @Test
    @DisplayName("Teste para validar retorno 200 de endpoint para alterar descrição")
    public void shouldUpdateDescriptionReturn() {
        when(descriptionFilmsUseCase.executeUpdateDescription(4,"Alteracao de descricao")).thenReturn(getNewHopeFixture());

        ResponseEntity<Filmes> alteracaoDeDescricao = filmesController.updateDescription(4, new DescriptionRequest("Alteracao de descricao"));

        assertEquals(HttpStatus.OK, alteracaoDeDescricao.getStatusCode());
    }
}