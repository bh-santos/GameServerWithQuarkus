package com.brendondias.game.client.repositories;

import com.brendondias.game.client.entities.ninjaranks.NinjaRank;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class NinjaRanksRepository implements PanacheRepository<NinjaRank> {

    public Optional<NinjaRank> findByNinjaRankName(String ninjaRankName){
        return find("ninjaRankName =?1",ninjaRankName).firstResultOptional();
    }
}
