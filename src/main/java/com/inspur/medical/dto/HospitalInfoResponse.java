package com.inspur.medical.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalInfoResponse {
    
    @JsonProperty("ResultCode")
    private String resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("Info")
    private String info;
    
    public static HospitalInfoResponse success(String info) {
        return new HospitalInfoResponse("1", "查询成功", info);
    }
    
    public static HospitalInfoResponse error(String message) {
        return new HospitalInfoResponse("0", message, null);
    }
}
