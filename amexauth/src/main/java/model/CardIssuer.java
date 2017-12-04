package model;

import model.Card;
import model.Transaction;

import java.util.ArrayList;
import java.util.List;

public class CardIssuer {

    private double balance;

    public static List<Card> cards = new ArrayList<Card>();


    public CardIssuer() {

    }

    public boolean processTransaction(Transaction transaction) {
        return true;
    }

    public static Card findCard (String s){

        for (Card c : cards)
        {
            if (c.getCardNumber(). equals (s)) return c;
        }

        return null;
    }

}
