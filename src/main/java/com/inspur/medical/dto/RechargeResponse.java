package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RechargeResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("SerialNo")
    private String serialNo;
    
    @JsonProperty("AccountID")
    private String accountID;
    
    @JsonProperty("BeforeBalAmt")
    private String beforeBalAmt;
    
    @JsonProperty("BalanceAmt")
    private String balanceAmt;
    
    @JsonProperty("LimitAmt")
    private String limitAmt;
    
    public static RechargeResponse success(String serialNo, String accountID, 
                                          String beforeBalAmt, String balanceAmt, String limitAmt) {
        return new RechargeResponse("1", "充值成功", serialNo, accountID, beforeBalAmt, balanceAmt, limitAmt);
    }
    
    public static RechargeResponse error(String message) {
        return new RechargeResponse("0", message, null, null, null, null, null);
    }
}
