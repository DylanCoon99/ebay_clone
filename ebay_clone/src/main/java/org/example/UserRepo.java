package org.example;
import java.util.List;

public interface UserRepo {
    User findById(int userId);
    List<User> findAll();
    void save(User user);
    void update(User user);
    void delete(int userId);
}
