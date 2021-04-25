package com.sliusar.projectzone.services;

import com.sliusar.projectzone.models.Task;

import java.util.List;
import java.util.Optional;

public interface TaskService {
    List<Task> getAll();
    Optional<Task> getById(int id);
    void save(Task task);
    void update(Task task, int taskId);
    void deleteById(int id);
    void updateTodo(Task task, int taskListId);

    void addTodo(Task task, int taskListId);
    void removeTodo(int taskId, int taskListId);
}
