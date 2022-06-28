package timerwheelTest;

public interface TimerTask {
    void run(Timeout timeout, String argv) throws Exception;
}
