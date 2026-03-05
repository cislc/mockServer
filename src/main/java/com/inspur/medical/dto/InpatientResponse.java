package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class InpatientResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("Inpatients")
    private List<InpatientDTO> inpatients;
    
    public static InpatientResponse success(List<InpatientDTO> inpatients) {
        return new InpatientResponse("1", "查询成功", inpatients);
    }
    
    public static InpatientResponse error(String message) {
        return new InpatientResponse("0", message, null);
    }
}
