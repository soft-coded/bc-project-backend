package com.project.MultiCurrencyTransfer.services.account;

import java.util.List;

import com.project.MultiCurrencyTransfer.entities.Account;

public interface IAccountService {
  Account getAccountById(String id);

  Account newAccount(Account acc);

  void deleteAccount(Account acc);

  Account updateAccount(Account acc);

  List<Account> getAccountsByUserId(String userId);
}