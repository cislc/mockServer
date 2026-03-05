package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class InpatientFeeQueryDTO {
    @JsonProperty("CardNo")
    private String cardNo;
    
    @JsonProperty("CardType")
    private String cardType;
    
    @JsonProperty("PatientID")
    private String patientID;
    
    @JsonProperty("MedicalNo")
    private String medicalNo;
}
