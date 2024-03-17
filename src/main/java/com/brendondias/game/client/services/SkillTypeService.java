package com.brendondias.game.client.services;

import com.brendondias.game.client.dtos.SkillTypeDTO;
import com.brendondias.game.client.entities.skillTypes.SkillType;
import com.brendondias.game.client.repositories.SkillTypesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Data
public class SkillTypeService {

    @Inject
    SkillTypesRepository skillTypesRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(SkillTypeService.class);

    @Transactional
    public void createSkillType(SkillType skillType){
        if(skillTypesRepository.findBySkillTypeName(skillType.getSkillTypeName()).isPresent()){
            LOGGER.info("Skill Type já existe");
        }else{
            skillTypesRepository.persist(skillType);
        }
    }

    @Transactional
    public SkillType findSkillTypeById(Long id){
        return skillTypesRepository.findById(id);
    }
}
