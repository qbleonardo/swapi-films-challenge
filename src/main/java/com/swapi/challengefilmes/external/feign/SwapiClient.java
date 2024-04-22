package com.swapi.challengefilmes.external.feign;

import com.swapi.challengefilmes.external.feign.response.SwapiResponse;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;

@FeignClient(name = "Swapi", url = "https://swapi.py4e.com/api")
public interface SwapiClient {

    @GetMapping(value = "/films", consumes = "application/json")
    ResponseEntity<SwapiResponse> getAllFilms();
}
