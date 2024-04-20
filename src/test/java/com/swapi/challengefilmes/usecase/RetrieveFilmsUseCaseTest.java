package com.swapi.challengefilmes.usecase;

import com.swapi.challengefilmes.domain.Filmes;
import com.swapi.challengefilmes.exception.FilmeNotFoundException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.swapi.challengefilmes.fixture.FilmesFixture.getNewHopeFixture;
import static com.swapi.challengefilmes.fixture.FilmesFixture.getRevengeSithFixture;
import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
class RetrieveFilmsUseCaseTest {

    @InjectMocks
    RetrieveFilmsUseCase retrieveFilmsUseCase;

    @BeforeEach
    void setUp() {
        Filmes.getFilmes().clear();

        Filmes.getFilmes().add(getNewHopeFixture());
        Filmes.getFilmes().add(getRevengeSithFixture());
    }

    @Test
    @DisplayName("Teste para validar retorno de filme conforme especificado em argumento")
    public void shouldToBeEqualsId(){
        Filmes quartoFilme = retrieveFilmsUseCase.executeGetFilmByIdLancamento(4);

        assertEquals(4, quartoFilme.getIdLancamento());
    }

    @Test
    @DisplayName("Teste para validar lançamento de exceção caso informe id de filme que não exista")
    public void shouldThrowFilmeNotFoundException(){
        assertThrows(FilmeNotFoundException.class, () -> retrieveFilmsUseCase.executeGetFilmByIdLancamento(8));
    }

    @Test
    @DisplayName("Teste para validar retorno da lista")
    public void shouldToBeNotNull(){
        assertNotNull(retrieveFilmsUseCase.executeGetAllFilms(false));
    }

    @Test
    @DisplayName("Teste para validar retorno de lista ordenado por id de lançamento caso parâmetro para ordernação seja true")
    public void shouldReturnSortedByIdLancamento(){
        List<Filmes> filmesOrdenados = retrieveFilmsUseCase.executeGetAllFilms(true);

        assertEquals(getRevengeSithFixture(), filmesOrdenados.get(0));
        assertEquals(getNewHopeFixture(), filmesOrdenados.get(1));
    }

    @Test
    @DisplayName("Teste para validar retorno de lista ordenado conforme consumo do Swapi caso parâmetro seja false")
    public void shouldReturnSortedOriginal(){
        List<Filmes> filmesOrdenados = retrieveFilmsUseCase.executeGetAllFilms(false);

        assertEquals(getNewHopeFixture(), filmesOrdenados.get(0));
        assertEquals(getRevengeSithFixture(), filmesOrdenados.get(1));
    }

}