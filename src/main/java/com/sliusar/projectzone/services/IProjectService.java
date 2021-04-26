package com.sliusar.projectzone.services;

import com.sliusar.projectzone.models.Project;
import com.sliusar.projectzone.models.TaskList;

import java.util.List;
import java.util.Optional;

public interface IProjectService {
    List<Project> getAll();
    Optional<Project> getById(int id);
    void save(Project project);
    void update(Project project, int id);
    void deleteById(int id);
}
