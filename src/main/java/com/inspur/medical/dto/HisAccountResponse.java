package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HisAccountResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("InvoiceNo")
    private String invoiceNo;
    
    @JsonProperty("MerNo")
    private String merNo;
    
    @JsonProperty("MzZyBz")
    private String mzZyBz;
    
    @JsonProperty("PayType")
    private String payType;
    
    @JsonProperty("OrderAmount")
    private String orderAmount;
    
    @JsonProperty("OrderType")
    private String orderType;
    
    @JsonProperty("TranDate")
    private String tranDate;
    
    @JsonProperty("OperUser")
    private String operUser;
    
    @JsonProperty("TranNo")
    private String tranNo;
    
    @JsonProperty("OrderState")
    private String orderState;
    
    @JsonProperty("PatientNo")
    private String patientNo;
    
    @JsonProperty("PatName")
    private String patName;
    
    public static HisAccountResponse success(String invoiceNo, String merNo, String mzZyBz, String payType,
                                             String orderAmount, String orderType, String tranDate, String operUser,
                                             String tranNo, String orderState, String patientNo, String patName) {
        return new HisAccountResponse("1", "查询成功", invoiceNo, merNo, mzZyBz, payType, orderAmount,
                                      orderType, tranDate, operUser, tranNo, orderState, patientNo, patName);
    }
    
    public static HisAccountResponse error(String message) {
        return new HisAccountResponse("0", message, null, null, null, null, null, null, null, null,
                                      null, null, null, null);
    }
}
