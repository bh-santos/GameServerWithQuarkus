package com.brendondias.game.client.dtos;

public record ClanDTO(
        String clanImage,
        String clanName,
        String clanDescription,
        float clanBonuses
) {
}
