import model.Card;
import model.CardMember;
import model.Merchant;
import java.io.*;
import java.text.SimpleDateFormat;
import java.util.*;

public class CardIssuer {

    private double balance;
    private List<Card> cards;
    private List<Merchant> merchants;
    private Set<CardMember> members;

    public CardIssuer() {
        cards = new ArrayList<Card>();
        merchants = new ArrayList<Merchant>();
        members = new HashSet<CardMember>();
        initTestData();
    }

    public static void main(String[] args) {
        CardIssuer cardIssuer = new CardIssuer();
        cardIssuer.initTestData();
    }

    public void initTestData() {
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

            int id = Integer.valueOf(parts[0]);
            CardMember member = null;
            for (int i = 0; i < members.size(); ++i) {
                member = members.get(i);
                if (member.getId() == id) {
                    break;
                }
            }

            Card card = new Card(, parts[1],parts[3], expiryDate, Double.valueOf(parts[4]));
            cards.add(card);
        }
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

            Merchant merchant = new Merchant(Integer.valueOf(parts[0]), parts[1], parts[2], 0, Double.valueOf(parts[13]));
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

            Merchant merchant = new Merchant(Integer.valueOf(parts[0]), parts[1], parts[2], 0, Double.valueOf(parts[13]));
            merchants.add(merchant);
        }
    }

//    public boolean processTransaction(Transaction transaction) {
//
//    }
//
//    public boolean validateTransaction(Transaction transaction) {
//
//    }

}
