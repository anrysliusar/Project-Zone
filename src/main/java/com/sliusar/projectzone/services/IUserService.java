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
    User findByUsername(String username);
    User findByUsernameAndPassword(String username, String password);
    void saveUser(User user);
    void update(User user, int id);
    void addSkill(Skill skill, int userId, byte level);
    void addToProject(int projectId, int userId);
    void assignTask(int taskId, int userId);

}
