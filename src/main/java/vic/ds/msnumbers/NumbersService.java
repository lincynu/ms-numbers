package vic.ds.msnumbers;

import org.springframework.stereotype.Service;

@Service
public class NumbersService {

    final NumbersRepository numbersRepository;

    public NumbersService(NumbersRepository numbersRepository) {
        this.numbersRepository = numbersRepository;
    }

    public String processNum(Integer num){
        return numbersRepository.checkInDb(num);
    }

}
