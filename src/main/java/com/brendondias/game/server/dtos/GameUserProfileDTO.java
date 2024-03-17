package com.brendondias.game.server.dtos;

public record GameUserProfileDTO(
        String profileImage,
        int level,

        int experience,

        int moonCoin,

        int ryous,

        String playerRank,

        String playerTitle,

        int wins,

        int loses,

        int maxLevel,

        int streak
) {
}
