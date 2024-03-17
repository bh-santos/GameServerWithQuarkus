package com.brendondias.game.client.services;

import com.brendondias.game.client.dtos.SkillDTO;
import com.brendondias.game.client.entities.skills.Skill;
import com.brendondias.game.client.repositories.SkillsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Data
public class SkillService {

    @Inject
    SkillsRepository skillsRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(SkillService.class);

    @Transactional
    public void createSkill(Skill skill){
        if(skillsRepository.findBySkillName(skill.getSkillName()).isPresent()){
            LOGGER.info("Skill já existe");
        }else{
            skillsRepository.persist(skill);
        }
    }

    @Transactional
    public Skill findSkillById(Long id){
        return skillsRepository.findById(id);
    }
}
