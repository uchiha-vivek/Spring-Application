package com.bank.app.service;

 
import java.util.List;

import com.bank.app.entity.Account;
 

public interface AccountService {


 

    // here we are just defining methods.
  
 // creating account

 public Account createAccount(Account account);

// get account details via accountNumber

public Account getAccountDetailsByAccountNumber(Long accountNumber);


  // getting list of accounts

  public List<Account>  getAllAccountDetails();

// deposit money

public Account depositMoney(Long accountNumber  , Double money);

// withdraw money
public Account withdrawMoney(Long accountNumber, Double money);

// closing the account

public void closAccount(Long accountNumber);




}
