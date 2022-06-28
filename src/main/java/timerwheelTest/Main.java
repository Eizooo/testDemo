package timerwheelTest;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Main implements TimerTask{
    final static Timer timerWheel = new TimerWheel();


    public static void main(String[] args) throws InterruptedException {
        System.out.println("time wheel start");
        TimerTask timerTask = new Main();
        for (int i = 0; i < 10; i++) {
            timerWheel.addTimeout(timerTask, 20, TimeUnit.SECONDS, "" + i );
        }
        Thread.sleep(10000);
        timerWheel.addTimeout(timerTask, 1, TimeUnit.SECONDS, "额外任务");
        System.out.println("time wheel end");
    }
    @Override
    public void run(Timeout timeout, String argv) throws Exception {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        System.out.println(simpleDateFormat.format(new Date()) + "timeout, argv = " + argv );
    }
}
