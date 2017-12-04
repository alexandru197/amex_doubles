import model.Card;
import model.Merchant;
import model.Transaction;

public class TransactionProcess {

    public static void process(Transaction t) {

        double amount = t.getAmount();
        String merchantid = t. getMerchantID();
        String cardnumber  = t. getCardNumber();
        Card c = CardIssuer.findCard(cardnumber);
        Merchant m = CardIssuer.findMerchant(merchantid);

        updateCardBalance(c, amount);
        updateRewardPoints(c, amount);
        updateMerchantBalance(m, calculateAmountAfterComission(amount));
    }


    public static void updateCardBalance(Card c, double amount){

        c.setBalance(c.getBalance()- amount );


    }

    public static double calculateAmountAfterComission (double amount ){

        return amount *0.98;
    }

    public static void updateMerchantBalance ( Merchant m, double  amount) {

        m.setBalance(m.getBalance() + amount);

    }

    public static void updateRewardPoints (Card c, double amount){

        c.setRewardPoint(c.getRewardPoint() + (int)amount/10 );
    }
}
