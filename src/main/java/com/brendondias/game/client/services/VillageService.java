package com.brendondias.game.client.services;

import com.brendondias.game.client.dtos.VillageDTO;
import com.brendondias.game.client.entities.villages.Village;
import com.brendondias.game.client.repositories.VillagesRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Data
public class VillageService {

    @Inject
    VillagesRepository villagesRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(VillageService.class);

    @Transactional
    public void createVillage(Village village){
        if(villagesRepository.findByVillageName(village.getVillageName()).isPresent()){
            LOGGER.info("Vila já existe");
        }else {
            villagesRepository.persist(village);
        }
    }

    @Transactional
    public Village findVillageById(Long id){
        return villagesRepository.findById(id);
    }
}
