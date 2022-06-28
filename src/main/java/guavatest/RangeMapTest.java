package guavatest;

import com.google.common.collect.Range;
import com.google.common.collect.RangeMap;
import com.google.common.collect.TreeRangeMap;

import java.util.HashMap;
import java.util.Hashtable;

public class RangeMapTest {
    public static void main(String[] args) {
        TreeRangeMap<Integer, Integer> comparableObjectTreeRangeMap = TreeRangeMap.create();
        comparableObjectTreeRangeMap.put(Range.lessThan(5),1);
        comparableObjectTreeRangeMap.put(Range.singleton(5),3);
        comparableObjectTreeRangeMap.put(Range.openClosed(5, 95),2);
        comparableObjectTreeRangeMap.put(Range.greaterThan(95),4);

        long l = System.currentTimeMillis();
        System.out.println("comparableObjectTreeRangeMap.get(55) = " + comparableObjectTreeRangeMap.get(2));
        System.out.println("comparableObjectTreeRangeMap.get(55) = " + comparableObjectTreeRangeMap.get(5));
        System.out.println("comparableObjectTreeRangeMap.get(55) = " + comparableObjectTreeRangeMap.get(55));
        System.out.println("comparableObjectTreeRangeMap.get(55) = " + comparableObjectTreeRangeMap.get(95));
        System.out.println("comparableObjectTreeRangeMap.get(55) = " + comparableObjectTreeRangeMap.get(110));
        long l1 = System.currentTimeMillis();


        Hashtable<String,String> stringHashtable = new Hashtable<String,String>(){
            {
                put("1","2");
                put("1","2");
                put("1","2");
                put("1","2");
            }
        };
        long l2 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            stringHashtable.put(i+"", "yes");
        }
        long l3 = System.currentTimeMillis();


        System.out.println("l2-l3 = " + (l2 - l3));

        HashMap<String,String> stringHashMap = new HashMap<>();
        long l4 = System.currentTimeMillis();
        for (int i = 0; i < 10000000; i++) {
            stringHashMap.put(i+"", "yes");
        }
        long l5 = System.currentTimeMillis();


        System.out.println("l4-l5 = " + (l4 - l5));

    }
}
