package com.brendondias.game.client.repositories;

import com.brendondias.game.client.entities.skillTypes.SkillType;
import com.brendondias.game.client.entities.skills.Skill;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class SkillTypesRepository implements PanacheRepository<SkillType> {

    public Optional<SkillType> findBySkillTypeName(String skillTypeName){
        return find("skillTypeName =?1",skillTypeName).firstResultOptional();
    }
}
