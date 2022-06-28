package guavatest;

import com.google.common.collect.HashMultimap;
import com.google.common.collect.ImmutableMap;
import com.google.common.collect.ListMultimap;
import com.google.common.collect.MultimapBuilder;
import com.google.common.collect.Multimaps;

public class MultiMapTest {
    public static void main(String[] args) {
        //不可变Map
        ImmutableMap<String, String> of = ImmutableMap.of("key", "value", "key2", "value2");

//        of.put("2","3");

        HashMultimap<String, String> objectObjectHashMultimap = HashMultimap.create();
        objectObjectHashMultimap.put("a" ,"1");
        objectObjectHashMultimap.put("a" ,"2");
        objectObjectHashMultimap.put("a" ,"3");
        objectObjectHashMultimap.put("a" ,"4");


        System.out.println("objectObjectHashMultimap = " + objectObjectHashMultimap);
    }
}
