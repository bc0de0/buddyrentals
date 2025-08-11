package com.kunalgupte.buddyrental.service;

import com.kunalgupte.buddyrental.entities.User;

import java.util.List;
import java.util.Optional;

public interface UserService {
    User addUser(User user);

    List<User> getAllUsers();

    Optional<User> getUserById(Long id);

    Optional<User> updateUser(Long id, User user);

    boolean deleteUser(Long id);
}
