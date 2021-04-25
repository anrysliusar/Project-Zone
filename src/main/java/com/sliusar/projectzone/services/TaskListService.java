package com.sliusar.projectzone.services;

import com.sliusar.projectzone.models.TaskList;

import java.util.List;
import java.util.Optional;

public interface TaskListService {
    List<TaskList> getAll();
    Optional<TaskList> getById(int id);
    void save(TaskList taskList);
    void update(TaskList taskList, int id);
    void deleteById(int id);
}
