import model.Card;
import model.Merchant;
import model.Transaction;

public class TransactionProcess {

    public static void process(Transaction t) {

        boolean valid = Verifier.verifyTransaction(t.getCardNumber(), t.getCvv(), t.getAmount(), t.getMerchantID());

        double amount = t.getAmount();
        String merchantid = t. getMerchantID();
        String cardnumber  = t. getCardNumber();
        Card c = CardIssuer.findCard(cardnumber);
        Merchant m = CardIssuer.findMerchant(merchantid);

        System.out.println("old balance: " + c.getBalance());

        updateCardBalance(c, amount);
        updateRewardPoints(c, amount);
        updateMerchantBalance(m, calculateAmountAfterComission(amount));

        System.out.println("new balance: " + c.getBalance());
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
