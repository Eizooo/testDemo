package timerwheelTest;

import java.util.Set;
import java.util.concurrent.TimeUnit;

/**
 * 时间轮接口规范
 */
public interface Timer {
    Timeout addTimeout(TimerTask task, long delay, TimeUnit unit, String argv);
    Set<Timeout> stop();
}
