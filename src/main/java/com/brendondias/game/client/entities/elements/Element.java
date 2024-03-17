package com.brendondias.game.client.entities.elements;

import com.brendondias.game.client.dtos.ElementDTO;
import com.brendondias.game.client.entities.ninjas.Ninja;
import com.brendondias.game.client.entities.skills.Skill;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Element {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idElement;

    @ManyToMany(mappedBy = "elementList")
    private List<Skill> skillList;

    @ManyToMany(mappedBy = "elementList")
    private List<Ninja> ninjaList;

    @Column
    private String elementImage;

    @Column
    private String elementName;


    @Column(columnDefinition = "TEXT")
    private String elementDescription;

    public Element(ElementDTO data){
        this.ninjaList = new LinkedList<>();
        this.skillList = new LinkedList<>();
        this.elementImage = data.elementImage();
        this.elementName = data.elementName();
        this.elementDescription = data.elementDescription();
    }


}
