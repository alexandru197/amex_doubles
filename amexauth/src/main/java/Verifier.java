import model.Card;
import model.Merchant;


import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Verifier
{
    static List<Card> cards;
    static List<Merchant> merchants;

    public Verifier(List<Card> cards, List<Merchant> merchants) {
        this.cards = cards;
        this.merchants = merchants;
    }
//
//    public static void main(String[] args)
//    {
//        Card card = new Card( ) ;
//        cards . add ( card ) ;
//        Merchant merchant = new Merchant ( ) ;
//        merchant.setId("431531531");
//        merchants.add ( merchant ) ;
//        //System.out.println ( verifyTransaction ( "AAAAAAAAAAAAAAA" , "1234" , 190, "431531531") ) ;
//    }
    public static boolean verifyTransaction(String cardNumber, String CVV, double amount, String merchantId)
    {
        int index = getCardIndex ( cardNumber ) ;
        if ( index == -1 )
        {
            return false ;
        }
        Card card = cards . get ( index ) ;
        if ( !( validCVV ( card , CVV) ) )
        {
            return false ;
        }
        if ( ! validMerchant( merchantId ) )
        {
            return false ;
        }
        double limit = card.getCreditLimit() ;
        if ( negativeTransaction( limit, card.getBalance() , amount ) )
        {
            return false ;
        }

        if (negValue(amount)) {
            return false;
        }

        return true ;
    }

    public static boolean negValue(double amount) {
        return amount < 0;
    }

    public static boolean validCVV ( Card card  , String CVV )
    {
        String originalCVV = card.getVerifNumber() ;
        if ( originalCVV . equals ( CVV ) )
        {
            return true ;
        }
        return false ;
    }
    public static int getCardIndex ( String cardNumber )
    {
        int len = cards.size() ;
        for ( int i = 0 ; i < len ; i ++ )
        {
            Card card = cards.get(i) ;
            if ( card.getCardNumber() . equals ( cardNumber ) )
            {
                return i ;
            }
        }
        return -1 ;
    }
    public static boolean negativeTransaction ( double limit, double balance , double amount )
    {
        return limit - balance <= amount ;
    }
    public static boolean expired ( Date expiration )
    {
        Date now = new Date();
        return now.before ( expiration ) ;
    }
    public static boolean validMerchant ( String merchantID )
    {
        int len = merchants.size() ;
        for ( int i = 0 ; i < len ; i ++ )
        {
            Merchant merchant = merchants.get ( i ) ;
            if ( merchant .getId() .equals ( merchantID ) )
            {
                return true ;
            }
        }
        return false ;
    }
}
