import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.alibaba.fastjson.parser.Feature;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

public class TestJson {
    public static void main(String[] args) {
        jsonTest02();
    }

    private static void jsonTest02() {
        String str = "{\"createTime\":\"2022-06-17 17:33:02\",\"orderId\":\"100000000007312647\",\"orderStatus\":\"2\",\"containerCount\":1,\"containerInfoList\":[{\"expressName\":\"韵达快递\",\"expressNo\":\"432620701995647\"}],\"merOrderId\":\"201-10000000000007628\"}";
        Map<String, Object> map = JSONObject.parseObject(str, Map.class);
        JSONArray containerInfoList = (JSONArray) map.get("containerInfoList");
        System.out.println("containerInfoList = " + containerInfoList);

    }

    private static void jsonTest01() {
        String str = "{\"code\":0,\"total_count\":1,\"trades\":[{\"trade_id\":10599169,\"trade_no\":\"JY202107054591\",\"platform_id\":127,\"warehouse_type\":20,\"src_tids\":\"110000000017205589\",\"pay_account\":\"\",\"trade_status\":214748368,\"consign_status\":12,\"trade_type\":1,\"delivery_term\":1,\"freeze_reason\":0,\"freeze_reason_info\":\"\",\"refund_status\":0,\"fenxiao_type\":0,\"fenxiao_nick\":\"\",\"buyer_nick\":\"u4E66u53CB20821721\",\"receiver_name\":\"u5C0Fu8D75\",\"receiver_province\":0,\"receiver_city\":0,\"receiver_district\":0,\"receiver_address\":\"u56DBu91CCu6751u8857u9053u5C71u4E1Cu7701u6D4Eu5357u5E02u5E02u4E2Du533Au4E8Cu73AFu897Fu8DEF11588u53F7u4E1Cu4E34HDu4ED3u50A8\",\"receiver_mobile\":\"15169193211\",\"receiver_telno\":\"\",\"receiver_zip\":\"\",\"receiver_area\":\"u5C71u4E1C u6D4Eu5357u5E02 u5E02u4E2Du533A\",\"receiver_ring\":\"\",\"receiver_dtb\":\"\",\"to_deliver_time\":\"\",\"bad_reason\":0,\"logistics_no\":\"YT5622974026332\",\"buyer_message\":\"\",\"cs_remark\":\"\",\"remark_flag\":0,\"print_remark\":\"\",\"goods_type_count\":1,\"goods_count\":3.0000,\"goods_amount\":264.0000,\"post_amount\":0.0000,\"other_amount\":0.0000,\"discount\":105.6000,\"receivable\":158.4000,\"dap_amount\":158.4000,\"cod_amount\":0.0000,\"ext_cod_fee\":0.0000,\"goods_cost\":0.0000,\"post_cost\":0.0000,\"paid\":158.4000,\"weight\":2.3400,\"profit\":158.4000,\"tax\":0.0000,\"tax_rate\":0.0000,\"commission\":0.0000,\"invoice_type\":0,\"invoice_title\":\"\",\"invoice_content\":\"\",\"salesman_id\":0,\"checker_id\":0,\"fchecker_id\":0,\"checkouter_id\":0,\"stockout_no\":\"SCK202107054877-1\",\"flag_name\":\"\",\"trade_from\":1,\"single_spec_no\":\"9787544295208\",\"raw_goods_count\":3.0000,\"raw_goods_type_count\":1,\"currency\":\"\",\"split_package_num\":0,\"invoice_id\":0,\"version_id\":4,\"checkouter_name\":\"\",\"id_card_type\":0,\"id_card\":\"\",\"shop_no\":\"A015\",\"shop_name\":\"u4E2Du4FE1u4E66u5E97-u54AAu5495\",\"shop_remark\":\"\",\"shop_platform_id\":127,\"warehouse_no\":\"Ck018\",\"customer_name\":\"u7C73u5F69u5E73\",\"customer_no\":\"KH202105212069\",\"logistics_id\":53,\"logistics_name\":\"u54AAu5495u5706u901Au4E00u8054u5355uFF08wmsuFF09\",\"logistics_code\":\"WL1042\",\"logistics_type\":4,\"fullname\":\"u7CFBu7EDF\",\"checker_name\":\"u7CFBu7EDF\",\"fchecker_name\":\"u7CFBu7EDF\",\"shop_id\":15,\"warehouse_id\":24,\"check_step\":0,\"unmerge_mask\":0,\"delay_to_time\":0,\"customer_type\":0,\"customer_id\":5084264,\"receiver_country\":0,\"pre_charge_time\":\"\",\"is_prev_notify\":0,\"note_count\":0,\"buyer_message_count\":0,\"cs_remark_count\":0,\"cs_remark_change_count\":0,\"discount_change\":0.0000,\"trade_prepay\":0.0000,\"pi_amount\":0.0000,\"other_cost\":0.0000,\"volume\":0.0000,\"sales_score\":0,\"flag_id\":0,\"is_sealed\":0,\"gift_mask\":0,\"split_from_trade_id\":0,\"logistics_template_id\":0,\"sendbill_template_id\":0,\"revert_reason\":0,\"cancel_reason\":0,\"is_unpayment_sms\":0,\"package_id\":0,\"trade_mask\":0,\"large_type\":0,\"trade_time\":\"2021-07-05 17:46:19\",\"pay_time\":\"2021-07-05 17:46:19\",\"modified\":\"2021-07-07 19:49:04\",\"created\":\"2021-07-05 17:50:54\",\"goods_list\":[{\"rec_id\":22975686,\"trade_id\":10599169,\"spec_id\":166174,\"platform_id\":127,\"src_oid\":\"100000000011048502\",\"suite_id\":0,\"src_tid\":\"110000000017205589\",\"gift_type\":0,\"refund_status\":0,\"guarantee_mode\":1,\"delivery_term\":1,\"bind_oid\":\"\",\"num\":3.0000,\"price\":88.0000,\"actual_num\":3.0000,\"refund_num\":0.0000,\"order_price\":52.8000,\"share_price\":52.8000,\"adjust\":0.0000,\"discount\":105.6000,\"share_amount\":158.4000,\"share_post\":0.0000,\"paid\":158.4000,\"goods_name\":\"u897Fu5C14u65AFu6000u5B55u767Eu79D1uFF082019u7248uFF09\",\"goods_id\":166251,\"goods_no\":\"100140758\",\"spec_name\":\"u518C\",\"spec_no\":\"9787544295208\",\"spec_code\":\"u672C\",\"suite_no\":\"\",\"flag\":0,\"suite_name\":\"\",\"suite_num\":0.0000,\"suite_amount\":0.0000,\"suite_discount\":0.0000,\"api_goods_name\":\"u897Fu5C14u65AFu6000u5B55u767Eu79D1(2019u7248)\",\"api_spec_name\":\"\",\"weight\":2.3400,\"commission\":0.0000,\"goods_type\":1,\"large_type\":0,\"invoice_type\":0,\"invoice_content\":\"\",\"from_mask\":0,\"cid\":0,\"remark\":\"u91D1u5361u5151u6362-1,u94BBu77F3u5151u6362-2\",\"platform_goods_id\":\"100000000000016830\",\"platform_spec_id\":\"9787544295208\",\"tc_order_id\":\"\",\"prop2\":\"\",\"class_name\":\"u5C11u513Fu8BA4u77E5\",\"barcode\":\"9787544295208\",\"share_amount2\":0.0000,\"is_print_suite\":0,\"is_zero_cost\":1,\"stock_reserved\":0,\"is_consigned\":0,\"is_received\":0,\"is_master\":1,\"tax_rate\":0.0000,\"base_unit_id\":0,\"unit_name\":\"\",\"pay_id\":\"\",\"pay_status\":2,\"created\":\"2021-07-05 17:50:54\",\"modified\":\"2021-07-07 19:49:04\",\"pay_time\":\"2021-07-05 17:46:19\"}]}],\"message\":\"ok\"} ";
//
//        int disableDecimalFeature = JSON.DEFAULT_PARSER_FEATURE & ~Feature.UseBigDecimal.getMask();
//        JSONObject queryRespJson = JSON.parseObject(a,JSONObject.class,disableDecimalFeature);

        String str2 = "{\"code\":0,\"total_count\":1,\"trades\":[{\"bad_reason\":\"0\",\"buyer_message\":\"\",\"buyer_message_count\":\"0\",\"buyer_nick\":\"13585865723\",\"cancel_reason\":\"0.00000\",\"check_step\":\"0\",\"checker_id\":\"0\",\"checker_name\":\"\\\\u7CFB\\\\u7EDF\",\"checkouter_id\":\"0\",\"checkouter_name\":\"\",\"cod_amount\":\"0.0000\",\"commission\":\"0.0000\",\"consign_status\":\"12\",\"created\":\"2021-07-01 11:10:53\",\"cs_remark\":\"\",\"cs_remark_change_count\":\"0\",\"cs_remark_count\":\"0\",\"currency\":\"\",\"customer_id\":\"1173042\",\"customer_name\":\"\\\\u80E1\\\\u5B9A\",\"customer_no\":\"KH201804102273\",\"customer_type\":\"0\",\"dap_amount\":\"21.4800\",\"delay_to_time\":\"0\",\"delivery_term\":\"1\",\"discount\":\"14.3200\",\"discount_change\":\"0.0000\",\"ext_cod_fee\":\"0.0000\",\"fchecker_id\":\"0\",\"fchecker_name\":\"\\\\u7CFB\\\\u7EDF\",\"fenxiao_nick\":\"\",\"fenxiao_type\":\"0\",\"flag_id\":\"0\",\"flag_name\":\"\",\"freeze_reason\":\"0\",\"freeze_reason_info\":\"\",\"fullname\":\"\\\\u7CFB\\\\u7EDF\",\"gift_mask\":\"0\",\"goods_amount\":\"35.8000\",\"goods_cost\":\"35.8000\",\"goods_count\":\"1.0000\",\"goods_list\":[{\"actual_num\":\"1.0000\",\"adjust\":\"0.0000\",\"api_goods_name\":\"\\\\u767D\\\\u6D0B\\\\u6DC0\\\\u7EAA\\\\u4E8B \\\\u4EBA\\\\u6559\\\\u7248\\\\u4E03\\\\u5E74\\\\u7EA7\\\\u4E0A\\\\u518C \\\\u6559\\\\u80B2\\\\u90E8\\\\u7EDF\\\\u7F16\\\\u8BED\\\\u6587\\\\u6307\\\\u5B9A\\\\u63A8\\\\u8350\\\\u5FC5\\\\u8BFB\\\\u4E66\\\\u76EE \\\\u4EBA\\\\u6C11\\\\u6559\\\\u80B2 \\\\u540D\\\\u8457\\\\u9605\\\\u8BFB\\\\u8BFE\\\\u7A0B\\\\u5316\\\\u4E1B\\\\u4E66\",\"api_spec_name\":\"\",\"barcode\":\"9787107323621\",\"base_unit_id\":\"0\",\"bind_oid\":\"\",\"cid\":\"0\",\"class_name\":\"\\\\u5C11\\\\u513F\\\\u8BA4\\\\u77E5\",\"commission\":\"0.0000\",\"created\":\"2021-07-01 11:10:53\",\"delivery_term\":\"1\",\"discount\":\"14.3200\",\"flag\":\"0\",\"from_mask\":\"0\",\"gift_type\":\"0\",\"goods_id\":\"200425\",\"goods_name\":\"\\\\u540D\\\\u8457\\\\u9605\\\\u8BFB\\\\u300A\\\\u767D\\\\u6D0B\\\\u6DC0\\\\u7EAA\\\\u4E8B\\\\u300B  \\\\u4E03\\\\u5E74\\\\u7EA7\\\\u4E0A\",\"goods_no\":\"100396705\",\"goods_type\":\"1\",\"guarantee_mode\":\"1\",\"invoice_content\":\"\",\"invoice_type\":\"0\",\"is_consigned\":\"0\",\"is_master\":\"1\",\"is_print_suite\":\"0\",\"is_received\":\"0\",\"is_zero_cost\":\"1\",\"large_type\":\"0\",\"modified\":\"2021-07-02 10:28:27\",\"num\":\"1.0000\",\"order_price\":\"21.4800\",\"paid\":\"21.4800\",\"pay_id\":\"\",\"pay_status\":\"2\",\"pay_time\":\"2021-07-01 11:04:03\",\"platform_goods_id\":\"100000000000472959\",\"platform_id\":\"127\",\"platform_spec_id\":\"9787107323621\",\"price\":\"35.8000\",\"prop2\":\"\",\"rec_id\":\"22909503\",\"refund_num\":\"0.0000\",\"refund_status\":\"0\",\"remark\":\"\\\\u94BB\\\\u77F3\\\\u5151\\\\u6362-1\",\"share_amount\":\"21.4800\",\"share_amount2\":\"0.0000\",\"share_post\":\"0.0000\",\"share_price\":\"21.4800\",\"spec_code\":\"EA\",\"spec_id\":\"200237\",\"spec_name\":\"EA\",\"spec_no\":\"9787107323621\",\"src_oid\":\"100000000010987217\",\"src_tid\":\"110000000017111498\",\"stock_reserved\":\"0\",\"suite_amount\":\"0.0000\",\"suite_discount\":\"0.0000\",\"suite_id\":\"0\",\"suite_name\":\"\",\"suite_no\":\"\",\"suite_num\":\"0.0000\",\"tax_rate\":\"0.0000\",\"trade_id\":\"10562270\",\"unit_name\":\"\",\"weight\":\"0.0000\"}],\"goods_type_count\":\"1\",\"id_card\":\"\",\"id_card_type\":\"0\",\"invoice_content\":\"\",\"invoice_id\":\"0\",\"invoice_title\":\"\",\"invoice_type\":\"0\",\"is_prev_notify\":\"0\",\"is_sealed\":\"0\",\"is_unpayment_sms\":\"0\",\"large_type\":\"0\",\"logistics_code\":\"WL1042\",\"logistics_id\":\"53\",\"logistics_name\":\"\\\\u54AA\\\\u5495\\\\u5706\\\\u901A\\\\u4E00\\\\u8054\\\\u5355\\\\uFF08wms\\\\uFF09\",\"logistics_no\":\"YT5610061826728\",\"logistics_template_id\":\"0\",\"logistics_type\":\"4\",\"modified\":\"2021-07-02 10:28:27\",\"note_count\":\"0\",\"other_amount\":\"0.0000\",\"other_cost\":\"0.0000\",\"package_id\":\"0\",\"paid\":\"21.4800\",\"pay_account\":\"\",\"pay_time\":\"2021-07-01 11:04:03\",\"pi_amount\":\"0.0000\",\"platform_id\":\"127\",\"post_amount\":\"0.0000\",\"post_cost\":\"0.0000\",\"pre_charge_time\":\"\",\"print_remark\":\"\",\"profit\":\"-14.3200\",\"raw_goods_count\":\"1.0000\",\"raw_goods_type_count\":\"1\",\"receivable\":\"21.4800\",\"receiver_address\":\"\\\\u91D1\\\\u56ED\\\\u4E00\\\\u8DEF1115\\\\u5F0437\\\\u53F7102\\\\u5BA4\",\"receiver_area\":\"\\\\u4E0A\\\\u6D77 \\\\u5609\\\\u5B9A\\\\u533A \\\\u6C5F\\\\u6865\\\\u9547\",\"receiver_city\":\"0\",\"receiver_country\":\"0\",\"receiver_district\":\"0\",\"receiver_dtb\":\"\",\"receiver_mobile\":\"13585865723\",\"receiver_name\":\"\\\\u80E1\\\\u5B9A\",\"receiver_province\":\"310000\",\"receiver_ring\":\"\",\"receiver_telno\":\"\",\"receiver_zip\":\"\",\"refund_status\":\"0\",\"remark_flag\":\"0\",\"revert_reason\":\"0\",\"sales_score\":\"0\",\"salesman_id\":\"0\",\"sendbill_template_id\":\"0\",\"shop_id\":\"15\",\"shop_name\":\"\\\\u4E2D\\\\u4FE1\\\\u4E66\\\\u5E97-\\\\u54AA\\\\u5495\",\"shop_no\":\"A015\",\"shop_platform_id\":\"127\",\"shop_remark\":\"\",\"single_spec_no\":\"9787107323621\",\"split_from_trade_id\":\"0\",\"split_package_num\":\"0\",\"src_tids\":\"110000000017111498\",\"stockout_no\":\"SCK202107014494\",\"tax\":\"0.0000\",\"tax_rate\":\"0.0000\",\"to_deliver_time\":\"\",\"trade_from\":\"1\",\"trade_id\":\"10562270\",\"trade_mask\":\"0\",\"trade_no\":\"JY202107013587\",\"trade_prepay\":\"0.0000\",\"trade_status\":\"95\",\"trade_time\":\"2021-07-01 11:04:03\",\"trade_type\":\"1\",\"unmerge_mask\":\"0\",\"version_id\":\"2\",\"volume\":\"0.0000\",\"warehouse_id\":\"6\",\"warehouse_no\":\"Ck006\",\"warehouse_type\":\"11\",\"weight\":\"0.0000\"}],\"message\":\"ok\"}";

        JSONObject queryRespJson = JSON.parseObject(str);
        JSONObject queryRespJson2 = JSON.parseObject(str2);


        List<Map<String, Object>> lists = (List<Map<String, Object>>) queryRespJson.get("trades");
        List<Map<String, Object>> lists_2 = (List<Map<String, Object>>) queryRespJson2.get("trades");

        for (Map<String, Object> list : lists) {
            //Long goodsCount  = Long.valueOf(list.get("goods_count").toString());带小数的string不能直接转成Long
            String goodsCount2  = String.valueOf(list.get("goods_count"));
        }

        for (Map<String, Object> list2 : lists_2) {

            Short citicOrderStatus = Short.valueOf(list2.get("trade_status").toString());
            System.out.println("citicOrderStatus = " + citicOrderStatus);
            Long a = Long.valueOf(((Number)Float.parseFloat((String) list2.get("trade_status"))).intValue());
            Long b = Long.valueOf(((Number)Float.parseFloat((String) list2.get("logistics_id"))).intValue());
            Long c = Long.valueOf(((Number)Float.parseFloat((String) list2.get("logistics_type"))).intValue());
            Long d = Long.valueOf(((Number)Float.parseFloat((String) list2.get("revert_reason"))).intValue());
            Long e = Long.valueOf(((Number)Float.parseFloat((String) list2.get("cancel_reason"))).intValue());
            Long f = Long.valueOf(((Number)Float.parseFloat((String) list2.get("goods_count"))).intValue());
            Long g = Long.valueOf(((Number)Float.parseFloat((String) list2.get("discount_change"))).intValue());
            Long h = Long.valueOf(((Number)Float.parseFloat((String) list2.get("customer_id"))).intValue());
            Long i = Long.valueOf(((Number)Float.parseFloat((String) list2.get("receivable"))).intValue());
            Long j = Long.valueOf(((Number)Float.parseFloat((String) list2.get("weight"))).intValue());

            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("c = " + c);
            System.out.println("d = " + d);
            System.out.println("e = " + e);
            System.out.println("f = " + f);
            System.out.println("g = " + g);
            System.out.println("h = " + h);
            System.out.println("i = " + i);
            System.out.println("j = " + j);
        }

        for (Map<String, Object> list : lists_2) {

            Long a = parseObj(list.get("trade_status"));
            Long b = parseObj(list.get("logistics_id"));
            Long c = parseObj(list.get("logistics_type"));
            Long d = parseObj(list.get("revert_reason"));
            Long e = parseObj(list.get("cancel_reason"));
            Long f = parseObj(list.get("goods_count"));
            Long g = parseObj(list.get("discount_change"));
            Long h = parseObj(list.get("customer_id"));
            Long i = parseObj(list.get("receivable"));
            Long j = parseObj(list.get("weight"));

            System.out.println("a = " + a);
            System.out.println("b = " + b);
            System.out.println("c = " + c);
            System.out.println("d = " + d);
            System.out.println("e = " + e);
            System.out.println("f = " + f);
            System.out.println("g = " + g);
            System.out.println("h = " + h);
            System.out.println("i = " + i);
            System.out.println("j = " + j);


        }
    }

    public static Long parseObj(Object jsonObj){
        String str = (String) jsonObj;
        String temp = "";
        try {
            if(null != str && !str.equals("")){
                if(str.contains(".")){
                    temp = str.substring(0,str.indexOf("."));
                }else {
                    temp = str;
                }
                return Long.valueOf(temp);
            }else {
                return null;
            }
        } catch (Exception e) {

            return null;
        }

    }
}
