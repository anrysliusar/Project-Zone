package com.sliusar.projectzone.services;

import com.sliusar.projectzone.models.Task;
import com.sliusar.projectzone.models.TaskList;

import java.util.List;
import java.util.Optional;

public interface ITaskListService {
    List<TaskList> getAll();
    Optional<TaskList> getById(int id);
    void save(TaskList taskList);
    void update(TaskList taskList, int id);
    void deleteById(int id);

    void addTaskList(TaskList taskList, int projectId);
    void removeTaskList(int taskListId, int projectId);
}
