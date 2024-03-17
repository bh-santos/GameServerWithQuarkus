package com.brendondias.game.server.sockets;

import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class JsonMessage<T> {
    private String jsonType;
    private T data;

    @JsonCreator
    public JsonMessage(@JsonProperty("jsonType") String jsonType, @JsonProperty("data") T data) {
        this.jsonType = jsonType;
        this.data = data;
        System.out.println("TESTADO MESSAGE JSON");
    }
}
