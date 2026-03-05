package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientSaveResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("PatientCard")
    private String patientCard;
    
    @JsonProperty("PatientID")
    private String patientID;
    
    public static PatientSaveResponse success(String patientCard, String patientID) {
        return new PatientSaveResponse("1", "建档成功", patientCard, patientID);
    }
    
    public static PatientSaveResponse error(String message) {
        return new PatientSaveResponse("0", message, null, null);
    }
}
