package vic.ds.msnumbers;

import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final NumbersService numbersService;

    public Controller(NumbersService numbersService) {
        this.numbersService = numbersService;
    }

    @PostMapping("{num}")
    public String processNum(@PathVariable Integer num){
        return numbersService.processNum(num);
    }
}
