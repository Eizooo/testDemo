package collectionTest;

import java.util.Collection;
import java.util.HashMap;

public class HashMapTest {
    public static void main(String[] args) {
        HashMap<Object, Object> objectObjectHashMap = new HashMap<>();
        objectObjectHashMap.put("1","a");
        objectObjectHashMap.put("2","b");
        objectObjectHashMap.put("3","c");

        Collection<Object> values = objectObjectHashMap.values();
        values.remove("1");
        System.out.println("values = " + values);
        System.out.println("objectObjectHashMap = " + objectObjectHashMap);
    }
}
