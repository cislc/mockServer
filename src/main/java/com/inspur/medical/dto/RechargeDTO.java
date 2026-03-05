package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class RechargeDTO {
    @JsonProperty("CardNo")
    private String cardNo;
    
    @JsonProperty("CardType")
    private String cardType;
    
    @JsonProperty("PatientId")
    private String patientId;
    
    @JsonProperty("PayDetails")
    private String payDetails;
    
    @JsonProperty("PayModeCode")
    private String payModeCode;
    
    @JsonProperty("PayAccountNo")
    private String payAccountNo;
    
    @JsonProperty("PayAmt")
    private String payAmt;
    
    @JsonProperty("PlatformNo")
    private String platformNo;
    
    @JsonProperty("OutPayNo")
    private String outPayNo;
    
    @JsonProperty("PayChannel")
    private String payChannel;
    
    @JsonProperty("POSPayStr")
    private String posPayStr;
    
    @JsonProperty("PayDate")
    private String payDate;
    
    @JsonProperty("PayTime")
    private String payTime;
}
