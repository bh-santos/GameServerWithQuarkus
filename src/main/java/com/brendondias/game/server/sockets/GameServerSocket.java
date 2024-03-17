package com.brendondias.game.server.sockets;


import com.brendondias.game.server.dtos.GameUserDTO;
import com.brendondias.game.server.dtos.GameUserProfileDTO;
import com.brendondias.game.server.dtos.LoginDTO;
import com.brendondias.game.server.dtos.RequestProfileDTO;
import com.brendondias.game.server.services.GameUserService;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.type.TypeFactory;
import com.fasterxml.jackson.datatype.jsr310.JavaTimeModule;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.websocket.*;
import jakarta.websocket.server.ServerEndpoint;

@ApplicationScoped
@ServerEndpoint("/gameClient")
public class GameServerSocket {
    @Inject
    GameUserService gameUserService;



    private ObjectMapper objectMapper = new ObjectMapper();
    JsonMessage<?> jsonMessage;

    public GameServerSocket(){
        objectMapper.registerModule(new JavaTimeModule());
    }
    @OnMessage
    public void onMessage(Session session,String message) throws Exception {

        jsonMessage = objectMapper.readValue(message, new TypeReference<JsonMessage<?>>() {});


        switch (jsonMessage.getJsonType()){
            case "create_account" :
                createAccount(session,message);
                break;
            case "login" :
                login(session,message);
                break;
            case "request_profile":
                requestProfile(session,message);
                break;
            case "request_ninjas":
                break;
            default:
                session.getAsyncRemote().sendText("Erro desconhecido");
        }

    }

    private void createAccount(Session session,String message) throws JsonProcessingException {
        JsonMessage<UserData> createAccountMessage = objectMapper.readValue(message, TypeFactory.defaultInstance().constructParametricType(JsonMessage.class, UserData.class));
        UserData userDataset = createAccountMessage.getData();

        var userData = new GameUserDTO(
                userDataset.getUsername(),
                userDataset.getPassword(),
                userDataset.getEmail(),
                userDataset.getNickname(),
                userDataset.getBirthday(),
                userDataset.getGameUserType()
        );

        var profileData = new ProfileData();
        var profileDataDTO = new GameUserProfileDTO(
                profileData.getProfileImage(),
                profileData.getLevel(),
                profileData.getExperience(),
                profileData.getMoonCoin(),
                profileData.getRyous(),
                profileData.getPlayerRank(),
                profileData.getPlayerTitle(),
                profileData.getWins(),
                profileData.getLoses(),
                profileData.getMaxLevel(),
                profileData.getStreak()
        );
        AsyncExecutor.execute(() -> {
            String queryResult;

            queryResult =gameUserService.createUser(userData,profileDataDTO);

            session.getAsyncRemote().sendText(queryResult);
        });
    }

    public void login(Session session, String message) throws JsonProcessingException {
        JsonMessage<LoginData> loginMessage = objectMapper.readValue(message, TypeFactory.defaultInstance().constructParametricType(JsonMessage.class, LoginData.class));
        LoginData loginDataset = loginMessage.getData();

            var loginData = new LoginDTO(
                    loginDataset.getUsername(),
                    loginDataset.getPassword()
            );

            AsyncExecutor.execute(()->{
                boolean isLogged;
                isLogged = gameUserService.login(loginData);

                if(isLogged){
                    JsonObject json = new JsonObject();
                        json.addProperty("jsonType", "login_response");

                        JsonObject jsonData = new JsonObject();

                        jsonData.addProperty("response_message","success");
                        jsonData.addProperty("login_code", gameUserService.requestLoginCode(loginData.username()));

                        json.add("data", jsonData);
                        String jsonString = new Gson().toJson(json);

                    session.getAsyncRemote().sendText(jsonString);
                }else{
                    JsonObject json = new JsonObject();
                    json.addProperty("jsonType", "login_response");

                    JsonObject jsonData = new JsonObject();

                    jsonData.addProperty("response_message","failed");

                    json.add("data", jsonData);
                    String jsonString = new Gson().toJson(json);

                    session.getAsyncRemote().sendText(jsonString);
                }
            });
    }

    private void requestProfile(Session session, String message) throws JsonProcessingException {
        JsonMessage<RequestProfileData> requestProfileDataJsonMessage = objectMapper.readValue(message, TypeFactory.defaultInstance().constructParametricType(JsonMessage.class, RequestProfileData.class));
        RequestProfileData profileDataset = requestProfileDataJsonMessage.getData();

        var profileData = new RequestProfileDTO(
                profileDataset.isRequestInformation(),
                profileDataset.getUsername(),
                profileDataset.getPassword(),
                profileDataset.getLoginCode()
        );

        AsyncExecutor.execute(()->{
                session.getAsyncRemote().sendText( gameUserService.requestProfile(profileData));
        });
    }

}
