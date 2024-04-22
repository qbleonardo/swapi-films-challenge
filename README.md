# Challenge Filmes - SWAPI

Desafio proposto para criação de uma API responsável por consumir a API do Stars Wars (<a href="https://swapi.py4e.com/">SWAPI</a>) e disponibilizar endpoints de alteração e recuperação de dados obtidos. 

## Definições técnicas

Implementação utilizando o Java 17 e a versão 3.2.5 do Spring Boot. A aplicação conta com o uso do <a href="https://docs.spring.io/spring-cloud-openfeign/docs/current/reference/html/">Feign Client</a> para consumo da API Swapi.

## Sobre a API 

A API possui três endpoints quais são referentes à alteração da descrição de um filme, obteção da listagem de todos os filmes e recuperação de um filme específico conforme seu id de lançamento. Os dados dos filmes são obtidos via o endpoint <a href="https://swapi.dev/api/films/">/films</a> da API Swapi. Segue abaixo os detalhes dos endpoints de alteração e recuperação:

<h5>GET</h5>
<ul>
  <li><strong>/filmes/listar-filmes</strong></li>
  Endpoint responsável por retornar uma lista com todos os filmes do Stars Wars.
  <li><strong>/filmes/buscar-filme/{idLancamento}</strong></li>
  Endpoint responsável por retornar um filme específico a partir do id de lançamento informado.
</ul>

<h5>PUT</h5>
<ul>
  <li><strong>/filmes/atualizar-descricao/{idLancamento}</strong></li>
  Endpoint responsável por atualizar a descrição do filme.
</ul>
 
## Documentação
Para mais informações sobre os endpoints disponíveis, a API está configurada com as anotações do OpenApi para visualização do contrato via endpoint /api-docs. 

<i>Porém, segue anexo abaixo em formato json para visualização no <a href="https://editor.swagger.io/">Swagger Editor</a> ou qualquer plataforma de sua preferência.</i>

<strong>Contrato/Swagger: </strong> [challenge-contrato.json](https://github.com/qbleonardo/swapi-films-challenge/files/15048969/challenge-contrato.json) 

## cURL
Caso deseje realizar as requisições testes aos endpoints da API localmente, disponibilizando abaixo uma collection gerada via POSTMAN com os cURLs para cada endpoint.

[SWAPI.postman_collection.json](https://github.com/qbleonardo/swapi-films-challenge/files/15049014/SWAPI.postman_collection.json)



