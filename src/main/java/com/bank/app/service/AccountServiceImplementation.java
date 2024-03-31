package com.bank.app.service;

 
import java.util.List;
import java.util.Optional;

 

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bank.app.entity.Account;
import com.bank.app.repo.AccountRepository;



@Service
public class AccountServiceImplementation  implements AccountService {
 

    @Autowired
    AccountRepository repo;

    @Override
    public Account createAccount(Account account){
        Account  account_save =   repo.save(account);
        return account_save ;
        
    }
   

    @Override
    public Account getAccountDetailsByAccountNumber(Long accountNumber){
       Optional<Account> account  = repo.findById(accountNumber);
     
       // check whether account exist
       if(account.isEmpty()){
        throw new  RuntimeException("Account is not present");
       }
       Account account_got = account.get();
      return account_got;

         
    }


    @Override
    public List<Account> getAllAccountDetails(){

      List<Account> account =    repo.findAll();

        return account;
    }



   @Override
    public Account depositMoney(Long accountNumber  , Double money){
        // finding the account number
     Optional<Account> account = repo.findById(accountNumber);
  
      if(account.isEmpty()){
        throw new RuntimeException("Account is not present");
      }
      Account accountPresent = account.get();
      Double NetBalance = accountPresent.getAccount_balance()+ money;
      accountPresent.setAccount_balance(NetBalance);
      repo.save(accountPresent);
      return accountPresent;


    }

    @Override
    public Account withdrawMoney(Long accountNumber, Double money){
       // finding the account number
     Optional<Account> account = repo.findById(accountNumber);
  
     if(account.isEmpty()){
       throw new RuntimeException("Account is not present");
     }
     Account accountPresent = account.get();
    Double netBalance =  accountPresent.getAccount_balance()-money;
       accountPresent.setAccount_balance(netBalance);
       repo.save(accountPresent);
        return accountPresent;
    }
    

    @Override
    public void closAccount(Long accountNumber){
         getAccountDetailsByAccountNumber(accountNumber);
         repo.deleteById(accountNumber);
    }
 
}
