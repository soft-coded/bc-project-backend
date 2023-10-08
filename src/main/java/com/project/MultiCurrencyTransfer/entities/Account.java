package com.project.MultiCurrencyTransfer.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "accounts")
public class Account {
  @Id
  private String accountId;
  private String accountNumber; // string because it can be too big even for a 64 bit integer (long)
  private String holderName;
  private String type; // savings or current or something else
  private String userId; // id of the user that created the account
  private double balance;
  private String currency; // home currency of the account

  public Account() {
  }

  public Account(String accountId, String accountNumber, String holderName, String type, String userId, long balance,
      String currency) {
    this.accountId = accountId;
    this.accountNumber = accountNumber;
    this.holderName = holderName;
    this.type = type;
    this.userId = userId;
    this.balance = balance;
    this.currency = currency;
  }

  public String getAccountId() {
    return accountId;
  }

  public void setAccountId(String accountId) {
    this.accountId = accountId;
  }

  public String getAccountNumber() {
    return accountNumber;
  }

  public void setAccountNumber(String accountNumber) {
    this.accountNumber = accountNumber;
  }

  public String getHolderName() {
    return holderName;
  }

  public void setHolderName(String holderName) {
    this.holderName = holderName;
  }

  public String getType() {
    return type;
  }

  public void setType(String type) {
    this.type = type;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  public double getBalance() {
    return balance;
  }

  public void setBalance(double balance) {
    this.balance = balance;
  }

  public String getCurrency() {
    return currency;
  }

  public void setCurrency(String currency) {
    this.currency = currency;
  }

  @Override
  public String toString() {
    return "Account [accountId=" + accountId + ", accountNumber=" + accountNumber + ", holderName=" + holderName
        + ", type=" + type + ", userId=" + userId + ", balance=" + balance + ", currency=" + currency + "]";
  }

}
