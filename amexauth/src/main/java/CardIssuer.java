import model.Card;
import model.CardMember;
import model.Merchant;
import model.Transaction;

import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CardIssuer {

    private double balance;
    private static List<Card> cards;
    private static List<Merchant> merchants;
    private static Set<CardMember> members;

    public CardIssuer() {
        cards = new ArrayList<Card>();
        merchants = new ArrayList<Merchant>();
        members = new HashSet<CardMember>();
        initData();
    }

    public List<Card> getCards() {
        return cards;
    }

    public List<Merchant> getMerchants() {
        return merchants;
    }

    public void initData() {
        initCardMembers();
        initCards();
        initMerchants();
    }

    public void initCards() {
        String cardFilePath = "C:\\Users\\axp_admin\\Documents\\hack_data\\hack_cards.csv";
        File cardFile = new File(cardFilePath);

        List<String> cardText = new ArrayList<String>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(cardFile));

            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                cardText.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace(new PrintStream(System.out));
        }

        for (String line : cardText) {
            String[] parts = line.split(",");

            Date expiryDate = null;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("MMM-yy");
                expiryDate = sdf.parse(parts[2]);
            } catch (Exception e) {
                e.printStackTrace(new PrintWriter(System.out));
            }


            CardMember member = findMember(parts[0]);

            Card card = new Card(member, parts[1],parts[3], expiryDate, Double.valueOf(parts[4]));
            cards.add(card);
        }
    }

    public CardMember findMember(String id) {
        for (CardMember member : members) {
            if (member.getId().equals(id)) {
                return member;
            }
        }
        return null;
    }

    public void initMerchants() {
        String filePath = "C:\\Users\\axp_admin\\Documents\\hack_data\\hack_merchants.csv";
        File file = new File(filePath);

        List<String> cardText = new ArrayList<String>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                cardText.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace(new PrintStream(System.out));
        }

        for (String line : cardText) {
            String[] parts = line.split(",");

            Merchant merchant = new Merchant(parts[0], parts[1], parts[2], 0, Double.valueOf(parts[13]));
            merchants.add(merchant);
        }
    }

    public void initCardMembers() {
        String filePath = "C:\\Users\\axp_admin\\Documents\\hack_data\\hack_card_members.csv";
        File file = new File(filePath);

        List<String> cardText = new ArrayList<String>();

        try {

            BufferedReader br = new BufferedReader(new FileReader(file));

            String line;
            br.readLine();
            while ((line = br.readLine()) != null) {
                cardText.add(line);
            }

        } catch (Exception e) {
            e.printStackTrace(new PrintStream(System.out));
        }

        for (String line : cardText) {
            String[] parts = line.split(",");

            CardMember cardMember = new CardMember(parts[0], parts[1], parts[2]);
            members.add(cardMember);
        }
    }



    public static Card findCard (String s){

        for (Card c : cards)
        {
            if (c.getCardNumber(). equals (s)) return c;
        }

        return null;
    }

    public static Merchant findMerchant (String id){

        for (Merchant m : merchants ){

            if (m.getId(). equals(id)) return m;

        }

        return null;
    }
//    public boolean validateTransaction(Transaction transaction) {
//
//    }


    public boolean validateTransaction(Transaction transaction) throws Exception {
        return false;
    }

}
