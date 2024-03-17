package com.brendondias.game.client.services;

import com.brendondias.game.client.entities.ninjas.Ninja;
import com.brendondias.game.client.repositories.NinjasRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Data
public class NinjaService {

    @Inject
    NinjasRepository ninjasRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(NinjaService.class);

    @Transactional
    public void createNinja(Ninja ninja){
        if(ninjasRepository.findByNinjaName(ninja.getNinjaName()).isPresent()){
            LOGGER.info("Ninja já existe");
        }else{
            ninjasRepository.persist(ninja);
        }
    }

    @Transactional
    public Ninja findNinjaById(Long id){
        return ninjasRepository.findById(id);
    }
}
