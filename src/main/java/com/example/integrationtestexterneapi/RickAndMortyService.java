package com.example.integrationtestexterneapi;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Objects;

@Service
public class RickAndMortyService {

    private final WebClient webClient;

    public RickAndMortyService(
            @Value("${rickandmorty.url}") String url
    ) {
        this.webClient = WebClient.create(url);
    }

    public List<RickAndMortyCharacter> getRickAndMorty() {
        return Objects.requireNonNull(webClient.get()
                .uri("character")
                .retrieve()
                .bodyToMono(RickAndMortyResponse.class)
                .block()).results();
    }
}
