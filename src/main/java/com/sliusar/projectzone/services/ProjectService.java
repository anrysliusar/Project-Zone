package com.sliusar.projectzone.services;

import com.sliusar.projectzone.models.Project;
import com.sliusar.projectzone.models.TaskList;

import java.util.List;
import java.util.Optional;

public interface ProjectService {
    List<Project> getAll();
    Optional<Project> getById(int id);
    void save(Project taskList);
    void update(Project taskList, int id);
    void deleteById(int id);
}
