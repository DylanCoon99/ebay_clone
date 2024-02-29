package org.example.service;

import org.example.model.Transaction;
import org.example.repository.JdbcTransactionRepo;
import org.example.repository.TransactionRepo;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.junit.jupiter.api.Assertions.assertNotNull;
public class TransactionServiceTest {

    TransactionRepo transactionRepo = new JdbcTransactionRepo();
    TransactionService transactionService = new TransactionService(transactionRepo);

    @Test
    public void InsertTransactionTest() {

        Transaction transactionToInsert = new Transaction();
        transactionToInsert.setTransactionID(1);
        transactionToInsert.setBuyerID(1);
        transactionToInsert.setSellerID(1);
        transactionToInsert.setProductID(1);
        transactionToInsert.setBid(10.0f);

        transactionService.createTransaction(transactionToInsert);


    }

}
