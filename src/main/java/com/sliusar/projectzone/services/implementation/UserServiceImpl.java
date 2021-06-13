package com.sliusar.projectzone.services.implementation;

import com.sliusar.projectzone.exeptions.ErrorType;
import com.sliusar.projectzone.exeptions.ProjectZoneException;
import com.sliusar.projectzone.models.*;
import com.sliusar.projectzone.repositories.ProjectRepository;
import com.sliusar.projectzone.repositories.TaskRepository;
import com.sliusar.projectzone.repositories.UserRepository;
import com.sliusar.projectzone.repositories.UserSkillRepository;
import com.sliusar.projectzone.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Qualifier("usi")
@AllArgsConstructor
public class UserServiceImpl implements IUserService {

    private final UserRepository userRepository;
    private final UserSkillRepository userSkillRepository;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final PasswordEncoder passwordEncoder;


    public List<User> getAll() {
        return userRepository.findAll();
    }

    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    public void saveUser(User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        userRepository.save(user);
    }


    public User findByUsername(String username) {
        return userRepository.findByUsername(username);
    }

    public User findByUsernameAndPassword(String username, String password) {
        User user = findByUsername(username);
        if(user != null){
            if(passwordEncoder.matches(password, user.getPassword())){
                return user;
            }
        }
        return null;
    }

    public void update(User user, int id) {
        user.setId(id);
        userRepository.save(user);
    }
// Todo
    public void addSkill(Skill skill, int userId, byte level) {
        User userForAddingSkill = userRepository.findById(userId).orElseThrow(() -> new ProjectZoneException(ErrorType.USR_NOT_FOUND.getMessage()));
        UserSkill userSkill = new UserSkill();
        userSkill.setUser(userForAddingSkill);
        userSkill.setSkill(skill);
        userSkill.setSkillLevel(level);
        userSkillRepository.save(userSkill);
    }

    public void addToProject(int projectId, int userId) {
        Project project = projectRepository.findById(projectId).orElseThrow(() -> new ProjectZoneException(ErrorType.PROJECT_NOT_FOUND.getMessage()));
        User user = userRepository.findById(userId).orElseThrow(() -> new ProjectZoneException(ErrorType.USR_NOT_FOUND.getMessage()));
        project.getMemberList().add(user);
        projectRepository.save(project);
    }

    public void assignTask(int taskId, int userId) {
        Task task = taskRepository.findById(taskId).orElseThrow(() -> new ProjectZoneException(ErrorType.TASK_NOT_FOUND.getMessage()));
        User user = userRepository.findById(userId).orElseThrow(() -> new ProjectZoneException(ErrorType.USR_NOT_FOUND.getMessage()));
        task.setUser(user);
        taskRepository.save(task);

    }
}
