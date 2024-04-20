package com.swapi.challengefilmes.controller;

import com.swapi.challengefilmes.domain.DescriptionRequest;
import com.swapi.challengefilmes.domain.Filmes;
import com.swapi.challengefilmes.usecase.DescriptionFilmsUseCase;
import com.swapi.challengefilmes.usecase.RetrieveFilmsUseCase;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
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
    public ResponseEntity<Filmes> getFilmByIdLancamento(@PathVariable(value = "idLancamento") Integer idLancamento) {
        return ResponseEntity.ok()
                .body(retrieveFilmsUseCase.executeGetFilmByIdLancamento(idLancamento));
    }

    @GetMapping(path = "/listar-filmes")
    public ResponseEntity<List<Filmes>> getAllFilms(@RequestParam(value = "ordenacao", required = false) boolean ordenacao) {
        return ResponseEntity.ok()
                .body(retrieveFilmsUseCase.executeGetAllFilms(ordenacao));
    }

    @PutMapping(path = "/atualizar-descricao/{idLancamento}")
    public ResponseEntity<Filmes> updateDescription(@PathVariable(value = "idLancamento") Integer idLancamento,
                                                    @RequestBody @Valid DescriptionRequest descricao) {
        return ResponseEntity.ok()
                .body(descriptionFilmsUseCase.executeUpdateDescription(idLancamento, descricao.getDescricao()));
    }
}
