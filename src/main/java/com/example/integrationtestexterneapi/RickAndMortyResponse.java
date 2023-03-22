package com.example.integrationtestexterneapi;

import java.util.List;

public record RickAndMortyResponse(
        List<RickAndMortyCharacter> results
) {
}
