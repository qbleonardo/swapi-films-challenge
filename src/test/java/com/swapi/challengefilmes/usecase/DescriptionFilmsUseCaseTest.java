package com.swapi.challengefilmes.usecase;

import com.swapi.challengefilmes.domain.Filmes;
import com.swapi.challengefilmes.exception.FilmeNotFoundException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.List;

@ExtendWith(MockitoExtension.class)
class DescriptionFilmsUseCaseTest {

    @InjectMocks
    DescriptionFilmsUseCase descriptionFilmsUseCase;

    @BeforeEach
    void setUp() {
       Filmes.getFilmes().add(Filmes.builder()
                .titulo("A New Hope")
                .diretor("George Lucas")
                .produtor("Gary Kurtz, Rick McCallum")
                .dataLancamento("1977-05-25")
                .idLancamento(4)
                .descricao("It is a period of civil war.\r\nRebel spaceships, striking\r\nfrom a hidden base, have won\r\ntheir first victory against\r\nthe evil Galactic Empire.\r\n\r\nDuring the battle, Rebel\r\nspies managed to steal secret\r\nplans to the Empire's\r\nultimate weapon, the DEATH\r\nSTAR, an armored space\r\nstation with enough power\r\nto destroy an entire planet.\r\n\r\nPursued by the Empire's\r\nsinister agents, Princess\r\nLeia races home aboard her\r\nstarship, custodian of the\r\nstolen plans that can save her\r\npeople and restore\r\nfreedom to the galaxy....")
                .versao(1)
                .build());
    }


    @Test
    public void shouldAssertEqualsDescription(){
        List<Filmes> filmes = Filmes.getFilmes();


    }

    @Test
    public void shouldThrowFilmeNaoEncontradoException(){
        Assertions.assertThrows(FilmeNotFoundException.class, () -> descriptionFilmsUseCase.executeUpdateDescription(8, "alteracao de descricao"));
    }
}