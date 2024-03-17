package com.brendondias.game.server.sockets;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class LoginData {
    private String username;
    private String password;

    public LoginData(@JsonProperty("username") String username,
                     @JsonProperty("password") String password){
        this.username=username;
        this.password=password;
    }
}
