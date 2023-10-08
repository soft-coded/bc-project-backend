package com.project.MultiCurrencyTransfer.services.account;

import com.project.MultiCurrencyTransfer.entities.Account;

public interface IAccountService {
  Account getAccountById(String id);

  Account newAccount(Account acc);

  void deleteAccount(Account acc);

  Account updateAccount(Account acc);
}
