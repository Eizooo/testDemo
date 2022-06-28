import pojo.PubInfo;
import utils.DESUtils;
import utils.StringUtil;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;

public class TestDes {
    public static final String SHOPPING_CART_ADD_KEY_PREFIX = "SHOPPING:CART:ADD:USERID:%s:PAPERBOOKID:%s";

    public static void main(String[] args) throws BadPaddingException, NoSuchAlgorithmException, IllegalBlockSizeException, NoSuchPaddingException, InvalidKeyException, InvalidKeySpecException {
        String s = "0041";
        System.out.println("Integer.parseInt(s) = " + Integer.parseInt(s));
    }

}
