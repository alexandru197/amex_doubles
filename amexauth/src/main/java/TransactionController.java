import model.Transaction;
import model.TransactionTest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;

@Controller
@EnableAutoConfiguration
public class TransactionController {

    static CardIssuer cardIssuer;

    @RequestMapping(value = "/submit",
            method=RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    String submitTransaction(@RequestBody Transaction transaction) {
        Verifier verifier = new Verifier(cardIssuer.getCards(), cardIssuer.getMerchants());
        boolean valid = Verifier.verifyTransaction(transaction.getCardNumber(), transaction.getCvv(), transaction.getAmount(), transaction.getMerchantID());

        if (!valid) {
            return "{\"message\": \"invalid transaction\"}";
        }

        TransactionProcess.process(transaction);

        return "{\"message\": \"ok\"}";
    }

    public static void main(String[] args) throws Exception {
        cardIssuer = new CardIssuer();
        SpringApplication.run(TransactionController.class, args);
    }

}