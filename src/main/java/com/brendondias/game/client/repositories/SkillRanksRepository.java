package com.brendondias.game.client.repositories;

import com.brendondias.game.client.entities.ninjas.Ninja;
import com.brendondias.game.client.entities.skillranks.SkillRank;
import com.brendondias.game.client.entities.skills.Skill;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class SkillRanksRepository implements PanacheRepository<SkillRank> {

    public Optional<SkillRank> findBySkillRankName(String skillRankName){
        return find("skillRankName =?1",skillRankName).firstResultOptional();
    }
}
