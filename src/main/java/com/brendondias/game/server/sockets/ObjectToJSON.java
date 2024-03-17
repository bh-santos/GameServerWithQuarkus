package com.brendondias.game.server.sockets;

import com.fasterxml.jackson.databind.ObjectMapper;

public class ObjectToJSON {
    private static ObjectMapper objectMapper;
    public static String createJSON(Object object){
        try{
            objectMapper = new ObjectMapper();
            return objectMapper.writeValueAsString(object);
        }catch (Exception e){
            throw new RuntimeException("Não foi possível criar o JSON");
        }
    }
}
