package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Blob;
import java.util.ArrayList;
import java.util.List;

public class JdbcProductRepo implements ProductRepo {

    private final Connection connection;


    public JdbcProductRepo(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Product findById(int productId) {
        String sql = "SELECT * FROM products WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, productId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToProduct(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // add more robust logging later
        }
        return null;
    }



    @Override
    public List<Product> findAll() {
        List<Product> products = new ArrayList<>();
        String sql = "SELECT * FROM products";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                products.add(mapResultSetToProduct(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // add more robust logging later
        }
        return products;
    }

    @Override
    public void save(Product product) {
        String sql = "INSERT INTO products (product_id, name, price, description, image) VALUES (?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, product.getProductID());
            statement.setString(2, product.getName());
            statement.setDouble(3, product.getPrice());
            statement.setString(4, product.getDescription());
            statement.setBlob(5, product.getImage());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // add more robust logging later
        }
    }

    @Override
    public void update(Product product) {
        String sql = "UPDATE products SET product_name = ?, price = ?, description = ?, image = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, product.getName());
            statement.setDouble(2, product.getPrice());
            statement.setString(3, product.getDescription());
            statement.setBlob(4, product.getImage());
            statement.setInt(5, product.getProductID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // add more robust logging later
        }
    }

    @Override
    public void delete(Product product) {
        String sql = "DELETE FROM products WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, product.getProductID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // add more robust logging later
        }
    }

    // Helper method to map ResultSet to User object
    private Product mapResultSetToProduct(ResultSet resultSet) throws SQLException {
        int product_id = resultSet.getInt("product_id");
        String product_name = resultSet.getString("product_name");
        float price = resultSet.getInt("price");
        String description = resultSet.getString("description");
        Blob image = resultSet.getBlob("image");

        return new Product(product_id, product_name, price, description, image);
    }





}
