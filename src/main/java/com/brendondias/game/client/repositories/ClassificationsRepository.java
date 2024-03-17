package com.brendondias.game.client.repositories;

import com.brendondias.game.client.entities.clans.Clan;
import com.brendondias.game.client.entities.classifications.NinjaClassification;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class ClassificationsRepository implements PanacheRepository<NinjaClassification> {

    public Optional<NinjaClassification> findByClassificationName(String classificationName){
        return find("classificationName =?1",classificationName).firstResultOptional();
    }
}
