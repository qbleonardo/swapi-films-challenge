package com.swapi.challengefilmes.usecase;

import com.swapi.challengefilmes.domain.Filmes;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ListsFilmsUseCase {

    public List<Filmes> executeGetAllFilms(){
        return Filmes.getFilmes();
    }
}
