package com.brendondias.game.client.entities.skillranks;

import com.brendondias.game.client.dtos.SkillRankDTO;
import com.brendondias.game.client.entities.skills.Skill;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.LinkedList;
import java.util.List;

@Entity
@Data
@NoArgsConstructor
public class SkillRank {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSkillRank;
    @OneToMany(mappedBy = "rank")
    private List<Skill> skillList;
    @Column
    private String skillRankName;

    @Column(columnDefinition = "TEXT")
    private String skillRankDescription;
    @Column
    private float damageBonuses;

    public SkillRank(SkillRankDTO data) {
        this.skillList = new LinkedList<>();
        this.skillRankName = data.skillRankName();
        this.skillRankDescription = data.skillRankDescription();
        this.damageBonuses = data.damageBonuses();
    }
}
