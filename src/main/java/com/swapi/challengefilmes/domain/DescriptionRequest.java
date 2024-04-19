package com.swapi.challengefilmes.domain;

import jakarta.validation.constraints.NotBlank;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class DescriptionRequest {

    @NotBlank(message = "O campo não poderá ser vazio ou nulo")
    private String descricao;
}
