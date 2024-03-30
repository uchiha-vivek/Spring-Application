package com.bank.app.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.bank.app.entity.Account;
import com.bank.app.service.AccountService;

@RestController
@RequestMapping("/account")
public class AccountController {

    
    @Autowired
    AccountService service;



    // creating the account
    @PostMapping("create")
    public ResponseEntity<Account> createAccount(@RequestBody Account account ){

         Account createAccount =    service.createAccount(account);
       return ResponseEntity.status(HttpStatus.CREATED).body(createAccount);
        
    }

    // get all the accounts

    @GetMapping("/{accountNumber}")
public Account getAccountByAccountId( @PathVariable  Long accountNumber){
    

     Account account =    service.getAccountDetailsByAccountNumber(accountNumber);

    return account;
}

@GetMapping("/getAllAccounts")
public List<Account> getAllAccountDetails(){
     List<Account> allAccountDetails = service.getAllAccountDetails();
     return allAccountDetails;
}



}
