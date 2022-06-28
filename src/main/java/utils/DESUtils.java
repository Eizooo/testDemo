package utils;


/**
 * @author: wangjg
 * @Date: 2018/7/4 14:54
 * @Description:
 */
import org.apache.commons.codec.binary.Base64;

import java.io.UnsupportedEncodingException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.DESKeySpec;
import javax.crypto.spec.IvParameterSpec;

/**
 *
 * DES加密工具类。
 *
 */
public class DESUtils {

    private static final String ALGORITHM_STR = "DES/ECB/PKCS5Padding";

    public static byte[] encrypt(byte[] expresslyBytes, byte[] rawKey) throws IllegalBlockSizeException,
            BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException,
            NoSuchPaddingException {

        DESKeySpec dkSpec = new DESKeySpec(rawKey);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dkSpec);

        Cipher cipher = Cipher.getInstance(ALGORITHM_STR);

        cipher.init(Cipher.ENCRYPT_MODE, key);

        return cipher.doFinal(expresslyBytes);

    }

    public static byte[] dencrypt(byte[] ciphertextBytes, byte[] rawKey) throws IllegalBlockSizeException,
            BadPaddingException, InvalidKeyException, NoSuchAlgorithmException, InvalidKeySpecException,
            NoSuchPaddingException {

        DESKeySpec dkSpec = new DESKeySpec(rawKey);

        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        SecretKey key = keyFactory.generateSecret(dkSpec);

        Cipher cipher = Cipher.getInstance(ALGORITHM_STR);

        cipher.init(Cipher.DECRYPT_MODE, key);

        return cipher.doFinal(ciphertextBytes);
    }

    public static String encryptUrl(String expresslyText, String key, String charset) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, InvalidKeySpecException,
            NoSuchPaddingException, UnsupportedEncodingException {
        byte[] data = encrypt(expresslyText.getBytes(charset), key.getBytes(charset));
        String text = new String(base64Encoding(data, true));
        return text;
    }

    public static String dencryptUrl(String cipherText, String key, String charset)
            throws UnsupportedEncodingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException,
            NoSuchAlgorithmException, InvalidKeySpecException, NoSuchPaddingException {
        byte[] data = base64Decoding(cipherText.getBytes(charset), true);
        data = dencrypt(data, key.getBytes(charset));
        return new String(data, charset);
    }

    public static String encryptUrl(String expresslyText, String key) throws InvalidKeyException,
            IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException, InvalidKeySpecException,
            NoSuchPaddingException, UnsupportedEncodingException {
        return encryptUrl(expresslyText, key, "UTF-8");
    }

    public static String dencryptUrl(String cipherText, String key) throws UnsupportedEncodingException,
            InvalidKeyException, IllegalBlockSizeException, BadPaddingException, NoSuchAlgorithmException,
            InvalidKeySpecException, NoSuchPaddingException {
        return dencryptUrl(cipherText, key, "UTF-8");
    }



    public static byte[] base64Encoding(byte[] pArray, boolean urlsafe) {
        return new Base64(0, null, urlsafe).encode(pArray);
    }

    /**
     * base64解码
     * <p>
     *
     * @author chen.chen.9, 2014-3-20
     * @param pArray
     *            编码后文本
     * @param urlsafe
     *            是否在URL中使用
     * @return 原始文本
     */
    public static byte[] base64Decoding(byte[] pArray, boolean urlsafe) {
        return new Base64(0, null, urlsafe).decode(pArray);
    }
    /**
     * 加密
     * @param data
     * @param sKey
     * @return
     */
    private static byte[] encryptCBC(byte[] data, String sKey) {
        try {
            byte[] key = sKey.getBytes();
            // 初始化向量
            IvParameterSpec iv = new IvParameterSpec(key);
            DESKeySpec desKey = new DESKeySpec(key);
            // 创建一个密匙工厂，然后用它把DESKeySpec转换成securekey
            SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
            SecretKey securekey = keyFactory.generateSecret(desKey);
            // Cipher对象实际完成加密操作
            Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
            // 用密匙初始化Cipher对象
            cipher.init(Cipher.ENCRYPT_MODE, securekey, iv);
            // 现在，获取数据并加密
            // 正式执行加密操作
            return cipher.doFinal(data);
        } catch (Throwable e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 解密
     * @param src
     * @param sKey
     * @return
     * @throws Exception
     */
    private static byte[] decryptCBC(byte[] src, String sKey) throws Exception {
        byte[] key = sKey.getBytes();
        // 初始化向量
        IvParameterSpec iv = new IvParameterSpec(key);
        // 创建一个DESKeySpec对象
        DESKeySpec desKey = new DESKeySpec(key);
        // 创建一个密匙工厂
        SecretKeyFactory keyFactory = SecretKeyFactory.getInstance("DES");
        // 将DESKeySpec对象转换成SecretKey对象
        SecretKey securekey = keyFactory.generateSecret(desKey);
        // Cipher对象实际完成解密操作
        Cipher cipher = Cipher.getInstance("DES/CBC/PKCS5Padding");
        // 用密匙初始化Cipher对象
        cipher.init(Cipher.DECRYPT_MODE, securekey, iv);
        // 真正开始解密操作
        return cipher.doFinal(src);
    }

    /**
     * 将二进制转换成16进制
     *
     * @param buf
     * @return
     */
    private static String parseByte2HexStr(byte buf[]) {
        StringBuffer sb = new StringBuffer();
        for (int i = 0; i < buf.length; i++) {
            String hex = Integer.toHexString(buf[i] & 0xFF);
            if (hex.length() == 1) {
                hex = '0' + hex;
            }
            sb.append(hex.toUpperCase());
        }
        return sb.toString();
    }

    /**
     * 将16进制转换为二进制
     *
     * @param hexStr
     * @return
     */
    private static byte[] parseHexStr2Byte(String hexStr) {
        if (hexStr.length() < 1) return null;
        byte[] result = new byte[hexStr.length() / 2];
        for (int i = 0; i < hexStr.length() / 2; i++) {
            int high = Integer.parseInt(hexStr.substring(i * 2, i * 2 + 1), 16);
            int low = Integer.parseInt(hexStr.substring(i * 2 + 1, i * 2 + 2), 16);
            result[i] = (byte) (high * 16 + low);
        }
        return result;
    }

    /**
     * 解密
     *
     * @param hexStr
     * @param sKey
     * @return
     * @throws Exception
     */
    public static String decryptCBC(String hexStr, String sKey) throws Exception {
        return decryptCBC(hexStr, StandardCharsets.UTF_8, sKey);
    }

    /**
     * 解密
     *
     * @param hexStr
     * @param sKey
     * @return
     * @throws Exception
     */
    private static String decryptCBC(String hexStr, Charset charset, String sKey) throws Exception {
        byte[] src = parseHexStr2Byte(hexStr);
        byte[] buf = decryptCBC(src, sKey);
        return new String(buf, charset);
    }

    /**
     * 加密
     * @param srcStr
     * @param sKey
     * @return
     */
    public static String encryptCBC(String srcStr, String sKey) {
        return encryptCBC(srcStr, StandardCharsets.UTF_8, sKey);
    }

    /**
     * 加密
     * @param srcStr
     * @param charset
     * @param sKey
     * @return
     */
    private static String encryptCBC(String srcStr, Charset charset, String sKey) {
        byte[] src = srcStr.getBytes(charset);
        byte[] buf = encryptCBC(src, sKey);
        return parseByte2HexStr(buf);
    }
}