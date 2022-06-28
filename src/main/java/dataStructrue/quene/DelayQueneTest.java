package dataStructrue.quene;

import java.util.concurrent.DelayQueue;
import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

public class DelayQueneTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("TimeUnit.MILLISECONDS.convert(1, TimeUnit.MILLISECONDS) = " + TimeUnit.MILLISECONDS.convert(1, TimeUnit.MILLISECONDS));
        DelayQueneManager instance = DelayQueneManager.getInstance();

        instance.addTask("sleep task", new Runnable() {
            @Override
            public void run() {
                System.out.println("sleep for a  while");
            }
        }, 15, TimeUnit.SECONDS);

        instance.addTask("work task", new Runnable() {
            @Override
            public void run() {
                System.out.println("work for a  while");
            }
        }, 1, TimeUnit.MINUTES);

    }
}

class DelayTask implements Delayed{

    private String name;

    private long deadline;

    private Runnable task;


    public DelayTask(){}

    public DelayTask(String name, long deadline) {
        this.name = name;
        this.deadline = System.currentTimeMillis() + deadline;
    }

    public DelayTask(String name, long deadline, Runnable task) {
        this.name = name;
        this.deadline = System.currentTimeMillis() + deadline;
        this.task = task;
    }

    @Override
    public int compareTo(Delayed o) {
        long other = o.getDelay(TimeUnit.MILLISECONDS);
        long self = this.getDelay(TimeUnit.MILLISECONDS);
        return Long.compare(self, other);
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return unit.convert(deadline - System.currentTimeMillis(), TimeUnit.MILLISECONDS);
    }

    @Override
    public String toString() {
        return "$classname{" +
                "name='" + name + '\'' +
                ", deadline=" + deadline +
                '}';
    }

    public Runnable getTask() {
        return task;
    }

    public void setTask(Runnable task) {
        this.task = task;
    }
}


