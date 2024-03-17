package com.brendondias.game.client.dtos;

public record SkillRankDTO(
        String skillRankName,
        String skillRankDescription,
        float damageBonuses
) {
}
