package com.project.MultiCurrencyTransfer.services.transfer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.project.MultiCurrencyTransfer.entities.Account;
import com.project.MultiCurrencyTransfer.entities.Transfer;
import com.project.MultiCurrencyTransfer.repositories.AccountRepository;
import com.project.MultiCurrencyTransfer.repositories.TransferRepository;

@Service
public class TransferServiceImpl implements ITransferService {
  @Autowired
  TransferRepository tr;
  @Autowired
  AccountRepository accRepo;

  @Override
  public Transfer getTransferById(String id) {
    return tr.findById(id).get();
  }

  @Override
  public Transfer newTransfer(Transfer t) {
    Account acc = accRepo.findByAccountNumber(t.getSenderAccountNumber());
    acc.setBalance(acc.getBalance() - t.getSenderAmount());
    accRepo.save(acc);
    return tr.save(t);
  }

  @Override
  public List<Transfer> getTransfersByUserId(String userId) {
    return tr.findByUserId(userId);
  }
}
