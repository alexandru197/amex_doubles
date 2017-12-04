package model;
import java.text.SimpleDateFormat;
import java.util.*;
public class Card {

    private String cardNumber;
    private String verifNumber;
    SimpleDateFormat expiryDate= new SimpleDateFormat("MMM-yy");
    private double balance;
    private double rewardPoint;
    private double creditLimit;

    Card(){
        cardNumber="AAAAAAAAAAAAAAA";
        verifNumber="1234";
        rewardPoint=0;
        balance=0;
        rewardPoint=0;
        creditLimit=0;
    }

    Card(String cardNumber, String verifNumber,SimpleDateFormat expiryDate){

        this.cardNumber=cardNumber;
        this.verifNumber=verifNumber;
        this.expiryDate=expiryDate;

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

}