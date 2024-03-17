package com.brendondias.game.client.controllers;

import com.brendondias.game.client.dtos.SkillRankDTO;
import com.brendondias.game.client.entities.skillranks.SkillRank;
import com.brendondias.game.client.services.SkillRankService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Data;

@ApplicationScoped
@Data
public class SkillRankController {

    @Inject
    SkillRankService skillRankService;

    public void createSkillRank(SkillRank skillRank){
        skillRankService.createSkillRank(skillRank);
    }
}
