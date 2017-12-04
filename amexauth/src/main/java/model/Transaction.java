package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {

    @JsonProperty("cardNumber")
    String cardNumber;

    @JsonProperty("cvv")
    String cvv;

    @JsonProperty("amount")
    long amount;

    @JsonProperty("merchantID")
    long merchantID;

    public Transaction(){

    }

    public Transaction(String cardNumber, String cvv, long amount, long merchantID) {
        this.cardNumber = cardNumber;
        this.cvv = cvv;
        this.amount = amount;
        this.merchantID = merchantID;
    }

    public String getCardNumber() {
        return cardNumber;
    }

    public void setCardNumber(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public String getCvv() {
        return cvv;
    }

    public void setCvv(String cvv) {
        this.cvv = cvv;
    }

    public long getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public long getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(long merchantID) {
        this.merchantID = merchantID;
    }
}
