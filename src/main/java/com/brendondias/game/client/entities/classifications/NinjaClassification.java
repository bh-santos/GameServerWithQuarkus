package com.brendondias.game.client.entities.classifications;

import com.brendondias.game.client.dtos.ClassificationDTO;
import com.brendondias.game.client.entities.ninjas.Ninja;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class NinjaClassification {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClassification;

    @OneToMany(mappedBy = "ninjaClassification")
    private List<Ninja> ninjaList;

    @Column
    private String classificationName;

    @Column
    private String classificationDescription;

    @Column
    private float attributeBonuses;

    public NinjaClassification(ClassificationDTO data){
        this.ninjaList = new LinkedList<>();
        this.classificationName = data.classificationName();
        this.classificationDescription = data.classificationDescription();
        this.attributeBonuses = data.attributeBonuses();
    }
}
