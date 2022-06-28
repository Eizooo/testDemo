import cn.hutool.core.date.DateUtil;

import java.util.Date;

public class Test_HuTool {
    public static void main(String[] args) throws InterruptedException {
        Date now = new Date();
        Date dayBeginTime = DateUtil.beginOfDay(now);
        Date modifyTime = new Date(1620263302000L);
        Thread.sleep(10000);
        Date date = new Date();
        Date dayBeginTime2 = DateUtil.beginOfDay(date);
        // 取最新配置时间
        System.out.println(DateUtil.compare(dayBeginTime, modifyTime));
        System.out.println(DateUtil.compare(dayBeginTime, dayBeginTime2));
        Date beginTime = DateUtil.compare(dayBeginTime, modifyTime) == 1 ? dayBeginTime : modifyTime;

        System.out.println(beginTime);
    }
}
