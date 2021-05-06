package com.sliusar.projectzone.services.implementation;

import com.sliusar.projectzone.models.Project;
import com.sliusar.projectzone.models.Skill;
import com.sliusar.projectzone.models.User;
import com.sliusar.projectzone.models.UserSkill;
import com.sliusar.projectzone.repositories.UserRepository;
import com.sliusar.projectzone.services.IUserService;
import lombok.AllArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@Qualifier("usi")
@AllArgsConstructor
public class UserServiceImpl implements IUserService {
    private UserRepository userRepository;
    private Project project;



    @Override
    public List<User> getAll() {
        return null; //todo
    }

    @Override
    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    @Override
    public void save(User user) {
        userRepository.save(user);
    }

    @Override
    public void update(User user, int id) {
        user.setId(id);
        userRepository.save(user);
    }

    @Override
    public void addSkill(Skill skill, int userId) {
//        todo
    }

    @Override
    public void addToProject(int projectId, int userId) {
//        todo
    }

    @Override
    public void assignTask(int taskId, int userId) {
//        todo
    }

    @Override
    public void addRole(User user, int roleId) {
//        todo
    }


}
