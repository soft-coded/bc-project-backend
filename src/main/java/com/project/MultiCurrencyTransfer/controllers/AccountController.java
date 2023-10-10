package com.project.MultiCurrencyTransfer.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.MultiCurrencyTransfer.entities.Account;
import com.project.MultiCurrencyTransfer.services.account.IAccountService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/account/")
public class AccountController {
  @Autowired
  private IAccountService accService;

  @PostMapping("new")
  public ResponseEntity<Account> newAccount(@RequestBody Account acc) {
    return new ResponseEntity<>(accService.newAccount(acc), HttpStatus.CREATED);
  }

  @GetMapping("of-user/{userId}") // /api/v1/account/of-user
  public ResponseEntity<List<Account>> getAccountsOfUser(@PathVariable String userId) {
    return new ResponseEntity<>(accService.getAccountsByUserId(userId), HttpStatus.OK);
  }

  @PostMapping("deposit/{accountId}")
  // the request body will only have one field, "balance"
  public ResponseEntity<Account> depositInAccount(@RequestBody Account acc, @PathVariable String accountId) {
    return new ResponseEntity<Account>(accService.deposit(accountId, acc.getBalance()), HttpStatus.OK);
  }

  @PutMapping("update")
  public ResponseEntity<Account> updateAccount(@RequestBody Account acc) {
    return new ResponseEntity<Account>(accService.updateAccount(acc), HttpStatus.ACCEPTED);
  }

  @GetMapping("{id}")
  public ResponseEntity<Account> getAccountById(@PathVariable String id) {
    return new ResponseEntity<>(accService.getAccountById(id), HttpStatus.OK);
  }
}
