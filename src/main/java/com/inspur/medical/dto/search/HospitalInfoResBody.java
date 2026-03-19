package com.inspur.medical.dto.search;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class HospitalInfoResBody {
    @JsonProperty("ResultCode")
    private Integer resultCode;
    
    @JsonProperty("ResultContent")
    private String resultContent;
    
    @JsonProperty("Info")
    private String info;
    
    public static HospitalInfoResBody success(String info) {
        return new HospitalInfoResBody(0, "成功", info);
    }
    
    public static HospitalInfoResBody error(String message) {
        return new HospitalInfoResBody(1, message, null);
    }
}
