package com.sliusar.projectzone.services;

import com.sliusar.projectzone.models.Project;
import com.sliusar.projectzone.models.User;

import java.util.List;
import java.util.Optional;

public interface IUserService {
    List<User> getAll();
    Optional<User> getById(int id);
    void save(User user);
    void update(User user, int id);
    void addRole(User user, int roleId);
}
