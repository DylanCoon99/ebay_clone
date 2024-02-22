package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class JdbcTransactionRepo implements TransactionRepo {

    private final Connection connection;

    // Constructor to inject the database connection
    public JdbcTransactionRepo(Connection connection) {
        this.connection = connection;
    }

    @Override
    public Transaction findById(int transactionId) {
        String sql = "SELECT * FROM transactions WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, transactionId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    return mapResultSetToTransaction(resultSet);
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // add more robust logging later
        }
        return null;
    }

    @Override
    public List<Transaction> findAll() {
        List<Transaction> transactions = new ArrayList<>();
        String sql = "SELECT * FROM transactions";
        try (PreparedStatement statement = connection.prepareStatement(sql);
             ResultSet resultSet = statement.executeQuery()) {
            while (resultSet.next()) {
                transactions.add(mapResultSetToTransaction(resultSet));
            }
        } catch (SQLException e) {
            e.printStackTrace();
            // add more robust logging later
        }
        return transactions;
    }

    @Override
    public void save(Transaction transaction) {
        String sql = "INSERT INTO transactions (transaction_id, buyer_id, seller_id, product_id, bid) VALUES (?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, transaction.getTransactionID());
            statement.setInt(2, transaction.getBuyerID());
            statement.setInt(3, transaction.getSellerID());
            statement.setInt(4, transaction.getProductID());
            statement.setFloat(5, transaction.getBid());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // add more robust logging later
        }
    }

    @Override
    public void update(Transaction transaction) {
        String sql = "UPDATE transactions SET buyer_id = ?, seller_id = ?, product_id = ?, bid = ? WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, transaction.getBuyerID());
            statement.setInt(2, transaction.getSellerID());
            statement.setInt(3, transaction.getProductID());
            statement.setFloat(4, transaction.getBid());
            statement.setInt(5, transaction.getTransactionID());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // add more robust logging later
        }
    }

    @Override
    public void delete(Transaction transaction) {
        String sql = "DELETE FROM transactions WHERE id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, transaction.getTransactionID());
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
            // add more robust logging later
        }
    }

    // Helper method to map ResultSet to User object
    private Transaction mapResultSetToTransaction(ResultSet resultSet) throws SQLException {
        int transaction_id = resultSet.getInt("transaction_id");
        int buyer_id = resultSet.getInt("buyer_id");
        int seller_id = resultSet.getInt("seller_id");
        int product_id = resultSet.getInt("product_id");
        float bid = resultSet.getFloat("bid");

        return new Transaction(transaction_id, buyer_id, seller_id, product_id, bid);
    }


}
