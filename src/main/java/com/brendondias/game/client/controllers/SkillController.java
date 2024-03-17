package com.brendondias.game.client.controllers;

import com.brendondias.game.client.dtos.SkillDTO;
import com.brendondias.game.client.entities.skills.Skill;
import com.brendondias.game.client.services.SkillService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Data;

@ApplicationScoped
@Data
public class SkillController {

    @Inject
    SkillService skillService;

    public void createSkill(Skill skill){
       skillService.createSkill(skill);
    }
}
