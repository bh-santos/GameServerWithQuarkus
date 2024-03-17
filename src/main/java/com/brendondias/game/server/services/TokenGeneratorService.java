package com.brendondias.game.server.services;

import java.security.SecureRandom;
import java.util.Base64;

public class TokenGeneratorService {
    private static final int TOKEN_LENGTH = 32;

    public static String generateToken() {
        byte[] randomBytes = new byte[TOKEN_LENGTH];
        SecureRandom secureRandom = new SecureRandom();
        secureRandom.nextBytes(randomBytes);

        return Base64.getUrlEncoder().withoutPadding().encodeToString(randomBytes);
    }
}
