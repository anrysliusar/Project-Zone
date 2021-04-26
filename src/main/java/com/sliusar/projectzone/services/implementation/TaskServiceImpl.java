package com.sliusar.projectzone.services.implementation;

import com.sliusar.projectzone.models.Task;
import com.sliusar.projectzone.models.TaskList;
import com.sliusar.projectzone.repositories.TaskListRepository;
import com.sliusar.projectzone.repositories.TaskRepository;
import com.sliusar.projectzone.services.ITaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("tsi")
@AllArgsConstructor
public class TaskServiceImpl implements ITaskService {
    private final TaskRepository taskRepository;
    private final TaskListRepository taskListRepository;

    @Override
    public List<Task> getAll() {
        return taskRepository.findAll();
    }

    @Override
    public Optional<Task> getById(int id) {
        return taskRepository.findById(id);
    }

    @Override
    public void save(Task task) {
        taskRepository.save(task);
    }

    @Override
    public void update(Task task, int taskListId) {
        TaskList taskListForUpdatingTask = taskListRepository.getOne(taskListId);
        List<Task> tasks = taskListForUpdatingTask.getTaskList();
        int chosenTaskIndex = 0;
        for (Task taskOne : tasks) {
            if (taskOne.getId() == task.getId()){
                chosenTaskIndex = tasks.indexOf(taskOne);
            }
        }
        task.setTaskList(taskListForUpdatingTask);
        taskListForUpdatingTask.getTaskList().set(chosenTaskIndex, task);
        taskListRepository.save(taskListForUpdatingTask);
    }

    @Override
    public void deleteById(int id) {
        taskRepository.deleteById(id);
    }

    @Override
    public void addTask(Task task, int taskListId) {
        TaskList taskListToAddingTask = taskListRepository.getOne(taskListId);
        if (taskListToAddingTask.getTaskList() != null){
            taskListToAddingTask.getTaskList().add(task);
        }else {
            List<Task> tasks = new ArrayList<>();
            tasks.add(task);
            taskListToAddingTask.setTaskList(tasks);
        }

    }

    @Override
    public void removeTask(int taskId, int taskListId) {
        TaskList taskListToDeleteTask = taskListRepository.getOne(taskListId);
        taskListToDeleteTask.getTaskList().removeIf(task -> task.getId() == taskId);
        taskRepository.deleteById(taskId);
        taskListRepository.save(taskListToDeleteTask);

    }
}
