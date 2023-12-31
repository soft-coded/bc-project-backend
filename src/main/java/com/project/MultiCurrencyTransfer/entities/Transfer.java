package com.project.MultiCurrencyTransfer.entities;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "transfers")
public class Transfer {
  @Id
  private String transferId;
  private String senderAccountNumber;
  private double senderAmount;
  private String senderCurrency;
  private String receiverAccountNumber;
  private double receiverAmount;
  private String receiverCurrency;
  private String userId; // id of the user that made the transfer

  public Transfer() {
  }

  public Transfer(String transferId, String senderAccountNumber, double senderAmount, String senderCurrency,
      String receiverAccountNumber, double receiverAmount, String receiverCurrency, String userId) {
    this.transferId = transferId;
    this.senderAccountNumber = senderAccountNumber;
    this.senderAmount = senderAmount;
    this.senderCurrency = senderCurrency;
    this.receiverAccountNumber = receiverAccountNumber;
    this.receiverAmount = receiverAmount;
    this.receiverCurrency = receiverCurrency;
    this.userId = userId;
  }

  public String getTransferId() {
    return transferId;
  }

  public void setTransferId(String transferId) {
    this.transferId = transferId;
  }

  public String getSenderAccountNumber() {
    return senderAccountNumber;
  }

  public void setSenderAccountNumber(String senderAccountNumber) {
    this.senderAccountNumber = senderAccountNumber;
  }

  public double getSenderAmount() {
    return senderAmount;
  }

  public void setSenderAmount(double senderAmount) {
    this.senderAmount = senderAmount;
  }

  public String getSenderCurrency() {
    return senderCurrency;
  }

  public void setSenderCurrency(String senderCurrency) {
    this.senderCurrency = senderCurrency;
  }

  public String getReceiverAccountNumber() {
    return receiverAccountNumber;
  }

  public void setReceiverAccountNumber(String receiverAccountNumber) {
    this.receiverAccountNumber = receiverAccountNumber;
  }

  public double getReceiverAmount() {
    return receiverAmount;
  }

  public void setReceiverAmount(double receiverAmount) {
    this.receiverAmount = receiverAmount;
  }

  public String getReceiverCurrency() {
    return receiverCurrency;
  }

  public void setReceiverCurrency(String receiverCurrency) {
    this.receiverCurrency = receiverCurrency;
  }

  public String getUserId() {
    return userId;
  }

  public void setUserId(String userId) {
    this.userId = userId;
  }

  @Override
  public String toString() {
    return "Transfer [transferId=" + transferId + ", senderAccountNumber=" + senderAccountNumber + ", senderAmount="
        + senderAmount + ", senderCurrency=" + senderCurrency + ", receiverAccountNumber=" + receiverAccountNumber
        + ", receiverAmount=" + receiverAmount + ", receiverCurrency=" + receiverCurrency + ", userId=" + userId + "]";
  }

}
