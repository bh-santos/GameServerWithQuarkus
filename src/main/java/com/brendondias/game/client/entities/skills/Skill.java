package com.brendondias.game.client.entities.skills;

import com.brendondias.game.client.dtos.SkillDTO;
import com.brendondias.game.client.entities.elements.Element;
import com.brendondias.game.client.entities.ninjas.Ninja;
import com.brendondias.game.client.entities.skillranks.SkillRank;
import com.brendondias.game.client.entities.skillTypes.SkillType;
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
public class Skill {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSkill;

    @ManyToOne
    @JoinColumn(name = "type_id")
    private SkillType type;

    @ManyToOne
    @JoinColumn(name = "rank_id")
    private SkillRank rank;

    @ManyToMany
    @JoinTable(
            name = "skill_element",
            joinColumns = @JoinColumn(name = "skill_id"),
            inverseJoinColumns = @JoinColumn(name = "element_id")
    )
    private List<Element> elementList;


    @ManyToMany(mappedBy = "skillList")
    private List<Ninja> ninjaList;

    @Column
    private String skillImage;
    @Column
    private String skillName;


    @Column(columnDefinition = "TEXT")
    private String skillDescription;

    public Skill(SkillDTO data) {
        this.elementList = new LinkedList<>();
        this.ninjaList = new LinkedList<>();
        this.skillImage = data.skillImage();
        this.skillName = data.skillName();
        this.skillDescription = data.skillDescription();
    }
}
