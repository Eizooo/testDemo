package timeTest;

import java.lang.reflect.Array;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

public class TestAddMonth {

    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.now();
        localDateTime = localDateTime.minusDays(6);
        ZonedDateTime zonedDateTime = localDateTime.atZone(ZoneId.systemDefault());
        // 本地时间线LocalDateTime到即时时间线Instant时间戳
        Instant instant = zonedDateTime.toInstant();
        // UTC时间(世界协调时间,UTC + 00:00)转北京(北京,UTC + 8:00)时间
        Date date = Date.from(instant);
        System.out.println(localDateTime);
        System.out.println("new Date() = " + date);
        System.out.println("compareDate(null,date, 0) = " + compareDate(null, date, 0));
//        System.out.println("getEndTime(2) = " + df.format(getEndTime(11)));
//        Integer[] bigMonth = new Integer[]{1,3,5,7,8,10,12};
//        for (int i = 0; i < 12 ; i++) {
//            for (int j = 1; j <= 12 ; j++) {
//                String day = "30";
//                if (j == 2) {
//                    day = "28";
//                } else if(Arrays.asList(bigMonth).contains(j)){
//                    day = "31";
//                }
//                String s = "2022-%s-%s 11:23:37";
//                String format = String.format(s, j, day);
//                Date endTime = getEndTime(i, format);
//                Date endTime2 = getEndTime2(i, format);
//                System.out.println(String.format("getEndTime add month--- " + i + "----nowTime = " + format + "------result1= " + df.format(endTime) + "------result2=" + df.format(endTime2)));
//            }
//        }
    }
    public static Date getEndTime(int addmonth,String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca = Calendar.getInstance();
        ca.setTime(df.parse(date));
        int month = ca.get(Calendar.MONTH);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date0 = new Date();
        // 如果是当前月
        if (addmonth == 0) {
            ca.set(Calendar.DAY_OF_MONTH,
                    ca.getActualMaximum(Calendar.DAY_OF_MONTH));
            // 最后一天格式化
            String lastDay = sdf.format(ca.getTime());
            StringBuffer endStrb = new StringBuffer().append(lastDay).append(" 23:59:59");
            try {
                date0 = df.parse(endStrb.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            ca.add(Calendar.MONTH, addmonth);
//            ca.set(Calendar.MONTH, month + addmonth);
            int actualMaximum = ca.getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.println("actualMaximum = " + actualMaximum);
            ca.set(Calendar.DAY_OF_MONTH,
                    actualMaximum);
            System.out.println("ca = " + ca.getTime());
            String lastDayOfMonths = sdf.format(ca.getTime());
            StringBuffer endStrbs = new StringBuffer().append(lastDayOfMonths)
                    .append(" 23:59:59");
            try {
                date0 = df.parse(endStrbs.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date0;
    }

    public static Date getEndTime2(int addmonth,String date) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        Calendar ca = Calendar.getInstance();
        ca.setTime(df.parse(date));
        int month = ca.get(Calendar.MONTH);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Date date0 = new Date();
        // 如果是当前月
        if (addmonth == 0) {
            ca.set(Calendar.DAY_OF_MONTH,
                    ca.getActualMaximum(Calendar.DAY_OF_MONTH));
            // 最后一天格式化
            String lastDay = sdf.format(ca.getTime());
            StringBuffer endStrb = new StringBuffer().append(lastDay).append(" 23:59:59");
            try {
                date0 = df.parse(endStrb.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        } else {
            ca.clear();
//            ca.add(Calendar.MONTH, addmonth);
            ca.set(Calendar.MONTH, month + addmonth);

            int actualMaximum = ca.getActualMaximum(Calendar.DAY_OF_MONTH);
            System.out.println("actualMaximum = " + actualMaximum);
            ca.set(Calendar.DAY_OF_MONTH,
                    actualMaximum);
            System.out.println("ca = " + ca.getTime());
            String lastDayOfMonths = sdf.format(ca.getTime());
            StringBuffer endStrbs = new StringBuffer().append(lastDayOfMonths)
                    .append(" 23:59:59");
            try {
                date0 = df.parse(endStrbs.toString());
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return date0;
    }

    public static boolean compareDate(Date subtrahend, Date minuend, int amount) {

        if (null == subtrahend) {
            subtrahend = new Date();
        }
        Calendar subtrahendCalendar = Calendar.getInstance();
        subtrahendCalendar.setTime(subtrahend);
        Calendar minuendCalendar = Calendar.getInstance();
        minuendCalendar.setTime(minuend);
        minuendCalendar.add(Calendar.HOUR_OF_DAY, amount);
        if (subtrahendCalendar.compareTo(minuendCalendar) > 0) {
            return true;
        }
        return false;
    }
}
