package com.project.MultiCurrencyTransfer.services.account;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.MultiCurrencyTransfer.entities.Account;
import com.project.MultiCurrencyTransfer.repositories.AccountRepository;

@Service
public class AccountServiceImpl implements IAccountService {
  @Autowired
  private AccountRepository accRepo;

  @Override
  public void deleteAccount(Account acc) {
    accRepo.delete(acc);
  }

  @Override
  public Account getAccountById(String id) {
    return accRepo.findById(id).get();
  }

  @Override
  public Account newAccount(Account acc) {
    return accRepo.save(acc);
  }

  @Override
  public Account updateAccount(Account acc) {
    return accRepo.save(acc);
  }
}
