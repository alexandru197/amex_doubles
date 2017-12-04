import jdk.nashorn.internal.objects.NativeJSON;
import model.Transaction;
import org.springframework.boot.*;
import org.springframework.boot.autoconfigure.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.*;
import org.springframework.web.bind.annotation.*;

@Controller
@EnableAutoConfiguration
public class TransactionController {

    @RequestMapping(value = "/submit",
            method=RequestMethod.POST,
            consumes = {MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    String submitTransaction(@RequestBody Transaction transaction) {
        return "{\"message\": \"ok\"}";
    }

    public static void main(String[] args) throws Exception {
        SpringApplication.run(TransactionController.class, args);
    }
}