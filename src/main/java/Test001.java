import java.util.concurrent.CountDownLatch;

public class Test001 {
    public static void main(String[] args) throws InterruptedException {

//        String prefix = "bookstore-member-center";
//        String[] split = prefix.split("-");
//        prefix = split[split.length - 1];
//        prefix = prefix + ":";
//        System.out.println(prefix);
//
//        Integer pageCount = (35663 / 3000) + 1;
//        System.out.println(pageCount);
//
//        for (Integer pageIndex = 1; pageIndex < pageCount+1; pageIndex++) {
//            System.out.println(pageIndex);
//        }

//
//        String test = "{'@type':'com.migu.reading.cache.TimeoutInvalidateWrapper','createTime':1631030123006,'timeoutSeconds':2591916,'value':{'@type':'com.migu.reading.cache.memcached.presubscription.UserAttrRefreshable','bookUpdateRemindFlag':true}}";
//        byte[] test2 = test.getBytes();
//        System.out.println("test2.length = " + test2.length);
//
//        String[] strings = new String[100];
//        System.out.println(strings.length);

        CountDownLatch countDownLatch = new CountDownLatch(1);
        CountDownLatch countDownLatch2 = new CountDownLatch(5);



        int a = 1;

        for (int i = 0; i <=5 ; i++) {
            new Thread(() -> {
                try {
                    test(a);
                    countDownLatch.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }).start();
            countDownLatch2.countDown();
        }
        System.out.println("主线程等待");
        countDownLatch2.await();
        System.out.println("子线程执行");
        countDownLatch.countDown();

        System.out.println("主线程执行完毕");



    }

    public static void test(int a) throws InterruptedException {
        Thread.sleep(3000);
        a++;
        System.out.println(a==3? "true": "false");

    }
}
