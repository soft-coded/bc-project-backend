package com.project.MultiCurrencyTransfer.service.user;

import com.project.MultiCurrencyTransfer.entity.User;

import java.util.List;

public interface UserService {
    List<User> getAllUsers();

    User registerUser(User user);
}