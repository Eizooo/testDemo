package resttemplate;

import com.alibaba.fastjson.JSON;
import org.apache.http.HttpEntity;
import org.apache.http.HttpStatus;
import org.apache.http.client.config.RequestConfig;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.entity.StringEntity;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.apache.http.util.EntityUtils;
import org.springframework.http.converter.json.MappingJackson2HttpMessageConverter;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.HashMap;

public class resTest {
    public static void main(String[] args) {
        mimeTest();
    }

    private static void resTest() {
        RestTemplate restTemplate = new RestTemplate();
        restTemplate.getMessageConverters().add(new MappingJackson2HttpMessageConverter());
        System.out.println("restTemplate.getMessageConverters() = " + restTemplate.getMessageConverters());

        MultiValueMap<String, Object> map = new LinkedMultiValueMap();
        map.add("mobile", "18176219668");
        map.add("monthlyId", 10148L);
        map.add("msisdn", "30858393080");
        map.add("orderType", "46");
        map.add("payType", "23");
        map.add("productId", "172");
        map.add("reqTime", 1654047180471L);
        map.add("totalPrice", "4800");
        map.add("userId", "53ec1ca15bc44d489a249f10e66d976b");
        CreateMemberOrderReq build = CreateMemberOrderReq.builder()
                .mobile("18176219668")
                .monthlyId(10148L)
                .msisdn("30858393080")
                .orderType("46")
                .payType("23")
                .productId("172")
                .reqTime(1654047180471L)
                .totalPrice("4800")
                .userId("53ec1ca15bc44d489a249f10e66d976b")
                .build();
        String createMemberRes = restTemplate.postForObject("http://200.200.6.11:8518/member/createMemberOrder", map, String.class);
        System.out.println("createMemberRes = " + createMemberRes);
    }

    private static String mimeTest() {
        CloseableHttpClient client = HttpClients.createDefault();

        String url = "http://200.200.6.11:8518/member/createMemberOrder";
        HttpPost httpPost = new HttpPost(url);
        // 设置超时时间
        RequestConfig requestConfig = RequestConfig.custom().setConnectTimeout(5000)
                .setConnectionRequestTimeout(5000)
                .setSocketTimeout(5000).build();
        httpPost.setConfig(requestConfig);

        HashMap<String, Object> map = new HashMap<>();
        map.put("mobile", "18176219668");
        map.put("monthlyId", 10148L);
        map.put("msisdn", "30858393080");
        map.put("orderType", "46");
        map.put("payType", "23");
        map.put("productId", "172");
        map.put("reqTime", 1654047180471L);
        map.put("totalPrice", "4800");
        map.put("userId", "53ec1ca15bc44d489a249f10e66d976b");
        CreateMemberOrderReq build = CreateMemberOrderReq.builder()
                .mobile("18176219668")
                .monthlyId(10148L)
                .msisdn("30858393080")
                .orderType("46")
                .payType("23")
                .productId("172")
                .reqTime(1654047180471L)
                .totalPrice("4800")
                .userId("53ec1ca15bc44d489a249f10e66d976b")
                .build();

        StringEntity stringEntity = new StringEntity(JSON.toJSONString(map), "UTF-8");
        stringEntity.setContentEncoding("UTF-8");
        stringEntity.setContentType("application/json");

        httpPost.setEntity(stringEntity);

        CloseableHttpResponse response = null;
        try {
            response = client.execute(httpPost);
            if (response.getStatusLine().getStatusCode() == HttpStatus.SC_OK) {
                HttpEntity resEntity = response.getEntity();
                System.out.println("EntityUtils.toString(resEntity) = " + EntityUtils.toString(resEntity));
                return EntityUtils.toString(resEntity);
            }
        } catch (IOException e) {

        }
        return "";

    }
}
