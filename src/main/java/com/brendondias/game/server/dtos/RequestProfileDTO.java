package com.brendondias.game.server.dtos;

public record RequestProfileDTO(boolean requestInformation, String username, String password, String loginCode) {
}
