package com.brendondias.game.client.entities.ninjas;

import com.brendondias.game.client.dtos.NinjaDTO;
import com.brendondias.game.client.entities.clans.Clan;
import com.brendondias.game.client.entities.classifications.NinjaClassification;
import com.brendondias.game.client.entities.elements.Element;
import com.brendondias.game.client.entities.ninjaranks.NinjaRank;
import com.brendondias.game.client.entities.skills.Skill;
import com.brendondias.game.client.entities.villages.Village;
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
public class Ninja {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idNinja;

    @ManyToOne
    @JoinColumn(name = "ninja_rank_id")
    private NinjaRank ninjaRank;

    @ManyToOne
    @JoinColumn(name = "ninja_classification_id")
    private NinjaClassification ninjaClassification;

    @ManyToOne
    @JoinColumn(name = "ninja_clan_id")
    private Clan ninjaClan;

    @ManyToOne
    @JoinColumn(name = "ninja_village_id")
    private Village ninjaVillage;

    @ManyToMany
    @JoinTable(
            name = "ninja_element",
            joinColumns = @JoinColumn(name = "ninja_id"),
            inverseJoinColumns = @JoinColumn(name = "element_id")
    )
    private List<Element> elementList;


    @ManyToMany
    @JoinTable(
            name = "ninja_skill",
            joinColumns = @JoinColumn(name = "ninja_id"),
            inverseJoinColumns = @JoinColumn(name = "skill_id")
    )
    private List<Skill> skillList;


    @Column
    private String ninjaImage;
    @Column
    private String ninjaName;
    @Column
    private float life;
    @Column
    private float chakra;
    @Column
    private float energy;
    @Column
    private int ninjutsu;
    @Column
    private int taijutsu;
    @Column
    private int genjutsu;
    @Column
    private int bukijutsu;
    @Column
    private int strength;
    @Column
    private int agility;
    @Column
    private int chakraControl;
    @Column
    private int velocity;
    @Column
    private int vitality;
    @Column
    private int resistance;

    public Ninja(NinjaDTO data) {
        this.elementList = new LinkedList<>();
        this.skillList = new LinkedList<>();

        this.ninjaImage = data.ninjaImage();
        this.ninjaName = data.ninjaName();
        this.life = data.life();
        this.chakra = data.chakra();
        this.energy = data.energy();
        this.ninjutsu = data.ninjutsu();
        this.taijutsu = data.taijutsu();
        this.genjutsu = data.genjutsu();
        this.bukijutsu = data.bukijutsu();
        this.strength = data.strength();
        this.agility = data.agility();
        this.chakraControl = data.chakraControl();
        this.velocity = data.velocity();
        this.vitality = data.vitality();
        this.resistance = data.resistance();
    }

}
