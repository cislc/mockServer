package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RegisterResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("SeqCode")
    private String seqCode;
    
    @JsonProperty("AdmitRange")
    private String admitRange;
    
    @JsonProperty("RegFee")
    private String regFee;
    
    @JsonProperty("AdmitAddress")
    private String admitAddress;
    
    @JsonProperty("TransactionId")
    private String transactionId;
    
    @JsonProperty("ApplID")
    private String applID;
    
    @JsonProperty("PayOrderId")
    private String payOrderId;
    
    @JsonProperty("AdmNo")
    private String admNo;
    
    @JsonProperty("DeptName")
    private String deptName;
    
    @JsonProperty("DoctorName")
    private String doctorName;
    
    @JsonProperty("DoctorLevelDesc")
    private String doctorLevelDesc;
    
    @JsonProperty("DoctorLevelCode")
    private String doctorLevelCode;
    
    @JsonProperty("ReceiptNo")
    private String receiptNo;
    
    @JsonProperty("TimeRange")
    private String timeRange;
    
    @JsonProperty("HisTradeOrderId")
    private String hisTradeOrderId;
    
    public static RegisterResponse success(String seqCode, String admitRange, String regFee, 
                                          String admitAddress, String transactionId, String applID,
                                          String payOrderId, String admNo, String deptName,
                                          String doctorName, String doctorLevelDesc, String doctorLevelCode,
                                          String receiptNo, String timeRange, String hisTradeOrderId) {
        return new RegisterResponse("1", "挂号成功", seqCode, admitRange, regFee, admitAddress,
                                    transactionId, applID, payOrderId, admNo, deptName, doctorName,
                                    doctorLevelDesc, doctorLevelCode, receiptNo, timeRange, hisTradeOrderId);
    }
    
    public static RegisterResponse error(String message) {
        return new RegisterResponse("0", message, null, null, null, null, null, null, null, null,
                                    null, null, null, null, null, null, null);
    }
}
