package com.project.MultiCurrencyTransfer.service.user;

import com.project.MultiCurrencyTransfer.entity.User;
import com.project.MultiCurrencyTransfer.repository.UserRepository;

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
