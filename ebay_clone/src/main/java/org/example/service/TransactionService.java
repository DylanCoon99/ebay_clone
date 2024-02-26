package org.example.service;

import org.example.model.Transaction;
import org.example.repository.TransactionRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TransactionService {

    private final TransactionRepo transactionRepo;

    @Autowired
    public TransactionService(TransactionRepo transactionRepo) {
        this.transactionRepo = transactionRepo;
    }

    public List<Transaction> getAllTransactions() {
        return transactionRepo.findAll();
    }

    public Optional<Transaction> getTransactionById(int transactionId) {
        Transaction transaction = transactionRepo.findById(transactionId);
        return Optional.ofNullable(transaction);
    }

    public Transaction createTransaction(Transaction transaction) {
        transactionRepo.save(transaction);
        return transaction;
    }

    public Transaction updateTransaction(Transaction transaction) {
        // Implement update logic
        transactionRepo.update(transaction);
        return transactionRepo.findById(transaction.getTransactionID());
    }

    public void deleteTransaction(int transactionId) {
        transactionRepo.delete(transactionId);
    }


}
