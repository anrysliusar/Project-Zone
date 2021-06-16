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
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;


@Service
@Qualifier("usi")
@AllArgsConstructor
public class UserServiceImpl implements IUserService, UserDetailsService {

    private final UserRepository userRepository;
    private final UserSkillRepository userSkillRepository;
    private final ProjectRepository projectRepository;
    private final TaskRepository taskRepository;
    private final PasswordEncoder passwordEncoder;


    public User findByUsername(String username){
        return userRepository.findByUsername(username);
    }


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

    public void update(User user, int id) {
        user.setId(id);
        userRepository.save(user);
    }

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

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = findByUsername(username);
        if(user == null){
            throw new UsernameNotFoundException(String.format("User %s not found",username));
        }

        return new org.springframework.security.core.userdetails.User(user.getUsername(), user.getPassword(),
                RolesToAuthority(user.getRoles()));
    }

    private Collection<? extends GrantedAuthority>RolesToAuthority(Collection<Role> roles){
        return roles.stream().map(r -> new SimpleGrantedAuthority(r.getName())).collect(Collectors.toList());
    }
}
