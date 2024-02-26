package org.example.repository;
import org.example.model.Transaction;

import java.util.List;

public interface TransactionRepo {
    Transaction findById(int transactionId);

    List<Transaction> findAll();

    void save(Transaction transaction);

    void update(Transaction transaction);

    void delete(int transactionId);
}
