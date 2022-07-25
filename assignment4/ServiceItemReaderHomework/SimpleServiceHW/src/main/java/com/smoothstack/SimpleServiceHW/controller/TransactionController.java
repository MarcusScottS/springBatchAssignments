package com.smoothstack.SimpleServiceHW.controller;

import com.smoothstack.SimpleServiceHW.model.Transaction;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class TransactionController {

    @GetMapping("/transactions")
    public List<Transaction> getTransactions(){
        ArrayList<Transaction> transactions = new ArrayList<>();

        return transactions;
    }

}
