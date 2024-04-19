package com.swapi.challengefilmes.usecase;

import com.swapi.challengefilmes.domain.Filmes;
import com.swapi.challengefilmes.exception.FilmeNotFoundException;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class RetrieveFilmsUseCase {

    public Filmes executeGetFilmByIdLancamento(Integer idLancamento){
        return Filmes.getFilmes().stream()
                .filter(filme -> filme.getIdLancamento().equals(idLancamento))
                .findFirst()
                .orElseThrow(() -> new FilmeNotFoundException(String.format("Não encontrado filme com o id de lançamento [%s], validar o id informado na requisição", idLancamento)));
    }

    public List<Filmes> executeGetAllFilms(){
        return Filmes.getFilmes();
    }
}
