package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class OutpatientPayDTO {
    @JsonProperty("CardNo")
    private String cardNo;
    
    @JsonProperty("CardType")
    private String cardType;
    
    @JsonProperty("PatientID")
    private String patientID;
    
    @JsonProperty("OrderNo")
    private String orderNo;
    
    @JsonProperty("PayDetails")
    private String payDetails;
    
    @JsonProperty("PayModeCode")
    private String payModeCode;
    
    @JsonProperty("PayAmt")
    private String payAmt;
    
    @JsonProperty("OutPayNo")
    private String outPayNo;
    
    @JsonProperty("PayChannel")
    private String payChannel;
    
    @JsonProperty("InsuPersonInfo")
    private String insuPersonInfo;
    
    @JsonProperty("InsuDivide")
    private String insuDivide;
    
    @JsonProperty("InsuTradeOut")
    private String insuTradeOut;
}
