package hutooltest;

import cn.hutool.core.util.HashUtil;

public class HashUtilTest {
    public static void main(String[] args) {
        System.out.println("HashUtil.apHash(\"2\") = " + HashUtil.apHash("2"));
        System.out.println("HashUtil.javaDefaultHash(\"2\") = " + HashUtil.javaDefaultHash("kjyurfjfas"));
        System.out.println("HashUtil.dekHash(\"2\") = " + HashUtil.dekHash("2"));
        System.out.println("HashUtil.intHash(\"3\") = " + HashUtil.intHash(3));
    }
}
