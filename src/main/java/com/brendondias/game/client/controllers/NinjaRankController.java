package com.brendondias.game.client.controllers;

import com.brendondias.game.client.dtos.NinjaRankDTO;
import com.brendondias.game.client.entities.ninjaranks.NinjaRank;
import com.brendondias.game.client.services.NinjaRankService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Data;

@ApplicationScoped
@Data
public class NinjaRankController {

    @Inject
    NinjaRankService ninjaRankService;

    public void createNinjaRank(NinjaRank ninjaRank){
        ninjaRankService.createNinjaRank(ninjaRank);
    }
}
