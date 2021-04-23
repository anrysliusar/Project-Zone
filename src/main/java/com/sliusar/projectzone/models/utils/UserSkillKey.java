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
public class UserSkillKey implements Serializable {

    @Column(name = "user_id")
    Long userId;

    @Column(name = "skill_id")
    Long skillId;
}
