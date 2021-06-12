package com.sliusar.projectzone.models;

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
public class UserSkill {
    @Id
    private int id;

    @ManyToOne
    private User user;

    @ManyToOne
    private Skill skill;

    private byte skillLevel;

}
