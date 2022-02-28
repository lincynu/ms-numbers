package vic.ds.msnumbers;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Component
public class NumbersRepository {

    private static final Logger LOGGER = LoggerFactory.getLogger(NumbersRepository.class);

    private final JdbcTemplate jdbcTemplate;

    public NumbersRepository(JdbcTemplate jdbcTemplate) {
        this.jdbcTemplate = jdbcTemplate;
    }

    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public String checkInDb(Integer num){
        String ans = "Invalid number was given.";
        if (num<0) return ans;
        String query = String.format("select id from numbers where id = %s or id = %s", num, num + 1);
        List<String> result = jdbcTemplate.queryForList(query, String.class);
        if (result.isEmpty()){
            jdbcTemplate.update(String.format("insert into numbers (id) values (%s)", num));
            ans = String.valueOf(num+1);
        }
        else if (result.size()==2){
            ans = String.format("Both %s and following number %s are already in db.", num, num + 1);
            LOGGER.error(String.format("Both %s and following number %s are already in db.", num, num + 1));
        }
        else if (result.get(0).equals(num.toString())){
            ans = String.format("Number %s is already in db.", num, result.get(0));
            LOGGER.error(String.format("Number %s is already in db.", num));
        }
        else {
            ans = String.format("Following number %s is already in db.", num + 1);
            LOGGER.error(String.format("Following number %s is already in db.", num + 1));
        }
        return ans;
    }
}
