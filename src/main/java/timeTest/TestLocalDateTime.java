package timeTest;

import org.apache.commons.pool2.impl.GenericObjectPoolConfig;
import redis.clients.jedis.BinaryJedisCluster;
import redis.clients.jedis.HostAndPort;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisCluster;
import redis.clients.util.SafeEncoder;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.temporal.TemporalAccessor;
import java.time.temporal.TemporalAdjusters;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class TestLocalDateTime {

    public static void main(String[] args) throws ParseException {

        System.out.println("getDurationSecondsBetweenNowAndLastDayOfMonth() = " + getDurationSecondsBetweenNowAndLastDayOfMonth());
        Set<HostAndPort> jedisClusterNode = new HashSet<>();
        jedisClusterNode.add(new HostAndPort("10.211.95.223", 7001));
        int connectionTimeout = 3000;
        int soTimeout = 3000;
        int maxAttempts = 5;
        String password = "654321";
        GenericObjectPoolConfig poolConfig = new GenericObjectPoolConfig();
        poolConfig.setMaxIdle(100);
        poolConfig.setMaxWaitMillis(10000);
        poolConfig.setTestOnBorrow(true);
        try (BinaryJedisCluster myCluster = new BinaryJedisCluster(jedisClusterNode, connectionTimeout, soTimeout, maxAttempts, poolConfig)) {

            System.out.println(myCluster.getClusterNodes().keySet());

            long time = 0;
            String ok = myCluster.set(SafeEncoder.encode("ok"),SafeEncoder.encode("ok"), SafeEncoder.encode("NX"), SafeEncoder.encode("EX"), time);
            System.out.println("ok = " + ok);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public static long getDurationSecondsBetweenNowAndLastDayOfMonth() throws ParseException {
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
        Date format = simpleDateFormat.parse("2022-06-30 23:59:59.444");
        LocalDateTime now = LocalDateTime.ofInstant(format.toInstant(), ZoneId.systemDefault());
        LocalDateTime lastTimeOfDayOfMonth = now.with(TemporalAdjusters.lastDayOfMonth()).withHour(23)
                .withMinute(59).withSecond(59);
        Duration duration = Duration.between(now, lastTimeOfDayOfMonth);
        return duration.getSeconds();
    }


}
