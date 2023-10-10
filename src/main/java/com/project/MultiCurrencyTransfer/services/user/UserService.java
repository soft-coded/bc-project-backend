package com.project.MultiCurrencyTransfer.services.user;

import java.util.List;
import java.util.Optional;

import com.project.MultiCurrencyTransfer.entities.User;

public interface UserService {
    List<User> getAllUsers();

    User registerUser(User user);

    User updateUser(User user);

    User getUserByEmail(String email);

    Optional<User> getUserById(String id);
}
