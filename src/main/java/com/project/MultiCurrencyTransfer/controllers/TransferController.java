package com.project.MultiCurrencyTransfer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.MultiCurrencyTransfer.entities.Transfer;
import com.project.MultiCurrencyTransfer.services.transfer.ITransferService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/transfer/")
public class TransferController {
  @Autowired
  ITransferService ts;

  @PostMapping("new")
  public ResponseEntity<Transfer> newTransfer(@RequestBody Transfer transfer) {
    Transfer t = ts.newTransfer(transfer);
    return new ResponseEntity<>(t, HttpStatus.CREATED);
  }

  @GetMapping("of-user/{userId}")
  public ResponseEntity<List<Transfer>> getTransfersOfUser(@PathVariable String userId) {
    return new ResponseEntity<>(ts.getTransfersByUserId(userId), HttpStatus.OK);
  }
}
