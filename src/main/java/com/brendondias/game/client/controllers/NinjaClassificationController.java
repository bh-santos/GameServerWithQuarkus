package com.brendondias.game.client.controllers;

import com.brendondias.game.client.entities.classifications.NinjaClassification;
import com.brendondias.game.client.services.ClassificationService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Data;

@ApplicationScoped
@Data
public class NinjaClassificationController {

    @Inject
    ClassificationService classificationService;

    public void createNinjaClassification(NinjaClassification ninjaClassification){
        classificationService.createNinjaClassification(ninjaClassification);
    }
}
