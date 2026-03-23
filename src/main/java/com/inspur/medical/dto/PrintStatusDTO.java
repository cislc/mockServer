package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PrintStatusDTO {
    @JsonProperty("ReportId")
    private String reportId;
    
    @JsonProperty("TypeCode")
    private String typeCode;
    
    @JsonProperty("PatientId")
    private String patientId;

    // To handle the typo in the API doc sample
    @JsonProperty("PatienId")
    public void setPatienId(String patienId) {
        this.patientId = patienId;
    }
}
