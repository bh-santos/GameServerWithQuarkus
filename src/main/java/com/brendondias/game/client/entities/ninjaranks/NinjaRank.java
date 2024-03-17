package com.brendondias.game.client.entities.ninjaranks;

import com.brendondias.game.client.dtos.NinjaRankDTO;
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
public class NinjaRank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNinjaRank;

    @OneToMany(mappedBy = "ninjaRank")
    private List<Ninja> ninjaList;

    @Column
    private String ninjaRankName;

    @Column(columnDefinition = "TEXT")
    private String ninjaRankDescription;
    @Column
    private float attributeBonuses;

    public NinjaRank(NinjaRankDTO data){
        ninjaList = new LinkedList<>();
        this.ninjaRankName = data.ninjaRankName();
        this.ninjaRankDescription = data.ninjaRankDescription();
        this.attributeBonuses = data.attributeBonuses();
    }


}
