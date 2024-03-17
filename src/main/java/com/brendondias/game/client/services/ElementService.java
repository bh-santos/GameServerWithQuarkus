package com.brendondias.game.client.services;

import com.brendondias.game.client.dtos.ElementDTO;
import com.brendondias.game.client.entities.elements.Element;
import com.brendondias.game.client.repositories.ElementsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Data
public class ElementService {

    @Inject
    ElementsRepository elementsRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ElementService.class);

    @Transactional
    public void createElement(Element element){
        if(elementsRepository.findByElementName(element.getElementName()).isPresent()){
            LOGGER.info("Elemento já existe.");
        }else{
            elementsRepository.persist(element);
        }
    }

    @Transactional
    public Element findElementById(Long id){
        return elementsRepository.findById(id);
    }
}
