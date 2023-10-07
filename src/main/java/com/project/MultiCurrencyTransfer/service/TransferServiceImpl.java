package com.project.MultiCurrencyTransfer.service;

import org.springframework.beans.factory.annotation.Autowired;

import com.project.MultiCurrencyTransfer.entity.Transfer;
import com.project.MultiCurrencyTransfer.repository.TransferRepository;

public class TransferServiceImpl implements ITransferService {
  @Autowired
  TransferRepository tr;

  @Override
  public Transfer getTransferById(int id) {
    return tr.findById(id).get();
  }

  @Override
  public Transfer newTransfer(Transfer t) {
    return tr.save(t);
  }
}
