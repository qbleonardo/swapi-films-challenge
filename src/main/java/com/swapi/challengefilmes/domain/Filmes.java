package com.swapi.challengefilmes.domain;

import com.swapi.challengefilmes.external.feign.response.Result;
import lombok.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@Builder
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public class Filmes {

    private static List<Filmes> filmes;

    private String titulo;
    private String diretor;
    private String produtor;
    private String dataLancamento;
    private Integer idLancamento;
    private String descricao;
    private Integer versao;

    public static List<Filmes> getFilmes() {
        if(Objects.isNull(filmes)){
            filmes = new ArrayList<>();
        }
        return filmes;
    }

    public static void appendFilmes(Result film) {
        getFilmes().add(Filmes.builder()
                .idLancamento(film.getEpisodeId())
                .versao(1)
                .titulo(film.getTitle())
                .dataLancamento(film.getReleaseDate())
                .diretor(film.getDirector())
                .produtor(film.getProducer())
                .descricao(film.getOpeningCrawl())
                .build());
    }

}
