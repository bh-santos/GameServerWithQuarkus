package com.brendondias.game.client.services;

import com.brendondias.game.client.dtos.ClanDTO;
import com.brendondias.game.client.entities.clans.Clan;
import com.brendondias.game.client.repositories.ClansRepository;
import io.quarkus.logging.Log;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import lombok.Data;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@ApplicationScoped
@Data
public class ClanService {


    @Inject
    ClansRepository clansRepository;

    private static final Logger LOGGER = LoggerFactory.getLogger(ClanService.class);



    @Transactional
    public void createClan(Clan clan){
        if(clansRepository.findByClanName(clan.getClanName()).isPresent()){
            LOGGER.info("Clã já criado");
        }else{
            clansRepository.persist(clan);
        }
    }
    @Transactional
    public Clan findClanById(Long id){
        return clansRepository.findById(id);
    }
}
