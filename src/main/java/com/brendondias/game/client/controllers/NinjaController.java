package com.brendondias.game.client.controllers;

import com.brendondias.game.client.dtos.NinjaDTO;
import com.brendondias.game.client.entities.ninjas.Ninja;
import com.brendondias.game.client.services.NinjaService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Data;

@ApplicationScoped
@Data
public class NinjaController {

    @Inject
    NinjaService ninjaService;

    public void createNinja(Ninja ninja){
       ninjaService.createNinja(ninja);
    }
}
