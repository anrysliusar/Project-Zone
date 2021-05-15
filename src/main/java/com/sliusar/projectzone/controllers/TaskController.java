package com.sliusar.projectzone.controllers;

import com.sliusar.projectzone.models.Task;
import com.sliusar.projectzone.services.ITaskService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/tasks")
public class TaskController {
    @Qualifier("tsi")
    private final ITaskService taskService;

    @GetMapping()
    public List<Task> getAll(){
        return taskService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Task> getById(@PathVariable int id){
        return taskService.getById(id);
    }

    @PutMapping("/{taskListId}/update/{taskId}")
    public void updateTask(@RequestBody Task task, @PathVariable("taskListId") int taskListId){
        taskService.update(task, taskListId);
    }

    @PostMapping("/{id}/addTask/{userId}")
    public void addTodo(@PathVariable("id") int id, @RequestBody Task task, @PathVariable("userId") int userId) {
        taskService.addTask(task, id, userId);
    }

    @DeleteMapping("/{taskListId}/delete/{taskId}")
    public void deleteTodo(@PathVariable("taskListId") int taskListId, @PathVariable("taskId") int taskId) {
        taskService.removeTask(taskId, taskListId);
    }
}
