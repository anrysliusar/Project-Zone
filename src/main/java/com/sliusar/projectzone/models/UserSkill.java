package com.sliusar.projectzone.models;

import com.sliusar.projectzone.models.utils.DevSkillKey;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class DeveloperSkill {
    @EmbeddedId
    private DevSkillKey id;

    @ManyToOne
    @MapsId("developerId")
    @JoinColumn(name = "developer_id")
    private Developer developer;

    @ManyToOne
    @MapsId("skillId")
    @JoinColumn(name = "skill_id")
    private Skill skill;


    private int skillLevel;

}
