package com.revature.services;

import com.revature.models.User;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
public class UserServiceImpl implements UserService{
    @Override
    public Optional<User> authenticate(String username, String password) {
        return Optional.empty();
    }

    @Override
    public User registerUser(User user) {
        return null;
    }

    @Override
    public Optional<User> getUserById(int id) {
        return Optional.empty();
    }

    @Override
    public List<User> getAllUsers() {
        return null;
    }

    @Override
    public User updateUser(User user) {
        return null;
    }
}
