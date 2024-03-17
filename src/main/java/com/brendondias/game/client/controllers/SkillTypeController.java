package com.brendondias.game.client.controllers;

import com.brendondias.game.client.dtos.SkillTypeDTO;
import com.brendondias.game.client.entities.skillTypes.SkillType;
import com.brendondias.game.client.services.SkillTypeService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Data;

@ApplicationScoped
@Data
public class SkillTypeController {

    @Inject
    SkillTypeService skillTypeService;

    public void createSkillType(SkillType skillType){
       skillTypeService.createSkillType(skillType);
    }
}
