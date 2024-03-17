package com.brendondias.game.client.services;

import com.brendondias.game.client.dtos.NinjaRankDTO;
import com.brendondias.game.client.entities.ninjaranks.NinjaRank;
import com.brendondias.game.client.repositories.NinjaRanksRepository;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Data
public class NinjaRankService {

    @Inject
    NinjaRanksRepository ninjaRanksRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(NinjaRankService.class);
    @Transactional
    public void createNinjaRank(NinjaRank ninjaRank){
        if(ninjaRanksRepository.findByNinjaRankName(ninjaRank.getNinjaRankName()).isPresent()){
         LOGGER.info("Rank Ninja já existe");
        }else{
            ninjaRanksRepository.persist(ninjaRank);
        }
    }
    @Transactional
    public NinjaRank findNinjaRankById(Long id){
        return ninjaRanksRepository.findById(id);
    }

}
