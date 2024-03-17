package com.brendondias.game.client.dtos;

public record ClassificationDTO(
        String classificationName,
        String classificationDescription,
        float attributeBonuses
) {
}
