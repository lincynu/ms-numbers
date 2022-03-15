package vic.ds.msnumbers;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDateTime;

@RestController
public class Controller {

    private final NumbersService numbersService;

    public Controller(NumbersService numbersService) {
        this.numbersService = numbersService;
    }

    @PostMapping("{num}")
    @Transactional(timeoutString = "1")
    public String processNum(@PathVariable Integer num){
        try {
            return numbersService.processNum(num);
        } catch (Exception e){
            return "Request Timeout";
        }
    }
}
