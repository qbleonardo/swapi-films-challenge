package com.swapi.challengefilmes.controller.swagger;

import com.swapi.challengefilmes.domain.DescriptionRequest;
import com.swapi.challengefilmes.domain.Filmes;
import com.swapi.challengefilmes.exception.response.ErrorData;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.media.ArraySchema;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@OpenAPIDefinition(info = @Info(title = "Challenge Filmes - SWAPI",
        description = "Aplicação desenvolvida para realização do desafio consumindo API Swapi", version = "v0.0.1"))
public interface FilmesControllerSwagger {

    @Operation(summary = "Buscar por id de lançamento",
            description = "Endpoint responsável por retornar um filme específico a partir do id de lançamento informado.",
            tags = {"Retorno de filme específico - Swapi"})
    @ApiResponse(responseCode = "200", description = "Retorno com sucesso",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = Filmes.class)))
    @ApiResponse(responseCode = "404",
            description = "Filme não encontrado",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorData.class)))
    @GetMapping(path = "/buscar-filme/{idLancamento}")
    ResponseEntity<Filmes> getFilmByIdLancamento(@Parameter(name = "idLancamento",
            description = "Parâmetro obrigatório para busca de filmes por id", required = true, example = "1") Integer idLancamento);

    @Operation(summary = "Listar todos os filmes",
            description = "Endpoint responsável por retornar uma lista com todos os filmes do Stars Wars.",
            tags = {"Retorno de lista com todos os filmes - Swapi"})
    @ApiResponse(responseCode = "200", description = "Retorno com sucesso",
            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Filmes.class))))
    @ApiResponse(responseCode = "400",
            description = "Lista vazia",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorData.class)))
    @GetMapping(path = "/listar-filmes")
    ResponseEntity<List<Filmes>> getAllFilms(@Parameter(name = "ordenacao", description = "Parâmetro opcional para ordenação de lista", example = "true") boolean ordenacao);

    @Operation(summary = "Atualizar descrição do filme",
            description = "Endpoint responsável por atualizar a descrição do filme",
            tags = {"Atualização de descrição - Swapi"})
    @ApiResponse(responseCode = "200", description = "Retorno com sucesso",
            content = @Content(mediaType = "application/json", array = @ArraySchema(schema = @Schema(implementation = Filmes.class))))
    @ApiResponse(responseCode = "404",
            description = "Filme não encontrado",
            content = @Content(mediaType = "application/json", schema = @Schema(implementation = ErrorData.class)))
    @PutMapping(path = "/atualizar-descricao/{idLancamento}")
     ResponseEntity<Filmes> updateDescription(@Parameter(name = "idLancamento",
            description = "Parâmetro obrigatório para busca de filmes por id", required = true, example = "1") Integer idLancamento,
                                                    @RequestBody DescriptionRequest descricao);

}
