package org.example.repository;
import org.example.model.User;

import java.util.List;

public interface UserRepo {
    User findById(int userId);
    List<User> findAll();
    User save(User user);
    void update(User user);
    void delete(int userId);
}
