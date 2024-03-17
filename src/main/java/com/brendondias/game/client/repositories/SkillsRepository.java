package com.brendondias.game.client.repositories;

import com.brendondias.game.client.entities.skillranks.SkillRank;
import com.brendondias.game.client.entities.skills.Skill;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class SkillsRepository implements PanacheRepository<Skill> {

    public Optional<Skill> findBySkillName(String skillName){
        return find("skillName =?1",skillName).firstResultOptional();
    }
}
