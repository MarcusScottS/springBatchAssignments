package com.smoothstack.SimpleClientHW.service;

import com.smoothstack.SimpleClientHW.model.Transaction;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import java.util.ArrayList;

@Service
public class TransactionService {
    public ArrayList<Transaction> getTransactions(){
        RestTemplate restTemplate = new RestTemplate();
        String url = "http://localhost:8090/transactions";
        Transaction[] transactions = restTemplate.getForObject(url, Transaction[].class);
        ArrayList<Transaction> transactionList = new ArrayList<Transaction>();
        for(Transaction t : transactions)
            transactionList.add(t);
        return transactionList;
    }

}
