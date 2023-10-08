package com.project.MultiCurrencyTransfer.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.project.MultiCurrencyTransfer.entity.Transfer;
import com.project.MultiCurrencyTransfer.services.transfer.ITransferService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/transfer/")
public class TransferController {
  @Autowired
  ITransferService ts;

  @PostMapping
  public ResponseEntity<Transfer> newTransfer(@RequestBody Transfer transfer) {
    Transfer t = ts.newTransfer(transfer);
    return new ResponseEntity<>(t, HttpStatus.CREATED);
  }
}
