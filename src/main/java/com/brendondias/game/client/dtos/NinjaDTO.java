package com.brendondias.game.client.dtos;

public record NinjaDTO(
        String ninjaImage,
        String ninjaName,
        float life,
        float chakra,
        float energy,
        int ninjutsu,
        int taijutsu,
        int genjutsu,
        int bukijutsu,
        int strength,
        int agility,
        int chakraControl,
        int velocity,
        int vitality,
        int resistance) {
}

