package com.project.MultiCurrencyTransfer.service;

import com.project.MultiCurrencyTransfer.entity.Transfer;

public interface ITransferService {
  Transfer newTransfer(Transfer t);

  Transfer getTransferById(int id);
}
