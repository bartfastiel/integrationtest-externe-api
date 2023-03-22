package com.example.integrationtestexterneapi;

public record RickAndMortyCharacter(
        int id,
        String name,
        String status,
        String species,
        String type,
        String gender,
        String image
) {
}
