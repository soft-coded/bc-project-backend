package com.project.MultiCurrencyTransfer.services.transfer;

import com.project.MultiCurrencyTransfer.entities.Transfer;

public interface ITransferService {
  Transfer newTransfer(Transfer t);

  Transfer getTransferById(String id);
}
