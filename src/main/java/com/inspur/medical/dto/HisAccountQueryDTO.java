package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class HisAccountQueryDTO {
    @JsonProperty("UserCode")
    private String userCode;
    
    @JsonProperty("EndDate")
    private String endDate;
    
    @JsonProperty("StartDate")
    private String startDate;
    
    @JsonProperty("ExpStr")
    private String expStr;
    
    @JsonProperty("TransNo")
    private String transNo;
    
    @JsonProperty("PayType")
    private String payType;
    
    @JsonProperty("ETPRc")
    private String etpRc;
    
    @JsonProperty("HospitalID")
    private String hospitalID;
}
