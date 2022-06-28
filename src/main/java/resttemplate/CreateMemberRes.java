package resttemplate;

import com.alibaba.fastjson.JSON;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CreateMemberRes implements Serializable {
    private static final long serialVersionUID = -5517693926090237632L;

    private String transactionId;
    private String cpid;
    private String prefix;
    private String servcode;
    private String payUrl;
    private String payType;
    private String miguPayRequestInfo;
    private String objectId;
    private String transactionCode;
    private String versionFlag;
    private String orderMType;
    private String preemptionStatus;
    private String productId;
    private String identityID;
    private String payMode;
    private String orderId;
    private String monthlyPrice;
    private String channelCode;

    @Override
    public String toString() {
        return JSON.toJSONString(this);
    }
}