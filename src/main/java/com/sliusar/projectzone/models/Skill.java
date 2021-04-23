package com.sliusar.projectzone.models;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @OneToMany(mappedBy = "skill")
    private Set<UserSkill> userSkills;

}
