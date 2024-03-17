package com.brendondias.game.client.repositories;

import com.brendondias.game.client.entities.ninjaranks.NinjaRank;
import com.brendondias.game.client.entities.ninjas.Ninja;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class NinjasRepository implements PanacheRepository<Ninja> {

    public Optional<Ninja> findByNinjaName(String ninjaName){
        return find("ninjaName =?1",ninjaName).firstResultOptional();
    }
}
