package com.brendondias.game.client.controllers;

import com.brendondias.game.client.dtos.ClanDTO;
import com.brendondias.game.client.entities.clans.Clan;
import com.brendondias.game.client.services.ClanService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Data;
@ApplicationScoped
@Data
public class ClanController {

    @Inject
    ClanService clanService;

    public void createClan(Clan clan){
        clanService.createClan(clan);
    }
}
