package com.sliusar.projectzone.services;

import com.sliusar.projectzone.models.Task;

import java.util.List;
import java.util.Optional;

public interface ITaskService {
    List<Task> getAll();
    Optional<Task> getById(int id);
    void save(Task task);
    void update(Task task, int taskListId);
    void deleteById(int id);

    void addTask(Task task, int taskListId);
    void removeTask(int taskId, int taskListId);
}
