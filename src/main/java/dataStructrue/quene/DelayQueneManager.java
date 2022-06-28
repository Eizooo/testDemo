package dataStructrue.quene;

import cn.hutool.cron.TaskLauncher;
import org.apache.logging.log4j.core.util.ExecutorServices;

import java.util.Map;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

public class DelayQueneManager {

    //守护线程
    private Thread deamonThread;

    //线程池
    private ExecutorService executorService;

    //延迟队列
    private DelayQueue<DelayTask> delayQueue;


    private static volatile DelayQueneManager delayQueneManager;

    private DelayQueneManager(){
        this.executorService= new ThreadPoolExecutor(4,4,0, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(), new ThreadPoolExecutor.AbortPolicy());

        delayQueue = new DelayQueue<>();
        init();
    }

    public static DelayQueneManager getInstance() {
        if(delayQueneManager == null) {
            synchronized (DelayQueneManager.class) {
                delayQueneManager = new DelayQueneManager();
            }
        }
        return delayQueneManager;
    }

    private void init(){
        deamonThread = new Thread(
            this::execute
        );
        deamonThread.setName("DelayQueneManagerMonitor");
        deamonThread.start();
    }

    private void execute() {
        //取出延时队列中的数据, 并执行
        //守护线程持续执行
        while (true) {
            Map<Thread, StackTraceElement[]> allStackTraces = Thread.getAllStackTraces();
            System.out.println("allStackTraces = " + allStackTraces);

            int taskNum = delayQueue.size();
            System.out.println("taskNum = " + taskNum);

            try {
                DelayTask delayTask = delayQueue.take();
                if (null != delayTask) {
                    Runnable task = delayTask.getTask();
                    if (null != task) {
                        executorService.execute(task);
                    }
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }

    }

    public void addTask(String name, Runnable task, long time, TimeUnit unit){
        long convert = TimeUnit.MILLISECONDS.convert(time, unit);
        System.out.println("convert = " + convert);
        DelayTask delayTask = new DelayTask(name, convert, task);
        delayQueue.put(delayTask);
    }


    public void removeTask(DelayTask delayTask){
        delayQueue.remove(delayTask);
    }

}
