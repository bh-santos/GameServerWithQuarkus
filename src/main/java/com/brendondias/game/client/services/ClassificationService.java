package com.brendondias.game.client.services;

import com.brendondias.game.client.dtos.ClanDTO;
import com.brendondias.game.client.dtos.ClassificationDTO;
import com.brendondias.game.client.entities.clans.Clan;
import com.brendondias.game.client.entities.classifications.NinjaClassification;
import com.brendondias.game.client.repositories.ClassificationsRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Data
public class ClassificationService {

    @Inject
    ClassificationsRepository classificationsRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ClassificationService.class);


    @Transactional
    public void createNinjaClassification(NinjaClassification ninjaClassification){
        if(classificationsRepository.findByClassificationName(ninjaClassification.getClassificationName()).isPresent()){
            LOGGER.info("Classificação já criada.");
        }else{
            classificationsRepository.persist(ninjaClassification);
        }
    }

    @Transactional
    public NinjaClassification findNinjaClassificationById(Long id){
        return classificationsRepository.findById(id);
    }
}
