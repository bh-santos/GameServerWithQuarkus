package com.brendondias.game.server.sockets;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonFormat;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDate;

@Data
public class UserData {
    private String username;
    private String nickname;
    private String password;
    private String email;
    @JsonFormat
    private LocalDate birthday;
    private String gameUserType;

    @JsonCreator
    public UserData(
            @JsonProperty("username") String username,
            @JsonProperty("password") String password,
            @JsonProperty("nickname") String nickname,
            @JsonProperty("birthday") @JsonFormat LocalDate birthday,
            @JsonProperty("gameUserType") String userType,
            @JsonProperty("email") String email
    ){
        this.username = username;
        this.password = password;
        this.nickname=nickname;
        this.birthday=birthday;
        this.gameUserType=userType;
        this.email=email;
        System.out.println("TESTADO JSON");
    }
}
