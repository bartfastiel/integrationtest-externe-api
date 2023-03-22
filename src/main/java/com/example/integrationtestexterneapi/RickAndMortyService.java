package com.example.integrationtestexterneapi;

import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
public class RickAndMortyService {

    private final WebClient webClient = WebClient.create("https://rickandmortyapi.com/api/");

    public List<RickAndMortyCharacter> getRickAndMorty() {
        return Objects.requireNonNull(webClient.get()
                .uri("character")
                .retrieve()
                .bodyToMono(RickAndMortyResponse.class)
                .block()).results();
    }
}
