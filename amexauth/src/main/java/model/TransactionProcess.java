package model;

public class TransactionProcess {

    public static void process( Transaction t) {

        long amount = t.getAmount();
        long merchantid = t. getMerchantID();
        String cardnumber  = t. getCardNumber();
        Card c = CardIssuer.findCard(cardnumber);

    }


    public static void updateCardBalance(Card c, long amount){

        c.setBalance(c.getBalance()- amount );


    }

    public static void updateMerchantBalance () {

    }
}
