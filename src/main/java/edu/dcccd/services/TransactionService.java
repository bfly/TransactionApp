package edu.dcccd.services;

import edu.dcccd.entity.SelectedDay;
import edu.dcccd.entity.Transaction;

import java.util.List;

public interface TransactionService
{
    void createTransaction(Transaction transaction);
    List<Transaction> getAllTransaction();
    List<Transaction> getTransactionByDay(SelectedDay selected);
}
