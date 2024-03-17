package com.brendondias.game.client.dtos;

public record VillageDTO(
        String villageImage,
        String villageName,
        String villageDescription,
        float attributeBonuses
) {
}
