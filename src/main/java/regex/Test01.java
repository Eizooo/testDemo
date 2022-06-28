package regex;

import cn.hutool.core.util.HashUtil;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;
import java.util.concurrent.TimeUnit;
import java.util.function.Predicate;
import java.util.stream.Collectors;

public class Test01 {
    static boolean isExistsNum(String str) {
        return str.matches("[^\\d]*");
    }


    static boolean isExistsFuhao(String str) {
        String pattern = "^[^@]*@[^@]*$";
        return str.matches(pattern);
    }
    public static void main(String[] args) throws InterruptedException {
//        String sentence = "cat and  dog";
//        String[] s = sentence.split(" ");
//        List<String> collect = Arrays.stream(s).filter(new Predicate<String>() {
//            @Override
//            public boolean test(String s) {
//                if (s.length() <= 0) {
//                    return false;
//                }
//                return true;
//            }
//        }).collect(Collectors.toList());
//        for (String s1 : collect) {
//            System.out.println("s1.length() = " + s1.length());
//            System.out.println("s1 = " + s1);
//        }
//        System.out.println(isExistsFuhao("fa@f@"));
//        System.out.println(isExistsFuhao("f1af"));

        ArrayList<Object> objects = new ArrayList<>();
        objects.add(1);
        objects.add(2);
        objects.add(3);
        objects.add(4);
        objects.add(5);
        objects.add(6);
        objects.add(7);
        objects.add(8);
        System.out.println("objects = " + objects);
//        List<Object> objects1 = objects.subList(0, 2);
//
//        System.out.println("objects1 = " + objects1);
//        objects1.equals(1);
//
//        ArrayList<Object> objects2 = new ArrayList<>();
//        objects2.add(1);
//        objects2.add(2);
//
//        boolean equals = objects1.equals(objects2);
//        System.out.println("equals = " + equals);
//        System.out.println("objects = " + objects);
//        System.out.println("objects1 = " + objects);
//        int pageSize = 2;
//        int count = objects.size()%pageSize == 0?objects.size()/pageSize:objects.size()/pageSize +1;
//        for (int i = 1 ; i <= count; i++) {
//            List<Object> subResult = new ArrayList<>();
//            if(objects.size() < pageSize) {
//                subResult = objects.subList(0,objects.size());
//            } else {
//                subResult = objects.subList(0,pageSize);
//            }
//
//            //处理逻辑
//
//            subResult.clear();
//
//            System.out.println("objects = " + objects);
//        }

        BlockingQueue<String> blockingQueue = new ArrayBlockingQueue<String>(20);

        String poll = blockingQueue.poll(2, TimeUnit.NANOSECONDS);
        Thread.sleep(3);
        blockingQueue.add("dd");
        System.out.println("poll = " + poll);
        System.out.println("blockingQueue = " + blockingQueue);


        int i = HashUtil.apHash("123");
        System.out.println("i = " + i);
    }
}
