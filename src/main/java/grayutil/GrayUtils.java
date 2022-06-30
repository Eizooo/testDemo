package grayutil;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class GrayUtils {
    private static Boolean grayRateHit(String msisdn, String rate) {
        // msisdn加密后转为数组
        byte[] bytes = MD5STo16Byte.encrypt2MD5toByte16(msisdn);

        if (Objects.isNull(bytes) || StringUtils.isEmpty(rate)) {
            return false;
        }
        // 灰度比例0到4096之间
        int intRate = Integer.parseInt(rate);
        int r = (((int)bytes[0] & 0xFF) << 4) | ((bytes[1] & 0xF0) >> 4);
        return r < intRate;
    }
}
