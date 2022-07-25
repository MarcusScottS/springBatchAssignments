package com.smoothstack.SimpleClientHW.reader;

import com.smoothstack.SimpleClientHW.model.Transaction;
import com.smoothstack.SimpleClientHW.service.TransactionService;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;

@Component
public class TransactionServiceAdapter implements InitializingBean {

    @Autowired
    private TransactionService transactionService;

    private ArrayList<Transaction> transactions;

    @Override
    public void afterPropertiesSet() throws Exception {
        this.transactions = transactionService.getTransactions();
    }

    public Transaction nextTransaction(){
        if(transactions.size() > 0){
            return transactions.remove(0);
        } else {
            return null;
        }
    }

    public TransactionService getTransactionService(){
        return transactionService;
    }

    public void setTransactionService(TransactionService transactionService){
        this.transactionService = transactionService;
    }

    public ArrayList<Transaction> getTransactions(){
        return transactions;
    }

    public void setTransactions(ArrayList<Transaction> transactions){
        this.transactions = transactions;
    }

}
