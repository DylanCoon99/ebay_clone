package org.example.service;

import org.example.model.User;
import org.example.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepo userRepo;

    @Autowired
    public UserService(UserRepo userRepo) {
        this.userRepo = userRepo;
    }

    public List<User> getAllUsers() {
        return userRepo.findAll();
    }

    public Optional<User> getUserById(int userId) {
        User user = userRepo.findById(userId);
        return Optional.ofNullable(user);
    }

    public User createUser(User user) {
        userRepo.save(user);
        return user;
    }

    public User updateUser(User user) {
        // Implement update logic
        userRepo.update(user);
        return userRepo.findById(user.getUserID());
    }

    public void deleteUser(int userId) {
        userRepo.delete(userId);
    }

}