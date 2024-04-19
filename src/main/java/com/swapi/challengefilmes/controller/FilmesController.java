package com.swapi.challengefilmes.controller;

import com.swapi.challengefilmes.domain.DescriptionRequest;
import com.swapi.challengefilmes.domain.Filmes;
import com.swapi.challengefilmes.usecase.DescriptionFilmsUseCase;
import com.swapi.challengefilmes.usecase.RetrieveFilmsUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/filmes")
public class FilmesController {

    @Autowired
    DescriptionFilmsUseCase descriptionFilmsUseCase;

    @Autowired
    RetrieveFilmsUseCase retrieveFilmsUseCase;

    @GetMapping(path = "/buscar-filme/{idLancamento}")
    public Filmes getFilmByIdLancamento(@PathVariable(value = "idLancamento") Integer idLancamento){
        return retrieveFilmsUseCase.executeGetFilmByIdLancamento(idLancamento);
    }

    @GetMapping(path = "/listar-filmes")
    public List<Filmes> getAllFilms(){
        return retrieveFilmsUseCase.executeGetAllFilms();
    }

    @PutMapping(path = "/atualizar-descricao/{idLancamento}")
    public Filmes updateDescription(@PathVariable(value = "idLancamento") Integer idLancamento,
                                    @RequestBody @Valid DescriptionRequest descricao){

        return descriptionFilmsUseCase.executeUpdateDescription(idLancamento, descricao.getDescricao());
    }
}
