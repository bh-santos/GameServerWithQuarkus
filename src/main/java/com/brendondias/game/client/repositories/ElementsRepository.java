package com.brendondias.game.client.repositories;

import com.brendondias.game.client.entities.elements.Element;
import io.quarkus.hibernate.orm.panache.PanacheRepository;
import jakarta.enterprise.context.ApplicationScoped;

import java.util.Optional;

@ApplicationScoped
public class ElementsRepository implements PanacheRepository<Element> {

    public Optional<Element> findByElementName(String elementName){
        return find("elementName =?1",elementName).firstResultOptional();
    }
}
