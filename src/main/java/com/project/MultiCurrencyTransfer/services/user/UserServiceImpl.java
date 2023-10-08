package com.project.MultiCurrencyTransfer.services.user;

import com.project.MultiCurrencyTransfer.entities.User;
import com.project.MultiCurrencyTransfer.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    @Override
    public User registerUser(User user) {
        User u = userRepository.save(user);
        return u;
    }
}
