package com.sliusar.projectzone.services.implementation;

import com.sliusar.projectzone.models.Project;
import com.sliusar.projectzone.repositories.ProjectRepository;
import com.sliusar.projectzone.services.IProjectService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@Qualifier("psi")
@AllArgsConstructor
public class ProjectServiceImpl implements IProjectService {
    private final ProjectRepository projectRepository;


    @Override
    public List<Project> getAll() {
        return projectRepository.findAll();
    }

    @Override
    public Optional<Project> getById(int id) {
        return projectRepository.findById(id);
    }

    @Override
    public void save(Project project) {
        if(project != null){
            projectRepository.save(project);
        }
    }

    @Override
    public void update(Project project, int projectId) {
        if (projectRepository.existsById(projectId)){
            Project chosenProject = projectRepository.getOne(projectId);
            project.setId(projectId);
            project.setTaskLists(chosenProject.getTaskLists());
            project.setAccessList(chosenProject.getAccessList());
            projectRepository.save(project);
        }
    }

    @Override
    public void deleteById(int id) {
        projectRepository.deleteById(id);
    }
}
