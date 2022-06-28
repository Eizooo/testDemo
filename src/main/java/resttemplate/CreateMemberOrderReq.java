package resttemplate;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CreateMemberOrderReq {

    private String mobile;

    private Long monthlyId;

    private String msisdn;

    private String orderType;

    private String payType;

    private String productId;

    private Long reqTime;

    private String totalPrice;

    private String userId;


}
