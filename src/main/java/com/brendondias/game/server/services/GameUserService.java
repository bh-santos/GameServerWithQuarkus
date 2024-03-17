package com.brendondias.game.server.services;

import com.brendondias.game.server.dtos.GameUserDTO;
import com.brendondias.game.server.dtos.GameUserProfileDTO;
import com.brendondias.game.server.dtos.LoginDTO;
import com.brendondias.game.server.dtos.RequestProfileDTO;
import com.brendondias.game.server.entities.GameUser;
import com.brendondias.game.server.entities.GameUserProfile;
import com.brendondias.game.server.repositories.GameUserRepository;
import com.brendondias.game.server.sockets.ProfileDataToJson;
import com.google.gson.Gson;
import com.google.gson.JsonObject;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.PersistenceUnit;
import jakarta.transaction.Transactional;
import lombok.Data;
@ApplicationScoped
@Data
public class GameUserService {

    @Inject
    GameUserRepository gameUserRepository;

    @Transactional
    public String createUser(GameUserDTO data, GameUserProfileDTO dataProfile) {

        if(gameUserRepository.findByUsername(data.username()).isPresent()){
            JsonObject json = new JsonObject();
            json.addProperty("jsonType", "create_account_response");
            JsonObject jsonData = new JsonObject();
            jsonData.addProperty("response_message","Usuário já existe.");
            json.add("data",jsonData);
            return new Gson().toJson(json);
        }else {
            if(gameUserRepository.findByEmail(data.email()).isPresent()){
                JsonObject json = new JsonObject();
                json.addProperty("jsonType", "create_account_response");
                JsonObject jsonData = new JsonObject();
                jsonData.addProperty("response_message","Email Já existe.");
                json.add("data",jsonData);
                return new Gson().toJson(json);
            }else{
                if(gameUserRepository.findByNickname(data.nickname()).isPresent()){
                    JsonObject json = new JsonObject();
                    json.addProperty("jsonType", "create_account_response");
                    JsonObject jsonData = new JsonObject();
                    jsonData.addProperty("response_message","Nickname já existe.");
                    json.add("data",jsonData);
                    return new Gson().toJson(json);
                }else{
                    JsonObject json = new JsonObject();
                    json.addProperty("jsonType", "create_account_response");
                    JsonObject jsonData = new JsonObject();
                    jsonData.addProperty("response_message","success");
                    json.add("data",jsonData);

                    GameUser user = new GameUser(data);

                    GameUserProfile profile = new GameUserProfile(dataProfile,user);

                    user.setUserProfile(profile);

                    gameUserRepository.persist(user);
                    return new Gson().toJson(json);
                }
            }
        }
    }
    @Transactional
    public boolean login(LoginDTO data){
        if(gameUserRepository.findByUsername(data.username()).isPresent()){
            if(gameUserRepository.findByUsername(data.username()).get().getPassword().equals(data.password())){
                gameUserRepository.findByUsername(data.username()).get().setLoginCode(TokenGeneratorService.generateToken());
                return true;
            }else {
                return false;
            }
        }else{return false;
        }
    }

    @Transactional
    public String requestProfile(RequestProfileDTO data){
        if(data.requestInformation()){
            if(gameUserRepository.findByUsername(data.username()).isPresent()){
                if(gameUserRepository.findByUsername(data.username()).get().getPassword().equals(data.password())){
                    if(gameUserRepository.findByUsername(data.username()).get().getLoginCode().equals(data.loginCode())){
                        ProfileDataToJson profileData = new ProfileDataToJson(
                                gameUserRepository.findByUsername(data.username()).get().getUserProfile().getProfileImage(),
                                gameUserRepository.findByUsername(data.username()).get().getUserProfile().getLevel(),
                                gameUserRepository.findByUsername(data.username()).get().getUserProfile().getExperience(),
                                gameUserRepository.findByUsername(data.username()).get().getUserProfile().getMoonCoin(),
                                gameUserRepository.findByUsername(data.username()).get().getUserProfile().getRyous(),
                                gameUserRepository.findByUsername(data.username()).get().getUserProfile().getPlayerRank(),
                                gameUserRepository.findByUsername(data.username()).get().getUserProfile().getPlayerTitle(),
                                gameUserRepository.findByUsername(data.username()).get().getUserProfile().getWins(),
                                gameUserRepository.findByUsername(data.username()).get().getUserProfile().getLoses(),
                                gameUserRepository.findByUsername(data.username()).get().getUserProfile().getWinPercentage(),
                                gameUserRepository.findByUsername(data.username()).get().getUserProfile().getMaxLevel(),
                                gameUserRepository.findByUsername(data.username()).get().getUserProfile().getStreak()
                        );


                        JsonObject json = new JsonObject();

                        json.addProperty("jsonType","request_profile_response");

                        JsonObject jsonData = new JsonObject();
                        jsonData.addProperty("nickname",gameUserRepository.findByUsername(data.username()).get().getNickname());
                        jsonData.addProperty("profileImage", profileData.getProfileImage());
                        jsonData.addProperty("level",profileData.getLevel());
                        jsonData.addProperty("experience", profileData.getExperience());
                        jsonData.addProperty("moonCoin", profileData.getMoonCoin());
                        jsonData.addProperty("ryous",profileData.getRyous());
                        jsonData.addProperty("playerRank", profileData.getPlayerRank());
                        jsonData.addProperty("playerTitle",profileData.getPlayerTitle());
                        jsonData.addProperty("wins",profileData.getWins());
                        jsonData.addProperty("loses",profileData.getLoses());
                        jsonData.addProperty("winPercentage",profileData.getWinPercentage());
                        jsonData.addProperty("maxLevel", profileData.getMaxLevel());
                        jsonData.addProperty("streak", profileData.getStreak());

                        json.add("data",jsonData);



                      return new Gson().toJson(json);
                    }else{
                        return "Usuário Offline";
                    }
                }else{
                    return "Senha Incorreta";
                }
            }else{
                return "Usuário não existe";
            }
        }else{
            return "Não houve solicitação";
        }
    }

    @Transactional
    public String requestLoginCode(String username){
       if(gameUserRepository.findByUsername(username).isPresent()){
          return gameUserRepository.findByUsername(username).get().getLoginCode();
       }else return "invalido";
    }

}
