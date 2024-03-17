package com.brendondias.game.client.entities.villages;

import com.brendondias.game.client.dtos.VillageDTO;
import com.brendondias.game.client.entities.ninjas.Ninja;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Village {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idVillage;

    @OneToMany(mappedBy = "ninjaVillage")
    private List<Ninja> ninjaList;

    @Column
    private String villageImage;

    @Column
    private String villageName;

    @Column(columnDefinition = "TEXT")
    private String villageDescription;

    @Column
    private float attributeBonuses;

    public Village(VillageDTO data) {
        ninjaList = new LinkedList<>();
        this.villageImage = data.villageImage();
        this.villageName = data.villageName();
        this.villageDescription = data.villageDescription();
        this.attributeBonuses = data.attributeBonuses();
    }
}
