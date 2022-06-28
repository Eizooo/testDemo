package pojo;


import net.sf.json.JSONArray;
import net.sf.json.JSONObject;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Test08 {

    public static void main(String[] args) {

//        String jsonString = "[{'ADDR_ID':'106','ADDR_DESP':'ability'}]";
//        jsonString.replaceAll("#范德萨发三份#","家具");
//        System.out.println(jsonString);
//
//
//        BigDecimal bookPrice = new BigDecimal(4500L).multiply(BigDecimal.valueOf(0.01)).multiply(new BigDecimal("0.01"));
//        System.out.println(bookPrice);
//
//        if (bookPrice.compareTo(new BigDecimal("100")) < 0) {
//            bookPrice = new BigDecimal("100");
//        }
//        // 四舍五入
//        bookPrice = bookPrice.setScale(0, BigDecimal.ROUND_HALF_UP);
//        System.out.println(bookPrice.longValue());
//

//        List<String> strings = new ArrayList<>();
//
//        List<String> collect = strings.stream().distinct().collect(Collectors.toList());
//
//        System.out.println(collect.size());

        Long cpId = 29L;
        if(cpId.equals(29L)){
            System.out.println(11111);
        }

        Integer cpId2 = 29;
        if (cpId2.equals(29)){
            System.out.println(111111);
        }
//        User user = new User();
//        User user2 = new User();
//        List<Long> users = new ArrayList<>();
//        users.add(1l);
//
//        List<Long> longs = users.subList(0, 2);
//        System.out.println(longs);
    }
}
