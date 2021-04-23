package com.sliusar.projectzone.models.utils;

import lombok.*;

import javax.persistence.Column;
import javax.persistence.Embeddable;
import java.io.Serializable;

@Embeddable
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DevSkillKey implements Serializable {

    @Column(name = "developer_id")
    Long developerId;

    @Column(name = "skill_id")
    Long skillId;
}
