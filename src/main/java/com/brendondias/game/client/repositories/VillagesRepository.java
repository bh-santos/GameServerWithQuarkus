package com.brendondias.game.client.repositories;

import com.brendondias.game.client.entities.villages.Village;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class VillagesRepository implements PanacheRepository<Village> {

    public Optional<Village> findByVillageName(String villageName){
        return find("villageName =?1",villageName).firstResultOptional();
    }
}
