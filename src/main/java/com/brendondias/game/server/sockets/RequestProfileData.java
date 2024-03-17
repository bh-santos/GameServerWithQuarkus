package com.brendondias.game.server.sockets;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RequestProfileData {
    private String username;
    private String password;
    private String loginCode;
    private boolean requestInformation;


    public RequestProfileData(@JsonProperty("requestInformation") boolean requestInformation, @JsonProperty("username") String username, @JsonProperty("password") String password,@JsonProperty("loginCode") String loginCode){
        this.requestInformation=requestInformation;
        this.username=username;
        this.password=password;
        this.loginCode=loginCode;
    }
}
