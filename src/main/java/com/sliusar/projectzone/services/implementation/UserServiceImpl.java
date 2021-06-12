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



    public List<User> getAll() {
        return null; //todo
    }

    public Optional<User> getById(int id) {
        return userRepository.findById(id);
    }

    public void save(User user) {
        userRepository.save(user);
    }

    public void update(User user, int id) {
        user.setId(id);
        userRepository.save(user);
    }

    public void addSkill(Skill skill, int userId) {
//        todo
    }

    public void addToProject(int projectId, int userId) {
//        todo
    }

    public void assignTask(int taskId, int userId) {
//        todo
    }

    public void addRole(User user, int roleId) {
//        todo
    }


}
