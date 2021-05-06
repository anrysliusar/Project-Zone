package com.sliusar.projectzone.services;

import com.sliusar.projectzone.models.Project;
import com.sliusar.projectzone.models.Skill;
import com.sliusar.projectzone.models.Task;
import com.sliusar.projectzone.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();
    Optional<User> getById(int id);
    void save(User user);
    void update(User user, int id);
    void addSkill(Skill skill, int userId);
    void addToProject(int projectId, int userId);
    void assignTask(int taskId, int userId);

    void addRole(User user, int roleId);
}
