package com.swapi.challengefilmes.domain;

import com.swapi.challengefilmes.external.feign.response.Result;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Filmes {

    private static List<Filmes> filmes;

    private Integer versao;
    private String titulo;
    private String diretor;
    private String produtor;
    private String dataLancamento;
    private String descricao;

    public static List<Filmes> getFilmes() {
        if(Objects.isNull(filmes)){
            filmes = new ArrayList<>();
        }
        return filmes;
    }

    public static void appendFilmes(Result film) {
        getFilmes().add(Filmes.builder()
                .versao(1)
                .titulo(film.getTitle())
                .dataLancamento(film.getReleaseDate())
                .diretor(film.getDirector())
                .produtor(film.getProducer())
                .descricao(film.getOpeningCrawl())
                .build());
    }

}
