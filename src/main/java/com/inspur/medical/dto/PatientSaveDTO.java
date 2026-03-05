package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PatientSaveDTO {
    @JsonProperty("PatientName")
    private String patientName;
    
    @JsonProperty("PatientCard")
    private String patientCard;
    
    @JsonProperty("PatientType")
    private String patientType;
    
    @JsonProperty("IDType")
    private String idType;
    
    @JsonProperty("IDNo")
    private String idNo;
    
    @JsonProperty("Sex")
    private String sex;
    
    @JsonProperty("DOB")
    private String dob;
    
    @JsonProperty("Mobile")
    private String mobile;
    
    @JsonProperty("CardTypeCode")
    private String cardTypeCode;
    
    @JsonProperty("Address")
    private String address;
}
