package com.brendondias.game.client.services;

import com.brendondias.game.client.dtos.SkillRankDTO;
import com.brendondias.game.client.entities.skillranks.SkillRank;
import com.brendondias.game.client.repositories.SkillRanksRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Data
public class SkillRankService {

    @Inject
    SkillRanksRepository skillRanksRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(SkillRankService.class);

    @Transactional
    public void createSkillRank(SkillRank skillRank){
        if(skillRanksRepository.findBySkillRankName(skillRank.getSkillRankName()).isPresent()){
            LOGGER.info("Skill Rank já existe");
        }else{
            skillRanksRepository.persist(skillRank);
        }
    }

    @Transactional
    public SkillRank findSkillRankById(Long id){
        return skillRanksRepository.findById(id);
    }
}
