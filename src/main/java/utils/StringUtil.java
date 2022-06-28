package utils;

import org.apache.commons.lang3.StringUtils;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Random;

public class StringUtil {
    public static String DOT_3 = "...";

    public StringUtil() {
    }

    public static boolean isEmpty(String str) {
        return str == null || str.trim().length() == 0;
    }

    public static boolean isNotEmpty(String str) {
        return !StringUtils.isEmpty(str);
    }

    public static List<Long> splitLong(String character, String separate) {
        List<Long> list = new ArrayList();
        if (!isEmpty(character)) {
            String[] temp = character.split(separate);

            for(int i = 0; i < temp.length; ++i) {
                list.add(Long.valueOf(temp[i]));
            }
        }

        return list;
    }

    public static List<String> convertLongListToStringList(List<Long> longList) {
        List<String> list = new ArrayList();
        if (!CollectionUtils.isEmpty(longList)) {
            Iterator var2 = longList.iterator();

            while(var2.hasNext()) {
                Long id = (Long)var2.next();
                list.add(id.toString());
            }
        }

        return list;
    }

    public static String replaceLongPartByDot(String origin, int lenth) {
        return !isEmpty(origin) && origin.length() > lenth && lenth >= 4 ? origin.substring(0, lenth - 3) + DOT_3 : origin;
    }

    public static String getStringRandom(int length) {
        String val = "";
        Random random = new Random();

        for(int i = 0; i < length; ++i) {
            String charOrNum = random.nextInt(2) % 2 == 0 ? "char" : "num";
            if ("char".equalsIgnoreCase(charOrNum)) {
                int temp = random.nextInt(2) % 2 == 0 ? 65 : 97;
                val = val + (char)(random.nextInt(26) + temp);
            } else if ("num".equalsIgnoreCase(charOrNum)) {
                val = val + String.valueOf(random.nextInt(10));
            }
        }

        return val;
    }

    public static String changeMobile(String mobile) {
        String new_mobile = "";
        if (null != mobile && !"".equals(mobile) && mobile.length() == 11) {
            new_mobile = mobile.substring(0, 3) + "*****" + mobile.substring(8);
        }

        return new_mobile;
    }

    public static String mobileChange(String mobile) {
        String new_mobile = "";
        if (null != mobile && !"".equals(mobile) && mobile.length() == 11) {
            new_mobile = mobile.replaceAll("(\\d{3})\\d*(\\d{5})", "$1****$2");
        }

        return new_mobile;
    }

    public static String valueOfExcel(Object data) {
        return !ObjectUtils.isEmpty(data) && data != null && !"null".equals(data) ? data.toString() : "";
    }
}
