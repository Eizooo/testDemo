import pojo.User;

import java.util.WeakHashMap;

public class Test06 {
    public static void main(String[] args) {

        String a1 = "fdasf2";
        String substring = a1.substring(a1.length() - 1);
        System.out.println("substring = " + substring);
        int a = 1010 & 1101;
        int b = ~1100;
        int c = -10 /500;
        System.out.println("c = " + c);
        System.out.println("b = " + b);
        System.out.println("a = " + a);

        long l2 = System.nanoTime();
        for (long i = 0; i < 10000000000000L; i++) {
            i *= 8;
        }
        long l3 = System.nanoTime();
        System.out.println("l1 - l = " + (l3 - l2));

        long l = System.nanoTime();
        for (long i = 0; i < 10000000000000L; i++) {
            i <<= 3;
        }
        long l1 = System.nanoTime();
        System.out.println("l1 - l = " + (l1 - l));



    }

    public static void changeUser(User user){
        user.setAge(12);
        user.setName("法外狂徒");
    }
}
