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
        return null;
    }

    @Override
    public Account withdrawMoney(Long accountNumber, Double money){
        return null;
    }
    

    @Override
    public void closAccount(Long accountNumber){

    }
 
}
