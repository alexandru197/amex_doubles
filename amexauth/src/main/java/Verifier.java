import model.Card;
import model.Merchant;


import java.util.ArrayList;
import java.util.Date;

public class Verifier
{
    static ArrayList <Card> cards = new ArrayList<Card>() ;
    static ArrayList <Merchant> merchants = new ArrayList<Merchant>() ;
    public static void main(String[] args)
    {
        Card card = new Card( ) ;
        cards . add ( card ) ;
        Merchant merchant = new Merchant ( ) ;
        merchant.setId("431531531");
        merchants.add ( merchant ) ;
        System.out.println ( verifyTransaction ( "AAAAAAAAAAAAAAA" , "1234" , 190, "431531531") ) ;
    }
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
        double balance = card.getBalance() ;
        if ( negativeTransaction( balance , amount ) )
        {
            return false ;
        }

        return true ;
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
    public static boolean negativeTransaction ( double balance , double amount )
    {
        return balance <= amount ;
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
