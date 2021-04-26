package com.sliusar.projectzone.services.implementation;

import com.sliusar.projectzone.models.Project;
import com.sliusar.projectzone.models.Task;
import com.sliusar.projectzone.models.TaskList;
import com.sliusar.projectzone.repositories.ProjectRepository;
import com.sliusar.projectzone.repositories.TaskListRepository;
import com.sliusar.projectzone.services.ITaskListService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@Qualifier("tlsi")
@AllArgsConstructor
public class TaskListServiceImpl implements ITaskListService {
    private final TaskListRepository taskListRepository;
    private final ProjectRepository projectRepository;

    @Override
    public List<TaskList> getAll() {
        return taskListRepository.findAll();
    }

    @Override
    public Optional<TaskList> getById(int id) {
        return taskListRepository.findById(id);
    }

    @Override
    public void save(TaskList taskList) {
        if (taskList != null){
            taskListRepository.save(taskList);
        }
    }

    @Override
    public void update(TaskList taskList, int projectId) {
        Project projectForUpdatingTaskList = projectRepository.getOne(projectId);
        List<TaskList> taskLists = projectForUpdatingTaskList.getTaskLists();
        int chosenTaskListIndex = 0;
        for (TaskList taskListOne : taskLists) {
            if (taskListOne.getId() == taskList.getId()){
                chosenTaskListIndex = taskLists.indexOf(taskListOne);
            }
        }
        taskList.setProject(projectForUpdatingTaskList);
        projectForUpdatingTaskList.getTaskLists().set(chosenTaskListIndex, taskList);
        projectRepository.save(projectForUpdatingTaskList);

    }

    @Override
    public void deleteById(int id) {
        taskListRepository.deleteById(id);
    }

    @Override
    public void addTaskList(TaskList taskList, int projectId) {
        Project projectToAddingTaskList = projectRepository.getOne(projectId);
        if (projectToAddingTaskList.getTaskLists() != null){
            projectToAddingTaskList.getTaskLists().add(taskList);
        }else {
            List<TaskList> taskLists = new ArrayList<>();
            taskLists.add(taskList);
            projectToAddingTaskList.setTaskLists(taskLists);
        }

    }
    @Override
    public void removeTaskList(int taskListId, int projectId) {
        Project projectToDeleteTaskList = projectRepository.getOne(projectId);
        projectToDeleteTaskList.getTaskLists().removeIf(taskList -> taskList.getId() == taskListId);
        taskListRepository.deleteById(taskListId);
        projectRepository.save(projectToDeleteTaskList);
    }
}
