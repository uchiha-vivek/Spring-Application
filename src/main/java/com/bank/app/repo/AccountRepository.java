package com.bank.app.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.bank.app.entity.Account;

public interface AccountRepository  extends JpaRepository<Account,Long> {

   


}
