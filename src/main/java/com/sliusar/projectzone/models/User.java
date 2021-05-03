package com.sliusar.projectzone.models;

import com.sliusar.projectzone.models.utils.Role;
import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;

@Entity
@Getter
@Setter
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;


    private String username;
    private String password;

    private String firstname;
    private String lastname;
    private String email;
    private String phone;
    private boolean status;//active inActive

    @ElementCollection(fetch = FetchType.EAGER)
    @Enumerated
    private List<Role> roles;

    @OneToMany(mappedBy = "user")
    private Set<UserSkill> userSkills;

    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    @JoinColumn(name = "user_id")
    private List<Task> tasks = new ArrayList<>();

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Project project;



}
