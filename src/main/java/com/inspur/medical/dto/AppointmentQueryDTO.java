package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class AppointmentQueryDTO {
    @JsonProperty("CardNo")
    private String cardNo;
    
    @JsonProperty("CardType")
    private String cardType;
    
    @JsonProperty("IdNo")
    private String idNo;
    
    @JsonProperty("StartDate")
    private String startDate;
    
    @JsonProperty("EndDate")
    private String endDate;
}
