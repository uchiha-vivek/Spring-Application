package com.bank.app.entity;

 

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="account")
public class Account {

  // setting account number as primary key
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long account_number;
  
  @Column
  private String account_holder_name;
  @Column
  private  Double account_balance;

  // setting up default constructor

  public Account(){
    
  }




   public Account(String account_holder_name, Double account_balance) {
    this.account_holder_name = account_holder_name;
    this.account_balance = account_balance;
}




public Long getAccount_number() {
        return account_number;
    }


    @Override
public String toString() {
    return "Account [account_number=" + account_number + ", account_holder_name=" + account_holder_name
            + ", account_balance=" + account_balance + "]";
}
    public void setAccount_number(Long account_number) {
        this.account_number = account_number;
    }
    public String getAccount_holder_name() {
        return account_holder_name;
    }
    public void setAccount_holder_name(String account_holder_name) {
        this.account_holder_name = account_holder_name;
    }
    public Double getAccount_balance() {
        return account_balance;
    }
    public void setAccount_balance(Double account_balance) {
        this.account_balance = account_balance;
    }
 

}
