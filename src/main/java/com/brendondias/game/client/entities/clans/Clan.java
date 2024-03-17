package com.brendondias.game.client.entities.clans;

import com.brendondias.game.client.dtos.ClanDTO;
import com.brendondias.game.client.entities.ninjas.Ninja;
import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class Clan {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idClan;

    @OneToMany(mappedBy = "ninjaClan")
    private List<Ninja> ninjaList;

    @Column
    private String clanImage;

    @Column
    private String clanName;


    @Column(columnDefinition = "TEXT")
    private String clanDescription;

    @Column
    private float clanBonuses;

    public Clan(ClanDTO data){
        this.ninjaList = new LinkedList<>();
        this.clanImage =data.clanImage();
        this.clanName = data.clanName();
        this.clanDescription = data.clanDescription();
        this.clanBonuses = data.clanBonuses();
    }

}
