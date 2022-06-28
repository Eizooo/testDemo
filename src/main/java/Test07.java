import org.apache.commons.lang.StringUtils;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Test07 {
    public static void main(String[] args) {

        String a = "\t \f \n aa \"";
        System.out.println("a = " + a);
        System.out.println("TimeUnit.MILLISECONDS.toNanos(1) = " + TimeUnit.MILLISECONDS.toNanos(1));
        String orderJdCode = null;
        String orderNo = "2";
        String expCode = "3";
        String expNo = "4";
        String requestData = StringUtils.isEmpty(orderJdCode) ?	"{'Callback':'" + orderNo + "','ShipperCode':'" + expCode + "','LogisticCode':'" + expNo + "'}" :
                "{'Callback':'" + orderNo + "','ShipperCode':'" + expCode + "','LogisticCode':'" + expNo + "','CustomerName':'" + orderJdCode + "'}";

        System.out.println("requestData = " + requestData);
    }
}
