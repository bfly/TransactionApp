package edu.dcccd.services;

import edu.dcccd.entity.SelectedDay;
import edu.dcccd.entity.Transaction;
import edu.dcccd.repository.SingletonTransaction;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class TransactionServiceImpl implements TransactionService
{

    @Override
    public void createTransaction(Transaction transaction)
    {
        SingletonTransaction.getInstance().transactions.add(transaction);
    }

    @Override
    public List<Transaction> getAllTransaction()
    {
        return SingletonTransaction.getInstance().transactions;
    }

    @Override
    public List<Transaction> getTransactionByDay(SelectedDay selected)
    {
        return SingletonTransaction.getInstance().transactions.stream()
                .filter(transaction ->
                        selected.getSelectedDays().stream()
                                .anyMatch(s->s.equals(transaction.getDay())))
                .collect(Collectors.toList());
    }
}
