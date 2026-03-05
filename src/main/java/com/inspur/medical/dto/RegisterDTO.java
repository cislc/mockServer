package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RegisterDTO {
    @JsonProperty("ScheduleItemCode")
    private String scheduleItemCode;
    
    @JsonProperty("ExtUserID")
    private String extUserID;
    
    @JsonProperty("PatientCard")
    private String patientCard;
    
    @JsonProperty("CardType")
    private String cardType;
    
    @JsonProperty("PatientID")
    private String patientID;
    
    @JsonProperty("PayBankCode")
    private String payBankCode;
    
    @JsonProperty("PayCardNo")
    private String payCardNo;
    
    @JsonProperty("PayModeCode")
    private String payModeCode;
    
    @JsonProperty("PayFee")
    private String payFee;
    
    @JsonProperty("PayInsuFeeStr")
    private String payInsuFeeStr;
    
    @JsonProperty("QueueNo")
    private String queueNo;
    
    @JsonProperty("PayTradeNo")
    private String payTradeNo;
    
    @JsonProperty("BankTradeInfo")
    private String bankTradeInfo;
    
    @JsonProperty("PayOrderId")
    private String payOrderId;
    
    @JsonProperty("PayTime")
    private String payTime;
}
