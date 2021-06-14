package com.sliusar.projectzone.controllers;

import com.sliusar.projectzone.models.Project;
import com.sliusar.projectzone.services.IProjectService;
import com.sliusar.projectzone.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
@RequestMapping("/projects")
public class ProjectController {
    @Qualifier("psi")
    private final IProjectService projectService;

    @Qualifier("usi")
    private final IUserService userService;

    @GetMapping()
    public List<Project> getAll(){
        return projectService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Project> getById(@PathVariable int id){
        return projectService.getById(id);
    }

    @PostMapping("/save")
    public void save(@RequestBody Project project){
        projectService.save(project);
    }

    @PutMapping("/{id}/update")
    public void update(@RequestBody Project project, @PathVariable int id){
        projectService.update(project, id);
    }

    @DeleteMapping("/{id}/delete")
    public void delete(@PathVariable int id) {
        projectService.deleteById(id);
    }

    @PostMapping("/addUser/{userId}/{projectId}")
    public void addUserToProject(@PathVariable("userId") int userId, @PathVariable("projectId") int projectId){
        userService.addToProject(projectId, userId);
    }



}
