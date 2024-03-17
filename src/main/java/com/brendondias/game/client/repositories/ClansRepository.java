package com.brendondias.game.client.repositories;

import com.brendondias.game.client.entities.clans.Clan;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class ClansRepository implements PanacheRepository<Clan> {

    public Optional<Clan> findByClanName(String clanName){
        return find("clanName =?1",clanName).firstResultOptional();
    }
}
