package com.brendondias.game.server.dtos;

import java.time.LocalDate;

public record GameUserDTO(
        String username,
        String password,
        String email,
        String nickname,
        LocalDate birthday,
        String gameUserType
) {
}
