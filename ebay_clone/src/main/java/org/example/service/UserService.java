package org.example.service;

import org.example.User;
import org.example.UserRepo;
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

    public void createUser(User user) {
        userRepo.save(user);
    }

    public void updateUser(User user) {
        // Implement update logic
        userRepo.update(user);
    }

    public void deleteUser(User user) {
        userRepo.delete(user);
    }

}