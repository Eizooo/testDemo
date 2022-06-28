package secretTest;



import org.apache.commons.lang.StringUtils;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.InputStream;
import java.io.UnsupportedEncodingException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.KeyFactory;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.spec.PKCS8EncodedKeySpec;

public class TestAes {
    public static final String  SIGN_ALGORITHMS = "SHA1WithRSA";
    public static final String charset = "UTF-8";
    public static void main(String[] args) throws Exception {
        String key = "8c18ec388f54ec4a";
        String sign = decryptECB("0PHVG33setqza1dVGiF/jg==", key);
        System.out.println("sign = " + sign);
    }

    private static String decryptECB(String data, String key) throws Exception {
        if (!StringUtils.isEmpty(key) && key.length() >= 16) {
            byte[] decryptdata = Base64.decode(data);
            byte[] skey = getSecretKey(key);
            byte[] decryptContent = decryptECB(decryptdata, skey);
            return new String(decryptContent);
        } else {
            return null;
        }
    }

    public static byte[] decryptECB(byte[] data, byte[] key) throws Exception {
        Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
        cipher.init(2, toKey(key));
        byte[] result = cipher.doFinal(data);
        return result;
    }

    private static Key toKey(byte[] key) throws Exception {
        return new SecretKeySpec(key, "AES");
    }

    private static byte[] getSecretKey(String key) throws UnsupportedEncodingException {
        byte[] skey = key.substring(0, 16).getBytes("UTF-8");
        return skey;
    }

    public static String encrypt(String str, String password) {
        try {
            byte[] enCodeFormat = password.substring(0, 16).getBytes("UTF-8");
            SecretKeySpec key = new SecretKeySpec(enCodeFormat, "AES");
            Cipher cipher = Cipher.getInstance("AES/ECB/PKCS5Padding");
            byte[] byteContent = str.getBytes("UTF-8");
            cipher.init(1, key);
            byte[] result = cipher.doFinal(byteContent);
            return Base64.encode(result);
        } catch (NoSuchAlgorithmException var7) {
            var7.printStackTrace();
        } catch (NoSuchPaddingException var8) {
            var8.printStackTrace();
        } catch (InvalidKeyException var9) {
            var9.printStackTrace();
        } catch (UnsupportedEncodingException var10) {
            var10.printStackTrace();
        } catch (IllegalBlockSizeException var11) {
            var11.printStackTrace();
        } catch (BadPaddingException var12) {
            var12.printStackTrace();
        }

        return null;
    }

//    public static String decrypt(String content, String private_key, String input_charset)
//            throws Exception
//    {
//        PrivateKey prikey = getPrivateKey(private_key);
//        Cipher cipher = Cipher.getInstance("RSA");
//        cipher.init(Cipher.DECRYPT_MODE, prikey);
//        InputStream ins = new ByteArrayInputStream(Base64.decodeBase64(content.getBytes()));
//        ByteArrayOutputStream writer = new ByteArrayOutputStream();
//        // rsa解密的字节大小最多是128，将需要解密的内容，按128位拆开解密
//        byte[] buf = new byte[128];
//        int bufl;
//        while ((bufl = ins.read(buf)) != -1)
//        {
//            byte[] block = null;
//            if (buf.length == bufl)
//            {
//                block = buf;
//            }
//            else
//            {
//                block = new byte[bufl];
//                for (int i = 0; i < bufl; i++)
//                {
//                    block[i] = buf[i];
//                }
//            }
//            writer.write(cipher.doFinal(block));
//        }
//        return new String(writer.toByteArray(), input_charset);
//    }
//
//    public static PrivateKey getPrivateKey(String key)
//            throws Exception
//    {
//        byte[] keyBytes;
//        keyBytes = Base64.decodeBase64(key.getBytes());
//        // 使用PKCS8
//        PKCS8EncodedKeySpec keySpec = new PKCS8EncodedKeySpec(keyBytes);
//        KeyFactory keyFactory = KeyFactory.getInstance("RSA");
//        PrivateKey privateKey = keyFactory.generatePrivate(keySpec);
//        return privateKey;
//    }
//
//    public static String sign(String content, String privateKey, String input_charset)
//    {
//        try
//        {
//            PKCS8EncodedKeySpec priPKCS8 	= new PKCS8EncodedKeySpec( Base64.decodeBase64(privateKey.getBytes(charset)) );
//            KeyFactory keyf 				= KeyFactory.getInstance("RSA");
//            PrivateKey priKey 				= keyf.generatePrivate(priPKCS8);
//
//            java.security.Signature signature = java.security.Signature
//                    .getInstance(SIGN_ALGORITHMS);
//
//            signature.initSign(priKey);
//            signature.update( content.getBytes(input_charset) );
//
//            byte[] signed = signature.sign();
//
//            return new String(Base64.encodeBase64(signed),charset);
//        }
//        catch (Exception e)
//        {
//        }
//
//        return null;
//    }
}
