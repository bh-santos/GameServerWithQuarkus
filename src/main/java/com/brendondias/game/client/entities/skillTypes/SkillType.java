package com.brendondias.game.client.entities.skillTypes;

import com.brendondias.game.client.dtos.SkillTypeDTO;
import com.brendondias.game.client.entities.skills.Skill;
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
public class SkillType {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idSkillType;

    @OneToMany(mappedBy = "type")
    private List<Skill> skillList;

    @Column
    private String skillTypeName;
    @Lob
    @Column(columnDefinition = "TEXT")
    private String skillTypeDescription;

    public SkillType(SkillTypeDTO data) {
        this.skillList = new LinkedList<>();
        this.skillTypeName = data.skillTypeName();
        this.skillTypeDescription = data.skillTypeDescription();
    }
}
