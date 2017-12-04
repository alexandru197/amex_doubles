package model;
import java.util.*;
public class Card {

    private CardMember owner;
    private String cardNumber;
    private String verifNumber;
    Date expiryDate;
    private double balance;
    private double rewardPoint;
    private double creditLimit;

    public Card(){
        cardNumber="AAAAAAAAAAAAAAA";
        verifNumber="1234";
        rewardPoint=0;
        balance=0;
        rewardPoint=0;
        creditLimit=0;
    }


    public Card(CardMember owner, String cardNumber, String verifNumber,Date expiryDate, double limit){
        this.owner = owner;
        this.cardNumber=cardNumber;
        this.verifNumber=verifNumber;
        this.expiryDate=expiryDate;
        this.creditLimit = limit;

    }
    public double getBalance(){
        return balance;
    }
    public void setBalance(double balance ){
        this.balance=balance;
    }
    public double getCreditLimit(){
        return creditLimit;
    }
    public void setCreditLimit(double creditLimit){
        this.creditLimit=creditLimit;
    }
    public double getRewardPoint(){
        return rewardPoint;
    }
    public void setRewardPoint(double rewardPoint){
        this.rewardPoint=rewardPoint;
    }
    public String getCardNumber(){
        return cardNumber;
    }
    public String getVerifNumber(){
        return verifNumber;
    }

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }

        Card card = (Card) obj;
        if (!cardNumber.equals(card.getCardNumber())) {
            return false;
        }

        return true;
    }

}