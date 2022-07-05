package collectionTest;

import dto.BigUserInfo;
import dto.TokenInfo;

import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.WeakHashMap;

public class WeakRefTest {

    public static void main(String[] args) {

        WeakHashMap<TokenInfo, BigUserInfo> map = new WeakHashMap<>();

        BigUserInfo bigUserInfo = new BigUserInfo("s", "d", new Date());
        BigUserInfo bigUserInfo2 = new BigUserInfo("s2", "d2", new Date());

        TokenInfo tokenInfo = new TokenInfo("fladjflasjf", 213123L);
        TokenInfo tokenInfo2 = new TokenInfo("3123", 221L);


        //强引用
        map.put(tokenInfo, bigUserInfo);
        map.put(tokenInfo, bigUserInfo2);

        System.out.println("map.containsKey(tokenInfo) = " + map.containsKey(tokenInfo));

        //map中的values对象成为弱引用对象
        tokenInfo = null;

        System.out.println("map.size() = " + map.size());

        //主动触发一次GC
        System.gc();
        try {
            Thread.sleep(10000L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("map.size() = " + map.size());

    }
}
