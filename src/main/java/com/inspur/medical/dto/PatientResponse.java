package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.inspur.medical.entity.Patient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PatientResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("PatInfos")
    private List<Patient> patInfos;
    
    public static PatientResponse success(List<Patient> patients) {
        return new PatientResponse("1", "查询成功", patients);
    }
    
    public static PatientResponse error(String message) {
        return new PatientResponse("0", message, null);
    }
}
