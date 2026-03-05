package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class ElectronicDocumentQueryDTO {
    @JsonProperty("CardNo")
    private String cardNo;
    
    @JsonProperty("CardType")
    private String cardType;
    
    @JsonProperty("StartTime")
    private String startTime;
    
    @JsonProperty("EndTime")
    private String endTime;
}
