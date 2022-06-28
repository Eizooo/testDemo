package secretTest;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.methods.RequestEntity;
import org.apache.commons.httpclient.methods.StringRequestEntity;
import org.apache.commons.lang.StringUtils;


import java.io.IOException;
import java.io.UnsupportedEncodingException;
import java.net.URLEncoder;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Map;

public class TestMD5 {
    private static final HttpClient httpClient = getHttpClient();

    private static HttpClient getHttpClient() {
        // 此处运用连接池技术
        MultiThreadedHttpConnectionManager manager = new MultiThreadedHttpConnectionManager();

        // 设定参数: 与每个主机的最大连接数
        int maxConnPerHost = 3;
        manager.getParams().setDefaultMaxConnectionsPerHost(maxConnPerHost);

        // 设定参数: 客户端的总连接数
        int maxTotalConnections = 10;
        manager.getParams().setMaxTotalConnections(maxTotalConnections);

        // 设置连接超时时间, 单位: 毫秒
        int connectionTimeOut = 10000;
        manager.getParams().setConnectionTimeout(connectionTimeOut);

        // 设置请求读取超时时间, 单位: 毫秒
        int soTimeOut = 10000;
        manager.getParams().setSoTimeout(soTimeOut);

        // 使用连接池技术创建HttpClient对象
        HttpClient httpClient = new HttpClient(manager);

        return httpClient;
    }

    private static final String CHARSET = "UTF-8";

    private static char[] base64EncodeChars = new char[] {
            'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H',
            'I', 'J', 'K', 'L', 'M', 'N', 'O', 'P',
            'Q', 'R', 'S', 'T', 'U', 'V', 'W', 'X',
            'Y', 'Z', 'a', 'b', 'c', 'd', 'e', 'f',
            'g', 'h', 'i', 'j', 'k', 'l', 'm', 'n',
            'o', 'p', 'q', 'r', 's', 't', 'u', 'v',
            'w', 'x', 'y', 'z', '0', '1', '2', '3',
            '4', '5', '6', '7', '8', '9', '+', '/'
    };

    private static String MD5(String str, String charset) throws Exception {
        MessageDigest md = MessageDigest.getInstance("MD5");
        md.update(str.getBytes(charset));
        byte[] result = md.digest();
        StringBuffer sb = new StringBuffer(32);
        for (int i = 0; i < result.length; i++) {
            int val = result[i] & 0xff;
            if (val <= 0xf) {
                sb.append("0");
            }
            sb.append(Integer.toHexString(val));
        }
        return sb.toString().toLowerCase();
    }

    public static void main(String[] args) throws Exception {
//        String requestData = "{'LogisticCode':'" + "300283681044" + "'}";
        String requestData = "{'ShipperCode':'" + "ZT0KY" + "','LogisticCode':'" + "300283681044" + "'}";

        Map<String, String> params = new HashMap<String, String>();
        params.put("RequestData", urlEncoder(requestData, CHARSET)); // 请求内容需进行URL(utf-8)编码. 请求内容JSON格式, 须和DataType一致
        params.put("EBusinessID", "1304312"); // 商户ID
        params.put("RequestType", "8001");
        String dataSign = encrypt(requestData, "48660cff-9ad6-4bba-8163-5e7ac54d5dba", CHARSET);
        params.put("DataSign", urlEncoder(dataSign, CHARSET));
        params.put("DataType", "2"); // 请求、返回数据类型: 2-json
        System.out.println("params = " + params);
        String result = postFormRequest("http://api.kdniao.com/Ebusiness/EbusinessOrderHandle.aspx", params);
        System.out.println("result = " + result);
    }

    public static String postFormRequest(String url, Map<String, String> params)  {

        PostMethod httpMethod = new PostMethod(url);

        httpMethod.addRequestHeader("Content-Type", "application/x-www-form-urlencoded; charset=UTF-8");

        try {
            // 发送请求参数
            StringBuilder param = new StringBuilder();
            for (Map.Entry<String, String> entry : params.entrySet()) {
                if (param.length() > 0) {
                    param.append("&");
                }
                param.append(entry.getKey());
                param.append("=");
                param.append(entry.getValue());
            }

            RequestEntity entity = new StringRequestEntity(param.toString(), "application/json", "utf-8");
            httpMethod.setRequestEntity(entity);
            // 执行请求并接收响应码
            int resultCode = httpClient.executeMethod(httpMethod);

            String respJson = httpMethod.getResponseBodyAsString();

            return respJson;

        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (httpMethod != null) {
                httpMethod.releaseConnection();
            }

        }
        return "null";
    }

    private static String encrypt (String content, String keyValue, String charset) throws UnsupportedEncodingException, Exception {
        if (keyValue != null) {
            return base64(MD5(content + keyValue, charset), charset);
        }
        return base64(MD5(content, charset), charset);
    }

    private static String base64(String str, String charset) throws UnsupportedEncodingException {
        String encoded = base64Encode(str.getBytes(charset));
        return encoded;
    }

    private static String urlEncoder(String str, String charset) throws UnsupportedEncodingException {
        String result = URLEncoder.encode(str, charset);
        return result;
    }

    public static String base64Encode(byte[] data) {
        StringBuffer sb = new StringBuffer();
        int len = data.length;
        int i = 0;
        int b1, b2, b3;
        while (i < len) {
            b1 = data[i++] & 0xff;
            if (i == len) {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[(b1 & 0x3) << 4]);
                sb.append("==");
                break;
            }
            b2 = data[i++] & 0xff;
            if (i == len)  {
                sb.append(base64EncodeChars[b1 >>> 2]);
                sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
                sb.append(base64EncodeChars[(b2 & 0x0f) << 2]);
                sb.append("=");
                break;
            }
            b3 = data[i++] & 0xff;
            sb.append(base64EncodeChars[b1 >>> 2]);
            sb.append(base64EncodeChars[((b1 & 0x03) << 4) | ((b2 & 0xf0) >>> 4)]);
            sb.append(base64EncodeChars[((b2 & 0x0f) << 2) | ((b3 & 0xc0) >>> 6)]);
            sb.append(base64EncodeChars[b3 & 0x3f]);
        }
        return sb.toString();
    }
}
