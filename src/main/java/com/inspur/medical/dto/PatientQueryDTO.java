package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PatientQueryDTO {
    @JsonProperty("CardNo")
    private String cardNo;
    
    @JsonProperty("CardType")
    private String cardType;
}
