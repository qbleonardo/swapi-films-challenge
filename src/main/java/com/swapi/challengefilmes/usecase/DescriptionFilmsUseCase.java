package com.swapi.challengefilmes.usecase;

import com.swapi.challengefilmes.domain.Filmes;
import com.swapi.challengefilmes.exception.FilmeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class DescriptionFilmsUseCase {

    public Filmes executeUpdateDescription(Integer idLancamento, String descricao){
        Optional<Filmes> filmeToUpdate = Filmes.getFilmes().stream()
                .filter(filme ->  filme.getIdLancamento().equals(idLancamento))
                .findAny();

        filmeToUpdate
                .ifPresent(f -> { 
                    f.setDescricao(descricao);
                    f.setVersao(f.getVersao() + 1);
                });

        return filmeToUpdate
                .orElseThrow(() -> new FilmeNotFoundException(String.format("Não encontrado filme com o id de lançamento [%s], validar o id informado na requisição", idLancamento)));
    }
}
