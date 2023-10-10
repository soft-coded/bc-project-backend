package com.project.MultiCurrencyTransfer.services.user;

import com.project.MultiCurrencyTransfer.entities.User;
import com.project.MultiCurrencyTransfer.repositories.UserRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

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

    @Override
    public User updateUser(User user) {
        User u = userRepository.save(user);
        return u;
    }

    @Override
    public User getUserByEmail(String email) {
        User u = userRepository.findByEmail(email);
        return u;
    }

    @Override
    public Optional<User> getUserById(String id) {
        Optional<User> u = userRepository.findById(id);
        return u;
    }
}
