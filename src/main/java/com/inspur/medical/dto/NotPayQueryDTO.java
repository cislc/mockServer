package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class NotPayQueryDTO {
    @JsonProperty("CardNo")
    private String cardNo;
    
    @JsonProperty("CardType")
    private String cardType;
    
    @JsonProperty("PatientID")
    private String patientID;
    
    @JsonProperty("StartTime")
    private String startTime;
    
    @JsonProperty("EndTime")
    private String endTime;
}
