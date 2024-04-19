package com.swapi.challengefilmes.external.feign.response;

import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.validation.Valid;
import lombok.Builder;
import lombok.Data;

import java.util.List;

@Data
@Builder
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Result {

    @JsonProperty("title")
    private String title;
    @JsonProperty("episode_id")
    private Integer episodeId;
    @JsonProperty("opening_crawl")
    private String openingCrawl;
    @JsonProperty("director")
    private String director;
    @JsonProperty("producer")
    private String producer;
    @JsonProperty("release_date")
    private String releaseDate;
    @JsonProperty("characters")
    @Valid
    private List<String> characters;
    @JsonProperty("planets")
    @Valid
    private List<String> planets;
    @JsonProperty("starships")
    @Valid
    private List<String> starships;
    @JsonProperty("vehicles")
    @Valid
    private List<String> vehicles;
    @JsonProperty("species")
    @Valid
    private List<String> species;
    @JsonProperty("created")
    private String created;
    @JsonProperty("edited")
    private String edited;
    @JsonProperty("url")
    private String url;
}
