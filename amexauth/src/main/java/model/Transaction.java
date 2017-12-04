package model;

import com.fasterxml.jackson.annotation.JsonProperty;

public class Transaction {

    String id;
    String type;

    @JsonProperty("cardNumber")
    String cardNumber;

    @JsonProperty("cvv")
    String cvv;

    @JsonProperty("amount")
    double amount;

    @JsonProperty("merchantID")
    String merchantID;

    public Transaction(){

    }


    public Transaction(String id, String type, String cardNumber, String cvv, double amount, String merchantID) {
        this.id = id;
        this.type = type;
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

    public double getAmount() {
        return amount;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public String getMerchantID() {
        return merchantID;
    }

    public void setMerchantID(String merchantID) {
        this.merchantID = merchantID;
    }
}
