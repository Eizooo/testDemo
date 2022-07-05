package collectionTest;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        String[] strings = new String[]{"c", "c", "c","d"};

        String[][] strings1 = new String[][]{{"a","b","c","d"},{"e","f","g","h"}};

        Arrays.stream(strings1).forEach(x -> {
            Arrays.stream(x).forEach(System.out::println);
        });

        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("1","a");
        objectObjectHashMap.put("3","c");
        objectObjectHashMap.put("2","b");
        objectObjectHashMap.put("4","c");
        objectObjectHashMap.put("5","c");

        Collection<Object> values = objectObjectHashMap.values();
        for (Object value : values) {
            System.out.println("value.equals(\"a\") = " + value.equals("a"));
        }
        //values进行remove的时候要使用value, 会根据value来确定节点, 最终底层还是调用hashmap中的removeNode方法,
        //有多个相同value时只会remove第一个
        values.removeAll(Arrays.asList(strings));
        System.out.println("values = " + values);
        System.out.println("objectObjectHashMap = " + objectObjectHashMap);
    }
}
