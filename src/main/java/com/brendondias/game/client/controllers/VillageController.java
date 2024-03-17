package com.brendondias.game.client.controllers;

import com.brendondias.game.client.dtos.VillageDTO;
import com.brendondias.game.client.entities.villages.Village;
import com.brendondias.game.client.services.VillageService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Data;

@ApplicationScoped
@Data
public class VillageController {

    @Inject
    VillageService villageService;

    public void createVillage(Village village){
       villageService.createVillage(village);
    }
}
