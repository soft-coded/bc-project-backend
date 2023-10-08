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

import com.project.MultiCurrencyTransfer.entities.Account;
import com.project.MultiCurrencyTransfer.services.account.IAccountService;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/account/")
public class AccountController {
  @Autowired
  private IAccountService accService;

  @GetMapping("{id}")
  public ResponseEntity<Account> getAccountById(@PathVariable String id) {
    return new ResponseEntity<>(accService.getAccountById(id), HttpStatus.OK);
  }

  @PostMapping("new")
  public ResponseEntity<Account> newAccount(@RequestBody Account acc) {
    return new ResponseEntity<>(accService.newAccount(acc), HttpStatus.CREATED);
  }

  @GetMapping("of-user") // /api/v1/account/of-user
  public ResponseEntity<List<Account>> getAccountsOfUser(@RequestBody String userId) {
    return new ResponseEntity<>(accService.getAccountsByUserId(userId), HttpStatus.OK);
  }
}
