package timerwheelTest;

import java.util.concurrent.TimeUnit;

public class TimeUnitTest {
    public static void main(String[] args) {

        long l = TimeUnit.SECONDS.toNanos(100);
        System.out.println("l = " + l);
    }
}
