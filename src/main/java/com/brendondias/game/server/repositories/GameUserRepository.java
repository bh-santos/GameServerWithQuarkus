package com.brendondias.game.server.repositories;

import com.brendondias.game.server.entities.GameUser;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.persistence.PersistenceUnit;

import java.util.Optional;
@ApplicationScoped
public class GameUserRepository implements PanacheRepository<GameUser> {

    public Optional<GameUser> findByUsername(String username) {
        return find("username = ?1", username).firstResultOptional();
    }


    public Optional<GameUser> findByEmail(String email){
        return find("email = ?1",email).firstResultOptional();
    }

    public Optional<GameUser> findByNickname(String nickname){
        return find("nickname = ?1", nickname).firstResultOptional();
    }

    public boolean deleteByUsername(String username){
       if(findByUsername(username).isPresent()){
           delete("username = ?1", username);
           return true;
       }else{
           return false;
       }
    }
}
