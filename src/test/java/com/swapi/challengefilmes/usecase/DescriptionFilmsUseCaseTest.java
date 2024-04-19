package com.swapi.challengefilmes.usecase;

import com.swapi.challengefilmes.domain.Filmes;
import com.swapi.challengefilmes.exception.FilmeNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

import static com.swapi.challengefilmes.fixture.FilmesFixture.getNewHopeFixture;

@ExtendWith(MockitoExtension.class)
class DescriptionFilmsUseCaseTest {

    @InjectMocks
    DescriptionFilmsUseCase descriptionFilmsUseCase;

    List<Filmes> filmes;

    @BeforeEach
    void setUp() {
        Filmes.getFilmes().clear();

        filmes = Filmes.getFilmes();
        filmes.add(getNewHopeFixture());
    }

    @Test
    @DisplayName(value = "Teste para validar alteração de descrição")
    public void shouldAssertEqualsDescription() {
        Filmes descricaoAlterada = descriptionFilmsUseCase.executeUpdateDescription(4, "alteracao teste");

        Assertions.assertEquals("alteracao teste", descricaoAlterada.getDescricao());
    }

    @Test
    @DisplayName(value = "Teste para validar incrementação de versão ao alteração descrição")
    public void shouldIncrementVersionAfterUpdate() {
        Filmes descricaoAlterada = descriptionFilmsUseCase.executeUpdateDescription(4, "alteracao de version/descricao");

        Assertions.assertEquals(2, descricaoAlterada.getVersao());
    }

    @Test
    @DisplayName(value = "Teste para validar lançamento de exceção para filme não encontrado")
    public void shouldThrowFilmeNaoEncontradoException() {
        Assertions.assertThrows(FilmeNotFoundException.class, () -> descriptionFilmsUseCase.executeUpdateDescription(8, "alteracao de descricao"));
    }
}