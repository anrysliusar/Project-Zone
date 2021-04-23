package com.sliusar.projectzone.models;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.util.Date;

@Entity
@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class Task {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String title;
    private String description;
    private Date createdAt;
    private Date deadline;
    private String stage;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private CheckList checkList;


    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private User user;
}
