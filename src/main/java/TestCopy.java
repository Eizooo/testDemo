import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.TypeReference;
import dto.AdvPayHttpRes;
import org.springframework.util.StringUtils;
import pojo.PubInfo;
import org.springframework.beans.BeanUtils;
import pojo.AdvPayHttpEntity;
import pojo.User;

import javax.xml.crypto.Data;
import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

public class TestCopy {
    public static void main(String[] args) throws ParseException {

        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar bef = Calendar.getInstance();

        Calendar aft = Calendar.getInstance();
        int result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
        int year = aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR);


            bef.setTime(sdf.parse("2020-01-01"));
            aft.setTime(sdf.parse("2022-04-19"));
            int surplus = aft.get(Calendar.DATE) - bef.get(Calendar.DATE);
            result = aft.get(Calendar.MONTH) - bef.get(Calendar.MONTH);
            year = aft.get(Calendar.YEAR) - bef.get(Calendar.YEAR);
            System.out.println(result);
        System.out.println("year = " + year);
        if(result < 0){
                result = 1;
            }else if(result == 0){
                result = surplus <= 0 ? 1 : 0;
            }else{
                result = 0;
            }

        System.out.println(Math.abs(year) + result);

        BigDecimal divide = new BigDecimal(3575).divide(new BigDecimal(3200), 0, BigDecimal.ROUND_UP);
        System.out.println("divide = " + divide);



        LocalDateTime localDateTime = LocalDateTime.now();
        LocalDateTime localDateTime1 = localDateTime.plusMonths(1);
        System.out.println("localDateTime = " + localDateTime1);
    }
}
