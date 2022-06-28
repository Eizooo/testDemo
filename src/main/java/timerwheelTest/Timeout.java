package timerwheelTest;

/**
 * 定时任务接口规范
 */
public interface Timeout {
    Timer timer();
    TimerTask task();
    boolean isExpired();
    boolean isCancelled();
    boolean cancel();
}
