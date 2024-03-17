package com.brendondias.game.client.controllers;

import com.brendondias.game.client.dtos.ElementDTO;
import com.brendondias.game.client.entities.elements.Element;
import com.brendondias.game.client.services.ElementService;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import lombok.Data;

@ApplicationScoped
@Data
public class ElementController {

    @Inject
    ElementService elementService;

    public void createElement(Element element){
       elementService.createElement(element);
    }
}
