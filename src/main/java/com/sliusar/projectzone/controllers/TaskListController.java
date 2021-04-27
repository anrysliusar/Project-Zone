package com.sliusar.projectzone.controllers;

import com.sliusar.projectzone.models.TaskList;
import com.sliusar.projectzone.services.ITaskListService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class TaskListController {
    @Qualifier("tlsi")
    private final ITaskListService taskListService;

    @GetMapping()
    public List<TaskList> getAll(){
        return taskListService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<TaskList> getById(@PathVariable int id){
        return taskListService.getById(id);
    }

    @PutMapping("/{projectId}/update/{taskListId}")
    public void updateTaskList(@RequestBody TaskList taskList, @PathVariable("projectId") int projectId){
        taskListService.update(taskList, projectId);
    }

    @PostMapping("/{projectId}/addTaskList")
    public void addTodo(@PathVariable int projectId, @RequestBody TaskList taskList) {
        taskListService.addTaskList(taskList, projectId);
    }

    @DeleteMapping("/{projectId}/delete/{taskListId}")
    public void deleteTodo(@PathVariable("projectId") int projectId, @PathVariable("taskListId") int taskListId) {
        taskListService.removeTaskList(taskListId, projectId);
    }
}
