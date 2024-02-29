package org.example.repository;

import org.example.DatabaseManager;
import org.example.model.User;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcUserRepo implements UserRepo {

    private final Connection connection;

    public JdbcUserRepo() {
        this.connection = null;
    }

    // Constructor to inject the database connection

    @Override
    public User findById(int userId) {
        String sql = "SELECT * FROM users WHERE id = ?";
        try (Connection connection = DatabaseManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToUser(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // add more robust logging later
        }
        return null;
    }

    @Override
    public List<User> findAll() {
        List<User> users = new ArrayList<>();
        String sql = "SELECT * FROM users";
        try (Connection connection = DatabaseManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                users.add(mapResultSetToUser(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // add more robust logging later
        }
        return users;
    }

    @Override
    public User save(User user) {
        String sql = "INSERT INTO users (user_id, username, email, password) VALUES (?, ?, ?, ?)";
        try (Connection connection = DatabaseManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, user.getUserID());
            statement.setString(2, user.getUsername());
            statement.setString(3, user.getEmail());
            statement.setString(4, user.getPassword());
            statement.executeUpdate();
            return user;
        } catch (SQLException e) {
            e.printStackTrace();
            // add more robust logging later
            return null;
        }
    }

    @Override
    public void update(User user) {
        String sql = "UPDATE users SET username = ?, email = ?, password = ? WHERE id = ?";
        try (Connection connection = DatabaseManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, user.getUsername());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getPassword());
            statement.setInt(4, user.getUserID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // add more robust logging later

        }
    }

    @Override
    public void delete(int userId) {
        String sql = "DELETE FROM users WHERE id = ?";
        try (Connection connection = DatabaseManager.getConnection();
                PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, userId);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // add more robust logging later
        }
    }

    // Helper method to map ResultSet to User object
    private User mapResultSetToUser(ResultSet resultSet) throws SQLException {
        int id = resultSet.getInt("id");
        String username = resultSet.getString("username");
        String email = resultSet.getString("email");
        String password = resultSet.getString("password");
        User userReturn = new User();
        userReturn.setUserID(id);
        userReturn.setUsername(username);
        userReturn.setEmail(email);
        userReturn.setPassword(password);
        return userReturn;
    }

}
