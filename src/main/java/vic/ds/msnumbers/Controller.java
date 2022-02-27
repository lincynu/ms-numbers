package vic.ds.msnumbers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final NumbersService numbersService;

    public Controller(NumbersService numbersService) {
        this.numbersService = numbersService;
    }

    @PostMapping("{id}")
    public String processNum(@PathVariable Integer id){
        return numbersService.processNum(id);
    }
}
